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
@Table(name = "tbl_transit")
public class Transit implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_transit;
	
	private String destination;
	
	private String origin;
	
	private double price;
	
	@JsonIgnore
	@OneToMany(mappedBy = "transit")
	private List<Travel> travels = new ArrayList<Travel>();

	public Transit(Long id_transit, String destination, String origin, double price) {
		super();
		this.id_transit = id_transit;
		this.destination = destination;
		this.origin = origin;
		this.price = price;
	}
	
	public Transit() {
		super();
	}

	public Long getId_transit() {
		return id_transit;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(destination, id_transit, origin, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transit other = (Transit) obj;
		return Objects.equals(destination, other.destination) && Objects.equals(id_transit, other.id_transit)
				&& Objects.equals(origin, other.origin)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
	
	

}