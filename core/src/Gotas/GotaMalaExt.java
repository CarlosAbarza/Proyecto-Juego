package Gotas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import jugadorTarro.Jugador;
import movimientosGotas.MovimientoGota;

public class GotaMalaExt extends Gota {

	public GotaMalaExt(int ptj, MovimientoGota mov) {
		super(ptj, new Texture(Gdx.files.internal("gotaRoja.png")), mov);
	}

	@Override
	public void efecto(Jugador pj) {
		// TODO Auto-generated method stub
		pj.dañar(3);
	}

}
