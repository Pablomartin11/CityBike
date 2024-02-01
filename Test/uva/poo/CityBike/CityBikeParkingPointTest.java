package uva.poo.CityBike;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fabricante.externo.tarjetas.TarjetaMonedero;

public class CityBikeParkingPointTest {
		
	@Test
	public void testConstructorVacioCityBikeParkingPoint() {
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint();
		
		assertNotNull(parkingPoint);
	}
	
	@Test
	public void testConstructorCityBikeParkingPoint() {
		int id = 1;
		int numAnclajes = 8;
		Gps gps = new Gps();
		
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(id, numAnclajes, gps);
		
		assertNotNull(parkingPoint);
	}
	
	@Test 
	public void testGetYSetGpsAUnPuntoDeAparcamiento() {
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint();
		ArrayList<Object> latitud = new ArrayList<Object>();
		latitud.add(20.0);
		latitud.add(30.0);
		latitud.add(40.0);
		latitud.add("N");
		
		ArrayList<Object> longitud = new ArrayList<Object>();
		longitud.add(20.0);
		longitud.add(30.0);
		longitud.add(40.0);
		longitud.add("E");
 
		Gps gpsEsperado = new Gps(latitud, longitud);
		
		parkingPoint.setGps(gpsEsperado);
		Gps gpsActual = parkingPoint.getGps();
		
		assertEquals(gpsEsperado,gpsActual);
	}
	
