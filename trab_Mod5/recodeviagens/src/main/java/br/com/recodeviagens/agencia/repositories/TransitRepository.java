package br.com.recodeviagens.agencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.recodeviagens.agencia.models.Transit;

public interface TransitRepository extends JpaRepository<Transit , Long> {

}
