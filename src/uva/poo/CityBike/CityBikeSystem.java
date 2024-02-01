package uva.poo.CityBike;

import java.util.ArrayList;
import java.util.List;

/**
 * Tipo abstracto de datos que implementa la funcionalidad del sistema general de puntos de aparcamiento de bicicletas de una ciudad.
 * @author pabmart0
 *
 */
public class CityBikeSystem {
	private double fianza;
	private List<CityBikeParkingPoint> listaPuntosDeAparcamiento;
	
	/**
	 * Constructor del sistema CityBike.
	 */
	public CityBikeSystem() {
		this.listaPuntosDeAparcamiento = new ArrayList<CityBikeParkingPoint>();
	}
	
	/**
	 * Constructor del sistema cityBike.
	 * @param fianza
	 * @param listaPuntosDeAparcamiento
	 */
	public CityBikeSystem(double fianza, List<CityBikeParkingPoint> listaPuntosDeAparcamiento) {
		this.listaPuntosDeAparcamiento = listaPuntosDeAparcamiento;
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
	 */
	public void setFianza(double fianza) {
		if (fianza < 0) throw new IllegalArgumentException("Llamada incorrecta: Fianza negativa");
		if (this.listaPuntosDeAparcamiento.isEmpty()) throw new IllegalStateException("Llamada incorrecta: Lista de puntos de aparcamiento vacia");
		
		this.fianza = fianza;
		for(int i=0;i<this.listaPuntosDeAparcamiento.size();i++) {
			this.listaPuntosDeAparcamiento.get(i).setPrecioFianza(fianza);
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
	 */
	public void setListaPuntosDeAparcamiento(List<CityBikeParkingPoint> puntosDeAparcamientoEsperados) {
		this.listaPuntosDeAparcamiento = puntosDeAparcamientoEsperados;
	}
	
	/**
	 * Añadir nuevo punto de aparcamiento al sistema.
	 * @param puntoDeAparcamientoNuevo
	 */
	public void addNuevoPuntoDeAparcamiento(CityBikeParkingPoint puntoDeAparcamientoNuevo) {
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
