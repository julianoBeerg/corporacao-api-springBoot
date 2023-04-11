package br.com.magna.corporacaoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magna.corporacaoapi.entity.Sede;

public interface SedeRepository extends JpaRepository<Sede, Long> {

}
