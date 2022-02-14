package br.com.recodeviagens.agencia.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
