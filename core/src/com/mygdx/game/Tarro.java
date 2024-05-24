package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;


public class Tarro implements Dibujable{
    private Rectangle bucket;
    private Texture bucketImage;
    private Sound sonidoHerido;
    // Sacar vida y ptj a una clase jugador o juego
    private int vidas = 3;
    private int puntos = 0;
    
    private int velx = 400;
    private boolean herido = false;
    private int tiempoHeridoMax=50;
    private int tiempoHerido;
    private float anchoCam;


    public Tarro(Texture tex, Sound ss, float anchoCam) {
        bucketImage = tex;
        sonidoHerido = ss;
        this.anchoCam = anchoCam;
    }

    public int getVidas() {
        return vidas;
    }

    public int getPuntos() {
        return puntos;
    }
    
    public Rectangle getArea() {
        return bucket;
    }
    
    public void sumarPuntos(int pp) {
        puntos+=pp;
    }

    public void crear() {
        bucket = new Rectangle();
        bucket.x = anchoCam / 2 - 64 / 2;
        bucket.y = 20;
        bucket.width = 64;
        bucket.height = 64;
    }
    
    public void dañar() {
        herido = true;
        tiempoHerido=tiempoHeridoMax;
        sonidoHerido.play();
    }
    
    @Override
    public void actualizarDibujo(SpriteBatch batch) {
        if (!herido)  
            batch.draw(bucketImage, bucket.x, bucket.y);
        
        else {
            batch.draw(bucketImage, bucket.x, bucket.y+ MathUtils.random(-5,5));
            tiempoHerido--;
            if (tiempoHerido<=0) herido = false;
        }
    }

    @Override
    public void actualizarMov() { 
        //movimiento desde teclado
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) bucket.x -= velx * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) bucket.x += velx * Gdx.graphics.getDeltaTime();
        // que no se salga de los bordes izq y der
        if(!dentroPantalla()) {
        	if (bucket.x < 0) {
        		bucket.x = 0;
        	}
        	else {
        		bucket.x = anchoCam - 64;
        	}
        }
    }
    
    @Override
    public boolean dentroPantalla() {
    	if (bucket.x < 0) 
    		return false;
    	if (bucket.x > anchoCam - 64) {
    		return false;
    	}
    	return true;
    }

    public void destruir() {
        bucketImage.dispose();
    }
	
    public boolean estaHerido() {
        return herido;
    }
	   
}
