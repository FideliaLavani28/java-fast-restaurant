//2401954905 - FIDELIA LAVANI
public class KidsMeal extends Order{
	private String toy;
	private String milkshake;
	
	public KidsMeal(String name, String phone, String notes, String id, int totalPrice, String toy, String milkshake) {
		super(name, phone, notes, id, totalPrice);
		this.toy = toy;
		this.milkshake = milkshake;
	}
	public String getToy() {
		return toy;
	}
	public void setToy(String toy) {
		this.toy = toy;
	}
	public String getMilkshake() {
		return milkshake;
	}
	public void setMilkshake(String milkshake) {
		this.milkshake = milkshake;
	}
	@Override
	public void countPrice() {
		// TODO Auto-generated method stub
		setTotalPrice(20000);
	}
	
	
}
