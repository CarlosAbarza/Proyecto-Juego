package factorias;

import Gotas.Gota;
import Gotas.GotaBuenaMedio;
import Gotas.GotaMalaMedio;
import Gotas.GotaSlow;
import movimientosGotas.CaidaDiagonal;
import movimientosGotas.MovimientoGota;

public class MedioFactory implements GotaFactory {
	private MovimientoGota mov;
	
	public MedioFactory() {
		this.mov = new CaidaDiagonal();
	}
	
	@Override
	public Gota crearBuena(int ptj) {
		return new GotaBuenaMedio(ptj, mov);
	}

	@Override
	public Gota crearMala(int ptj) {
		return new GotaMalaMedio(ptj, mov);
	}

	@Override
	public Gota crearExtra(int ptj) {
		return new GotaSlow(ptj, mov);
	}
}
