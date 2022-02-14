package br.com.recodeviagens.agencia.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

}
