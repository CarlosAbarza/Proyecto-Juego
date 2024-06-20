package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class Lluvia {
    private Array<Gota> rainDrops;
	private long lastDropTime;
	/*
    private Texture gotaBuena;
    private Texture gotaMala;
    */
    private Sound dropSound;
    private Music rainMusic;
    private float anchoCam;
    private ArrayList<MovimientoGota> movs;
	   
    public Lluvia(Sound ss, Music mm, float anchoCam) {
        rainMusic = mm;
        dropSound = ss;
        this.anchoCam = anchoCam;
        
        movs = new ArrayList<>();
        movs.add(new CaidaRecta());
        movs.add(new CaidaDiagonal());
        movs.add(new CaidaZigZag());
    }

    public void crear() {
    	rainDrops = new Array<>();
        crearGotaDeLluvia(0);
        // start the playback of the background music immediately
        rainMusic.setLooping(true);
        rainMusic.play();
    }

    private void crearGotaDeLluvia(int ptj) {
    	int aux =MathUtils.random(1,15);
    	if (aux<12) {
    		GotaBuena rd = new GotaBuena(MathUtils.random(-150,150), (ptj + 250), dropSound, anchoCam, movs.get(MathUtils.random(movs.size()-1)));
    		rainDrops.add(rd);
    	}
    	else if (aux < 14){
    		GotaMala rd = new GotaMala(MathUtils.random(-150,150), (ptj + 250), anchoCam, movs.get(MathUtils.random(movs.size()-1)));
    		rainDrops.add(rd);
    	}
    	else  if (aux < 15){
    		GotaEscudo rd = new GotaEscudo(MathUtils.random(-150,150), (ptj + 250), anchoCam, movs.get(MathUtils.random(movs.size()-1)));
    		rainDrops.add(rd);
    	}
    	else {
    		GotaSlow rd = new GotaSlow(MathUtils.random(-150,150), (ptj + 250), anchoCam, movs.get(MathUtils.random(movs.size()-1)));
    		rainDrops.add(rd);
    	}
        lastDropTime = TimeUtils.nanoTime();
    }

    public void actualizarMovimiento(Jugador pj) { 
        // generar gotas de lluvia 
        if(TimeUtils.nanoTime() - lastDropTime > 100000000) crearGotaDeLluvia(pj.getPtj());

        for (int i = 0; i < rainDrops.size; i++) {
        	Gota rd = rainDrops.get(i);
        	/*rd.actualizarMov();
        	if (!rd.dentroPantalla()) {
        		rainDrops.removeIndex(i);
        	}
        	
        	if (pj.estadoEsc() && rd.colision(pj.getShield())) {
        		rainDrops.removeIndex(i);
        	}
        	else if (rd.colision(Tarro.getTarro(anchoCam))) {
        		rd.efecto(pj);
        		rainDrops.removeIndex(i);
        	}*/
        	
        	if (pj.estadoEsc() && !rd.actualizacion(pj, pj.getShield())) {
        		rainDrops.removeIndex(i);
        	}
        	else {
        		if (!rd.actualizacion(pj)) {
        			rainDrops.removeIndex(i);
        		}
        	}
        	
        }
    }

    public void actualizarDibujoLluvia(SpriteBatch batch) { 
    	for (int i = 0; i < rainDrops.size; i++) {
    		Gota rd = rainDrops.get(i);
    		rd.actualizarDibujo(batch);
    	}
    }
    
    public void acelerar() {
    	for (int i = 0; i < rainDrops.size; i++) {
    		Gota rd = rainDrops.get(i);
    		rd.acelerar();
    	}
    }
    
    public void relentizar() {
    	for (int i = 0; i < rainDrops.size; i++) {
    		Gota rd = rainDrops.get(i);
    		rd.relentizar();
    	}
    }
    
    public void destruir() {
        dropSound.dispose();
        rainMusic.dispose();
    }
    
    public void pausar() {
        rainMusic.stop();
    }
    
    public void continuar() {
        rainMusic.play();
    }
}