	@Test 
	public void testGetYSetIdAUnPuntoDeAparcamiento() {
		int idEsperado = 3;
		CityBikeParkingPoint parkingPointVacio = new CityBikeParkingPoint();
		
		parkingPointVacio.setId(3);
		int idActual = parkingPointVacio.getId();
		
		assertEquals(idEsperado,idActual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloSetIdNegativoAUnPuntoDeAparcamiento() {
		CityBikeParkingPoint parkingPointVacio = new CityBikeParkingPoint();
		
		parkingPointVacio.setId(-6);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloSetIdIgualACeroAUnPuntoDeAparcamiento() {
		CityBikeParkingPoint parkingPointVacio = new CityBikeParkingPoint();
		
		parkingPointVacio.setId(0);
	}
	
	@Test
	public void testGetYSetNumeroDeAnclajesAUnPuntoDeAparcamiento() {
		int numAnclajesEsperado = 8;
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(1,8,new Gps());
		
		int numAnclajesActual = parkingPoint.getNumAnclajes();
		
		assertEquals(numAnclajesEsperado,numAnclajesActual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloSetNumeroDeAnclajesNegativoAUnPuntoDeAparcamiento() {
		new CityBikeParkingPoint(1,-20,new Gps());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloSetNumeroDeAnclajesIgualACeroAUnPuntoDeAparcamiento() {
		new CityBikeParkingPoint(1,0,new Gps());
	}
	
	@Test
	public void testGetYSetListaDeAnclajes() {
		List<Anclaje> listaEsperada = new ArrayList<Anclaje>();
		listaEsperada.add(new Anclaje());
		listaEsperada.add(new Anclaje());
		listaEsperada.add(new Anclaje());
		
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(1,3,new Gps());
		parkingPoint.setListaAnclajes(listaEsperada);
		List<Anclaje> listaActual = parkingPoint.getListaAnclajes();
		
		assertEquals(listaEsperada,listaActual);
	}
	
	@Test
	public void testSetListaDeAnclajesAUnPuntoDeAparcamientoVacio() {
		List<Anclaje> listaEsperada = new ArrayList<Anclaje>();
		listaEsperada.add(new Anclaje());
		listaEsperada.add(new Anclaje());
		listaEsperada.add(new Anclaje());
		
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint();
		parkingPoint.setListaAnclajes(listaEsperada);
		List<Anclaje> listaActual = parkingPoint.getListaAnclajes();
		
		assertEquals(listaEsperada,listaActual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloSetListaDeAnclajesConLongitudDiferenteALaEstablecida() {
		List<Anclaje> listaDeAnclajes = new ArrayList<Anclaje>();
		listaDeAnclajes.add(new Anclaje());
		listaDeAnclajes.add(new Anclaje());
		listaDeAnclajes.add(new Anclaje());
		listaDeAnclajes.add(new Anclaje());
		
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(1,3,new Gps());
		parkingPoint.setListaAnclajes(listaDeAnclajes);
	}
	
	@Test
	public void testGetYSetPrecioFianzaDeUnPuntoDeAparcamiento() {
		double precioEsperado = 3;
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint();
		
		parkingPoint.setPrecioFianza(3);
		double precioActual = parkingPoint.getPrecioFianza();
		
		assertEquals(precioEsperado,precioActual,0.01);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloSetPrecioFianzaNegativoAUnPuntoDeAparcamiento() {
		double precioFianza = -3;
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint();
		
		parkingPoint.setPrecioFianza(precioFianza);
	}
	
	@Test
	public void testGetNumeroDeAnclajesOcupados() {
		int numeroEsperado =3;
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint();
		List<Anclaje> listaDeAnclajes = new ArrayList<Anclaje>();
		listaDeAnclajes.add(new Anclaje(1,1));
		listaDeAnclajes.add(new Anclaje(2,1));
		listaDeAnclajes.add(new Anclaje(3,1));
		listaDeAnclajes.add(new Anclaje(4,0));
		parkingPoint.setListaAnclajes(listaDeAnclajes);
		
		int numeroActual = parkingPoint.getNumeroAnclajesOcupados();
		
		assertEquals(numeroEsperado,numeroActual);
	}
	
	@Test
	public void testGetNumeroDeAnclajesVacios() {
		int numeroEsperado = 2;
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint();
		List<Anclaje> listaDeAnclajes = new ArrayList<Anclaje>();
		listaDeAnclajes.add(new Anclaje(1,1));
		listaDeAnclajes.add(new Anclaje(2,0));
		listaDeAnclajes.add(new Anclaje(3,1));
		listaDeAnclajes.add(new Anclaje(4,0));
		parkingPoint.setListaAnclajes(listaDeAnclajes);
		
		int numeroActual = parkingPoint.getNumeroAnclajesVacios();
		
		assertEquals(numeroEsperado,numeroActual);
	}
	
	@Test
	public void testGetEstadoDeUnaBaseDeAnclaje() {
		int estadoEsperado = 0;
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(1,3,new Gps());
		
		parkingPoint.getListaAnclajes().get(2).setEstado(0);
		int estadoActual = parkingPoint.getEstadoBaseDeAnclaje(parkingPoint.getListaAnclajes().get(2));
		
		assertEquals(estadoEsperado,estadoActual);
	}
	
	@Test
	public void testPrestarBicicleta() {
		double saldoEsperado = 2;
		int estadoEsperado = 0;
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(1,3,new Gps());
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894",5);
		parkingPoint.setPrecioFianza(3);
		
		parkingPoint.prestarBici(parkingPoint.getListaAnclajes().get(1), tarjeta);
		double saldoActual = tarjeta.getSaldoActual();
		int estadoActual = parkingPoint.getListaAnclajes().get(1).getEstado();
		
		assertEquals(saldoEsperado, saldoActual,0.01);
		assertEquals(estadoEsperado,estadoActual);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testFalloPrestarBiciPorSaldoInsuficiente() {
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(1,3,new Gps());
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894",2);
		parkingPoint.setPrecioFianza(3);
		
		parkingPoint.prestarBici(parkingPoint.getListaAnclajes().get(1), tarjeta);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testFalloPrestarBiciPorBaseDeAnclajeNoDisponible() {
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(1,3,new Gps());
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894",5);
		parkingPoint.setPrecioFianza(3);
		
		parkingPoint.getListaAnclajes().get(1).setEstado(0);
		parkingPoint.prestarBici(parkingPoint.getListaAnclajes().get(1), tarjeta);

	}
	
	@Test
	public void testDevolverBicicleta() {
		double saldoEsperado = 3;
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(1,3,new Gps());
		parkingPoint.setPrecioFianza(3);
		parkingPoint.getListaAnclajes().get(1).setEstado(0);
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894");
		
		parkingPoint.devolverBici(parkingPoint.getListaAnclajes().get(1), tarjeta);
		double saldoActual = tarjeta.getSaldoActual();
		
		assertEquals(saldoEsperado,saldoActual,0.01);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testFalloDevolverBiciPorEstadoDeBaseDeAnclajeOcupado() {
		CityBikeParkingPoint parkingPoint = new CityBikeParkingPoint(1,3,new Gps());
		parkingPoint.setPrecioFianza(3);
		parkingPoint.getListaAnclajes().get(1).setEstado(1);
		TarjetaMonedero tarjeta = new TarjetaMonedero("A156Bv09_1zXo894");
		
		parkingPoint.devolverBici(parkingPoint.getListaAnclajes().get(1), tarjeta);
	}

	@Test
	public void testGetDistanciaDeUnPuntoDeAparcamientoAOtro() {
		ArrayList<Object> longitud = new ArrayList<Object>();
		longitud.add(20.0);
		longitud.add(30.0);
		longitud.add(40.0);
		longitud.add("O");
		
		ArrayList<Object> latitud = new ArrayList<Object>();
		latitud.add(20.0);
		latitud.add(30.0);
		latitud.add(40.0);
		latitud.add("S");
		
		Gps gps = new Gps(latitud, longitud);
		Gps coord = new Gps(latitud, longitud);
		
		CityBikeParkingPoint punto1 = new CityBikeParkingPoint();
		punto1.setGps(gps);
		CityBikeParkingPoint punto2 = new CityBikeParkingPoint();
		punto2.setGps(coord);
		
		double latitud1 = (double) gps.getLatitud().get(4);
		double latitud2 = (double) coord.getLatitud().get(4);
		double longitud1 = (double) gps.getLongitud().get(4);
		double longitud2 = (double) coord.getLongitud().get(4);
		
		// Transformamos las coordenadas de Grados Decimales a Radianes
		double latitudRad1 = gps.transformarGradosARadianes(latitud1);
		double latitudRad2 = coord.transformarGradosARadianes(latitud2);
		double longitudRad1 = gps.transformarGradosARadianes(longitud1);
		double longitudRad2 = coord.transformarGradosARadianes(longitud2);
		
		// Calculamos las diferencias
		double dlat = latitudRad2 - latitudRad1;
		double dlon = longitudRad2 - longitudRad1;
		
		// Calculamos el paramatro 'a'
		double a = Math.pow(Math.sin(dlat/2), 2) + Math.cos(latitudRad1) * Math.cos(latitudRad2) * Math.pow(Math.sin(dlon/2), 2);
		
		// Calculamos el parametro 'c'
		double c = 2 * Math.asin(Math.min(1, Math.sqrt(a)));
		
		// Calculamos la distancia
		double distanciaEsperada = 6371 * c;
		
		double distanciaActual = punto1.getDistanciaAOtroPuntoDeAparcamiento(punto2);
		
		assertEquals(distanciaEsperada, distanciaActual, 0.001);
	}
	
	@Test
	public void testGetDistanciaAUnPuntoGpsDesdeUnPuntoDeAparcamiento() {
		ArrayList<Object> longitud = new ArrayList<Object>();
		longitud.add(20.0);
		longitud.add(30.0);
		longitud.add(40.0);
		longitud.add("O");
		
		ArrayList<Object> latitud = new ArrayList<Object>();
		latitud.add(20.0);
		latitud.add(30.0);
		latitud.add(40.0);
		latitud.add("S");
		
		Gps gps = new Gps(latitud, longitud);
		Gps coord = new Gps(latitud, longitud);
		
		CityBikeParkingPoint punto1 = new CityBikeParkingPoint();
		punto1.setGps(gps);
		
		
		double latitud1 = (double) gps.getLatitud().get(4);
		double latitud2 = (double) coord.getLatitud().get(4);
		double longitud1 = (double) gps.getLongitud().get(4);
		double longitud2 = (double) coord.getLongitud().get(4);
		
		// Transformamos las coordenadas de Grados Decimales a Radianes
		double latitudRad1 = gps.transformarGradosARadianes(latitud1);
		double latitudRad2 = coord.transformarGradosARadianes(latitud2);
		double longitudRad1 = gps.transformarGradosARadianes(longitud1);
		double longitudRad2 = coord.transformarGradosARadianes(longitud2);
		
		// Calculamos las diferencias
		double dlat = latitudRad2 - latitudRad1;
		double dlon = longitudRad2 - longitudRad1;
		
		// Calculamos el paramatro 'a'
		double a = Math.pow(Math.sin(dlat/2), 2) + Math.cos(latitudRad1) * Math.cos(latitudRad2) * Math.pow(Math.sin(dlon/2), 2);
		
		// Calculamos el parametro 'c'
		double c = 2 * Math.asin(Math.min(1, Math.sqrt(a)));
		
		// Calculamos la distancia
		double distanciaEsperada = 6371 * c;
		
		double distanciaActual = punto1.getDistanciaAUnPuntoGPS(coord);
		
		assertEquals(distanciaEsperada, distanciaActual, 0.001);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
