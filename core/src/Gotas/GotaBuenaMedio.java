package Gotas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

import jugadorTarro.Jugador;
import movimientosGotas.MovimientoGota;

public class GotaBuenaMedio extends Gota {
	private Sound dropSound;
	private int ptj;
	
	public GotaBuenaMedio(int velY, MovimientoGota mov) {
		super(velY, new Texture(Gdx.files.internal("drop.png")), mov);
		this.dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
		this.ptj = 10;
	}

	@Override
	public void efecto(Jugador pj) {
		// TODO Auto-generated method stub
		pj.sumarPuntos(ptj);
		dropSound.play();
	}

	public Sound getDropSound() {
		return dropSound;
	}

	public void setDropSoud(Sound dropSoud) {
		this.dropSound = dropSoud;
	}
}
