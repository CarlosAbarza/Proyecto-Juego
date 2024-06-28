package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;


public class PausaScreen implements Screen {

    private final MyGdxGame game;
    private GameScreen juego;
    private SpriteBatch batch;	   
    private BitmapFont font;
    private OrthographicCamera camera;
    private int ptj;

    public PausaScreen (final MyGdxGame game, GameScreen juego, int ptj) {
        this.game = game;
        this.juego = juego;
        this.batch = game.getBatch();
        this.font = game.getFont();
        camera = game.getCam();
        this.ptj = ptj;
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 1.0f, 0.5f);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        font.draw(batch, "Juego en Pausa ", 100, 150);
        font.draw(batch, "Toca en cualquier lado para continuar !!!", 100, 100);
        font.draw(batch, "Gotas totales: " + ptj, 100, 50);
        batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(juego);
            dispose();
        }
    }

    @Override
    public void show() {
        // TODO Auto-generated method stub
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
    }
}

