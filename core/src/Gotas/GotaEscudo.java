package Gotas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import jugadorTarro.Jugador;
import movimientosGotas.MovimientoGota;

public class GotaEscudo extends Gota {

	public GotaEscudo(int velX, int velY, MovimientoGota mov) {
		super(velX, velY, new Texture(Gdx.files.internal("gotaVerde.png")), mov);
	}

	@Override
	public void efecto(Jugador pj) {
		pj.recargaShield();

	}

}
