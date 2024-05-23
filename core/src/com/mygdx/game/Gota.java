package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public abstract class Gota implements Movible, Dibujable{
	protected int velX;
	protected int velY;
	protected Texture img;
	protected Rectangle raindrop;
	protected float anchoCam;

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
	}

	public abstract void efecto(Tarro pj);
	
	@Override
	public void actualizarMov() {
		// TODO Auto-generated method stub
		raindrop.y -=  velY * Gdx.graphics.getDeltaTime();
		moverX();
	}
	
	@Override
	public void actualizarDibujo(SpriteBatch batch) {
		// TODO Auto-generated method stub
		batch.draw(img, raindrop.x, raindrop.y);
	}
	
	public boolean dentroPantalla() {
		if (raindrop.y + 64 < 0) {
			return false;
		}
		return true;
	}

	public void moverX() {
		if (raindrop.x > (anchoCam-64) ||
			raindrop.x < 0) {
			velX *= -1;
		}
		raindrop.x += velX * Gdx.graphics.getDeltaTime();
	}
	
	public boolean verificarH() {
		if (raindrop.y + 64 < 0) {
			return false;
		}
		return true;
	}
	
	public boolean colision(Tarro pj) {
		if (raindrop.overlaps(pj.getArea())) {
			efecto(pj);
			return true;
		}
		return false;
	}
}