package uva.poo.CityBike;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Tipo abstracto de datos que implementa toda la funcionalidad de un Pack.
 * @author pabmart0 pabdear.
 *
 */
public abstract class Pack implements Resource{
	protected double fianzaPack;
	protected Bike listaBicis[];
	
	
	/**
	 * Constructor de un Pack.
	 */
	protected Pack() {
	}
	
	/**
	 * Obtener el precio de la fianza de un pack.
	 * @return precio del pack
	 */
	public double getFianzaPack() {
		return fianzaPack;
	}
	
	/**
	 * Actualizar la fianza de un pack.
	 * @param fianzaPack
	 */
	public abstract void setFianzaPack(double fianzaPack);

	/**
	 * Obtener la lista de bicis que conforman un pack.
	 * @return lista de las bicis.
	 */
	public Bike[] getListaBicis() {
		return listaBicis;
	}
	
	/**
	 * Actualizar la lista de bicis que conforman un pack.
	 * @param listaBicis.
	 */
	public abstract void setListaBicis(Bike[] listaBicis);

	/**
	 * Comprueba si hay bicicletas repetidas en una lista de bicicletas.
	 * @param listaBicis
	 * @return boolean.
	 */
	protected boolean checkBicisRepetidas(Bike[] listaBicis) {
		for (int i = 0; i < listaBicis.length; i++) {
			for (int j = 0; j < listaBicis.length; j++) {
				if(listaBicis[i].equals(listaBicis[j]) && i!=j) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Permite cambiar una bicicleta por otra dentro del pack.
	 * @param biciNueva
	 * @param biciEliminar
	 */
	public abstract void cambiarBiciDelPack(Bike biciNueva, Bike biciEliminar);

	/**
	 * Obtener el numero de bicicletas que existen en el pack.
	 * @return el numero de bicicletas.
	 */
	public int getNumeroBicisDelPack() {
		return this.listaBicis.length;
	}
	
	/**
	 * Comprueba si una bicicleta pertenece al Pack.
	 * @param bici
	 * @return boolean
	 */
	public boolean checkBiciPerteneceAlPack(Bike bici) {
		for(int i = 0; i < this.listaBicis.length; i++) {
			if (this.listaBicis[i].equals(bici)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Obtener un String con toda la informacion importante sobre un Pack.
	 */
	@Override
	public String toString() {
		return "Pack [fianzaPack=" + fianzaPack + ", listaBicis=" + Arrays.toString(listaBicis) + "]";
	}

	/**
	 * Comprueba si un objeto es igual a un Pack.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pack other = (Pack) obj;
		if (Double.doubleToLongBits(fianzaPack) != Double.doubleToLongBits(other.fianzaPack))
			return false;
		if (!Arrays.equals(listaBicis, other.listaBicis))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
