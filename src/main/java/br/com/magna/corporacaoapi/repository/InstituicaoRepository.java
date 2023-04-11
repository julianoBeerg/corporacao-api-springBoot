package br.com.magna.corporacaoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magna.corporacaoapi.entity.Instituicao;

public interface InstituicaoRepository extends JpaRepository<Instituicao, Long> {

}
