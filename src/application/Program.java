package application;

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

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Order order = new Order();
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date(DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		Client client = new Client(name, email, birthDate);
		sc.nextLine();
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.nextLine();
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		OrderStatus orderStatus = OrderStatus.valueOf(status.toUpperCase());
		
		for (int i = 1; i <=n; i++) {
			System.out.printf("Enter #%d item data:\n", i);
			sc.nextLine();
			System.out.print("Product name: ");
			String pName = sc.nextLine();
			System.out.print("Product price: ");
			Double pPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(pName, pPrice);
			OrderItem orderItem = new OrderItem(quantity, pPrice, product);
			order.addItem(orderItem);
		}
		
		sc.close();
	}

}