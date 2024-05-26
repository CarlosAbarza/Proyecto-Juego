package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {
    final MyGdxGame game;
    private OrthographicCamera camera;
    private SpriteBatch batch;	   
    private BitmapFont font;
    private Jugador pj;
    private Lluvia lluvia;


    //boolean activo = true;

    public GameScreen(final MyGdxGame game) {
        this.game = game;
        this.batch = game.getBatch();
        this.font = game.getFont();
        
        
        // load the images for the droplet and the bucket, 64x64 pixels each 	     
        Sound hurtSound = Gdx.audio.newSound(Gdx.files.internal("hurt.ogg"));
        pj = new Jugador(new Texture(Gdx.files.internal("bucket.png")),hurtSound, game.getCam().viewportWidth);

        // load the drop sound effect and the rain background "music" 
        Texture gota = new Texture(Gdx.files.internal("drop.png"));
        Texture gotaMala = new Texture(Gdx.files.internal("gotaRoja.png"));

        Sound dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));

        Music rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
        lluvia = new Lluvia(gota, gotaMala, dropSound, rainMusic, game.getCam().viewportWidth);

        // camera
        camera = game.getCam();
        batch = new SpriteBatch();
        // creacion del tarro
        pj.crear();

        // creacion de la lluvia
        lluvia.crear();
    }

    @Override
    public void render(float delta) {
        //limpia la pantalla con color azul obscuro.
        ScreenUtils.clear(0.5f, 0.5f, 0.5f, 1);
        //actualizar matrices de la cámara
        camera.update();
        //actualizar 
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        //dibujar textos
        font.draw(batch, "Gotas totales: " + pj.getPtj(), 5, 475);
        //font.draw(batch, "Vidas : " + tarro.getVidas(), 670, 475);
        font.draw(batch, "Vidas : " + pj.getVidas(), 670, 475);
        font.draw(batch, "HighScore : " + game.getHigherScore(), camera.viewportWidth/2-50, 475);
        font.draw(batch, "SlowTimeLeft: " + pj.getSlowTime() + " seconds", 10, 450);

        
        if (!pj.estaHerido()) {
            // movimiento del tarro desde teclado
            pj.mover();        
            // caida de la lluvia 
	        lluvia.actualizarMovimiento(pj);
	        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && pj.getSlowTime() > 0) {
	        	float deltaTime = Gdx.graphics.getDeltaTime();
	        	pj.tiempoSlow(deltaTime);
	        	pj.relentizar();
	        	lluvia.relentizar();
	        }
	        else if (!Gdx.input.isKeyPressed(Input.Keys.SPACE) ||  pj.getSlowTime() == 0) {
	        	pj.acelerar();
	        	lluvia.acelerar();
	        }
	        if (pj.getVidas() == 0) {
	            //actualizar HigherScore
	            if (game.getHigherScore()<pj.getPtj())
	                game.setHigherScore(pj.getPtj());  
	            //ir a la ventana de finde juego y destruir la actual
	            game.setScreen(new GameOverScreen(game));
	            dispose();
            }
        }

        pj.dibujar(batch);
        lluvia.actualizarDibujoLluvia(batch);

        batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
        // continuar con sonido de lluvia
        lluvia.continuar();
    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {
        lluvia.pausar();
        game.setScreen(new PausaScreen(game, this)); 
    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        pj.destruir();
        lluvia.destruir();
    }

}
