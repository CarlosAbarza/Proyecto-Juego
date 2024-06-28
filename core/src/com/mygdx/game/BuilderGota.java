package com.mygdx.game;

import com.badlogic.gdx.math.MathUtils;

public class BuilderGota {
	private MovimientoGota mov;

	public MovimientoGota getMov() {
		return mov;
	}

	public BuilderGota setMov(MovimientoGota mov) {
		this.mov = mov;
		return this;
	}
	
	
	
	public GotaBuena getBuena(int ptj) {
		return new GotaBuena(MathUtils.random(-150,150), (ptj + 250), mov);
	}
	
	public GotaEscudo getEscudo(int ptj) {
		return new GotaEscudo(MathUtils.random(-150,150), (ptj + 250), mov);
	}
	
	public GotaMala getMala(int ptj) {
		return new GotaMala(MathUtils.random(-150,150), (ptj + 250), mov);
	}
	
	public GotaSlow getSlow(int ptj) {
		return new GotaSlow(MathUtils.random(-150,150), (ptj + 250), mov);
	}
}
