package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class GotaMala extends Gota {
	
	public GotaMala(int velX, int velY, float anchoCam, MovimientoGota mov) {
		super(velX, velY, new Texture(Gdx.files.internal("gotaRoja.png")), anchoCam, mov);
	}

	@Override
	public void efecto(Jugador pj) {
		// TODO Auto-generated method stub
		pj.dañar();
	}

}
