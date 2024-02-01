package uva.poo.CityBike;

/**
 * Tipo abstracto de datos que implementa la funcionalidad de una base de anclaje de un punto de aparcamiento.
 * @author pablo
 *
 */
public class Anclaje {
	
	private int id;
	private int estado; // 0 (rojo/vacio), 1 (verde/ocupado), 2 (azul/reservado), 3(apagado/inoperativo).
	
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
	

}
