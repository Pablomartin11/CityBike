package uva.poo.CityBike;

import java.util.ArrayList;
import java.util.List;

/**
 * Tipo abstracto que impelementa la funcionalidad de una poasicion GPS expresada en Grados, Minutos y Segundos
 * @author pabmart0
 *
 */
public class Gps {
	
	private List<Object> latitud; // [0] = Grados, [1] = Minutos, [2] = Segundos, [3] = Punto Cardinal, [4] = Grados Decimales
	private List<Object> longitud; // [0] = Grados, [1] = Minutos, [2] = Segundos, [3] = Punto Cardinal, [4] = Grados Decimales
	
	/**
	 * Constructor de Gps en grados, minutos y segundos
	 */
	public Gps() {
		latitud = new ArrayList<Object>();
		longitud = new ArrayList<Object>();
	}
	
	/**
	 * Constructor de Gps en grados, minutos y segundos.
	 * Las componentes GMS han de ser positivas o iguales a cero.
	 * @param latitud
	 * @param longitud
	 * @throws IllegalArgumentException si alguna componente GMS de la latitud es negativa.
	 * @throws IllegalArgumentException si alguna componente GMS de la longitud es negativa.
	 * @throws IllegalArgumentException si el punto cardinal no es N,S,E,O.
	 */
	public Gps(ArrayList latitud, ArrayList longitud) {
		for (int i=0;i<3;i++) {
			if ((double)latitud.get(i)<0) {
				throw new IllegalArgumentException("llamada incorrecta: Una componente es negativa");
			}
		}
		
		for (int i=0;i<3;i++) {
			if ((double)longitud.get(i)<0) {
				throw new IllegalArgumentException("llamada incorrecta: Una componente es negativa");
			}
		}
		if ((latitud.get(3).equals("N") | latitud.get(3).equals("S")) & (longitud.get(3).equals("E") | longitud.get(3).equals("O"))) {
				this.latitud = latitud;
				this.longitud = longitud;
				transformarCoordenadasGmsADecimal();
		} else {
			throw new IllegalArgumentException("llamada incorrecta: Punto cardinal invalido");
		}
	}

	/**
	 * Obtener la latitud de las coordenadas GPS en grados, minutos y segundos
	 * @return lista con las coordenadas
	 */
	public List<Object> getLatitud() {
		return latitud;
	}
 
	/**
	 * Actualizar la latitud de las coordenadas GPS en grados minutos y segundos
	 * Las componentes GMS han de ser positivas o iguales a cero.
	 * @param latitud
	 * @throws IllegalArgumentException si alguna componente GMS es negativa
	 * @throws IllegalArgumentException si alguna si el punto cardinal no es N,S,E,O
	 */
	public void setLatitud(List<Object> latitud) {
		for (int i=0;i<3;i++) {
			if ((double)latitud.get(i)<0) {
				throw new IllegalArgumentException("llamada incorrecta: Una componente es negativa");
			}
		}
		if (latitud.get(3).equals("N") | latitud.get(3).equals("S")){
				this.latitud = latitud;
		} else {
			throw new IllegalArgumentException("llamada incorrecta: Punto cardinal invalido");
		}
	}

	/**
	 * Obtener la longitud de las coordenadas GPS en grados, minutos y segundos
	 * @return
	 */
	public List<Object> getLongitud() {
		return longitud;
	}

	/**
	 * Actualizar la longitud de las coordenadas GPS en grados, minutos y segundos
	 * @param longitud
	 * @throws IllegalArgumentException si alguna componente GMS es negativa
	 * @throws IllegalArgumentException si alguna si el punto cardinal no es N,S,E,O
	 */
	public void setLongitud(List<Object> longitud) {
		for (int i=0;i<3;i++) {
			if ((double)longitud.get(i)<0) {
				throw new IllegalArgumentException("llamada incorrecta: Una componente es negativa");
			}
		}
		if (longitud.get(3).equals("E") | longitud.get(3).equals("O")){
			this.longitud = longitud;
		} else {
			throw new IllegalArgumentException("llamada incorrecta: Punto cardinal invalido");
		}
	}
	
	/**
	 * Transforma las coordenadas de GMS a decimal
	 * @return coordenadas en decimal
	 */
	protected void transformarCoordenadasGmsADecimal() {
		double gradosLatitud = (double) this.getLatitud().get(0);
		double minutosLatitud = (double) this.getLatitud().get(1);
		double segundosLatitud = (double) this.getLatitud().get(2);
		
		double latitud = gradosLatitud + minutosLatitud /60.0 + segundosLatitud /3600.0;

		if (this.getLatitud().get(3).equals("S")) {
			latitud = -latitud;	
		}
		this.latitud.add(latitud);
		 
		double gradosLongitud = (double) this.getLongitud().get(0);
		double minutosLongitud = (double) this.getLongitud().get(1);
		double segundosLongitud = (double) this.getLongitud().get(2);
		
		double longitud = gradosLongitud + minutosLongitud /60.0 + segundosLongitud /3600.0;
		if (this.getLongitud().get(3).equals("O")) {
			longitud = -longitud;	
		}
		this.longitud.add(longitud);	
	}
	
	/**
	 * Calcula la distancia a unas coordenadas dadas
	 * @param coor2
	 * @return distancia
	 */
	public double calcularDistanciaAOtrasCoordenadasGPS(Gps coor2) {
		// Obtenemos las coordenadas en Grados Decimales
		double latitud1 = (double) this.getLatitud().get(4);
		double latitud2 = (double) coor2.getLatitud().get(4);
		double longitud1 = (double) this.getLongitud().get(4);
		double longitud2 = (double) coor2.getLongitud().get(4);
		
		// Transformamos las coordenadas de Grados Decimales a Radianes
		double latitudRad1 = transformarGradosARadianes(latitud1);
		double latitudRad2 = transformarGradosARadianes(latitud2);
		double longitudRad1 = transformarGradosARadianes(longitud1);
		double longitudRad2 = transformarGradosARadianes(longitud2);
		
		// Calculamos las diferencias
		double dlat = latitudRad2 - latitudRad1;
		double dlon = longitudRad2 - longitudRad1;
		
		// Calculamos el paramatro 'a'
		double a = Math.pow(Math.sin(dlat/2), 2) + Math.cos(latitudRad1) * Math.cos(latitudRad2) * Math.pow(Math.sin(dlon/2), 2);
		
		// Calculamos el parametro 'c'
		double c = 2 * Math.asin(Math.min(1, Math.sqrt(a)));
		
		// Calculamos la distancia
		double distancia = 6371 * c;
		
		return distancia;
	}
	
	/**
	 * Transforma la coordenada de grados a radianes
	 * @param la coordenada en grados 
	 * @return la coordenada en radianes
	 */
	protected double transformarGradosARadianes(double grados) {
		return grados*Math.PI/180;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
