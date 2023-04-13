package br.com.magna.corporacaoapi.repository.repositoryHistoric;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magna.corporacaoapi.entity.entityHistoric.InstituicaoHistoric;

public interface InstituicaoRepositoryHistoric extends JpaRepository<InstituicaoHistoric, Long> {

}
