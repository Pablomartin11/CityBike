package uva.poo.CityBike;

/**
 * Tipo abstracto de datos que implementa la funcionalidad de una bicicleta electrica.
 * @author pabmart0 pabdear.
 *
 */
public class ElectricBike extends Bike{

	private double fianza;
	private String talla;
	private double par;
	private double voltaje;
	private double cargaElectrica;
	
	/**
	 * Constructor de ElectricBike
	 * @param id
	 * @param marca
	 * @param modelo
	 * @param peso
	 * @param numPlatos
	 * @param numPinones
	 * @param talla
	 * @param fianza
	 * @param par
	 * @param voltaje
	 * @param cargaElectrica
	 * @throws IllegalArgumentexception si {@code fianza < 0}
	 * @throws IllegalArgumentException si {@code if(!talla.equals("S") && !talla.equals("M") && !talla.equals("L") && !talla.equals("XL"))}
	 * @throws IllegalArgumentException si {@code par < 0}
	 * @throws IllegalArgumentException si {@code voltaje < 0}
	 * @throws IllegalArgumentException si {@code cargaBateria < 0}
	 */
	public ElectricBike(int id, String marca, String modelo, double peso, int numPlatos, int numPinones, String talla, double fianza, double par, double voltaje, double cargaElectrica) {
		super(id,marca,modelo,peso,numPlatos,numPinones);
		this.setFianza(fianza);
		this.setTalla(talla);
		this.setPar(par);
		this.setVoltaje(voltaje);
		this.setCargaElectrica(cargaElectrica);
	}

	@Override
	public double getDepositToPay(double deposit) {
		return deposit + deposit*this.getVoltaje()/100;
	}
	
	/**
	 * Obtener la fianza de la bicicleta electrica.
	 */
	public double getFianza() {
		return fianza;
	}

	/**
	 * Actualizar la fianza de la bicicleta electrica.
	 * @throws IllegalArgumentexception si {@code fianza < 0}
	 */
	public void setFianza(double fianza) {
		if (fianza < 0) throw new IllegalArgumentException("Fianza no puede ser negativa");
		this.fianza = fianza;
	}

	/**
	 * Obtener la talla de la bicicleta electrica.
	 */
	@Override
	public String getTalla() {
		return talla;
	}

	/**
	 * Actualizar la talla de la bicicleta electrica.
	 * @param la nueva talla.
	 * @throws IllegalArgumentException si {@code if(!talla.equals("S") && !talla.equals("M") && !talla.equals("L") && !talla.equals("XL"))}
	 */
	@Override
	protected void setTalla(Object tallaNueva) {
		String talla = (String) tallaNueva;
		if (!talla.equals("S") && !talla.equals("M") && !talla.equals("L") && !talla.equals("XL")) throw new IllegalArgumentException("Llamada incorrecta: talla no disponible"); 
		this.talla = talla;
	}

	/**
	 * Obtener el par del motor electrico de la bicicleta en Newtons por metro (Nm).
	 * @return par del motor.
	 */
	public double getPar() {
		return par;
	}

	/**
	 * Actualizar el par del motor electrico de la bicicleta en Newtons por metro (Nm).
	 * @param par del motor.
	 * @throws IllegalArgumentException si {@code par < 0}
	 */
	private void setPar(double par) {
		if(par < 0 ) throw new IllegalArgumentException("par no puede ser negativo");
		this.par = par;
	}

	/**
	 * Obtener el voltaje de la bateria de la bicicleta en Voltios (V).
	 * @return el voltaje de la bateria de la bicicleta.
	 */
	public double getVoltaje() {
		return voltaje;
	}

	/**
	 * Actualizar el voltaje de la bateria de la bicicleta en Voltios (V).
	 * @param voltaje de la beteria.
	 * @throws IllegalArgumentException si {@code voltaje < 0}
	 */
	private void setVoltaje(double voltaje) {
		if(voltaje < 0 ) throw new IllegalArgumentException("voltaje no puede ser negativo");
		this.voltaje = voltaje;
	}

	/**
	 * Obtener la carga electrica de la bateria de la bicicleta en Amperios hora (Ah).
	 * @return la carga de la bateria.
	 */
	public double getCargaElectrica() {
		return cargaElectrica;
	}

	/**
	 * Actualizar la carga electrica de la bateria de la bicicleta en Amperios hora (Ah)
	 * @param cargaBateria
	 * @throws IllegalArgumentException si {@code cargaBateria < 0}
	 */
	private void setCargaElectrica(double cargaBateria) {
		if(cargaBateria < 0 ) throw new IllegalArgumentException("voltaje no puede ser negativo");
		this.cargaElectrica = cargaBateria;
	}

	/**
	 * Obtener la energia almacenada en la bateria en Kilowatios hora.
	 * @return la energia almacenada en la bateria.
	 */
	public double getEnergiaAlamcenada() {
		return this.getVoltaje()*this.getCargaElectrica();
	}

	@Override
	public String toString() {
		return super.toString()+"ElectricBike [fianza=" + fianza + ", talla=" + talla + ", par=" + par + ", voltaje=" + voltaje
				+ ", cargaElectrica=" + cargaElectrica + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ElectricBike other = (ElectricBike) obj;
		if (Double.doubleToLongBits(cargaElectrica) != Double.doubleToLongBits(other.cargaElectrica))
			return false;
		if (Double.doubleToLongBits(fianza) != Double.doubleToLongBits(other.fianza))
			return false;
		if (Double.doubleToLongBits(par) != Double.doubleToLongBits(other.par))
			return false;
		if (talla == null) {
			if (other.talla != null)
				return false;
		} else if (!talla.equals(other.talla))
			return false;
		if (Double.doubleToLongBits(voltaje) != Double.doubleToLongBits(other.voltaje))
			return false;
		return true;
	}

	


	
	
	
	
}
