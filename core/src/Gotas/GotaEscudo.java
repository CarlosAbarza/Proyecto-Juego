package Gotas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

import jugadorTarro.Jugador;
import movimientosGotas.MovimientoGota;

public class GotaEscudo extends Gota {
	private Sound sonido;

	public GotaEscudo(int ptj, MovimientoGota mov) {
		super(ptj, new Texture(Gdx.files.internal("gotaVerde.png")), mov);
		sonido = Gdx.audio.newSound(Gdx.files.internal("sonidoShield.mp3"));
	}

	@Override
	public void efecto(Jugador pj) {
		pj.recargaShield();
		sonido.play();
	}

}
