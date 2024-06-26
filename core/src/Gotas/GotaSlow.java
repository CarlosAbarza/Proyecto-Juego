package Gotas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

import jugadorTarro.Jugador;
import movimientosGotas.MovimientoGota;

public class GotaSlow extends Gota {
	private Sound sonido;
	
	public GotaSlow(int ptj, MovimientoGota mov) {
		super(ptj, new Texture(Gdx.files.internal("gotaMorada.png")), mov);
		sonido = Gdx.audio.newSound(Gdx.files.internal("sonidoSlow.mp3"));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void efecto(Jugador pj) {
		pj.recargaSlow();
		sonido.play();
	}

}
