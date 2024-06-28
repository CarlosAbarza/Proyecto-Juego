package factorias;

import java.util.ArrayList;

import com.badlogic.gdx.math.MathUtils;

import Gotas.GotaBuena;
import Gotas.GotaEscudo;
import Gotas.GotaMala;
import Gotas.GotaSlow;
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
	public GotaBuena crearBuena(int ptj) {
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
		return new GotaBuena(MathUtils.random(-150,150), (ptj + 250), mov);
	}

	@Override
	public GotaMala crearMala(int ptj) {
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
		return new GotaMala(MathUtils.random(-150,150), (ptj + 250), mov);
	}

	@Override
	public GotaEscudo crearEscudo(int ptj) {
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
		return new GotaEscudo(MathUtils.random(-150,150), (ptj + 250), mov);
	}

	@Override
	public GotaSlow crearSlow(int ptj) {
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
		return new GotaSlow(MathUtils.random(-150,150), (ptj + 250), mov);
	}

}
