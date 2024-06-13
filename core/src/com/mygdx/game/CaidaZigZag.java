package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class CaidaZigZag extends MovimientoGota {

	@Override
	public void actualizarY(int velY, Rectangle gota) {
		gota.y -=  velY * Gdx.graphics.getDeltaTime();
	}
	
	@Override
	public void actualizarX(int velX, Rectangle gota, float anchoCam) {
		if (gota.x > (anchoCam-64) ||
			gota.x < 0) {
			velX *= -1;
		}
		gota.x += (velX/15 * Math.sin(Math.toRadians(gota.y)));
	}
}
