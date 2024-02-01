package uva.poo.CityBike;

import static org.junit.Assert.*;

import org.junit.Test;

public class ResourceTest {

	@Test
	public void testResourceAdultBike() {
		Resource r = new AdultBike(1,"BH","X",20,3,7,"XL",10);
		double fianzaActual = r.getDepositToPay(10);
		assertEquals(fianzaActual,10,0.01);
		
	}
	
	
	@Test
	public void testResourceChildBike() {
		Resource r = new ChildBike(1,"BH","X",20,3,7,20,10);
		double fianzaActual = r.getDepositToPay(10);
		double fianzaEsperada = 10*0.85;
		assertEquals(fianzaActual,fianzaEsperada,0.01);
		
	}
	
	
	@Test
	public void testResourceElectricBike() {
		Resource r = new ElectricBike(1,"BH","X",20,3,7,"XL",10,40,36,10);
		double fianzaActual = r.getDepositToPay(10);
		double fianzaEsperada = 10 + 10*0.36;
		assertEquals(fianzaActual,fianzaEsperada,0.01);
		
	}
	
	
	@Test
	public void testResourcePackGrupo() {
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",10);
		AdultBike bici2 = new AdultBike(2,"BH","X",20,3,7,"XL",10);
		AdultBike bici3 = new AdultBike(3,"BH","X",20,3,7,"XL",10);
		AdultBike bici4 = new AdultBike(4,"BH","X",20,3,7,"XL",10);
		AdultBike bici5 = new AdultBike(5,"BH","X",20,3,7,"XL",10);
		AdultBike bici6 = new AdultBike(6,"BH","X",20,3,7,"XL",10);
		AdultBike bici7 = new AdultBike(7,"BH","X",20,3,7,"XL",10);
		AdultBike bici8 = new AdultBike(8,"BH","X",20,3,7,"XL",10);
		AdultBike bici9 = new AdultBike(9,"BH","X",20,3,7,"XL",10);
		AdultBike bici10 = new AdultBike(10,"BH","X",20,3,7,"XL",10);
		
		Bike[] listaBicis = new Bike[10];
		
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
		
		Resource pack = new PackGrupo(listaBicis);
		
		double sumaFianzasPack = 10.0*10.0;
		
		double fianzaActual = pack.getDepositToPay(sumaFianzasPack);
		double fianzaEsperada = sumaFianzasPack*0.8;
		assertEquals(fianzaActual,fianzaEsperada,0.01);
	}
	
	@Test
	public void testResourcePackFamiliar() {
		AdultBike bici1 = new AdultBike(1,"BH","X",20,3,7,"XL",10);
		AdultBike bici2 = new AdultBike(2,"BH","X",20,3,7,"XL",10);
		ChildBike bici3 = new ChildBike(3,"BH","X",20,3,7,20,10);
		ChildBike bici4 = new ChildBike(4,"BH","X",20,3,7,16,10);
		
		
		Bike[] listaBicis = new Bike[4];
		
		listaBicis[0] = bici1;
		listaBicis[1] = bici2; 
		listaBicis[2] = bici3;
		listaBicis[3] = bici4;
		
		Resource pack = new PackFamiliar(listaBicis);
		
		double sumaFianzasPack = 10.0*4.0;
		
		double fianzaActual = pack.getDepositToPay(sumaFianzasPack);
		double fianzaEsperada = sumaFianzasPack*0.5;
		assertEquals(fianzaActual,fianzaEsperada,0.01);
	}
	
	

}
