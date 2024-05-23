package com.mygdx.game;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class GotaBuena extends Gota {
	private Sound dropSound;
	
	public GotaBuena(int velX, int velY, Texture img, Sound dropSound, float anchoCam) {
		super(velX, velY, img, anchoCam);
		this.dropSound = dropSound;
	}

	@Override
	public void efecto(Tarro pj) {
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
