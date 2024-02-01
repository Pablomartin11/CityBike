package uva.poo.CityBike;


import java.util.ArrayList;
import java.util.List;

import fabricante.externo.tarjetas.TarjetaMonedero;
import uva.poo.CityBike.Anclaje;



/**
 * Tipo abstracto de datos que implementa la funcionalidad de un punto de aparcamiento de bicis del sistema global.
 * @author pabmart0
 *
 */
public class CityBikeParkingPoint {
	
	private int id;
	private int numAnclajes;
	private Gps gps;
	private List<Anclaje> listaAnclajes;
	private double precioFianza;
	
	/**
	 * Constructor vacio de un punto de aparcamiento
	 */
	public CityBikeParkingPoint() {
		this.listaAnclajes = new ArrayList<Anclaje>();
	}
	
	/**
	 * Constructor de un punto de aparcamiento.
	 * El precio de la fianza debe ser determinado por el sistema central.
	 * @param id del punto de aparcamiento.
	 * @param numAnclajes
	 * @param gpsgms
	 * @param gpsdec
	 */
	public CityBikeParkingPoint(int id, int numAnclajes, Gps gps) {
		this.setId(id);
		this.setNumAnclajes(numAnclajes);
		this.gps = gps;
		
		this.listaAnclajes = new ArrayList<Anclaje>();
		//añadir los anclajes a la lista
		for (int i=1; i<=numAnclajes; i++) {
			this.listaAnclajes.add(new Anclaje(i,1));
		}
	}
	
	
	/**
	 * Obtener la posicion GPS del punto de aparcamiento en GMS.
	 * @return
	 */
	public Gps getGps() {
		return gps;
	}
	
	/**
	 * Actualizar la posicion GPS del punto de aparcamiento en GMS.
	 * @param gps
	 */
	public void setGps(Gps gps) {
		this.gps = gps;
	}
	
	/**
	 * Obtener id del punto de aparcamiento.
	 * @return id del aparcamiento.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Actualiza el id del punto de aparcamiento.
	 * El id del punto no puede ser negativo o igual a cero
	 * @param id del aparcamiento.
	 * @throws IllegalArgumentException si {@code}
	 */
	public void setId(int id) {
		if (id<=0) throw new IllegalArgumentException("Llamada incorrecta: ID de un punto de aparcamiento no puede negativo o igual a cero");
		this.id = id;
	}
	
	/**
	 * Obtener el numero de anclajes del cual dispone el punto de aparcamiento.
	 * @return numero de anclajes.
	 */
	public int getNumAnclajes() {
		return numAnclajes;
	}
	
	/**
	 * Actualizar el numero de anclajes que dispone el punto de aparcamiento.
	 * El numero total de bases de anclaje no puede ser negativo ni igual a cero.
	 * @param numAnclajes
	 * @throws IllegalArgumentException si {@code numAnclajes <= 0}
	 */
	private void setNumAnclajes(int numAnclajes) {
		if (numAnclajes <= 0) throw new IllegalArgumentException("Llamada incorrecta: El numero de Anclajes debe ser positivo y distinto de cero");
		this.numAnclajes = numAnclajes;
	}
		
	
	/**
	 * Obtener la lista de anclajes que se encuentran en el punto de aparcamiento.
	 * @return la lista de anclajes.
	 */
	public List<Anclaje> getListaAnclajes() {
		return listaAnclajes;
	}
	
	/**
	 * Actualizar la lista de anclajes que se encuentran en el punto de aparcamiento.
	 * @param listaAnclajes.
	 * @throws IllegalArgumentException si {@code istaAnclajes.size() != this.getNumAnclajes() && !this.listaAnclajes.isEmpty()}
	 */
	public void setListaAnclajes(List<Anclaje> listaAnclajes) {
		if (listaAnclajes.size() != this.getNumAnclajes() && !this.listaAnclajes.isEmpty()) throw new IllegalArgumentException("Llamada incorrecta: La longitud de la lista de Anclajes no se corresponde con la prevista");
		this.listaAnclajes = listaAnclajes;
	}

	/**
	 * Obtener el valor de la fianza que se ha de pagar para realizar el prestamo.
	 * @return e valor de la fianza.
	 */
	public double getPrecioFianza() {
		return precioFianza;
	}
	
