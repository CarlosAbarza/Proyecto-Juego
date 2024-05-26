package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;

public interface Movible {
	public void actualizarMov();
	public boolean dentroPantalla();
	public boolean colision(Movible obj);
	public Rectangle getArea();
	public void acelerar();
	public void relentizar();
}
