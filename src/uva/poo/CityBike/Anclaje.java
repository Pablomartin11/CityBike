package uva.poo.CityBike;

/**
 * Tipo abstracto de datos que implementa la funcionalidad de una base de anclaje de un punto de aparcamiento.
 * @author pabmart0 pabdear
 *
 */
public class Anclaje {
	
	private int id;
	private int estado; // 0 (rojo/vacio), 1 (verde/ocupado), 2 (azul/reservado), 3(apagado/inoperativo).
	private Bike biciAnclada;
	
	/**
	 * Contructor de una base de anclaje.
	 */
	public Anclaje() {
	}
	
	/**	
	 * Contructor de una base de anclaje.
	 * @param id de la base de anclaje.
	 * @param estado 0 (rojo/vacio), 1 (verde/ocupado), 2 (azul/reservado), 3 (apagada/base inoperativa).
	 * @throws IllegalArgumentException si {@code id <= 0}
	 * @throws IllegalArgumentException si {@code estado != 0 && estado != 1 && estado != 2 && estado != 3}

	 */
	public Anclaje(int id, int estado) {
		this.setId(id);
		this.setEstado(estado);
	}
	
	/**
	 * Obtener el identificador de una base de anclaje.
	 * @return el identificador.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Actualizar el identificador de una base de anclaje.
	 * @param id
	 * @throws IllegalArgumentException si {@code id <= 0}
	 */
	public void setId(int id) {
		if (id <= 0) throw new IllegalArgumentException("llamada incorrecta: id <= 0");
		this.id = id;
	}
	
	/**
	 * Obtener el estado de una base de anclaje.
	 * @return el estado 0 (rojo/vacio), 1 (verde/ocupado), 2 (azul/reservado), 3 (apagada/base inoperativa).
	 */
	public int getEstado() {
		return estado;
	}
	
	/**
	 * Actualizar el estado de una base de anclaje.
	 * @param estado
	 * @throws IllegalArgumentException si {@code estado != 0 && estado != 1 && estado != 2 && estado != 3}
	 */
	public void setEstado(int estado) {
		if (estado != 0 && estado != 1 && estado != 2 && estado != 3) throw new IllegalArgumentException("llamada incorrecta: estado != 0 || estado != 1 || estado != 2");
		this.estado = estado;
	}

	/**
	 * Obtener la bicicleta anclada al anclaje.
	 * @return bicicleta anclada.
	 */
	public Bike getBiciAnclada() {
		return biciAnclada;
	}

	/**
	 * Actualizar la bicicleta anclada al anclaje.
	 * @param biciAnclada.
	 * @throws NullPointerException si {@code biciAnclajda == null}.
	 */
	public void setBiciAnclada(Bike biciAnclada) {
		if (biciAnclada == null) throw new NullPointerException("Llamada incorrecta: la bicicleta no puede ser nula");
		this.biciAnclada = biciAnclada;
	}

	/**
	 * Obtener un String con la informacion de la base de Anclaje.
	 */
	@Override
	public String toString() {
		return "Anclaje [id=" + id + ", estado=" + estado + ", biciAnclada=" + biciAnclada.getId() + "]";
	}

	/**
	 * Comprueba si dos bases de anclaje son iguales.
	 * @param objecto al cual lo quieres comparar.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anclaje other = (Anclaje) obj;
		if (estado != other.estado)
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
