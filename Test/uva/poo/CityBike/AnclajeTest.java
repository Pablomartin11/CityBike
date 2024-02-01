package uva.poo.CityBike;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnclajeTest {

	@Test
	public void testConstructorAnlcajeVacio() {
		Anclaje nuevoAnclaje = new Anclaje();
		
		assertNotNull(nuevoAnclaje);
	}
	
	@Test 
	public void testConstructorAnclajeConIDyEstado() {
		int id = 3;
		int estado = 1;
		Anclaje nuevoAnclaje = new Anclaje(id,estado);
		
		assertNotNull(nuevoAnclaje);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloIDdeAnclajeNegativo() {
		int id = -2;
		int estado = 1;
		
		new Anclaje(id,estado);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloEstadoDeAnclajeNoValido() {
		int id = 2;
		int estado = 7;
		
		new Anclaje(id,estado);
	}

	@Test
	public void testGetYSetIdDeUnAnclaje() {
		int idEsperado = 3;
		Anclaje nuevoAnclaje = new Anclaje();
		
		nuevoAnclaje.setId(3);
		int idActual = nuevoAnclaje.getId();
		
		assertEquals(idEsperado,idActual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloSetIdDeUnAnclajeNegativo() {
		Anclaje nuevoAnclaje = new Anclaje();
	
		nuevoAnclaje.setId(-7);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloSetIdDeUnAnclajeIgualACero() {
		Anclaje nuevoAnclaje = new Anclaje();
		
		nuevoAnclaje.setId(0);
	}
	
	@Test
	public void testGetYSetEstadoDeUnAnclajeA0() {
		int estadoEsperado = 0;
		Anclaje nuevoAnclaje = new Anclaje();
		
		nuevoAnclaje.setEstado(0);
		int estadoActual = nuevoAnclaje.getEstado();
		
		assertEquals(estadoEsperado,estadoActual);
	}
	
	@Test
	public void testGetYSetEstadoDeUnAnclajeA1() {
		int estadoEsperado = 1;
		Anclaje nuevoAnclaje = new Anclaje();
		
		nuevoAnclaje.setEstado(1);
		int estadoActual = nuevoAnclaje.getEstado();
		
		assertEquals(estadoEsperado,estadoActual);
	}
	
	@Test
	public void testGetYSetEstadoDeUnAnclajeA2() {
		int estadoEsperado = 2;
		Anclaje nuevoAnclaje = new Anclaje();
		
		nuevoAnclaje.setEstado(2);
		int estadoActual = nuevoAnclaje.getEstado();
		
		assertEquals(estadoEsperado,estadoActual);
	}
	
	@Test
	public void testGetYSetEstadoDeUnAnclajeA3() {
		int estadoEsperado = 3;
		Anclaje nuevoAnclaje = new Anclaje();
		
		nuevoAnclaje.setEstado(3);
		int estadoActual = nuevoAnclaje.getEstado();
		
		assertEquals(estadoEsperado,estadoActual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloSetEstadoInvalido() {
		Anclaje nuevoAnclaje = new Anclaje();
		
		nuevoAnclaje.setEstado(8);
	}
	
	@Test
	public void testGetYSetBiciAnclada() {
		Bike biciEsperada = new AdultBike(1,"BH","modeloPrueba",20,3,7,"L",3);
		
		Anclaje nuevoAnclaje = new Anclaje();
		nuevoAnclaje.setBiciAnclada(biciEsperada);
		
		Bike biciActual = nuevoAnclaje.getBiciAnclada();
		
		assertEquals(biciEsperada,biciActual);
	}
	
	@Test(expected = NullPointerException.class)
	public void testFalloSetBiciNula() {
		Bike bici = null;
		
		Anclaje nuevoAnclaje = new Anclaje();
		nuevoAnclaje.setBiciAnclada(bici);
	}
	
	@Test
	public void testToStringAnclaje() {
		String respuestaEsperada = "Anclaje [id=1, estado=0, biciAnclada=1]";
		
		Anclaje anclaje = new Anclaje(1,0);
		Bike biciAnclada = new AdultBike(1,"BH","modeloPrueba",20,3,7,"L",3);
		anclaje.setBiciAnclada(biciAnclada);
		
		String respuestaActual = anclaje.toString();
		
		assertEquals(respuestaEsperada,respuestaActual);
	}
	
	@Test 
	public void testEqualsAnclaje1() {
		boolean respuestaEsperada = true;
		
		Anclaje anclaje1 = new Anclaje(1,0);
		
		boolean respuestaActual = anclaje1.equals(anclaje1);
		
		assertEquals(respuestaEsperada,respuestaActual);
	}
	
	@Test 
	public void testEqualsAnclaje2() {
		boolean respuestaEsperada = false;
		
		Anclaje anclaje1 = new Anclaje(1,0);
		Anclaje anclaje2 = null;
		
		boolean respuestaActual = anclaje1.equals(anclaje2);
		
		assertEquals(respuestaEsperada,respuestaActual);
	}
	
	@Test
	public void testEqualsAnclaje3() {
		boolean respuestaEsperada = false;
		
		Anclaje anclaje1 = new Anclaje(1,0);
		CityBikeSystem anclaje2 = new CityBikeSystem();
		
		boolean respuestaActual = anclaje1.equals(anclaje2);
		
		assertEquals(respuestaEsperada,respuestaActual);
	}
	
	@Test
	public void testEqualsAnclaje4() {
		boolean respuestaEsperada = false;
		
		Anclaje anclaje1 = new Anclaje(1,1);
		Anclaje anclaje2 = new Anclaje(1,0);
		
		boolean respuestaActual = anclaje1.equals(anclaje2);
		
		assertEquals(respuestaEsperada,respuestaActual);
	}
	
	@Test
	public void testEqualsAnclaje5() {
		boolean respuestaEsperada = false;
		
		Anclaje anclaje1 = new Anclaje(500,0);
		Anclaje anclaje2 = new Anclaje(1,0);
		
		boolean respuestaActual = anclaje1.equals(anclaje2);
		
		assertEquals(respuestaEsperada,respuestaActual);
	}
	
	@Test
	public void testEqualsAnclaje6() {
		boolean respuestaEsperada = true;
		
		Anclaje anclaje1 = new Anclaje(1,0);
		Anclaje anclaje2 = new Anclaje(1,0);
		
		boolean respuestaActual = anclaje1.equals(anclaje2);
		
		assertEquals(respuestaEsperada,respuestaActual);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
