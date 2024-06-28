package factorias;

import Gotas.Gota;
import Gotas.GotaBuenaFacil;
import Gotas.GotaEscudo;
import Gotas.GotaMalaFacil;
import movimientosGotas.CaidaRecta;
import movimientosGotas.MovimientoGota;

public class FacilFactory implements GotaFactory {
	private MovimientoGota mov;
	
	public FacilFactory() {
		this.mov = new CaidaRecta();
	}
	
	@Override
	public Gota crearBuena(int ptj) {
		return new GotaBuenaFacil(ptj, mov);
	}

	@Override
	public Gota crearMala(int ptj) {
		return new GotaMalaFacil(ptj, mov);
	}

	@Override
	public Gota crearExtra(int ptj) {
		return new GotaEscudo(ptj, mov);
	}

}
