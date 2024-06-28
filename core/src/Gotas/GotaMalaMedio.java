package Gotas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import jugadorTarro.Jugador;
import movimientosGotas.MovimientoGota;

public class GotaMalaMedio extends Gota {
	
	public GotaMalaMedio(int ptj, MovimientoGota mov) {
		super(ptj, new Texture(Gdx.files.internal("gotaRoja.png")), mov);
	}

	@Override
	public void efecto(Jugador pj) {
		// TODO Auto-generated method stub
		pj.dañar(1);
	}

}
