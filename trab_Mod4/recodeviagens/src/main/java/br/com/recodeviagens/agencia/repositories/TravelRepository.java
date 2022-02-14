package br.com.recodeviagens.agencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.recodeviagens.agencia.models.Travel;

public interface TravelRepository extends JpaRepository<Travel , Long> {

}
