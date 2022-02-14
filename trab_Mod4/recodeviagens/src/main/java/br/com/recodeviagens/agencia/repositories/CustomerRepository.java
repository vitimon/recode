package br.com.recodeviagens.agencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.recodeviagens.agencia.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer , Long> {
	
	
	

}
