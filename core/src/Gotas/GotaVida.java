package Gotas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

import jugadorTarro.Jugador;
import movimientosGotas.MovimientoGota;

public class GotaVida extends Gota {
	private Sound sonido;
	
	public GotaVida(int velY, MovimientoGota mov) {
		super(velY, new Texture(Gdx.files.internal("corazon.png")), mov);
		sonido = Gdx.audio.newSound(Gdx.files.internal("sonidoVida.mp3"));
	}
	
	
	@Override
	public void efecto(Jugador pj) {
		// TODO Auto-generated method stub
		pj.curar();
		sonido.play();
	}

}
