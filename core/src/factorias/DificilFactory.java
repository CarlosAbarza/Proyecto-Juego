package factorias;

import com.badlogic.gdx.math.MathUtils;

import Gotas.GotaBuena;
import Gotas.GotaEscudo;
import Gotas.GotaMala;
import Gotas.GotaSlow;
import movimientosGotas.CaidaZigZag;
import movimientosGotas.MovimientoGota;

public class DificilFactory implements GotaFactory {
	private MovimientoGota mov;
	
	public DificilFactory() {
		this.mov = new CaidaZigZag();
	}
	
	@Override
	public GotaBuena crearBuena(int ptj) {
		return new GotaBuena(MathUtils.random(-150,150), (ptj + 250), mov);
	}

	@Override
	public GotaMala crearMala(int ptj) {
		return new GotaMala(MathUtils.random(-150,150), (ptj + 250), mov);
	}

	@Override
	public GotaEscudo crearEscudo(int ptj) {
		return new GotaEscudo(MathUtils.random(-150,150), (ptj + 250), mov);
	}

	@Override
	public GotaSlow crearSlow(int ptj) {
		return new GotaSlow(MathUtils.random(-150,150), (ptj + 250), mov);
	}
}
