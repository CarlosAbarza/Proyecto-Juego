package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class GotaEscudo extends Gota {

	public GotaEscudo(int velX, int velY, float anchoCam, MovimientoGota mov) {
		super(velX, velY, new Texture(Gdx.files.internal("gotaVerde.png")), anchoCam, mov);
	}

	@Override
	public void efecto(Jugador pj) {
		pj.recargaShield();

	}

}
