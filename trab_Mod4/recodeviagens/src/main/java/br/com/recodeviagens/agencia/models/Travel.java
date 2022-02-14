package br.com.recodeviagens.agencia.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;

import br.com.recodeviagens.agencia.repositories.CustomerRepository;
import br.com.recodeviagens.agencia.repositories.TransitRepository;


@Entity
@Table(name = "tbl_travel")
public class Travel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_travel;
	
	private int tickets;
	
	private String status;
	
	private Date date;
	
	private String promoCode;

	@ManyToOne
	@JoinColumn(name = "id_transit")
	private Transit transit;
	
	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@Transient
	@Autowired
	private static TransitRepository transitRepository;
	
	@Transient
	@Autowired
	private static CustomerRepository customerRepository;
	
	
	public Travel(int tickets, String status, Date date, String promoCode, Long id_transit, Long id_customer) {
		super();
		
		this.tickets = tickets;
		this.status = status;
		this.date = date;
		this.promoCode = promoCode;
		this.transit = transitRepository.findById(id_transit).get();
		this.customer = customerRepository.findById(id_customer).get();
		System.out.println("construtor detalhado");
	}
	
	public Travel() {
		super();
		System.out.println("construtor generico");
	}

	public int getTickets() {
		return tickets;
	}

	public void setTickets(int tickets) {
		this.tickets = tickets;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		System.out.println("set date");
		this.date = date;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public Long getId_travel() {
		return id_travel;
	}
	
	

	public Transit getTransit() {
		return transit;
	}

	public void setTransit(Long id_transit) {
		System.out.println("set transit");
		this.transit = transitRepository.findById(id_transit).get();
		
		
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Long id_customer) {
		System.out.println("set customer");
		this.customer = customerRepository.findById(id_customer).get();
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, id_travel, promoCode, status, tickets);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Travel other = (Travel) obj;
		return Objects.equals(date, other.date) && Objects.equals(id_travel, other.id_travel)
				&& Objects.equals(promoCode, other.promoCode) && Objects.equals(status, other.status)
				&& tickets == other.tickets;
	}
	
	
	

}
