package factorias;

import Gotas.Gota;

public interface GotaFactory {
	public Gota crearBuena(int ptj);
	public Gota crearMala(int ptj);
	public Gota crearExtra(int ptj);
}
