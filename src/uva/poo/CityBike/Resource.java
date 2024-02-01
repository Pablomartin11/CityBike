package uva.poo.CityBike;

public interface Resource {
	
	/**
	 * Obtener el total de fianza a pagar segun el tipo de recurso.
	 * @param deposit
	 * @return la fianza total.
	 */
	public double getDepositToPay(double deposit);
	
}
