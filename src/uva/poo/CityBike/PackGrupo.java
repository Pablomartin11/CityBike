package uva.poo.CityBike;

/**
 * Tipo abstracto de datos que implementa la funcionalidad de un Pack de Grupo.
 * @author pabmart0 pabdear.
 *
 */
public class PackGrupo extends Pack{
	
	private static final int MINBICIS = 10;
	
	/**
	 * Constructor de un PackGrupo.
	 * @param listaBicis
	 */
	public PackGrupo(Bike[] listaBicis) {
		this.setListaBicis(listaBicis);
	}

	@Override
	public double getDepositToPay(double deposit) {
		return deposit - deposit*0.20;
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
	 * Actualizar la lista de bicicletas que conforman un PackGrupal.
	 * @param lista de bicicletas.
	 * @throws IllegalArgumentException si {@code listaBicis.length < MINBICIS}
	 * @throws IllegalArgumentException si {@code if(checkBicisRepetidas)}
	 */
	@Override
	public void setListaBicis(Bike[] listaBicis) {
		// Comprueba si tiene el minimo de bicis
		if (listaBicis.length < MINBICIS) throw new IllegalArgumentException("Llamada incorrecta: El minimo de bicicletas que debe contener el Pack es de 10 de estas");
		
		// Comprueba si hay bicis repetidas
		if (super.checkBicisRepetidas(listaBicis)) throw new IllegalArgumentException("Lllamada incorrecta: no puede haber bicicletas repetidas");
		
		super.listaBicis = listaBicis;
	}
	
	/**
	 * Cambiar una bicicleta por otra en el PackGrupo.
	 * @throws IllegalArgumentException si {@code if(checkBicisRepetidas)}
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
	}
	
	/**
	 * Añadir una bici al Pack.
	 * @param biciNueva
	 * @throws IllegalArgumentException si {@code listaBicis.length < MINBICIS}
	 * @throws IllegalArgumentException si {@code if(checkBicisRepetidas)}
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
		if (size <= 10) throw new IllegalArgumentException("Llamada incorrecta: No se puede eliminar una bici si el pack tiene la cantidad minima");
		
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
		
		this.setListaBicis(nuevaListaBicis);
	}
	
	

}
