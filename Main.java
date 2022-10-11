//2401954905 - FIDELIA LAVANI

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	Scanner scan = new Scanner(System.in);
	ArrayList<Order> orderList = new ArrayList<>();
	
	public Main() {
		// TODO Auto-generated constructor stub
		
		int menu;

		do {
			viewOrder();

			System.out.println("Fast Restaurant");
			System.out.println();
			System.out.println("1. Order");
			System.out.println("2. Proceed Order");
			System.out.println("3. Exit");
			System.out.print("Choose: ");
			menu = scan.nextInt(); scan.nextLine();
			
			if(menu==1) {
				menu1();
			}
			else if(menu==2) {
				menu2();
			}
			
		}while(menu!=3);
		
		if(menu==3) {
			System.out.println("Thank You!");
		}
	}
	
	public void menu1() {
		String name, phone, type,notes,id;
		
		do {
			System.out.print("Input Customer Name [Must not empty]: ");
			name = scan.nextLine();
		}while(name.isEmpty()==true);
		
		do {
			System.out.print("Input Customer Phone [Must not empty]: ");
			phone = scan.nextLine();
		}while(phone.isEmpty()==true);
		
		do {
			System.out.print("Choose Meal [Value Meal | Kids Meal] (Case Insensitive): ");
			type = scan.nextLine();
		}while(type.equalsIgnoreCase("Value Meal")==false && type.equalsIgnoreCase("Kids Meal")==false);
		
		id = generateId();
		
		if(type.equalsIgnoreCase("Value Meal")==true) {
			
			String drink, carbo;
			do {
				System.out.print("Choose Drink [Coca Cola | Teh Botol | RB Float] [Case Sensitive]: ");
				drink = scan.nextLine();
			}while(drink.equals("Coca Cola")==false && drink.equals("Teh Botol")==false && drink.equals("RB Float")==false);
			
			do {
				System.out.print("Choose Between [Rice | French Fries] [Case Sensitive]: ");
				carbo = scan.nextLine();
			}while(carbo.equals("Rice")==false && carbo.equals("French Fries")==false);
			
			System.out.print("Input Notes: ");
			notes = scan.nextLine();
			
			ValueMeal v = new ValueMeal(name, phone, notes, id, 0, drink, carbo);
			v.countPrice();
			orderList.add(v);
			
			System.out.println("Sucess Order");
			System.out.println("Press enter to continue...");
			scan.nextLine();
		}
		else if(type.equalsIgnoreCase("Kids Meal")==true) {
			String toy, milkshake;
			
			do {
				System.out.print("Choose Extra Toy [Iron Man | Captain America | Spider Man] [Case Sensitive]: ");
				toy = scan.nextLine();
			}while(toy.equals("Iron Man")==false && toy.equals("Captain America")==false && toy.equals("Spider Man")==false);
			
			do {
				System.out.print("Choose Milkshake [Chocolate | Strawberry | Vanilla] [Case Sensitive]: ");
				milkshake = scan.nextLine();
			}while(milkshake.equals("Chocolate")==false && milkshake.equals("Strawberry")==false && milkshake.equals("Vanilla")==false);
			
			System.out.print("Input Notes: ");
			notes = scan.nextLine();
			
			KidsMeal k = new KidsMeal(name, phone, notes, id, 0, toy, milkshake);
			k.countPrice();
			orderList.add(k);
			
			System.out.println("Sucess Order");
			System.out.println("Press enter to continue...");
			scan.nextLine();
		}
	}
	
	public String generateId() {
		
		String ID=null;
		Random rand = new Random();
		ID = "OR"+ rand.nextInt(10) + rand.nextInt(10)+ rand.nextInt(10);
		
		return ID;
		
	}
	
	public void viewOrder() {
		if(orderList.isEmpty()==true) {
			System.out.println("No Order");
			System.out.println();
			return;
		}
		else {
			for (Order order : orderList) {
				if(order instanceof ValueMeal) {
					System.out.println("Order ID: "+order.getId());
					System.out.println("CustomerName: "+order.getName());
					System.out.println("CustomerPhone: "+order.getPhone());
					System.out.println("Meal: Value Meal ("+ ((ValueMeal) order).getDrink()+" + "+((ValueMeal) order).getCarbo()+")");
					System.out.println("Price: "+order.getTotalPrice());
					System.out.println("Notes: "+order.getNotes());
					System.out.println();
				}
				else if(order instanceof KidsMeal) {
					System.out.println("Order ID: "+order.getId());
					System.out.println("CustomerName: "+order.getName());
					System.out.println("CustomerPhone: "+order.getPhone());
					System.out.println("Meal: Kids Meal ("+((KidsMeal) order).getToy()+" + "+((KidsMeal) order).getMilkshake()+")");
					System.out.println("Price: "+order.getTotalPrice());
					System.out.println("Notes: "+order.getNotes());
					System.out.println();
				}
			}
		}
	}
	
	public void menu2() {
		
		if(orderList.isEmpty()==true) {
			System.out.println("No Order");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			return;
		}
		else {
			viewOrder();
		} 
		
		String chooseID;
		int index;
		do {
			System.out.print("Choose Order to be proceed [Case Sensitive | 'Cancel' to cancel]: ");
			chooseID = scan.nextLine();
			index = searchID(chooseID);
			
			if(chooseID.equals("Cancel")==true) return;
			
		}while(index==-1);
		
		orderList.remove(index);
		
		System.out.println("Succeed Proceed Order "+chooseID);
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}
	
	public int searchID(String chooseID) {
		int index=-1;
		
		for (int i = 0; i < orderList.size(); i++) {
			if(orderList.get(i).getId().equals(chooseID)) {
				index = i;
				break;
			}
		}
		
		return index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
