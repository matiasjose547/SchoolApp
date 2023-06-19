package br.edu.ifal.SistemaEscolarweb.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifal.SistemaEscolarweb.modelo.Boletim;

public interface BoletimRepository extends JpaRepository<Boletim, Integer>{

}
