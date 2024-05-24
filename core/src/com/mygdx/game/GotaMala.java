package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class GotaMala extends Gota {
	
	public GotaMala(int velX, int velY, Texture img, float anchoCam) {
		super(velX, velY, img, anchoCam);
	}

	@Override
	public void efecto(Jugador pj) {
		// TODO Auto-generated method stub
		pj.dañar();
	}

}
