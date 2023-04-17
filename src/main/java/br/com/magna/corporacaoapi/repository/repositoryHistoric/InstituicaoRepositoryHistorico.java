package br.com.magna.corporacaoapi.repository.repositoryHistoric;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magna.corporacaoapi.entity.entityHistoric.InstituicaoHistorico;

public interface InstituicaoRepositoryHistorico extends JpaRepository<InstituicaoHistorico, Long> {

}
