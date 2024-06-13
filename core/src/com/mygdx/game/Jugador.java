package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public final class Jugador {
	private static Jugador instance;
	private int vidas;
	private int ptj;
	private Tarro pj;
	private Shield esc;
	
	private float slowTMax;
	private float slowTLeft;
	
	private Jugador(Texture tex, Sound ss, float anchoCam) {
		pj = Tarro.getTarro(anchoCam);
		vidas = 3;
		ptj = 0;
		slowTMax = 3f;
		slowTLeft = slowTMax;
		esc = new Shield(anchoCam);
		
		pj.crear();
		esc.crear();
	}
	
	public static Jugador getJugador(float anchoCam) {
		if (instance == null) {
			instance = new Jugador(new Texture(Gdx.files.internal("bucket.png")),Gdx.audio.newSound(Gdx.files.internal("hurt.ogg")), anchoCam);
		}
		return instance;
	}

	public int getVidas() {
		return vidas;
	}

	public int getPtj() {
		return ptj;
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
		esc.actualizarMov();
	}
	
	public void dibujar(SpriteBatch batch) {
		pj.actualizarDibujo(batch);
		if (esc.estado()) 
			esc.actualizarDibujo(batch);
		
	}
	
	public void destruir() {
		pj.destruir();
		esc.destruir();
		instance = null;
	}
	
	public void relentizar() {
		pj.relentizar();
		esc.relentizar();
	}
	
	public void acelerar() {
		pj.acelerar();
		esc.acelerar();	
	}
	
	public void tiempoSlow(float time) {
		slowTLeft -= time;
		if (slowTLeft < 0) 
			slowTLeft = 0f;
	}
	
	public String getSlowTime() {
		String truncatedNumber = String.format("%.2f", slowTLeft);
        return truncatedNumber;
	}
	
	public boolean puedeSlow() {
		return (slowTLeft > 0);
	}
	
	public void recargaSlow() {
		slowTLeft = slowTMax;
	}
	
	public void activarEscudo() {
		esc.activar();
	}
	
	public void desactivarEscudo() {
		esc.desactivar();
	}
	
	public boolean estadoEsc() {
		return esc.estado();
	}
	
	public Shield getShield() {
		return esc;
	}
	
	public String getShielTime() {
		return esc.getTimeLeft();
	}
	
	public void usarShield(float time) {
		esc.usar(time);
	}
	
	public boolean puedeShield() {
		return esc.puede();
	}
	
	public void recargaShield() {
		esc.recarga();
	}
}
