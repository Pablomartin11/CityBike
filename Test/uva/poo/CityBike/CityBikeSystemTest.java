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
		
		Bike[] listaBicis = new Bike[10];
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
		AdultBike bici2 = new AdultBike(2,"BH","X",20,3,7,"XL",3);
		AdultBike bici3 = new AdultBike(3,"BH","X",20,3,7,"XL",3);
		AdultBike bici4 = new AdultBike(4,"BH","X",20,3,7,"XL",3);
		AdultBike bici5 = new AdultBike(5,"BH","X",20,3,7,"XL",3);
		AdultBike bici6 = new AdultBike(6,"BH","X",20,3,7,"XL",3);
		AdultBike bici7 = new AdultBike(7,"BH","X",20,3,7,"XL",3);
		AdultBike bici8 = new AdultBike(8,"BH","X",20,3,7,"XL",3);
		AdultBike bici9 = new AdultBike(9,"BH","X",20,3,7,"XL",3);
		AdultBike bici10 = new AdultBike(10,"BH","X",20,3,7,"XL",3);

		listaBicis[0] = bici1;
		listaBicis[1] = bici2;
		listaBicis[2] = bici3;
		listaBicis[3] = bici4;
		listaBicis[4] = bici5;
		listaBicis[5] = bici6;
		listaBicis[6] = bici7;
		listaBicis[7] = bici8;
		listaBicis[8] = bici9;
		listaBicis[9] = bici10;
		
		PackGrupo pack = new PackGrupo(listaBicis);
		List<Pack> listaDePacks = new ArrayList<Pack>();
		listaDePacks.add(pack);
		
		CityBikeSystem system = new CityBikeSystem();
		system.setListaDePacks(listaDePacks);
		system.setListaPuntosDeAparcamiento(puntosDeAparcamiento);
		system.setFianza(3);
		double fianzaActual = system.getFianza();
		
		assertEquals(fianzaEsperada,fianzaActual,0.01);
	}
	
	@Test
	public void testGetYSetFianzaCeroDeUnSistema() {
		double fianzaEsperada = 0;
		double fianzaInicial = 5;
		List<CityBikeParkingPoint> puntosDeAparcamiento = new ArrayList<CityBikeParkingPoint>();
		puntosDeAparcamiento.add(new CityBikeParkingPoint());
		puntosDeAparcamiento.add(new CityBikeParkingPoint());
		
		CityBikeSystem system = new CityBikeSystem(fianzaInicial, puntosDeAparcamiento);
		system.setFianza(0);
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
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloSetListaDePuntosDeAparcamientoVacia() {
		List<CityBikeParkingPoint> puntosDeAparcamiento = new ArrayList<CityBikeParkingPoint>();
		
		CityBikeSystem system = new CityBikeSystem();
		system.setListaPuntosDeAparcamiento(puntosDeAparcamiento);
	}
	
	@Test
	public void testAddNUevoPuntoDeAparcamiento() {
		List<CityBikeParkingPoint> puntosDeAparcamientoEsperados = new ArrayList<CityBikeParkingPoint>();
		List<CityBikeParkingPoint> puntosDeAparcamientoTest = new ArrayList<CityBikeParkingPoint>();
		
		CityBikeParkingPoint punto1 = new CityBikeParkingPoint(1,"Punto1",5,new Gps());
		CityBikeParkingPoint punto2 = new CityBikeParkingPoint(2,"Punto2",5,new Gps());
		CityBikeParkingPoint puntoAdd = new CityBikeParkingPoint(3,"PuntoAdd",5,new Gps());
		
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
	
	@Test (expected=IllegalArgumentException.class)
	public void testFalloAddNuevoPuntoDeAparcamientoExistente() {
		List<CityBikeParkingPoint> puntosDeAparcamiento = new ArrayList<CityBikeParkingPoint>();
		
		CityBikeParkingPoint punto1 = new CityBikeParkingPoint();
		CityBikeParkingPoint punto2 = new CityBikeParkingPoint();
		
		puntosDeAparcamiento.add(punto1);
		puntosDeAparcamiento.add(punto2);
		
		CityBikeSystem system = new CityBikeSystem();
		system.setListaPuntosDeAparcamiento(puntosDeAparcamiento);
		system.addNuevoPuntoDeAparcamiento(punto2);
		
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
		CityBikeParkingPoint puntoRemove = new CityBikeParkingPoint(1,"PuntoRemove",5,new Gps());
		
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
	public void testGetPuntosDeAparcamientoConAnclajesVaciosPeroNoHay() {
		List<CityBikeParkingPoint> puntosDeAparcamiento = new ArrayList<CityBikeParkingPoint>();
		
		CityBikeParkingPoint punto2 = new CityBikeParkingPoint();
		CityBikeParkingPoint punto3 = new CityBikeParkingPoint();
		
		Anclaje anclaje1 = new Anclaje();
		Anclaje anclaje2 = new Anclaje();
		Anclaje anclaje3 = new Anclaje();
		anclaje2.setEstado(1);
		anclaje3.setEstado(1);
		
		List<Anclaje> listaAnclajes2 = new ArrayList<Anclaje>();
		List<Anclaje> listaAnclajes3 = new ArrayList<Anclaje>();
		
		listaAnclajes2.add(anclaje2);
		listaAnclajes3.add(anclaje3);
		
		punto2.setListaAnclajes(listaAnclajes2); // Todos los anclajes ocupados
		punto3.setListaAnclajes(listaAnclajes3); // Todos los anclajes ocupados
		
		
		puntosDeAparcamiento.add(punto2);
		puntosDeAparcamiento.add(punto3);
		
		CityBikeSystem sistema = new CityBikeSystem();
		sistema.setListaPuntosDeAparcamiento(puntosDeAparcamiento);
		
		List<CityBikeParkingPoint> listaAparcamientosVaciosEsperada = new ArrayList<CityBikeParkingPoint>();
		
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
	public void testGetPuntosDeAparcamientoConBicisDisponiblesPeroEstanTodasOcupadas() {
		List<CityBikeParkingPoint> puntosDeAparcamiento = new ArrayList<CityBikeParkingPoint>();
		
		CityBikeParkingPoint punto1 = new CityBikeParkingPoint();
		CityBikeParkingPoint punto2 = new CityBikeParkingPoint();
		
		Anclaje anclaje1 = new Anclaje();
		Anclaje anclaje2 = new Anclaje();
		anclaje1.setEstado(0);
		anclaje2.setEstado(0);
		
		List<Anclaje> listaAnclajes1 = new ArrayList<Anclaje>();
		List<Anclaje> listaAnclajes2 = new ArrayList<Anclaje>();
		
		listaAnclajes1.add(anclaje1);
		listaAnclajes2.add(anclaje2);
		
		punto1.setListaAnclajes(listaAnclajes1);
		punto2.setListaAnclajes(listaAnclajes2);
		
		
		puntosDeAparcamiento.add(punto1); 
		puntosDeAparcamiento.add(punto2);
		
		CityBikeSystem sistema = new CityBikeSystem();
		sistema.setListaPuntosDeAparcamiento(puntosDeAparcamiento);
		
		List<CityBikeParkingPoint> listaAparcamientosConBicisEsperada = new ArrayList<CityBikeParkingPoint>();
		
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
	
	@Test
	public void testEqualsSystem() {
		boolean iguales = true;
		
		CityBikeSystem sistema1 = new CityBikeSystem();
		CityBikeSystem sistema2 = new CityBikeSystem();
		
		List<CityBikeParkingPoint> puntosDeAparcamiento = new ArrayList<CityBikeParkingPoint>();
		CityBikeParkingPoint punto1 = new CityBikeParkingPoint();
		CityBikeParkingPoint punto2 = new CityBikeParkingPoint();
		
		
		puntosDeAparcamiento.add(punto1); 
		puntosDeAparcamiento.add(punto2);
		
		sistema1.setListaPuntosDeAparcamiento(puntosDeAparcamiento);
		sistema2.setListaPuntosDeAparcamiento(puntosDeAparcamiento);
		
		boolean respuestaActual = sistema1.equals(sistema2);
		
		assertEquals(iguales,respuestaActual);
	}
	
	@Test
	public void testGetYSetListaDePacks() {
		Bike[] listaBicis = new Bike[10];
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
		AdultBike bici2 = new AdultBike(2,"BH","X",20,3,7,"XL",3);
		AdultBike bici3 = new AdultBike(3,"BH","X",20,3,7,"XL",3);
		AdultBike bici4 = new AdultBike(4,"BH","X",20,3,7,"XL",3);
		AdultBike bici5 = new AdultBike(5,"BH","X",20,3,7,"XL",3);
		AdultBike bici6 = new AdultBike(6,"BH","X",20,3,7,"XL",3);
		AdultBike bici7 = new AdultBike(7,"BH","X",20,3,7,"XL",3);
		AdultBike bici8 = new AdultBike(8,"BH","X",20,3,7,"XL",3);
		AdultBike bici9 = new AdultBike(9,"BH","X",20,3,7,"XL",3);
		AdultBike bici10 = new AdultBike(10,"BH","X",20,3,7,"XL",3);

		listaBicis[0] = bici1;
		listaBicis[1] = bici2;
		listaBicis[2] = bici3;
		listaBicis[3] = bici4;
		listaBicis[4] = bici5;
		listaBicis[5] = bici6;
		listaBicis[6] = bici7;
		listaBicis[7] = bici8;
		listaBicis[8] = bici9;
		listaBicis[9] = bici10;
		
		PackGrupo pack = new PackGrupo(listaBicis);
		List<Pack> listaDePacks = new ArrayList<Pack>();
		List<Pack> listaEsperada = listaDePacks;
		
		CityBikeSystem system = new CityBikeSystem();
		system.setListaDePacks(listaDePacks);
		
		List<Pack> listaActual = system.getListaDePacks();
		
		assertEquals(listaEsperada,listaActual);
	}
	
	@Test
	public void testToStringCityBikeSystem() {
		String respuestaEsperada = "CityBikeSystem [fianza=3.0, listaPuntosDeAparcamiento=[CityBikeParkingPoint [id=1, nombre=nombre, numAnclajes=2, gps=Gps [latitud=[], longitud=[]], listaAnclajes=[Anclaje [id=0, estado=0, biciAnclada=1], Anclaje [id=0, estado=0, biciAnclada=2]], precioFianza=3.0], CityBikeParkingPoint [id=2, nombre=nombre, numAnclajes=2, gps=Gps [latitud=[], longitud=[]], listaAnclajes=[Anclaje [id=0, estado=0, biciAnclada=1], Anclaje [id=0, estado=0, biciAnclada=2]], precioFianza=3.0]], listaDePacks=[Pack [fianzaPack=24.0, listaBicis=[Bike [id=1, marca=BH, modelo=X, peso=20.0, numPlatos=3, numPinones=7]AdultBike [talla=XL, fianza=3.0], Bike [id=2, marca=BH, modelo=X, peso=20.0, numPlatos=3, numPinones=7]AdultBike [talla=XL, fianza=3.0], Bike [id=3, marca=BH, modelo=X, peso=20.0, numPlatos=3, numPinones=7]AdultBike [talla=XL, fianza=3.0], Bike [id=4, marca=BH, modelo=X, peso=20.0, numPlatos=3, numPinones=7]AdultBike [talla=XL, fianza=3.0], Bike [id=5, marca=BH, modelo=X, peso=20.0, numPlatos=3, numPinones=7]AdultBike [talla=XL, fianza=3.0], Bike [id=6, marca=BH, modelo=X, peso=20.0, numPlatos=3, numPinones=7]AdultBike [talla=XL, fianza=3.0], Bike [id=7, marca=BH, modelo=X, peso=20.0, numPlatos=3, numPinones=7]AdultBike [talla=XL, fianza=3.0], Bike [id=8, marca=BH, modelo=X, peso=20.0, numPlatos=3, numPinones=7]AdultBike [talla=XL, fianza=3.0], Bike [id=9, marca=BH, modelo=X, peso=20.0, numPlatos=3, numPinones=7]AdultBike [talla=XL, fianza=3.0], Bike [id=10, marca=BH, modelo=X, peso=20.0, numPlatos=3, numPinones=7]AdultBike [talla=XL, fianza=3.0]]]]]";
		List<CityBikeParkingPoint> puntosDeAparcamiento = new ArrayList<CityBikeParkingPoint>();
		CityBikeParkingPoint parkingPoint1 = new CityBikeParkingPoint(1,"nombre",2,new Gps());
		CityBikeParkingPoint parkingPoint2 = new CityBikeParkingPoint(2,"nombre",2,new Gps());

		List<Anclaje> listaDeAnclajes = new ArrayList<Anclaje>();
		listaDeAnclajes.add(new Anclaje());
		listaDeAnclajes.add(new Anclaje());
		listaDeAnclajes.get(0).setBiciAnclada(new AdultBike(1,"BH","modeloPrueba",20,3,7,"L",3));
		listaDeAnclajes.get(1).setBiciAnclada(new AdultBike(2,"BH","modeloPrueba",20,3,7,"L",3));
		
		parkingPoint1.setListaAnclajes(listaDeAnclajes);
		parkingPoint2.setListaAnclajes(listaDeAnclajes);

		
		puntosDeAparcamiento.add(parkingPoint1);
		puntosDeAparcamiento.add(parkingPoint2);
		
		Bike[] listaBicis = new Bike[10];
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
		AdultBike bici2 = new AdultBike(2,"BH","X",20,3,7,"XL",3);
		AdultBike bici3 = new AdultBike(3,"BH","X",20,3,7,"XL",3);
		AdultBike bici4 = new AdultBike(4,"BH","X",20,3,7,"XL",3);
		AdultBike bici5 = new AdultBike(5,"BH","X",20,3,7,"XL",3);
		AdultBike bici6 = new AdultBike(6,"BH","X",20,3,7,"XL",3);
		AdultBike bici7 = new AdultBike(7,"BH","X",20,3,7,"XL",3);
		AdultBike bici8 = new AdultBike(8,"BH","X",20,3,7,"XL",3);
		AdultBike bici9 = new AdultBike(9,"BH","X",20,3,7,"XL",3);
		AdultBike bici10 = new AdultBike(10,"BH","X",20,3,7,"XL",3);

		listaBicis[0] = bici1;
		listaBicis[1] = bici2;
		listaBicis[2] = bici3;
		listaBicis[3] = bici4;
		listaBicis[4] = bici5;
		listaBicis[5] = bici6;
		listaBicis[6] = bici7;
		listaBicis[7] = bici8;
		listaBicis[8] = bici9;
		listaBicis[9] = bici10;
		
		PackGrupo pack = new PackGrupo(listaBicis);
		List<Pack> listaDePacks = new ArrayList<Pack>();
		listaDePacks.add(pack);
		
		CityBikeSystem system = new CityBikeSystem();
		system.setListaDePacks(listaDePacks);
		system.setListaPuntosDeAparcamiento(puntosDeAparcamiento);
		system.setFianza(3);
		
		String respuestaActual = system.toString();
		
		assertEquals(respuestaEsperada,respuestaActual);
	}
	
	@Test
	public void testEquals1() {
		boolean respuestaEsperada = true;
		CityBikeSystem system = new CityBikeSystem();
		
		boolean respuestaActual = system.equals(system);
		
		assertEquals(respuestaEsperada,respuestaActual);
	}
	
	@Test
	public void testEquals2() {
		boolean respuestaEsperada = false;
		CityBikeSystem system1 = new CityBikeSystem();
		CityBikeSystem system2 = null;
		
		boolean respuestaActual = system1.equals(system2);
		
		assertEquals(respuestaEsperada,respuestaActual);
	}
	
	@Test
	public void testEquals3() {
		boolean respuestaEsperada = false;
		CityBikeSystem system1 = new CityBikeSystem();
		CityBikeParkingPoint system2 = new CityBikeParkingPoint();
		
		boolean respuestaActual = system1.equals(system2);
		
		assertEquals(respuestaEsperada,respuestaActual);
	}
	
	@Test
	public void testEquals4() {
		boolean respuestaEsperada = false;
		CityBikeSystem system1 = new CityBikeSystem();
		CityBikeSystem system2 = new CityBikeSystem();
		system1.setListaDePacks(null);
		
		boolean respuestaActual = system1.equals(system2);
		
		assertEquals(respuestaEsperada,respuestaActual);
	}
	
	@Test
	public void testEquals5() {
		boolean respuestaEsperada = false;
		CityBikeSystem system1 = new CityBikeSystem();
		CityBikeSystem system2 = new CityBikeSystem();
		
		Bike[] listaBicis = new Bike[10];
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
		AdultBike bici2 = new AdultBike(2,"BH","X",20,3,7,"XL",3);
		AdultBike bici3 = new AdultBike(3,"BH","X",20,3,7,"XL",3);
		AdultBike bici4 = new AdultBike(4,"BH","X",20,3,7,"XL",3);
		AdultBike bici5 = new AdultBike(5,"BH","X",20,3,7,"XL",3);
		AdultBike bici6 = new AdultBike(6,"BH","X",20,3,7,"XL",3);
		AdultBike bici7 = new AdultBike(7,"BH","X",20,3,7,"XL",3);
		AdultBike bici8 = new AdultBike(8,"BH","X",20,3,7,"XL",3);
		AdultBike bici9 = new AdultBike(9,"BH","X",20,3,7,"XL",3);
		AdultBike bici10 = new AdultBike(10,"BH","X",20,3,7,"XL",3);

		listaBicis[0] = bici1;
		listaBicis[1] = bici2;
		listaBicis[2] = bici3;
		listaBicis[3] = bici4;
		listaBicis[4] = bici5;
		listaBicis[5] = bici6;
		listaBicis[6] = bici7;
		listaBicis[7] = bici8;
		listaBicis[8] = bici9;
		listaBicis[9] = bici10;
		
		PackGrupo pack = new PackGrupo(listaBicis);
		List<Pack> listaDePacks = new ArrayList<Pack>();
		listaDePacks.add(pack);
		system1.setListaDePacks(listaDePacks);
		system2.setListaDePacks(null);
		
		boolean respuestaActual = system1.equals(system2);
		
		assertEquals(respuestaEsperada,respuestaActual);
	}
	
	@Test
	public void testEquals6() {
		boolean respuestaEsperada = false;
		CityBikeSystem system1 = new CityBikeSystem();
		CityBikeSystem system2 = new CityBikeSystem();
		system1.setListaDePacks(null);
		system2.setListaDePacks(null);
		
		List<CityBikeParkingPoint> puntosDeAparcamiento = new ArrayList<CityBikeParkingPoint>();
		CityBikeParkingPoint parkingPoint1 = new CityBikeParkingPoint(1,"nombre",2,new Gps());
		CityBikeParkingPoint parkingPoint2 = new CityBikeParkingPoint(2,"nombre",2,new Gps());
		puntosDeAparcamiento.add(parkingPoint1);
		puntosDeAparcamiento.add(parkingPoint2);
		
		system1.setListaPuntosDeAparcamiento(puntosDeAparcamiento);
		
		boolean respuestaActual = system1.equals(system2);
		
		assertEquals(respuestaEsperada,respuestaActual);
	}
	
	@Test
	public void testEquals7() {
		boolean respuestaEsperada = false;
		CityBikeSystem system1 = new CityBikeSystem();
		CityBikeSystem system2 = new CityBikeSystem();
		system1.setListaDePacks(null);
		system2.setListaDePacks(null);
		
		List<CityBikeParkingPoint> puntosDeAparcamiento = new ArrayList<CityBikeParkingPoint>();
		CityBikeParkingPoint parkingPoint1 = new CityBikeParkingPoint(1,"nombre",2,new Gps());
		CityBikeParkingPoint parkingPoint2 = new CityBikeParkingPoint(2,"nombre",2,new Gps());
		puntosDeAparcamiento.add(parkingPoint1);
		puntosDeAparcamiento.add(parkingPoint2);
		
		List<Anclaje> listaDeAnclajes = new ArrayList<Anclaje>();
		listaDeAnclajes.add(new Anclaje());
		listaDeAnclajes.add(new Anclaje());
		listaDeAnclajes.get(0).setBiciAnclada(new AdultBike(1,"BH","modeloPrueba",20,3,7,"L",3));
		listaDeAnclajes.get(1).setBiciAnclada(new AdultBike(2,"BH","modeloPrueba",20,3,7,"L",3));
		
		parkingPoint1.setListaAnclajes(listaDeAnclajes);
		parkingPoint2.setListaAnclajes(listaDeAnclajes);
		
		Bike[] listaBicis = new Bike[10];
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
		AdultBike bici2 = new AdultBike(2,"BH","X",20,3,7,"XL",3);
		AdultBike bici3 = new AdultBike(3,"BH","X",20,3,7,"XL",3);
		AdultBike bici4 = new AdultBike(4,"BH","X",20,3,7,"XL",3);
		AdultBike bici5 = new AdultBike(5,"BH","X",20,3,7,"XL",3);
		AdultBike bici6 = new AdultBike(6,"BH","X",20,3,7,"XL",3);
		AdultBike bici7 = new AdultBike(7,"BH","X",20,3,7,"XL",3);
		AdultBike bici8 = new AdultBike(8,"BH","X",20,3,7,"XL",3);
		AdultBike bici9 = new AdultBike(9,"BH","X",20,3,7,"XL",3);
		AdultBike bici10 = new AdultBike(10,"BH","X",20,3,7,"XL",3);

		listaBicis[0] = bici1;
		listaBicis[1] = bici2;
		listaBicis[2] = bici3;
		listaBicis[3] = bici4;
		listaBicis[4] = bici5;
		listaBicis[5] = bici6;
		listaBicis[6] = bici7;
		listaBicis[7] = bici8;
		listaBicis[8] = bici9;
		listaBicis[9] = bici10;
		
		PackGrupo pack = new PackGrupo(listaBicis);
		List<Pack> listaDePacks = new ArrayList<Pack>();
		listaDePacks.add(pack);
		
		system1.setListaPuntosDeAparcamiento(puntosDeAparcamiento);
		system2.setListaPuntosDeAparcamiento(puntosDeAparcamiento);
		system1.setListaDePacks(listaDePacks);
		system2.setListaDePacks(listaDePacks);
		
		system1.setFianza(15);
		
		boolean respuestaActual = system1.equals(system2);
		
		assertEquals(respuestaEsperada,respuestaActual);
	}
	
	@Test
	public void testEquals8() {
		boolean respuestaEsperada = true;
		CityBikeSystem system1 = new CityBikeSystem();
		CityBikeSystem system2 = new CityBikeSystem();
		system1.setListaDePacks(null);
		system2.setListaDePacks(null);
		
		List<CityBikeParkingPoint> puntosDeAparcamiento = new ArrayList<CityBikeParkingPoint>();
		CityBikeParkingPoint parkingPoint1 = new CityBikeParkingPoint(1,"nombre",2,new Gps());
		CityBikeParkingPoint parkingPoint2 = new CityBikeParkingPoint(2,"nombre",2,new Gps());
		puntosDeAparcamiento.add(parkingPoint1);
		puntosDeAparcamiento.add(parkingPoint2);
		
		List<Anclaje> listaDeAnclajes = new ArrayList<Anclaje>();
		listaDeAnclajes.add(new Anclaje());
		listaDeAnclajes.add(new Anclaje());
		listaDeAnclajes.get(0).setBiciAnclada(new AdultBike(1,"BH","modeloPrueba",20,3,7,"L",3));
		listaDeAnclajes.get(1).setBiciAnclada(new AdultBike(2,"BH","modeloPrueba",20,3,7,"L",3));
		
		parkingPoint1.setListaAnclajes(listaDeAnclajes);
		parkingPoint2.setListaAnclajes(listaDeAnclajes);
		
		Bike[] listaBicis = new Bike[10];
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
		AdultBike bici2 = new AdultBike(2,"BH","X",20,3,7,"XL",3);
		AdultBike bici3 = new AdultBike(3,"BH","X",20,3,7,"XL",3);
		AdultBike bici4 = new AdultBike(4,"BH","X",20,3,7,"XL",3);
		AdultBike bici5 = new AdultBike(5,"BH","X",20,3,7,"XL",3);
		AdultBike bici6 = new AdultBike(6,"BH","X",20,3,7,"XL",3);
		AdultBike bici7 = new AdultBike(7,"BH","X",20,3,7,"XL",3);
		AdultBike bici8 = new AdultBike(8,"BH","X",20,3,7,"XL",3);
		AdultBike bici9 = new AdultBike(9,"BH","X",20,3,7,"XL",3);
		AdultBike bici10 = new AdultBike(10,"BH","X",20,3,7,"XL",3);

		listaBicis[0] = bici1;
		listaBicis[1] = bici2;
		listaBicis[2] = bici3;
		listaBicis[3] = bici4;
		listaBicis[4] = bici5;
		listaBicis[5] = bici6;
		listaBicis[6] = bici7;
		listaBicis[7] = bici8;
		listaBicis[8] = bici9;
		listaBicis[9] = bici10;
		
		PackGrupo pack = new PackGrupo(listaBicis);
		List<Pack> listaDePacks = new ArrayList<Pack>();
		listaDePacks.add(pack);
		
		system1.setListaPuntosDeAparcamiento(puntosDeAparcamiento);
		system2.setListaPuntosDeAparcamiento(puntosDeAparcamiento);
		system1.setListaDePacks(listaDePacks);
		system2.setListaDePacks(listaDePacks);
				
		boolean respuestaActual = system1.equals(system2);
		
		assertEquals(respuestaEsperada,respuestaActual);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
