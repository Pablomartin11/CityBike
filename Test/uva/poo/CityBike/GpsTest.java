package uva.poo.CityBike;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class GpsTest {
	
   
	@Test
	public void testConstructorGpsVacio() {
		Gps gps = new Gps();
		assertNotNull(gps);
	}
	
	@Test
	public void testConstructorGpsConLatitudYLongitud() {
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
 
			
		Gps gps = new Gps(latitud, longitud);
		assertNotNull(gps);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloComponenteLatitudGmsNegativa() {
		ArrayList<Object> latitud = new ArrayList<Object>();
		latitud.add(-20.0);
		latitud.add(30.0);
		latitud.add(40.0);
		latitud.add("N");
		ArrayList<Object> longitud = new ArrayList<Object>();
		longitud.add(20.0);
		longitud.add(30.0);
		longitud.add(40.0);
		longitud.add("E");
		
		new Gps(latitud, longitud);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloComponenteLongitudGmsNegativa() {
		ArrayList<Object> latitud = new ArrayList<Object>();
		latitud.add(20.0);
		latitud.add(30.0);
		latitud.add(40.0);
		latitud.add("N");
		ArrayList<Object> longitud = new ArrayList<Object>();
		longitud.add(-20.0);
		longitud.add(30.0);
		longitud.add(40.0);
		longitud.add("E");
		
		new Gps(latitud, longitud);
		
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloPuntoCardinalLatitudInvalido() {
		ArrayList<Object> latitud = new ArrayList<Object>();
		latitud.add(20.0);
		latitud.add(30.0);
		latitud.add(40.0);
		latitud.add("X");
		ArrayList<Object> longitud = new ArrayList<Object>();
		longitud.add(20.0);
		longitud.add(30.0);
		longitud.add(40.0);
		longitud.add("E");
		
		new Gps(latitud,longitud);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloPuntoCardinalLongitudInvalido() {
		ArrayList<Object> longitud = new ArrayList<Object>();
		longitud.add(20.0);
		longitud.add(30.0);
		longitud.add(40.0);
		longitud.add("H");
		ArrayList<Object> latitud = new ArrayList<Object>();
		latitud.add(20.0);
		latitud.add(30.0);
		latitud.add(40.0);
		latitud.add("N");
		
		new Gps(latitud,longitud);
	}
	
	
	
	@Test
	public void testGetLatitud() {
		ArrayList<Object> latitud = new ArrayList<Object>();
		latitud.add(20.0);
		latitud.add(30.0);
		latitud.add(40.0);
		latitud.add("N");
		
		ArrayList<Object> latitudEsperada = latitud;
			
		Gps gps = new Gps();
		gps.setLatitud(latitud);
		
		
		ArrayList<Object> latitudActual=(ArrayList<Object>) gps.getLatitud();
		assertEquals(latitudEsperada, latitudActual);
	}
	
	
	@Test
	public void testSetLatitud() {
		ArrayList<Object> latitud = new ArrayList<Object>();
		latitud.add(20.0);
		latitud.add(30.0);
		latitud.add(40.0);
		latitud.add("N");
			
		Gps gps = new Gps();
		gps.setLatitud(latitud);
		
		ArrayList<Object> latitudActual=(ArrayList<Object>) gps.getLatitud();
		assertEquals(latitud, latitudActual);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloSetLatitudNegativa() {
		
		ArrayList<Object> latitud = new ArrayList<Object>();
		latitud.add(-1.0);
		latitud.add(2.0);
		latitud.add(-3.0);
		latitud.add("N");
			
		Gps gps = new Gps();
		gps.setLatitud(latitud);
		
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloSetLatitudConPuntoCardinalInvalido() {

		
		ArrayList<Object> latitud = new ArrayList<Object>();
		latitud.add(1.0);
		latitud.add(2.0);
		latitud.add(3.0);
		latitud.add("X");
			
		Gps gps = new Gps();
		gps.setLatitud(latitud);
	}
	
	@Test
	public void testGetLongitud() {
		
		ArrayList<Object> longitud = new ArrayList<Object>();
		longitud.add(20.0);
		longitud.add(30.0);
		longitud.add(40.0);
		longitud.add("E");
		
		ArrayList<Object> longitudEsperada = longitud;
			
		Gps gps = new Gps();
		gps.setLongitud(longitud);
		
		ArrayList<Object> longitudActual=(ArrayList<Object>) gps.getLongitud();
		assertEquals(longitudEsperada, longitudActual);
	}
	
	
	@Test
	public void testSetLongitud() {
		
		ArrayList<Object> longitud = new ArrayList<Object>();
		longitud.add(20.0);
		longitud.add(30.0);
		longitud.add(40.0);
		longitud.add("E");
		
		Gps gps = new Gps();
		gps.setLongitud(longitud);
		
		ArrayList<Object> longitudActual=(ArrayList<Object>) gps.getLongitud();
		assertEquals(longitud, longitudActual);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloSetLongitudNegativa() {
		
		ArrayList<Object> longitud = new ArrayList<Object>();
		longitud.add(-1.0);
		longitud.add(2.0);
		longitud.add(-3.0);
		longitud.add("N");
			
		Gps gps = new Gps();
		gps.setLongitud(longitud);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloSetLongitudConPuntoCardinalInvalido() {
		
		ArrayList<Object> longitud = new ArrayList<Object>();
		longitud.add(1.0);
		longitud.add(2.0);
		longitud.add(3.0);
		longitud.add("X");
			
		Gps gps = new Gps();
		gps.setLongitud(longitud);
	}
	
	@Test
	public void testTransformarCoordenadasGmsADecimalPositivo() {
		
		ArrayList<Object> longitud = new ArrayList<Object>();
		longitud.add(20.0);
		longitud.add(30.0);
		longitud.add(40.0);
		longitud.add("E");
		
		ArrayList<Object> latitud = new ArrayList<Object>();
		latitud.add(20.0);
		latitud.add(30.0);
		latitud.add(40.0);
		latitud.add("N");
		
		double gradosLatitud = (double) latitud.get(0);
		double minutosLatitud = (double) latitud.get(1);
		double segundosLatitud = (double) latitud.get(2);
		
		double latitud1 = gradosLatitud + minutosLatitud/60 + segundosLatitud/3600;
		
		Gps gps2 = new Gps();
		gps2.setLatitud(latitud);
		gps2.setLongitud(longitud);
		
		gps2.transformarCoordenadasGmsADecimal();
		
		double latitud2 = (double)gps2.getLatitud().get(4);
		assertEquals(latitud1,latitud2,0.01);
		
		  
	}
	
	
	@Test
	public void testTransformarCoordenadasGmsADecimalNegativo() {
		
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
		
		Gps gps1 = new Gps(latitud, longitud);
		
		Gps gps2 = new Gps();
		gps2.setLatitud(latitud);
		gps2.setLongitud(longitud);
		
		gps2.transformarCoordenadasGmsADecimal();
		
		double latitud1 = (double)gps1.getLatitud().get(4);
		double latitud2 = (double)gps2.getLatitud().get(4);
		assertEquals(latitud1,latitud2,0.01);
		
		  
	}
	
	@Test
	public void testCalcularDistanciaAOtrasCoordenadas() {
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
		
		double distanciaActual = gps.calcularDistanciaAOtrasCoordenadasGPS(coord);
		
		assertEquals(distanciaEsperada, distanciaActual, 0.001);
		
	
	}
	 
	
	@Test
	public void testTransformarGradosARadianes() {
		double grados = 50;
		double radianesEsperados = grados*Math.PI/180;
		
		Gps gps = new Gps();
		double radianesActuales = gps.transformarGradosARadianes(grados);
		
		assertEquals(radianesEsperados, radianesActuales, 0.001);
	}
 
}
