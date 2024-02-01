package uva.poo.CityBike;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class AdultBikeTest {

	@Test
	public void testConstructorAdultBike() {
		
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
		
		assertNotNull(bici1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloConstructorAdultBikePesoNegativo() {
		
		AdultBike bici1 = new AdultBike(1,"BH","X",-20,3,7,"XL",3);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloConstructorAdultBikeNumPlatosNegativo() {
		
		AdultBike bici1 = new AdultBike(1,"BH","X",20,-3,7,"XL",3);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloConstructorAdultBikeNumPinonesNegativo() {
		
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,-7,"XL",3);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloConstructorAdultBikeTallaIncorrecta() {
		
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,-7,"T",3);
		
	}
	
	@Test
	public void testGetDepositToPay() {
		
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
		bici1.setFianza(20);
		double depositoActual = bici1.getDepositToPay(bici1.getFianza());
		double depositoEsperado = 20;
		assertEquals(depositoEsperado, depositoActual, 0.01);
	}
	
	@Test
	public void testGetTalla() {
		
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
	
		String tallaActual = bici1.getTalla();
		String tallaEsperada = "XL";
		assertEquals(tallaEsperada, tallaActual);
	}
	
	@Test
	public void testSetTallaS() {
		
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
	
		bici1.setTalla("S");
		String tallaActual = bici1.getTalla();
		String tallaEsperada = "S";
		assertEquals(tallaEsperada, tallaActual);
	}
	
	
	@Test
	public void testSetTallaM() {
		
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
	
		bici1.setTalla("M");
		String tallaActual = bici1.getTalla();
		String tallaEsperada = "M";
		assertEquals(tallaEsperada, tallaActual);
	}
	
	@Test
	public void testSetTallaL() {
		
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
	
		bici1.setTalla("L");
		String tallaActual = bici1.getTalla();
		String tallaEsperada = "L";
		assertEquals(tallaEsperada, tallaActual);
	}
	
	@Test
	public void testSetTallaXL() {
		
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
	
		bici1.setTalla("XL");
		String tallaActual = bici1.getTalla();
		String tallaEsperada = "XL";
		assertEquals(tallaEsperada, tallaActual);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloSetTallaInvalida() {
		
		AdultBike bici1 = new AdultBike(1,"BH","XL",20,3,7,"XL",3);
	
		bici1.setTalla("efvjbrf"); 
	}
	
	
	@Test
	public void testGetFianza() {
		
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
		bici1.setFianza(20);
		double fianzaActual = bici1.getFianza();
		double fianzaEsperada = 20;
		assertEquals(fianzaEsperada, fianzaActual, 0.01);
	}
	
	@Test
	public void testSetFianza() {
		
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
		double fianzaActual = bici1.getFianza();
		double fianzaEsperada = 3;
		assertEquals(fianzaEsperada, fianzaActual, 0.01);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testFalloSetFianza() {
		
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
		bici1.setFianza(-20);

	}
	
	@Test
	public void testToString() {
		
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
		
		String cadenaPadre = "Bike [id=" + bici1.getId() + ", marca=" + bici1.getMarca() + ", modelo=" + bici1.getModelo() + ", peso=" + bici1.getPeso() + ", numPlatos="
		+ bici1.getNumPlatos() + ", numPinones=" + bici1.getNumPinones() + "]";
		
		String cadenaHijo = "AdultBike [talla=" + bici1.getTalla() + ", fianza=" + bici1.getFianza() + "]";
		
		String cadenaEsperada = cadenaPadre+cadenaHijo;
		
		String cadenaActual = bici1.toString();
		
		assertEquals(cadenaEsperada, cadenaActual);
	}
	
	
	@Test
	public void testEqualsBicisIgualesDistintoObjeto() {
		
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
		AdultBike bici2 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
		
		boolean valorEsperado = true; 
		
		boolean valorActual = bici1.equals(bici2);
		
		assertEquals(valorEsperado, valorActual);
		
		
	}
	
	@Test
	public void testEqualsBicisIgualesMismoObjeto() {
		
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
		
		boolean valorEsperado = true; 
		
		boolean valorActual = bici1.equals(bici1);
		
		assertEquals(valorEsperado, valorActual);
		
		
	}
	
	@Test
	public void testEqualsBicisDistintoIdEnElPadre() {
		
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
		
		AdultBike bici2 = new AdultBike(2,"BH","X",20,3,7,"XL",3);
		
		boolean valorEsperado = false; 
		
		boolean valorActual = bici1.equals(bici2);
		
		assertEquals(valorEsperado, valorActual);
		
		
	}
	
	@Test
	public void testEqualsBicisDistintaMarcaEnElPadre() {
		
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
		
		AdultBike bici2 = new AdultBike(1,"HB","X",20,3,7,"XL",3);
		
		boolean valorEsperado = false; 
		
		boolean valorActual = bici1.equals(bici2);
		
		assertEquals(valorEsperado, valorActual);
		
		
	}
	
	@Test
	public void testEqualsBicisDistintoModeloEnElPadre() {
		
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
		
		AdultBike bici2 = new AdultBike(1,"BH","Y",20,3,7,"XL",3);
		
		boolean valorEsperado = false; 
		
		boolean valorActual = bici1.equals(bici2);
		
		assertEquals(valorEsperado, valorActual);
		
		
	}
	
	@Test
	public void testEqualsBicisDistintoPesoEnElPadre() {
		
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
		
		AdultBike bici2 = new AdultBike(1,"BH","X",30,3,7,"XL",3);
		
		boolean valorEsperado = false; 
		
		boolean valorActual = bici1.equals(bici2);
		
		assertEquals(valorEsperado, valorActual);
		
		
	}
	
	@Test
	public void testEqualsBicisDistintoNumPlatosEnElPadre() {
		
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
		
		AdultBike bici2 = new AdultBike(1,"BH","X",20,4,7,"XL",3);
		
		boolean valorEsperado = false; 
		
		boolean valorActual = bici1.equals(bici2);
		
		assertEquals(valorEsperado, valorActual);
		
		
	}
	
	@Test
	public void testEqualsBicisDistintoNumPinonesEnElPadre() {
		
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
		
		AdultBike bici2 = new AdultBike(1,"BH","X",20,3,8,"XL",3);
		
		boolean valorEsperado = false; 
		
		boolean valorActual = bici1.equals(bici2);
		
		assertEquals(valorEsperado, valorActual);
		
		
	}
	
	
	@Test
	public void testEqualsBicisDistintaFianza() {
		
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
		
		AdultBike bici2 = new AdultBike(1,"BH","X",20,3,7,"XL",5);
		
		boolean valorEsperado = false; 
		
		boolean valorActual = bici1.equals(bici2);
		
		assertEquals(valorEsperado, valorActual);
		
		
	}
	
	@Test
	public void testEqualsBicisDistintaTalla() {
		
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
		
		AdultBike bici2 = new AdultBike(1,"BH","X",20,3,7,"L",3);
		
		boolean valorEsperado = false; 
		
		boolean valorActual = bici1.equals(bici2);
		
		assertEquals(valorEsperado, valorActual);
		
		
	}
	
	@Test
	public void testEqualsObjetosDistintaClase() {
		
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",3);
		
		Anclaje objeto2 = new Anclaje();
		
		boolean valorEsperado = false; 
		
		boolean valorActual = bici1.equals(objeto2);
		
		assertEquals(valorEsperado, valorActual);
		
		
	}
	
}
