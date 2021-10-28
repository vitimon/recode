//By Leo N. ---- métodos "print" não citados na uml

import java.util.Scanner;
import java.util.Vector;
import java.util.Calendar;

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
	private String place;
	private int price;
	
	public Destination(String placeS,int priceS){
		place = placeS;
		price = priceS;
	}
	public void printDestination(){
		System.out.println(this.getPlace()+ " R$ " + Integer.toString(this.getPrice()));
	}
	public String getPlace(){
		return this.place;
	}
	public int getPrice(){
		return this.price;
	}
public void setPlace(String placeS){
		this.place = placeS;	
	}
	public void setPrice(int priceS){
		this.price = priceS;	
	}
	
}

class Travel{
	private int travelID;
	private Customer customer;
	private Destination destination;
	private int tickets;
	private String status;
	
	public Travel(int tidS, Customer customerS, Destination destinationS, int ticketsS){
		travelID = tidS;
		customer = customerS;
		destination = destinationS;
		tickets = ticketsS;
		status = "open";
	}
	public void printTravel(){
		System.out.println(Integer.toString(this.travelID) + " " + customer.getName() + " " + destination.getPlace() + " " + Integer.toString(this.getTotalPrice()) + " " + this.status);
	}
	public int getTravelID(){
		return this.travelID;
	}
	public Customer getCustomer(){
		return this.customer;
	}
	public Destination getDestination(){
		return this.destination;
	}
	public int getTickets(){
		return this.tickets;
	} 
	public String getStatus(){
		return this.status;
	}
	public int getTotalPrice(){
		return this.destination.getPrice()*this.tickets;
	}
	public void updateStatus(String nameS){
		this.status = nameS;	
	}
	public void setDestination(Destination destinationS){
		this.destination = destinationS;	
	}
	public void setTickets(int ticketsS){
		this.tickets = ticketsS;	
	}
}
		
		
public class Tour {
	public static void main(String[] args){
		System.out.println("\n");
		System.out.println("Primeiro dia de atividades da Vai & Nãovolta Tur");
		System.out.println("Não tivemos clientes, mas atualizamos nossa tabela de preços");
		
		Destination destino1 = new Destination("Jururema",1400);
		Destination destino2 = new Destination("Eppppppadora",900);
		Destination destino3 = new Destination("Absologonego",1100);
		Destination destino4 = new Destination("Emanaubas",5000);
		Destination destino5 = new Destination("Essenervero",300);
		destino1.printDestination();
		destino2.printDestination();
		destino3.printDestination();
		destino4.printDestination();
		destino5.printDestination();
		
		System.out.println("\n");
		System.out.println("SegundoDia dia de atividades da Vai & Nãovolta Tur");
		System.out.println("Não tivemos clientes, mas atualizamos nossa tabela de preços e corrigimos uns erros de digitação");
		System.out.println("\n");
		
		destino2.setPlace("Eppadora");
		destino1.setPrice(1299);
		destino2.setPrice(849);
		destino3.setPrice(999);
		destino4.setPrice(4999);
		destino5.setPrice(299);
		destino1.printDestination();
		destino2.printDestination();
		destino3.printDestination();
		destino4.printDestination();
		destino5.printDestination();
		
		System.out.println("\n");
		System.out.println("Terceiro Dia dia de atividades da Vai & Nãovolta Tur");
		System.out.println("Nosso primeiro cliente!!!😃😃😃😃! Fizemos seu cadastro, mas infelizmente nosso sistema não conta com promoções e ele prefiriu a concorrência, mas ele prometeu voltar...");
		System.out.println("\n");
		
		Customer cliente1 = new Customer(135777,"Jerontodas","jerôpegadô@flogão.net");
		cliente1.printCustomer();
		
		System.out.println("\n");
		System.out.println("Quarto Dia dia de atividades da Vai & Nãovolta Tur");
		System.out.println("E não é que seu Jerô voltou!!! E trouxe a família e como não temos promoção para criança ele deixou seus filhos aqui na agência e foi com a esposa curtir uma praia!!");
		System.out.println("\n");
		
		Travel viagem1 = new Travel(001,cliente1,destino4,2);
		viagem1.printTravel();
		viagem1.updateStatus("PAGO");
		viagem1.printTravel();
		
		System.out.println("\n");
		System.out.println("5º Dia dia de atividades da Vai & Nãovolta Tur");
		System.out.println("hoje tivemos novos clientes e ainda e aproveitamos e mandamos os filhos de seu Jerô na mala deles");
		System.out.println("\n");
		
		Customer cliente2 = new Customer(445777,"Silverlina","silsilmatadora@podcast.tech");
		Travel viagem2 = new Travel(2,cliente2,destino3,5);
		viagem2.updateStatus("PAGO");
		Customer cliente3 = new Customer(667788,"Agcolino","gedogona@gemeiou.co");
		Travel viagem3 = new Travel(3,cliente3,destino2,1);
		viagem3.updateStatus("PAGO");
		viagem2.printTravel();
		viagem3.printTravel();
		
				
	
		
		
	}
			
}																																																																																																																										
