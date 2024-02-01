package uva.poo.CityBike;

/**
 * Tipo abstracto de datos que implementa la funcionalidad de un PackFamiliar.
 * @author pabmart0 pabdear
 *
 */
public class PackFamiliar extends Pack{
	
	private static final int MINBICIS = 4;
	private static final int INFANTILES = 2;

	/**
	 * Constructor de un PackFamiliar.
	 * @param listaBicis
	 * @throws IllegalArgumentException si {@code listaBicis.length < MINBICIS}
	 * @throws IllegalArgumentException si {@code contadorInfantiles < INFANTILES}
	 * @throws IllegalArgumentexception si {@code if(checkBicisRepetidas(listaBicis)}
	 */
	public PackFamiliar(Bike[] listaBicis) {
		this.setListaBicis(listaBicis);
	}
	
	@Override
	public double getDepositToPay(double deposit) {
		return deposit - deposit*0.50;
	}

	@Override
	public void setFianzaPack(double fianzaPack) {
		double sumaFianzas = 0;
		for (int i = 0; i < this.listaBicis.length; i++) {
			sumaFianzas += this.listaBicis[i].getFianza();
		}
		super.fianzaPack = this.getDepositToPay(sumaFianzas);
	}

	/**
	 * Actualiza la lista de bicicletas del PackFamiliar.
	 * @throws IllegalArgumentException si {@code listaBicis.length < MINBICIS}
	 * @throws IllegalArgumentException si {@code contadorInfantiles < INFANTILES}
	 * @throws IllegalArgumentexception si {@code if(checkBicisRepetidas(listaBicis)}
	 */
	@Override
	public void setListaBicis(Bike[] listaBicis) {
		// Comprueba si tiene minimo 4 bicis
		if (listaBicis.length < MINBICIS) throw new IllegalArgumentException("Llamada incorrecta: El Pack Familiar debe tener al menos 4 bicicletas");
		
		// Comprueba si tiene minimo 2 bicis infantiles
		int contadorInfantiles = this.getNumeroDeBicisInfantiles(listaBicis);
		if (contadorInfantiles < INFANTILES) throw new IllegalArgumentException("llamada incorrecta: El Pack Familiar debe tener al menos 2 bicicletas infantiles");
		
		// Comprueba si hay bicis repetidas
		if (super.checkBicisRepetidas(listaBicis)) throw new IllegalArgumentException("Lllamada incorrecta: no puede haber bicicletas repetidas");

		
		super.listaBicis = listaBicis;
	}
	
	/**
	 * Obtener el numero de bicicletas infantiles que contiene la lista de bicicletas que se desea emplear en el Pack Familiar.
	 * @param listaBicis
	 * @return numero de bicicletas infantiles.
	 */
	private int getNumeroDeBicisInfantiles(Bike[] listaBicis) {
		int contadorInfantiles = 0;
		for(int i=0;i<listaBicis.length;i++) {
			if(listaBicis[i].getClass() == ChildBike.class) contadorInfantiles++;
		}
		return contadorInfantiles;
	}
	
	/**
	 * Cambiar una bicicleta por otra del PackFamiliar.
	 * @throws IllegalArgumentException si {@code if(checkBicisRepetidas(listaBicis))}
	 * @throws IllegalArgumentException si {@code listaBicis.length < MINBICIS}
	 * @throws IllegalArgumentexception si {@code contadorInfantiles < INFANTILES}
	 */
	@Override
	public void cambiarBiciDelPack(Bike biciNueva, Bike biciEliminar) {
		for (int i = 0; i < this.listaBicis.length; i++) {
			if (this.listaBicis[i].equals(biciEliminar)) {
				this.listaBicis[i] = biciNueva;
			}
		}
		// Comprueba si hay bicis repetidas
		if (super.checkBicisRepetidas(listaBicis)) throw new IllegalArgumentException("Lllamada incorrecta: no puede haber bicicletas repetidas");

		// Comprueba si tiene minimo 4 bicis
		if (listaBicis.length < MINBICIS) throw new IllegalArgumentException("Llamada incorrecta: El Pack Familiar debe tener al menos 4 bicicletas");
			
		// Comprueba si tiene minimo 2 bicis infantiles
		int contadorInfantiles = this.getNumeroDeBicisInfantiles(listaBicis);
		if (contadorInfantiles < INFANTILES) throw new IllegalArgumentException("llamada incorrecta: El Pack Familiar debe tener al menos 2 bicicletas infantiles");			
	}
	
	/**
	 * Añadir una bici al Pack.
	 * @param biciNueva
	 * @throws IllegalArgumentException si {@code listaBicis.length < MINBICIS}
	 * @throws IllegalArgumentException si {@code contadorInfantiles < INFANTILES}
	 * @throws IllegalArgumentexception si {@code if(checkBicisRepetidas(listaBicis)}
	 */
	public void addBiciAlPack(Bike biciNueva) {
		int size = this.getListaBicis().length;
		Bike[] nuevaListaBicis = new Bike[size+1];
		
		for (int i = 0; i < size; i++) {
			nuevaListaBicis[i] = this.getListaBicis()[i]; 
		}
		nuevaListaBicis[size] = biciNueva;
		
		this.setListaBicis(nuevaListaBicis);
	}
	
	/**
	 * Eliminar bici del Pack.
	 * @param bici a eliminar.
	 * @throws IllegalArgumentException si {@code size < 10}
	 */
	public void removeBiciDelPack(Bike bici) {
		int size = this.getListaBicis().length;
		if (size < 4) throw new IllegalArgumentException("Llamada incorrecta: PackFamiliar debe tener al menos 4 bicicletas");
		if (this.getNumeroDeBicisInfantiles(this.getListaBicis()) < 2) throw new IllegalArgumentException("Llamada incorrecta: PackFamiliar debe tener al menos 2 bicicletas infantiles");
		
		Bike[] nuevaListaBicis = new Bike[size-1];

		boolean bandera = false;
		
		// la idea es hacer un bucle que vaya metiendo en el nuevo los elementos del antiguo, cuando encuentre el que hay que eliminar, no lo mete y a partir de ese punto hay que empezar a meter el i+1
		for (int i = 0; i < size-1; i++) {
			if (!this.getListaBicis()[i].equals(bici)) {
				nuevaListaBicis[i] = this.getListaBicis()[i];
			} else bandera = true;

			if (bandera) {
				nuevaListaBicis[i] = this.getListaBicis()[i+1];
			}
		}
	}
	
}
