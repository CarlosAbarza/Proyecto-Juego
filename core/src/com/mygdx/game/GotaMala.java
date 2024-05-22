package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class GotaMala extends Gota {
	
	public GotaMala(int velX, int velY, Texture img) {
		super(velX, velY, img);
	}

	@Override
	public void efecto(Tarro pj) {
		// TODO Auto-generated method stub
		pj.dañar();
	}

}
