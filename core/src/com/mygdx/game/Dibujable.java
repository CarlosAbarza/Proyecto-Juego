package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Dibujable extends Movible {
	public void actualizarDibujo(SpriteBatch batch);
}
