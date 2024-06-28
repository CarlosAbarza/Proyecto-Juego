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
    private Music rainMusic;
    private ArrayList<MovimientoGota> movs;
    private BuilderGota builder;
    
    
    public Lluvia(Music mm) {
        rainMusic = mm;
        
        movs = new ArrayList<>();
        movs.add(new CaidaRecta());
        movs.add(new CaidaDiagonal());
        movs.add(new CaidaZigZag());
    }

    public void crear() {
    	rainDrops = new Array<>();
    	builder = new BuilderGota();
        crearGotaDeLluvia(0);
        // start the playback of the background music immediately
        rainMusic.setLooping(true);
        rainMusic.play();
    }

    private void crearGotaDeLluvia(int ptj) {
    	int tipo = MathUtils.random(1,15);
    	
    	if (tipo<12) {
    		GotaBuena rd = builder.setMov(movs.get(MathUtils.random(movs.size()-1))).getBuena(ptj);
    		rainDrops.add(rd);
    	}
    	else if (tipo < 14){
    		GotaMala rd = builder.setMov(movs.get(MathUtils.random(movs.size()-1))).getMala(ptj);
    		rainDrops.add(rd);
    	}
    	else  if (tipo < 15){
    		GotaEscudo rd = builder.setMov(movs.get(MathUtils.random(movs.size()-1))).getEscudo(ptj);
    		rainDrops.add(rd);
    	}
    	else {
    		GotaSlow rd = builder.setMov(movs.get(MathUtils.random(movs.size()-1))).getSlow(ptj);
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
        rainMusic.dispose();
    }
    
    public void pausar() {
        rainMusic.stop();
    }
    
    public void continuar() {
        rainMusic.play();
    }
}
