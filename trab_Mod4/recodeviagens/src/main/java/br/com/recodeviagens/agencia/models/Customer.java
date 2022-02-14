package br.com.recodeviagens.agencia.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "tbl_customer")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_customer;
	
	private String name;
	
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	private List<Travel> travels = new ArrayList<Travel>();

	public Customer(Long id_customer, String name, String email) {
		super();
		this.id_customer = id_customer;
		this.name = name;
		this.email = email;
	}
	
	public Customer() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId_customer() {
		return id_customer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id_customer, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(email, other.email) && Objects.equals(id_customer, other.id_customer)
				&& Objects.equals(name, other.name);
	}
	
	

}
