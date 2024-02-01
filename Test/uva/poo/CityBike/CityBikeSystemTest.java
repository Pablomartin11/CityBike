	package uva.poo.CityBike;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CityBikeSystemTest {

	@Test
	public void testConstructorVacioCityBikeSystem() {
		CityBikeSystem system = new CityBikeSystem();
		
		assertNotNull(system);
	}
	
	@Test
	public void testConstructorCityBikeSystem() {
		double fianza = 3;
		List<CityBikeParkingPoint> puntosDeAparcamiento = new ArrayList<CityBikeParkingPoint>();
		puntosDeAparcamiento.add(new CityBikeParkingPoint());
		puntosDeAparcamiento.add(new CityBikeParkingPoint());
		
		CityBikeSystem system = new CityBikeSystem(fianza, puntosDeAparcamiento);
		
		assertNotNull(system);
	}
	
	@Test
	public void testGetYSetFianzaDeUnSistema() {
		double fianzaEsperada = 3;
		double fianzaInicial = 5;
		List<CityBikeParkingPoint> puntosDeAparcamiento = new ArrayList<CityBikeParkingPoint>();
		puntosDeAparcamiento.add(new CityBikeParkingPoint());
		puntosDeAparcamiento.add(new CityBikeParkingPoint());
		
		CityBikeSystem system = new CityBikeSystem(fianzaInicial, puntosDeAparcamiento);
		system.setFianza(3);
		double fianzaActual = system.getFianza();
		
		assertEquals(fianzaEsperada,fianzaActual,0.01);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloSetFianzaNegativa() {
		double fianzaInicial = 5;
		List<CityBikeParkingPoint> puntosDeAparcamiento = new ArrayList<CityBikeParkingPoint>();
		puntosDeAparcamiento.add(new CityBikeParkingPoint());
		puntosDeAparcamiento.add(new CityBikeParkingPoint());
		CityBikeSystem system = new CityBikeSystem(fianzaInicial, puntosDeAparcamiento);
		
		system.setFianza(-3);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testFalloSetFianzaAUnaListaDePuntosDeAparcamientoVacia() {
		CityBikeSystem system = new CityBikeSystem();
		
		system.setFianza(3);
	}
	
	@Test
	public void testGetYSetListaDePuntosDeAparcamiento() {
		List<CityBikeParkingPoint> puntosDeAparcamientoEsperados = new ArrayList<CityBikeParkingPoint>();
		puntosDeAparcamientoEsperados.add(new CityBikeParkingPoint());
		puntosDeAparcamientoEsperados.add(new CityBikeParkingPoint());
		
		CityBikeSystem system = new CityBikeSystem();
		system.setListaPuntosDeAparcamiento(puntosDeAparcamientoEsperados);
		List<CityBikeParkingPoint> puntosDeAparcamientoActuales = system.getListaPuntosDeAparcamiento();
		
		assertEquals(puntosDeAparcamientoEsperados, puntosDeAparcamientoActuales);
	}
	
	@Test
	public void testAddNUevoPuntoDeAparcamiento() {
		List<CityBikeParkingPoint> puntosDeAparcamientoEsperados = new ArrayList<CityBikeParkingPoint>();
		List<CityBikeParkingPoint> puntosDeAparcamientoTest = new ArrayList<CityBikeParkingPoint>();
		
		CityBikeParkingPoint punto1 = new CityBikeParkingPoint();
		CityBikeParkingPoint punto2 = new CityBikeParkingPoint();
		CityBikeParkingPoint puntoAdd = new CityBikeParkingPoint();
		
		puntosDeAparcamientoEsperados.add(punto1);
		puntosDeAparcamientoEsperados.add(punto2);
		puntosDeAparcamientoEsperados.add(puntoAdd);
		
		puntosDeAparcamientoTest.add(punto1);
		puntosDeAparcamientoTest.add(punto2);
		
		CityBikeSystem system = new CityBikeSystem();
		system.setListaPuntosDeAparcamiento(puntosDeAparcamientoTest);
		system.addNuevoPuntoDeAparcamiento(puntoAdd);
		List<CityBikeParkingPoint> puntosDeAparcamientoActuales = system.getListaPuntosDeAparcamiento();
		
		assertEquals(puntosDeAparcamientoEsperados,puntosDeAparcamientoActuales);
	}
	
	@Test
	public void testRemovePuntoDeAparcamiento() {
		List<CityBikeParkingPoint> puntosDeAparcamientoEsperados = new ArrayList<CityBikeParkingPoint>();
		List<CityBikeParkingPoint> puntosDeAparcamientoTest = new ArrayList<CityBikeParkingPoint>();
		
		CityBikeParkingPoint punto1 = new CityBikeParkingPoint();
		CityBikeParkingPoint punto2 = new CityBikeParkingPoint();
		CityBikeParkingPoint puntoRemove = new CityBikeParkingPoint();
		
		puntosDeAparcamientoEsperados.add(punto1);
		puntosDeAparcamientoEsperados.add(punto2);
		
		puntosDeAparcamientoTest.add(punto1);
		puntosDeAparcamientoTest.add(punto2);
		puntosDeAparcamientoTest.add(puntoRemove);
		
		CityBikeSystem system = new CityBikeSystem();
		system.setListaPuntosDeAparcamiento(puntosDeAparcamientoTest);
		system.removePuntoDeAparcamiento(puntoRemove);
		List<CityBikeParkingPoint> puntosDeAparcamientoActuales = system.getListaPuntosDeAparcamiento();
		
		assertEquals(puntosDeAparcamientoEsperados,puntosDeAparcamientoActuales);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloRemovePuntoDeAparcamientoNoestaEnLaLista() {
		List<CityBikeParkingPoint> puntosDeAparcamientoTest = new ArrayList<CityBikeParkingPoint>();
		
		CityBikeParkingPoint punto1 = new CityBikeParkingPoint();
		CityBikeParkingPoint punto2 = new CityBikeParkingPoint();
		CityBikeParkingPoint puntoRemove = new CityBikeParkingPoint();
		
		puntosDeAparcamientoTest.add(punto1);
		puntosDeAparcamientoTest.add(punto2);
		
		CityBikeSystem system = new CityBikeSystem();
		system.setListaPuntosDeAparcamiento(puntosDeAparcamientoTest);
		system.removePuntoDeAparcamiento(puntoRemove);
	}
	
	
	
	
	
	@Test
	public void testGetPuntosdeAparcamientoConAnclajesVacios() {
		List<CityBikeParkingPoint> puntosDeAparcamiento = new ArrayList<CityBikeParkingPoint>();
		
		CityBikeParkingPoint punto1 = new CityBikeParkingPoint();
		CityBikeParkingPoint punto2 = new CityBikeParkingPoint();
		CityBikeParkingPoint punto3 = new CityBikeParkingPoint();
		
		Anclaje anclaje1 = new Anclaje();
		Anclaje anclaje2 = new Anclaje();
		Anclaje anclaje3 = new Anclaje();
		anclaje1.setEstado(0);
		anclaje2.setEstado(1);
		anclaje3.setEstado(1);
		
		List<Anclaje> listaAnclajes1 = new ArrayList<Anclaje>();
		List<Anclaje> listaAnclajes2 = new ArrayList<Anclaje>();
		List<Anclaje> listaAnclajes3 = new ArrayList<Anclaje>();
		
		listaAnclajes1.add(anclaje1);
		listaAnclajes2.add(anclaje2);
		listaAnclajes3.add(anclaje3);
		
		punto1.setListaAnclajes(listaAnclajes1); // Tiene anclajes vacios
		punto2.setListaAnclajes(listaAnclajes2); // Todos los anclajes ocupados
		punto3.setListaAnclajes(listaAnclajes3); // Todos los anclajes ocupados
		
		
		puntosDeAparcamiento.add(punto1); 
		puntosDeAparcamiento.add(punto2);
		puntosDeAparcamiento.add(punto3);
		
		CityBikeSystem sistema = new CityBikeSystem();
		sistema.setListaPuntosDeAparcamiento(puntosDeAparcamiento);
		
		List<CityBikeParkingPoint> listaAparcamientosVaciosEsperada = new ArrayList<CityBikeParkingPoint>();
		listaAparcamientosVaciosEsperada.add(punto1);
		
		List<CityBikeParkingPoint> listaAparcamientosVaciosActual = new ArrayList<CityBikeParkingPoint>();
		listaAparcamientosVaciosActual = sistema.getPuntosDeAparcamientoConAnclajesVacios();
		
		
		assertEquals(listaAparcamientosVaciosEsperada,listaAparcamientosVaciosActual);
	}
	
	
	
	@Test
	public void testGetPuntosdeAparcamientoConBicisDisponibles() {
		List<CityBikeParkingPoint> puntosDeAparcamiento = new ArrayList<CityBikeParkingPoint>();
		
		CityBikeParkingPoint punto1 = new CityBikeParkingPoint();
		CityBikeParkingPoint punto2 = new CityBikeParkingPoint();
		CityBikeParkingPoint punto3 = new CityBikeParkingPoint();
		
		Anclaje anclaje1 = new Anclaje();
		Anclaje anclaje2 = new Anclaje();
		Anclaje anclaje3 = new Anclaje();
		anclaje1.setEstado(0);
		anclaje2.setEstado(1);
		anclaje3.setEstado(1);
		
		List<Anclaje> listaAnclajes1 = new ArrayList<Anclaje>();
		List<Anclaje> listaAnclajes2 = new ArrayList<Anclaje>();
		List<Anclaje> listaAnclajes3 = new ArrayList<Anclaje>();
		
		listaAnclajes1.add(anclaje1);
		listaAnclajes2.add(anclaje2);
		listaAnclajes3.add(anclaje3);
		
		punto1.setListaAnclajes(listaAnclajes1); // Tiene anclajes vacios
		punto2.setListaAnclajes(listaAnclajes2); // Todos los anclajes ocupados
		punto3.setListaAnclajes(listaAnclajes3); // Todos los anclajes ocupados
		
		
		puntosDeAparcamiento.add(punto1); 
		puntosDeAparcamiento.add(punto2);
		puntosDeAparcamiento.add(punto3);
		
		CityBikeSystem sistema = new CityBikeSystem();
		sistema.setListaPuntosDeAparcamiento(puntosDeAparcamiento);
		
		List<CityBikeParkingPoint> listaAparcamientosConBicisEsperada = new ArrayList<CityBikeParkingPoint>();
		listaAparcamientosConBicisEsperada.add(punto2);
		listaAparcamientosConBicisEsperada.add(punto3);
		
		List<CityBikeParkingPoint> listaAparcamientosConBicisActual = sistema.getPuntosdeAparcamientoConBicisDisponibles();
		
		assertEquals(listaAparcamientosConBicisEsperada,listaAparcamientosConBicisActual);
	}
	
	
	@Test
	public void testGetPuntosdeAparcamientoCercanos() {
		List<CityBikeParkingPoint> puntosDeAparcamiento = new ArrayList<CityBikeParkingPoint>();
		
		CityBikeParkingPoint punto1 = new CityBikeParkingPoint();
		CityBikeParkingPoint punto2 = new CityBikeParkingPoint();
		CityBikeParkingPoint punto3 = new CityBikeParkingPoint();
		
		ArrayList<Object> latitud1 = new ArrayList<Object>();
		latitud1.add(10.0);
		latitud1.add(10.0);
		latitud1.add(10.0);
		latitud1.add("N");
		
		ArrayList<Object> longitud1 = new ArrayList<Object>();
		longitud1.add(10.0);
		longitud1.add(10.0);
		longitud1.add(10.0);
		longitud1.add("E");
		longitud1.add(10.0);
		
		ArrayList<Object> latitud2 = latitud1;
		
		ArrayList<Object> longitud2 = longitud1;
		
		
		Gps gps1 = new Gps(latitud1, longitud1);
		Gps gps2 = new Gps(latitud2, longitud2);		
				
		
		punto1.setGps(gps1);
		punto2.setGps(gps2);
		
		puntosDeAparcamiento.add(punto1); 
		puntosDeAparcamiento.add(punto2);
		
		CityBikeSystem sistema = new CityBikeSystem();
		sistema.setListaPuntosDeAparcamiento(puntosDeAparcamiento);
		
		List<CityBikeParkingPoint> aparcamientosCercanosActuales = sistema.getPuntosDeAparcamientoCercanos(gps1, 10);
		List<CityBikeParkingPoint> aparcamientosCercanosEsperados = new ArrayList<CityBikeParkingPoint>();
		aparcamientosCercanosEsperados.add(punto1);
		aparcamientosCercanosEsperados.add(punto2);
		
		
		assertEquals(aparcamientosCercanosEsperados,aparcamientosCercanosActuales);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
