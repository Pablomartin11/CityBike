package uva.poo.CityBike;

/**
 * Tipo abstracto de datos que implementa la funcionalidad de una bicicleta.
 * Ademas implementa Resource;
 * @author pabmart0 pabdear
 */
public abstract class Bike implements Resource{
	
	private int id;
	private String marca;
	private String modelo;
	private double peso;
	private int numPlatos;
	private int numPinones;

	
	/**
	 * Constructor de una bicicleta.
	 * @param id
	 * @param marca
	 * @param modelo
	 * @param peso
	 * @param numPlatos
	 * @param numPi�ones
	 * @throws IllegalArgumentException si {@code peso < 0}
	 * @throws IllegalArgumentException si {@code numPlatos < 0}
	 * @throws IllegalArgumentException si {@code numPinones < 0}
	 */
	protected Bike(int id, String marca, String modelo, double peso, int numPlatos, int numPinones) {
		this.setId(id);
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setPeso(peso);
		this.setNumPlatos(numPlatos);
		this.setNumPinones(numPinones);
	}
	
	/**
	 * Obtener el id de la bicicleta.
	 * @return el id de la bicicleta.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Actualizar el id de la bicicleta.
	 * @param id de la bicicleta
	 */
	private void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtener el nombre de la marca de la bicicleta.
	 * @return el nombre de la marca de la bicicleta.
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Actualizar el nombre de la marca de la bicicleta.
	 * @param marca de la bicicleta.
	 */
	private void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Obtener el modelo de la bicicleta.
	 * @return el modelo de la bicicleta.
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Actualizar el modelo dela bicicleta.
	 * @param modelo de la bicicleta.
	 */
	private void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Obtener la talla de la bicicleta.
	 * Cambia en funcion del tipo de la bicicleta.
	 * @return la talla de la bicicleta.
	 */
	public abstract Object getTalla();

	/**
	 * Actualizar la talla de la bicicleta.
	 * Cambia en funcion de la bicicleta.
	 * @param talla de la bicicleta.
	 */
	protected abstract void setTalla(Object talla);

	/**
	 * Obtener el peso de la bicicleta.
	 * @return el peso de la bicicleta.
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * Actualizar el peso de la bicicleta.
	 * @param peso de la bicicleta.
	 * @throws IllegalArgumentException si {@code peso < 0}
	 */
	private void setPeso(double peso) {
		if(peso<0) {
			throw new IllegalArgumentException("El peso no puede ser negativo");
		}
		this.peso = peso;
	}

	/**
	 * Obtener el numero de platos de la bicicleta.
	 * @return el numero de platos de la bicicleta.
	 */
	public int getNumPlatos() {
		return numPlatos;
	}

	/**
	 * Actualizar el numero de platos de la bicicleta.
	 * @param numPlatos de la bicicleta.
	 * @throws IllegalArgumentException si {@code numPlatos < 0}
	 */
	private void setNumPlatos(int numPlatos) {
		if(numPlatos<0) {
			throw new IllegalArgumentException("El numero de platos no puede ser negativo");
		}
		this.numPlatos = numPlatos;
	}

	/**
	 * Obtener el numero de pi�ones de la bicicleta.
	 * @return el numero de pi�ones de la bicicleta.
	 */
	public int getNumPinones() {
		return numPinones;
	}

	/**
	 * Actualizar el numero de pi�ones de la bicicleta.
	 * @param numPi�ones de la bicicleta.
	 * @throws IllegalArgumentException si {@code numPinones < 0}
	 */
	private void setNumPinones(int numPinones) {
		if(numPinones<0) {
			throw new IllegalArgumentException("El numero de pinones no puede ser negativo");
		}
		this.numPinones = numPinones;
	}

	/**
	 * Obtener la fianza de la bicicleta.
	 * @return la fianza de la bicicleta.
	 */
	public abstract double getFianza();

	/**
	 * Actualizar la fianza de la bicicleta.
	 * @param fianza de la bicicleta.
	 */
	public abstract void setFianza(double fianza);

	@Override
	public String toString() {
		return "Bike [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", peso=" + peso + ", numPlatos="
				+ numPlatos + ", numPinones=" + numPinones + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bike other = (Bike) obj;
		if (id != other.id)
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (numPinones != other.numPinones)
			return false;
		if (numPlatos != other.numPlatos)
			return false;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
			return false;
		return true;
	}
	

	
	
	

}
