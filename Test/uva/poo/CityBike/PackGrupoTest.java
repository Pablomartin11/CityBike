package uva.poo.CityBike;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class PackGrupoTest {

	@Test
	public void testConstructorPackGrupal() {
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
		
		assertNotNull(pack);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloConstructorCantidadMinima() {
		Bike[] listaBicis = new Bike[9];
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
		AdultBike bici2 = new AdultBike(2,"BH","X",20,3,7,"XL",3);
		AdultBike bici3 = new AdultBike(3,"BH","X",20,3,7,"XL",3);
		AdultBike bici4 = new AdultBike(4,"BH","X",20,3,7,"XL",3);
		AdultBike bici5 = new AdultBike(5,"BH","X",20,3,7,"XL",3);
		AdultBike bici6 = new AdultBike(6,"BH","X",20,3,7,"XL",3);
		AdultBike bici7 = new AdultBike(7,"BH","X",20,3,7,"XL",3);
		AdultBike bici8 = new AdultBike(8,"BH","X",20,3,7,"XL",3);
		AdultBike bici9 = new AdultBike(9,"BH","X",20,3,7,"XL",3);

		listaBicis[0] = bici1;
		listaBicis[1] = bici2;
		listaBicis[2] = bici3;
		listaBicis[3] = bici4;
		listaBicis[4] = bici5;
		listaBicis[5] = bici6;
		listaBicis[6] = bici7;
		listaBicis[7] = bici8;
		listaBicis[8] = bici9;
		
		
		PackGrupo pack = new PackGrupo(listaBicis);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloConstructorBicisRepetidas() {
		Bike[] listaBicis = new Bike[9];
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
		AdultBike bici2 = new AdultBike(2,"BH","X",20,3,7,"XL",3);
		AdultBike bici3 = new AdultBike(3,"BH","X",20,3,7,"XL",3);
		AdultBike bici4 = new AdultBike(4,"BH","X",20,3,7,"XL",3);
		AdultBike bici5 = new AdultBike(5,"BH","X",20,3,7,"XL",3);
		AdultBike bici6 = new AdultBike(6,"BH","X",20,3,7,"XL",3);
		AdultBike bici7 = new AdultBike(7,"BH","X",20,3,7,"XL",3);
		AdultBike bici8 = new AdultBike(8,"BH","X",20,3,7,"XL",3);

		listaBicis[0] = bici1;
		listaBicis[1] = bici2;
		listaBicis[2] = bici3;
		listaBicis[3] = bici4;
		listaBicis[4] = bici5;
		listaBicis[5] = bici6;
		listaBicis[6] = bici7;
		listaBicis[7] = bici8;
		listaBicis[8] = bici8;
		
		
		PackGrupo pack = new PackGrupo(listaBicis);
	}
	
	
	@Test
	public void testGetDepositToPay() {
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
		
		double fianza = pack.getFianzaPack();
		double fianzaActual = pack.getDepositToPay(fianza);
		double fianzaEsperada = fianza - fianza*0.2;
		assertEquals(fianzaEsperada, fianzaActual, 0.01);
	}
	
	@Test
	public void testSetFianzaPack() {
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
		
		double sumaFianzas = 0;
		for (int i = 0; i < pack.listaBicis.length; i++) {
			sumaFianzas += pack.listaBicis[i].getFianza();
		}
		double fianzaEsperada = pack.getDepositToPay(sumaFianzas);
		
		pack.setFianzaPack(sumaFianzas);
		double fianzaActual = pack.getFianzaPack();
		
		assertEquals(fianzaEsperada, fianzaActual, 0.01);
	}
	
	
	@Test
	public void testSetListaBicis() {
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
		
		Bike[] listaAlternativa = listaBicis;
		listaAlternativa[0].setTalla("M");
		
		PackGrupo pack = new PackGrupo(listaAlternativa);
		pack.setListaBicis(listaBicis);
		 
		Bike[] listaActual = pack.getListaBicis();
		
		Bike[] listaEsperada = listaBicis;
		
		assertTrue(Arrays.equals(listaEsperada,listaActual));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloSetListaBicisCantidadMinima() {
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
		
		Bike[] listaAlternativa = new Bike[1];
		
		listaAlternativa[0] = bici1;
		
		pack.setListaBicis(listaAlternativa);
		 
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloSetListaBicisConRepetidas() {
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
		
		listaBicis[0] = bici2;
		
		pack.setListaBicis(listaBicis);
		
		
	}
	
	
	@Test
	public void testCambiarBiciDelPack() {
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
		AdultBike bici11 = new AdultBike(11,"BH","X",20,3,7,"XL",3);

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
		
		pack.cambiarBiciDelPack(bici11,bici1);
		
		Bike[] listaActual = pack.getListaBicis();		
		
		listaBicis[0] = bici11;
		
		Bike[] listaEsperada = listaBicis;
		
		assertTrue(Arrays.equals(listaEsperada, listaActual));
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloCambiarBiciDelPackBicisRepetidas() {
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
		AdultBike bici11 = new AdultBike(11,"BH","X",20,3,7,"XL",3);

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
		
		pack.cambiarBiciDelPack(bici2,bici1);
		
	}
	

	
	
	@Test
	public void testAddBiciAlPack() {
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
		AdultBike bici11 = new AdultBike(11,"BH","X",20,3,7,"XL",3);

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
		
		pack.addBiciAlPack(bici11);
		Bike [] listaActual = pack.getListaBicis();
		
		Bike [] listaEsperada = new Bike[11];	
		
		listaEsperada[0] = bici1;
		listaEsperada[1] = bici2;
		listaEsperada[2] = bici3;
		listaEsperada[3] = bici4;
		listaEsperada[4] = bici5;
		listaEsperada[5] = bici6;
		listaEsperada[6] = bici7;
		listaEsperada[7] = bici8;
		listaEsperada[8] = bici9;
		listaEsperada[9] = bici10;
		listaEsperada[10] = bici11;
		
		
		assertTrue(Arrays.equals(listaEsperada, listaActual));
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloAddBiciAlPackRepetida() {
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
		
		pack.addBiciAlPack(bici10);

		
	}
	
	
	
	@Test
	public void testRemoveBiciDelPackUltimaPosicion() {
		Bike[] listaBicis = new Bike[11];
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
		AdultBike bici11 = new AdultBike(11,"BH","X",20,3,7,"XL",3);

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
		listaBicis[10] = bici11;
		
		
		PackGrupo pack = new PackGrupo(listaBicis);
		
		pack.removeBiciDelPack(bici11);
		Bike [] listaActual = pack.getListaBicis();
		
		Bike [] listaEsperada = new Bike[10];	
		
		listaEsperada[0] = bici1;
		listaEsperada[1] = bici2;
		listaEsperada[2] = bici3;
		listaEsperada[3] = bici4;
		listaEsperada[4] = bici5;
		listaEsperada[5] = bici6;
		listaEsperada[6] = bici7;
		listaEsperada[7] = bici8;
		listaEsperada[8] = bici9;
		listaEsperada[9] = bici10;
		
		
		assertTrue(Arrays.equals(listaEsperada, listaActual));
		
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloRemoveBiciDelPackCantidadMinima() {
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
		
		pack.removeBiciDelPack(bici10);

		
	}
	
	@Test
	public void testRemoveBiciDelPackPoisicionMedio() {
		Bike[] listaBicis = new Bike[11];
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
		AdultBike bici11 = new AdultBike(11,"BH","X",20,3,7,"XL",3);

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
		listaBicis[10] = bici11;
		
		
		PackGrupo pack = new PackGrupo(listaBicis);
		
		pack.removeBiciDelPack(bici8);
		Bike [] listaActual = pack.getListaBicis();
		
		Bike [] listaEsperada = new Bike[10];	
		
		listaEsperada[0] = bici1;
		listaEsperada[1] = bici2;
		listaEsperada[2] = bici3;
		listaEsperada[3] = bici4;
		listaEsperada[4] = bici5;
		listaEsperada[5] = bici6;
		listaEsperada[6] = bici7;
		listaEsperada[7] = bici9;
		listaEsperada[8] = bici10;
		listaEsperada[9] = bici11;
		
		
		assertTrue(Arrays.equals(listaEsperada, listaActual));

		
	}
	

}
