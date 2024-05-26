package com.mygdx.game;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Jugador {
	private int vidas;
	private int ptj;
	private Tarro pj;
	
	private float slowTMax;
	private float slowTLeft;
	
	public Jugador(Texture tex, Sound ss, float anchoCam) {
		pj = new Tarro(tex, ss, anchoCam);
		vidas = 3;
		ptj = 0;
		slowTMax = 3f;
		slowTLeft = slowTMax;
		
		pj.crear();
	}

	public int getVidas() {
		return vidas;
	}

	public int getPtj() {
		return ptj;
	}
	
	public Tarro getPj() {
		return pj;
	}
	
	public void crear() {
		pj.crear();
	}
	
	public void sumarPuntos(int pp) {
		ptj += pp;
	}
	
	public void dañar() {
		vidas--;
		pj.dañar();
	}
	 
	public boolean estaHerido() {
		return pj.estaHerido();
	}
	
	public void mover() {
		pj.actualizarMov();
	}
	
	public void dibujar(SpriteBatch batch) {
		pj.actualizarDibujo(batch);
	}
	
	public void destruir() {
		pj.destruir();
	}
	
	public void relentizar() {
		pj.relentizar();
	}
	
	public void acelerar() {
		pj.acelerar();
	}
	
	public void tiempoSlow(float time) {
		slowTLeft -= time;
		if (slowTLeft < 0) 
			slowTLeft = 0f;
	}
	
	public float getSlowTime() {
		return slowTLeft;
	}
}
