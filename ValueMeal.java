//2401954905 - FIDELIA LAVANI
public class ValueMeal extends Order{
	private String drink;
	private String carbo;
	
	public ValueMeal(String name, String phone, String notes, String id, int totalPrice, String drink, String carbo) {
		super(name, phone, notes, id, totalPrice);
		this.drink = drink;
		this.carbo = carbo;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public String getCarbo() {
		return carbo;
	}

	public void setCarbo(String carbo) {
		this.carbo = carbo;
	}

	@Override
	public void countPrice() {
		// TODO Auto-generated method stub
		if(getCarbo().equals("Rice")==true) {
			setTotalPrice(17000);
		}
		else if(getCarbo().equals("French Fries")==true) {
			setTotalPrice(22000);
		}
	}
	
	
}
