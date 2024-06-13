package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;

public abstract class MovimientoGota {
	public void actualizarMov(int velX, int velY, Rectangle gota, float anchoCam) {
		actualizarY(velY, gota);
		actualizarX(velX, gota, anchoCam);
	}
	
	public abstract void actualizarY(int velY, Rectangle gota);
	public abstract void actualizarX(int velX, Rectangle gota, float anchoCam);
}