	/**
	 * Actualizar el valor de la fianza que se ha de pagar en un punto de aparcamiento.
	 * El precio de la fianza no puede ser negativo.
	 * @param precioFianza
	 * @throws IllegalArgumentException si @code(precioFianza < 0)
	 */
	protected void setPrecioFianza(double precioFianza) {
		if (precioFianza < 0) throw new IllegalArgumentException("Llamada incorrecta: El precio de fianza no puede ser negativo");
		this.precioFianza = precioFianza;
	}
	
	/**
	 * Obtener el numero de anclajes ocupados o con una bicicleta disponible en un punto de aparcamiento
	 * @return el numero de anclajes ocupados.
	 */
	public int getNumeroAnclajesOcupados() {
		int ocupados = 0;
		
		for (int i=0; i<this.getListaAnclajes().size();i++) {
			int estadoAnclaje = this.getListaAnclajes().get(i).getEstado();
			if (estadoAnclaje == 1) {
				ocupados+=1;
			}
		}
		return ocupados;
	}
	
	/**
	 * Obtener el numero de anclajes vacios en un punto de aparcamiento.
	 * @return el numero de anclajes vacios.
	 */
	public int getNumeroAnclajesVacios() {
		int vacios = 0;
		
		for (int i=0; i < this.getListaAnclajes().size(); i++) {
			int estadoAnclaje = this.getListaAnclajes().get(i).getEstado();
			if(estadoAnclaje == 0) {
				vacios++;
			}
		}
		return vacios;
	}
	
	
	/**
	 * Obtener el estado de una base de anclaje del punto de aparcamiento.
	 * @param base de la cual se quiere conocer el estado.
	 * @return 0 (rojo/vacio), 1 (verde/ocupado), 2 (azul/reservado).
	 */
	public  int getEstadoBaseDeAnclaje(Anclaje base) {
		return base.getEstado();
	}
	
	/**
	 * Procedimiento para poder serle prestada una bicicleta al usuario.
	 * Es necesario pasar una tarjeta con el saldo suficiente para pagar la fianza.
	 * Se ha de escoger una base de anclaje disponible u ocupada con una bicicleta.
	 * @param base
	 * @param tarjeta con la que se va a pagar
	 * @throws IllegalStateException si {@code saldoActual < this.getPrecioFianza()}
	 *@throws IllegalStateException  si {@code base.getEstado() != 1}
	 */
	public void prestarBici(Anclaje base, TarjetaMonedero tarjeta) {
		double saldoActual = tarjeta.getSaldoActual();
		
		if (saldoActual < this.getPrecioFianza()) throw new IllegalStateException("Llamada incorrecta: Saldo Insuficiente");
		else if(base.getEstado() != 1) throw new IllegalStateException("Llamada incorrecta: Base de Anclaje no disponible");
			else {
			tarjeta.descontarDelSaldo("6Z1y00Nm31aA-571", this.getPrecioFianza());
			base.setEstado(0);
			}
	}
	
	/**
	 * Procedimiento para poder devolver una bicicleta en un punto de aparcamiento.
	 * Para poder devolver la bicicleta a una base de anclaje, esta ha de estar vacia.
	 * @param base de anclaje.
	 * @param tarjeta a la que devolveremos la fianza.
	 * @throws IllegalStateException si {@code base.getEstado() != 0}
	 * 
	 */
	public void devolverBici(Anclaje base, TarjetaMonedero tarjeta) {
		if (base.getEstado() != 0) throw new IllegalStateException("Llamada incorrecta: Base de Anclaje Ocupada");
		else {
			base.setEstado(1);
			tarjeta.recargaSaldo("A156Bv09_1zXo894", this.getPrecioFianza());
		}
	}
	
	/**
	 * Obtener la distancia a otro punto de aparcamiento, desde ese mismo.
	 * @param puntoDeAparcamiento.
	 * @return la distancia a ese punto de aparcamiento.
	 */
	public double getDistanciaAOtroPuntoDeAparcamiento(CityBikeParkingPoint puntoDeAparcamiento) {
		Gps gpsPunto1 = this.getGps();
		Gps gpsPunto2 = puntoDeAparcamiento.getGps();
		
		return gpsPunto1.calcularDistanciaAOtrasCoordenadasGPS(gpsPunto2);
	}
	
	/**
	 * Obtener la distancia a un punto GPS dado.
	 * @param gps 
	 */
	public double getDistanciaAUnPuntoGPS(Gps gps) {
		return this.getGps().calcularDistanciaAOtrasCoordenadasGPS(gps);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}