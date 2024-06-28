package Gotas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Dibujable;
import com.mygdx.game.GameScreen;
import com.mygdx.game.Movible;

import jugadorTarro.Jugador;
import jugadorTarro.Tarro;
import movimientosGotas.MovimientoGota;

public abstract class Gota implements Dibujable{
	protected int velX;
	protected int velY;
	protected Texture img;
	protected Rectangle raindrop;
	protected MovimientoGota mov;
	
	// temporal
	protected boolean relentizado;

	public Gota(int ptj, Texture img, MovimientoGota mov) {
		this.velX = MathUtils.random(-150,150);
		this.velY = ptj + 250;
		this.img = img;
		this.raindrop = new Rectangle();
		raindrop.x = MathUtils.random(0, GameScreen.getAnchoCam()-64);
		raindrop.y = Gdx.graphics.getHeight();
		raindrop.height = 64;
		raindrop.width = 64;	
		relentizado = false;
		this.mov = mov;
		
	}

	public abstract void efecto(Jugador pj);
	
	public boolean actualizacion(Jugador pj, Movible shield) {
		actualizarMov();
		if (!dentroPantalla()) return false;
		if (colision(shield)) {
			return false;
		}
		else if (colision(Tarro.getTarro())) {
			efecto(pj);
			return false;
		}
		return true;
	}
	
	public boolean actualizacion(Jugador pj) {
		actualizarMov();
		if (!dentroPantalla()) return false;
		if (colision(Tarro.getTarro())) {
			efecto(pj);
			return false;
		}
		return true;
	}
	
	@Override
	public void actualizarMov() {
		// TODO Auto-generated method stub
		//raindrop.y -=  velY * Gdx.graphics.getDeltaTime();
		//moverX();
		mov.actualizarMov(velX, velY, raindrop);
	}
	
	@Override
	public void actualizarDibujo(SpriteBatch batch) {
		// TODO Auto-generated method stub
		batch.draw(img, raindrop.x, raindrop.y, 64, 64);
	}
	
	@Override
	public boolean dentroPantalla() {
		if (raindrop.y + 64 < 0) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean colision(Movible pj) {
		if (raindrop.overlaps(pj.getArea())) {
			return true;
		}
		return false;
	}
	
	@Override
	public Rectangle getArea() {
		return raindrop;
	}
	
	@Override
	public void acelerar() {
		if (relentizado) {
			velX *= 2;
			velY *= 2;
			relentizado = false; 
		}
	}
	
	@Override
	public void relentizar() {
		if (!relentizado) {
			velX /= 2;
			velY /= 2;
			relentizado = true;
		}
	}
}