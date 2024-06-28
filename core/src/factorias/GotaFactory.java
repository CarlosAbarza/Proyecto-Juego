package factorias;

import Gotas.GotaBuena;
import Gotas.GotaEscudo;
import Gotas.GotaMala;
import Gotas.GotaSlow;

public interface GotaFactory {
	public GotaBuena crearBuena(int ptj);
	public GotaMala crearMala(int ptj);
	public GotaEscudo crearEscudo(int ptj);
	public GotaSlow crearSlow(int ptj);
}
