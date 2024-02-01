package uva.poo.CityBike;

/**
 * Tipo abtracto de datos que implementa la funcionalidad de una bicicleta infantil.
 * @author pabmart0 pabdear
 *
 */
public class ChildBike extends Bike{
	
	private int talla;
	private double fianza;
	
	/**
	 * Constructor de ChildBike.
	 * @param id
	 * @param marca
	 * @param modelo
	 * @param peso
	 * @param numPlatos
	 * @param numPinones
	 * @param talla
	 * @param fianza
	 * @throws IllegalArgumentException si {@code numPlatos < 0}
	 * @throws IllegalArgumentException si {@code numPinones < 0}
	 * @throws IllegalArgumentException si {@code fianza < 0}
	 * @throws IllegalArgumentException si {@code if ((int) talla % 2 != 0 && ((int) talla < 12 || (int) talla > 26 ))}
	 */
	public ChildBike(int id, String marca, String modelo, double peso, int numPlatos, int numPinones, int talla, double fianza) {
		super(id,marca,modelo,peso,numPlatos,numPinones);
		this.setFianza(fianza);
		this.setTalla(talla);
	}
	
	@Override
	public double getDepositToPay(double deposit) {
		return deposit - deposit*0.15;
	}

	@Override
	public Integer getTalla() {
		return this.talla;
	}

	/**
	 * @throws IllegalArgumentException si {@code if ((int) talla % 2 != 0 && ((int) talla < 12 || (int) talla > 26 ))}
	 */
	@Override
	public void setTalla(Object talla) {
		if ((int) talla % 2 != 0 && ((int) talla < 12 || (int) talla > 26 )) throw new IllegalArgumentException("talla incorrecta");
		this.talla = (int)talla;
	}

	@Override
	public double getFianza() {
		return this.fianza;
	}

	/**
	 * @throws IllegalArgumentException si {@code fianza < 0}
	 */
	@Override
	public void setFianza(double fianza) {
		if(fianza < 0 ) throw new IllegalArgumentException("fianza no puede ser negativa");
		this.fianza = this.getDepositToPay(fianza);
	}

	@Override
	public String toString() {
		return super.toString()+"ChildBike [talla=" + talla + ", fianza=" + fianza + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChildBike other = (ChildBike) obj;
		if (Double.doubleToLongBits(fianza) != Double.doubleToLongBits(other.fianza))
			return false;
		if (talla != other.talla)
			return false;
		return true;
	}

	
	
	

}
