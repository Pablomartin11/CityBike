package uva.poo.CityBike;

import java.util.ArrayList;
import java.util.List;

/**
 * Tipo abstracto de datos que implementa la funcionalidad del sistema general de puntos de aparcamiento de bicicletas de una ciudad.
 * @author pabmart0 pabdear
 *
 */
public class CityBikeSystem {
	private double fianza;
	private List<CityBikeParkingPoint> listaPuntosDeAparcamiento;
	private List<Pack> listaDePacks;
	
	/**
	 * Constructor del sistema CityBike.
	 */
	public CityBikeSystem() {
		this.listaPuntosDeAparcamiento = new ArrayList<CityBikeParkingPoint>();
		this.listaDePacks = new ArrayList<Pack>();
	}
	
	/**
	 * Constructor del sistema cityBike.
	 * @param fianza
	 * @param listaPuntosDeAparcamiento.
	 * @throws IllegalArgumentException si {@code fianza < 0}
	 * @throws IllegalStateException si {@code this.listaPuntosDeAparcamiento.isEmpty()}
	 * @throws IllegalArgumentException si @code(precioFianza < 0)
	 */
	public CityBikeSystem(double fianza, List<CityBikeParkingPoint> listaPuntosDeAparcamiento) {
		this.listaPuntosDeAparcamiento = listaPuntosDeAparcamiento;
		this.listaDePacks = new ArrayList<Pack>();
		this.setFianza(fianza);
	}

	/**
	 * Obtener el valor de la fianza a depositar por una bicicleta
	 * @return el valor de la fianza.
	 */
	public double getFianza() {
		return fianza;
	}

	/**
	 * Actualizar el valor de la fianza a depositar por una bicicleta.
	 * El valor de la fianza debe ser positivo o cero.
	 * Para actualizar el valor de la fianza el sistema ha de contener al menos un punto de aparcamiento.
	 * @param fianza nueva.
	 * @throws IllegalArgumentException si {@code fianza < 0}
	 * @throws IllegalStateException si {@code this.listaPuntosDeAparcamiento.isEmpty()}
	 * @throws IllegalArgumentException si @code(precioFianza < 0)
	 */
	public void setFianza(double fianza) {
		if (fianza < 0) throw new IllegalArgumentException("Llamada incorrecta: Fianza negativa");
		if (this.listaPuntosDeAparcamiento.isEmpty()) throw new IllegalStateException("Llamada incorrecta: Lista de puntos de aparcamiento vacia");
		
		this.fianza = fianza;
		
		for(int i=0;i<this.listaPuntosDeAparcamiento.size();i++) {
			this.listaPuntosDeAparcamiento.get(i).setPrecioFianza(fianza);
		}
		
		if (!(this.listaDePacks.isEmpty())) {
			for(int i = 0; i < this.listaDePacks.size(); i++) {
				this.listaDePacks.get(i).setFianzaPack(fianza);
			}
		}
	}

	/**
	 * Obtener la lista de puntos de aparcamiento de la ciudad.
	 * @return la lista de puntos de aparcamiento.
	 */
	public List<CityBikeParkingPoint> getListaPuntosDeAparcamiento() {
		return listaPuntosDeAparcamiento;
	}

	/**
	 * Actualizar la lista de puntos de aparcamiento de la ciudad a una dada.
	 * @param puntosDeAparcamientoEsperados
	 * @throws IllegalArgumentException si {@code puntosDeAparcamientoEsperados.isEmpty()}
	 */
	public void setListaPuntosDeAparcamiento(List<CityBikeParkingPoint> puntosDeAparcamientoEsperados) {
		if (puntosDeAparcamientoEsperados.isEmpty()) throw new IllegalArgumentException("Llamada incorrecta: la lista no debe estar vacia");
		this.listaPuntosDeAparcamiento = puntosDeAparcamientoEsperados;
	}
	
	/**
	 * A�adir nuevo punto de aparcamiento al sistema.
	 * @param puntoDeAparcamientoNuevo
	 */
	public void addNuevoPuntoDeAparcamiento(CityBikeParkingPoint puntoDeAparcamientoNuevo) {
		if(this.getListaPuntosDeAparcamiento().contains(puntoDeAparcamientoNuevo)) throw new IllegalArgumentException("Llamada incorrecta: El punto de aparcamiento ya existe en la lista");
		this.getListaPuntosDeAparcamiento().add(puntoDeAparcamientoNuevo);
	}
	
