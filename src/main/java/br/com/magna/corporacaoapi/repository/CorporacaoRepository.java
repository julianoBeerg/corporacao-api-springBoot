package br.com.magna.corporacaoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magna.corporacaoapi.entity.Corporacao;

public interface CorporacaoRepository extends JpaRepository<Corporacao, Long> {

}
