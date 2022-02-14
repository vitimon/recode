package br.com.recodeviagens.agencia.resources;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import br.com.recodeviagens.agencia.models.Customer;
import br.com.recodeviagens.agencia.repositories.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerResource {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@PostMapping
	public void save(@RequestBody Customer customer) {
		customerRepository.save(customer);
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> listing(){
		List<Customer> clientes = customerRepository.findAll();
		return ResponseEntity.ok().body(clientes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> listingById(@PathVariable Long id){
		Customer customer = customerRepository.findById(id).get();
		return ResponseEntity.ok().body(customer);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletingById(@PathVariable Long id){
		customerRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> updatingById(@PathVariable Long id,@RequestBody Customer customer){
		Customer customerCurrent = customerRepository.findById(id).get();
		BeanUtils.copyProperties(customer, customerCurrent,"id");
		customerRepository.save(customerCurrent);
		return ResponseEntity.ok().body(customerCurrent);
	}

}
