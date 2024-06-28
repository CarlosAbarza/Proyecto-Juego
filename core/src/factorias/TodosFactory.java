package factorias;

import java.util.ArrayList;

import com.badlogic.gdx.math.MathUtils;

import Gotas.Gota;
import Gotas.GotaBuenaExt;
import Gotas.GotaBuenaFacil;
import Gotas.GotaEscudo;
import Gotas.GotaMalaExt;
import Gotas.GotaSlow;
import Gotas.GotaVida;
import movimientosGotas.CaidaDiagonal;
import movimientosGotas.CaidaRecta;
import movimientosGotas.CaidaZigZag;
import movimientosGotas.MovimientoGota;

public class TodosFactory implements GotaFactory {
	private ArrayList<MovimientoGota> movs;
	
	public TodosFactory() {
		movs = new ArrayList<>();
		movs.add(new CaidaRecta());
		movs.add(new CaidaDiagonal());
		movs.add(new CaidaZigZag());
	}
	
	@Override
	public Gota crearBuena(int ptj) {
		int aux = MathUtils.random(0,10);
		if (aux < 2) {
			aux = 0;
		}
		else if (aux < 6) {
			aux = 1;
		}
		else {
			aux = 2;
		}
		MovimientoGota mov = movs.get(aux);
		return new GotaBuenaExt(ptj, mov);
	}

	@Override
	public Gota crearMala(int ptj) {
		int aux = MathUtils.random(0,10);
		if (aux < 2) {
			aux = 0;
		}
		else if (aux < 6) {
			aux = 1;
		}
		else {
			aux = 2;
		}
		MovimientoGota mov = movs.get(aux);
		return new GotaMalaExt(ptj, mov);
	}

	@Override
	public Gota crearExtra(int ptj) {
		int aux = MathUtils.random(0,10);
		if (aux < 2) {
			aux = 0;
		}
		else if (aux < 6) {
			aux = 1;
		}
		else {
			aux = 2;
		}
		MovimientoGota mov = movs.get(aux);
		int tipo = MathUtils.random(0, 2);
		if (tipo == 0)
			return new GotaEscudo(ptj, mov);
		else if(tipo == 1) 
			return new GotaSlow(ptj,mov);
		else
			return new GotaVida(ptj,mov);
	}

}
