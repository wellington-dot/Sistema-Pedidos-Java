package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import entities.enums.OrderStatus;

public class Order {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	
	//Adicionando o objeto cliente a classe Order
	private Client client;
	
	//Criado uma lista de items
	private ArrayList<OrderItem> items = new ArrayList<>();
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	//Método para adicionar uma order
	public void addItem(OrderItem orderItem) {
		items.add(orderItem);
	}
	
	//Método para remover uma order
	public void removeItem(OrderItem orderItem) {
		items.remove(orderItem);
	}
	
	//Calcular o total de todos os items
	public double total() {
		double soma = 0.0;
		for (OrderItem i : items) {
			soma = soma + i.subTotal();
		}
		return soma;
	}
	
	//To string para imprimir na formatação correta
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY:  \n");
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n\n");
		sb.append("Order items: \n");
		
		for (OrderItem item : items) {
			sb.append(item + "\n");
		}
		
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	    }
}










