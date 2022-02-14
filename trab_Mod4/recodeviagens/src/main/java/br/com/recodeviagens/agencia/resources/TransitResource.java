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
import br.com.recodeviagens.agencia.models.Transit;
import br.com.recodeviagens.agencia.repositories.TransitRepository;

@RestController
@RequestMapping("/transit")
public class TransitResource {
	
	@Autowired
	private TransitRepository transitRepository;
	
	@PostMapping
	public void save(@RequestBody Transit transit) {
		transitRepository.save(transit);
	}
	
	@GetMapping
	public ResponseEntity<List<Transit>> listing(){
		List<Transit> transits = transitRepository.findAll();
		return ResponseEntity.ok().body(transits);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Transit> listingById(@PathVariable Long id){
		Transit transit = transitRepository.findById(id).get();
		return ResponseEntity.ok().body(transit);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletingById(@PathVariable Long id){
		transitRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Transit> updatingById(@PathVariable Long id,@RequestBody Customer transit){
		Transit transitCurrent = transitRepository.findById(id).get();
		BeanUtils.copyProperties(transit, transitCurrent,"id");
		transitRepository.save(transitCurrent);
		return ResponseEntity.ok().body(transitCurrent);
	}

}
