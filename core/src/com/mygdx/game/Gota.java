package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public abstract class Gota implements Dibujable{
	protected int velX;
	protected int velY;
	protected Texture img;
	protected Rectangle raindrop;
	protected float anchoCam;
	
	// temporal
	protected boolean relentizado;

	public Gota(int velX, int velY, Texture img, float anchoCam) {
		this.velX = velX;
		this.velY = velY;
		this.img = img;
		this.raindrop = new Rectangle();
		raindrop.x = MathUtils.random(0, anchoCam-64);
		raindrop.y = Gdx.graphics.getHeight();
		raindrop.height = 64;
		raindrop.width = 64;	
		this.anchoCam = anchoCam;
		relentizado = false;
		
	}

	public abstract void efecto(Jugador pj);
	
	@Override
	public void actualizarMov() {
		// TODO Auto-generated method stub
		raindrop.y -=  velY * Gdx.graphics.getDeltaTime();
		moverX();
	}
	
	@Override
	public void actualizarDibujo(SpriteBatch batch) {
		// TODO Auto-generated method stub
		batch.draw(img, raindrop.x, raindrop.y, 64, 64);
	}
	
	@Override
	public boolean dentroPantalla() {
		if (raindrop.y + 64 < 0) {
			return false;
		}
		return true;
	}

	protected void moverX() {
		if (raindrop.x > (anchoCam-64) ||
			raindrop.x < 0) {
			velX *= -1;
		}
		raindrop.x += velX * Gdx.graphics.getDeltaTime();
	}
	
	@Override
	public boolean colision(Movible pj) {
		if (raindrop.overlaps(pj.getArea())) {
			return true;
		}
		return false;
	}
	
	@Override
	public Rectangle getArea() {
		return raindrop;
	}
	
	@Override
	public void acelerar() {
		if (relentizado) {
			velX *= 2;
			velY *= 2;
			relentizado = false; 
		}
	}
	
	@Override
	public void relentizar() {
		if (!relentizado) {
			velX /= 2;
			velY /= 2;
			relentizado = true;
		}
	}
}