package uva.poo.CityBike;

/**
 * Tipo abstracto de datos que implementa toda la funcionalida de una bicicleta para adultos.
 * @author pabmart0 pabdear
 *
 */
public class AdultBike extends Bike {
	
	private String talla;
	private double fianza;
	
	
	/**
	 * Constructor de AdultBike.
	 * @param id
	 * @param marca
	 * @param modelo
	 * @param peso
	 * @param numPlatos
	 * @param numPinones
	 * @param talla
	 * @param fianza
	 * @throws IllegalArgumentException si {@code fianza < 0}
	 * @throws IllegalArgumentException si {@code numPlatos < 0}
	 * @throws IllegalArgumentException si {@code numPinones < 0}
	 */
	public AdultBike(int id, String marca, String modelo, double peso, int numPlatos, int numPinones, String talla, double fianza) {
		super(id,marca,modelo,peso,numPlatos,numPinones);
		this.setFianza(fianza);
		this.setTalla(talla);
	}

	@Override
	public double getDepositToPay(double deposit) {
		return deposit;
	}

	@Override
	public String getTalla() {
		return this.talla;
	}

	/**
	 * @throws IllegalArgumentException si {@code if(!talla.equals("S") && !talla.equals("M") && !talla.equals("L") && !talla.equals("XL"))}
	 */
	@Override
	protected void setTalla(Object tallaNueva) {
		String talla = (String) tallaNueva;
		if (!talla.equals("S") && !talla.equals("M") && !talla.equals("L") && !talla.equals("XL")) {
			throw new IllegalArgumentException("Llamada incorrecta: talla no disponible"); 
		}
		this.talla = talla;
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
		if(fianza<0) {
			throw new IllegalArgumentException("La fianza no puede ser negativa");
		}
		this.fianza = this.getDepositToPay(fianza);
	}

	@Override
	public String toString() {
		return super.toString()+"AdultBike [talla=" + talla + ", fianza=" + fianza + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (getClass() != obj.getClass())
			return false;
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		AdultBike other = (AdultBike) obj;
		if (this.getFianza() != other.getFianza())
			return false;		
		if (!talla.equals(other.talla))
			return false;
		return true;
	}
	
	

}
