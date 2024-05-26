package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Shield implements Dibujable {
	private Rectangle shield;
	private Texture shieldImg;
	private float timeMax;
	private float timeLeft;
	private float anchoCam;
	private int velX;
	private boolean relentizado;
	private boolean activo;
	
	public Shield(float anchoCam) {
		shieldImg = new Texture(Gdx.files.internal("barraAzulP.png"));
		timeMax = 3f;
		timeLeft = timeMax;
		this.anchoCam = anchoCam;
		velX = 400;
		relentizado = false;
		activo = false;
		
	}
	
	public void crear() {
		shield = new Rectangle();
		shield.x = anchoCam / 2 - 93 / 2;
		shield.y = 80;
		shield.width = 93;
		shield.height = 32;
	}
	
	@Override
	public void actualizarMov() {
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) shield.x -= velX * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) shield.x += velX * Gdx.graphics.getDeltaTime();
        // que no se salga de los bordes izq y der
        if(!dentroPantalla()) {
        	if (shield.x < 0) {
        		shield.x = 0;
        	}
        	else {
        		shield.x = anchoCam - shield.width;
        	}
        }
	}

	@Override
    public boolean dentroPantalla() {
    	if (shield.x < 0) 
    		return false;
    	if (shield.x > anchoCam - shield.width) {
    		return false;
    	}
    	return true;
    }

	@Override
	public void actualizarDibujo(SpriteBatch batch) {
		// TODO Auto-generated method stub
		batch.draw(shieldImg, shield.x, shield.y);
	}

	@Override
	public boolean colision(Movible obj) {
		if (shield.overlaps(obj.getArea())) {
			return true;
		}
		return false;
	}

	@Override
	public Rectangle getArea() {
		return shield;
	}

	@Override
	public void acelerar() {
		if (relentizado) {
			velX *= 2;
			relentizado = false;
		}
	}

	@Override
	public void relentizar() {
		if (!relentizado) {
			velX /= 2; 
			relentizado = true;
		}
	}
	
	public void activar() {
		activo = true;
	}
	
	public void desactivar() {
		activo = false;
	}
	
	public void resetTime() {
		timeLeft = timeMax;
	}
	
	public boolean estado() {
		return activo;
	}

	public String getTimeLeft() {
		String truncatedNumber = String.format("%.2f", timeLeft);
        return truncatedNumber;
	}
	
	public void usar(float time) {
		timeLeft -= time;
		if (timeLeft < 0) {
			timeLeft = 0;
		}
	}
	
	public boolean puede() {
		return timeLeft > 0;
	}
	
	public void recarga() {
		timeLeft = timeMax;
	}
}
