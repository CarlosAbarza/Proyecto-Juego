package Gotas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import jugadorTarro.Jugador;
import movimientosGotas.MovimientoGota;

public class GotaMala extends Gota {
	
	public GotaMala(int velX, int velY, MovimientoGota mov) {
		super(velX, velY, new Texture(Gdx.files.internal("gotaRoja.png")), mov);
	}

	@Override
	public void efecto(Jugador pj) {
		// TODO Auto-generated method stub
		pj.dañar();
	}

}
