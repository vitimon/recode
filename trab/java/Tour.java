import java.util.Scanner;
import java.util.Vector;

class Customer{
	private int cpf;
	private String name;
	private String email;
	
	public Customer(int cpfS,String nameS,String emailS){
		cpf = cpfS;
		name = nameS;
		email = emailS;
	}
	public void printCustomer(){
		System.out.println(Integer.toString(this.getCPF()) + " " + this.getName()+ " " + this.getEmail());
	}
	public int getCPF(){
		return this.cpf;
	}
	public String getName(){
		return this.name;
	}
	public String getEmail(){
		return this.email;
	}
	public void setName(String nameS){
		this.name = nameS;	
	}
	public void setEmail(String emailS){
		this.email = emailS;	
	}
	
}

class Destination{
	private String name;
	private int price;
	
	public Destination(String nameS,int priceS){
		name = nameS;
		price = priceS;
	}
	public void printDestination(){
		System.out.println(this.getName()+ " R$ " + Integer.toString(this.getPrice()));
	}
	public String getName(){
		return this.name;
	}
	public int getPrice(){
		return this.price;
	}

	public void setPrice(int priceS){
		this.price = priceS;	
	}
	
}

class Travel{
	private int travelID;
	private Customer customer;
	private Destination destination;
	private int totalPrice;
	private String status;
	
	public Travel(int tidS, Customer customerS, Destination destinationS){
		travelID = tidS;
		customer = customerS;
		destination = destinationS;
		totalPrice = destination.getPrice();
		status = "open";
	}
	public void printTravel(){
		System.out.println(Integer.toString(this.travelID) + " " + customer.getName() + " " + destination.getName() + " " + Integer.toString(this.totalPrice) + " " + this.status);
	}/*
	public int getCPF(){
		return this.cpf;
	}
	public String getName(){
		return this.name;
	}
	public String getEmail(){
		return this.email;
	}
	public void setName(String nameS){
		this.name = nameS;	
	}
	public void setEmail(String emailS){
		this.email = emailS;	
	}*/
	
	
}
		
		
public class Tour {
	public static void main(String[] args){
		
		Customer cliente1 = new Customer(12345,"amendobobo","oeoe@gmail.com");
		Destination destino1 = new Destination("jururema",1400);
		Travel viagem1 = new Travel(0001,cliente1,destino1);
		viagem1.printTravel();
		destino1.setPrice(1200);
		cliente1.setName("boboamendo");
		viagem1.printTravel();
	}
			
}																																																																																																																										
