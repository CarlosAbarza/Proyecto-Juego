package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Shield implements Dibujable {
	private Rectangle shield;
	private Texture shieldImg;
	private float timeMax;
	private float timeLeft;
	private float anchoCam;
	
	
	
	@Override
	public void actualizarMov() {
		// TODO Auto-generated method stub
		
	}

	@Override
    public boolean dentroPantalla() {
    	if (shield.x < 0) 
    		return false;
    	if (shield.x > anchoCam - 64) {
    		return false;
    	}
    	return true;
    }

	@Override
	public void actualizarDibujo(SpriteBatch batch) {
		// TODO Auto-generated method stub
		batch.draw(shieldImg, shield.x, shield.y);
	}
	
	public void resetTime() {
		timeLeft = timeMax;
	}

	@Override
	public boolean colision(Movible obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Rectangle getArea() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void acelerar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void relentizar() {
		// TODO Auto-generated method stub
		
	}
}
