package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class GotaBuena extends Gota {
	private Sound dropSound;
	
	public GotaBuena(int velX, int velY, Sound dropSound, float anchoCam, MovimientoGota mov) {
		super(velX, velY, new Texture(Gdx.files.internal("drop.png")), anchoCam, mov);
		this.dropSound = dropSound;
	}

	@Override
	public void efecto(Jugador pj) {
		// TODO Auto-generated method stub
		pj.sumarPuntos(10);
		dropSound.play();
	}

	public Sound getDropSound() {
		return dropSound;
	}

	public void setDropSoud(Sound dropSoud) {
		this.dropSound = dropSoud;
	}
}
