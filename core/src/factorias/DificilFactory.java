package factorias;

import Gotas.Gota;
import Gotas.GotaBuenaDificil;
import Gotas.GotaMalaDificil;
import Gotas.GotaVida;
import movimientosGotas.CaidaZigZag;
import movimientosGotas.MovimientoGota;

public class DificilFactory implements GotaFactory {
	private MovimientoGota mov;
	
	public DificilFactory() {
		this.mov = new CaidaZigZag();
	}
	
	@Override
	public Gota crearBuena(int ptj) {
		return new GotaBuenaDificil(ptj, mov);
	}

	@Override
	public Gota crearMala(int ptj) {
		return new GotaMalaDificil(ptj, mov);
	}

	@Override
	public Gota crearExtra(int ptj) {
		return new GotaVida(ptj, mov);
	}
}
