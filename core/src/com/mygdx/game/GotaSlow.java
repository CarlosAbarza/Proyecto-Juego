package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class GotaSlow extends Gota {

	public GotaSlow(int velX, int velY, MovimientoGota mov) {
		super(velX, velY, new Texture(Gdx.files.internal("gotaMorada.png")), mov);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void efecto(Jugador pj) {
		pj.recargaSlow();

	}

}
