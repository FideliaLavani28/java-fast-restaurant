//2401954905 - FIDELIA LAVANI
public abstract class Order {
	private String name;
	private String phone;
	private String notes;
	private String id;
	private int totalPrice;
	
	public abstract void countPrice();
	
	public Order(String name, String phone, String notes, String id, int totalPrice) {
		super();
		this.name = name;
		this.phone = phone;
		this.notes = notes;
		this.id = id;
		this.totalPrice = totalPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
