package Aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String args[]) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 
		String name;
		String email;
		Date bithDate;
		
		System.out.println("Enter cliente Data: ");
		System.out.print("Name: ");
		name = input.next();
		System.out.print("Email: ");
		email = input.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		bithDate = sdf.parse(input.next());
		
		Client client = new Client(name, email, bithDate);
		
		System.out.println();
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(input.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.println();
		System.out.print("How many items to this order: ");
		int items = input.nextInt();

		for (int i = 0; i<items; i++) {
			System.out.println("Enter #" +( i+1) + "item data: ");
			System.out.print("Product name:" );
			String productName = input.next();
			input.nextLine();
			System.out.print("Product price: ");
			double productPrice = input.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = input.nextInt();
			System.out.println();
			
			Product product = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);
			
			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println(order);
		
		input.close();
	}

}