	/**
	 * Eliminar un punto de aparcamiento del sistema.
	 * Se debe elegir un punto de aparcamiento reconocido por el sistema central.
	 * @param puntoDeAparcamientoEliminar
	 * @throws IllegalArgumentException si {@code !this.getListaPuntosDeAparcamiento().contains(puntoDeAparcamientoEliminar)}
	 */
	public void removePuntoDeAparcamiento(CityBikeParkingPoint puntoDeAparcamientoEliminar) {
		if (!this.getListaPuntosDeAparcamiento().contains(puntoDeAparcamientoEliminar)) throw new IllegalArgumentException("Llamada incorrecta: puntoDeAparcamientoEliminar no se encuentra en la lista de puntos de aparcamiento");
		this.getListaPuntosDeAparcamiento().remove(puntoDeAparcamientoEliminar);
	}
	
	/**
	 * Obtener lista con los puntos de aparcamiento que disponen de bicicletas disponibles o ancladas.
	 * @return la lista con los puntos de aparcamiento.
	 */
	public ArrayList<CityBikeParkingPoint> getPuntosdeAparcamientoConBicisDisponibles(){
		ArrayList<CityBikeParkingPoint> puntosDisponibles = new ArrayList<CityBikeParkingPoint>();
		
		for(int i=0; i < this.getListaPuntosDeAparcamiento().size(); i++) {
			if(this.getListaPuntosDeAparcamiento().get(i).getNumeroAnclajesOcupados() != 0) {
				puntosDisponibles.add(this.getListaPuntosDeAparcamiento().get(i));
			}
		}
		return puntosDisponibles;
	}
	
	/**
	 * Obtener una lista de los puntos de aparcamiento que tienen al menos un anclaje vacio para devolver una bicicleta.
	 * @return la lista de los puntos de aparcamiento.
	 */
	public ArrayList<CityBikeParkingPoint> getPuntosDeAparcamientoConAnclajesVacios(){
		ArrayList<CityBikeParkingPoint> puntosVacios = new ArrayList<CityBikeParkingPoint>();
		
		for (int i=0; i < this.getListaPuntosDeAparcamiento().size(); i++) {
			if (this.getListaPuntosDeAparcamiento().get(i).getNumeroAnclajesVacios() != 0) {
				puntosVacios.add(this.getListaPuntosDeAparcamiento().get(i));
			}
		}
		return puntosVacios;
	}
	
	/**
	 * Obtener los puntos de aparcamiento cercanos a una coordenada dada
	 * @param gps coordenadas de las cuales queremos ver puntos cercanos
	 * @param radio dentro del cual queremos ver puntos cercanos
	 * @return puntos de aparcamiento cercanos
	 */
	public List<CityBikeParkingPoint> getPuntosDeAparcamientoCercanos(Gps gps, double radio) {
		List<CityBikeParkingPoint> puntosDeAparcamientoCercanos = new ArrayList<CityBikeParkingPoint>();
		
		for(int i=0;i<this.getListaPuntosDeAparcamiento().size();i++) {
			Gps gpsPunto = this.getListaPuntosDeAparcamiento().get(i).getGps();
			
			double distancia = gps.calcularDistanciaAOtrasCoordenadasGPS(gpsPunto);
			
			if (Math.abs(distancia) <= radio) {
				puntosDeAparcamientoCercanos.add(this.getListaPuntosDeAparcamiento().get(i));
			}
		}
		return puntosDeAparcamientoCercanos;
	}
	
	/**
	 * Obtener la lista de todos los Packs registrados en el sistema.
	 * @return la lista de Packs.
	 */
	public List<Pack> getListaDePacks() {
		return listaDePacks;
	}

	/**
	 * Actualizar la lista de Packs.
	 * @param nueva listaDePacks.
	 */
	public void setListaDePacks(List<Pack> listaDePacks) {
		this.listaDePacks = listaDePacks;
	}

	/**
	 * Obtener un String con toda la informacion relevante sobre un CityBikeSystem.
	 */
	@Override
	public String toString() {
		return "CityBikeSystem [fianza=" + fianza + ", listaPuntosDeAparcamiento=" + listaPuntosDeAparcamiento
				+ ", listaDePacks=" + listaDePacks + "]";
	}

	/**
	 * Comprueba si un objeto es igual a un CityBikeSystem.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CityBikeSystem other = (CityBikeSystem) obj;
		if (listaDePacks == null) {
			if (other.listaDePacks != null)
				return false;
		} else if (!listaDePacks.equals(other.listaDePacks))
			return false;
		if (!listaPuntosDeAparcamiento.equals(other.listaPuntosDeAparcamiento))
			return false;
		if (Double.doubleToLongBits(fianza) != Double.doubleToLongBits(other.fianza))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
