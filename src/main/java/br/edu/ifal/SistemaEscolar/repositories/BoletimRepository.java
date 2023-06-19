package br.edu.ifal.SistemaEscolar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifal.SistemaEscolar.model.Boletim;

public interface BoletimRepository extends JpaRepository<Boletim, Integer>{

}
