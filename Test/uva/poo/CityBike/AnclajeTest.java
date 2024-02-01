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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
