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

import br.com.recodeviagens.agencia.models.Travel;
import br.com.recodeviagens.agencia.repositories.TravelRepository;

@RestController
@RequestMapping("/travel")
public class TravelResource {

	
	@Autowired
	private TravelRepository travelRepository;
	
	@PostMapping
	public void save(@RequestBody Travel travel) {
		travelRepository.save(travel);
	}
	
	@GetMapping
	public ResponseEntity<List<Travel>> listing(){
		List<Travel> travels = travelRepository.findAll();
		return ResponseEntity.ok().body(travels);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Travel> listingById(@PathVariable Long id){
		Travel travel = travelRepository.findById(id).get();
		return ResponseEntity.ok().body(travel);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletingById(@PathVariable Long id){
		travelRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Travel> updatingById(@PathVariable Long id,@RequestBody Travel travel){
		Travel travelCurrent = travelRepository.findById(id).get();
		BeanUtils.copyProperties(travel, travelCurrent,"id");
		travelRepository.save(travelCurrent);
		return ResponseEntity.ok().body(travelCurrent);
	}


}
