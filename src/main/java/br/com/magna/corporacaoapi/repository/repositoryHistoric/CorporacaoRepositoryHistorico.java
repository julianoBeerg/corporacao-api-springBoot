package br.com.magna.corporacaoapi.repository.repositoryHistoric;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magna.corporacaoapi.entity.Corporacao;
import br.com.magna.corporacaoapi.entity.entityHistoric.CorporacaoHistorico;

public interface CorporacaoRepositoryHistorico extends JpaRepository<CorporacaoHistorico, Long> {
	 
	Page<Corporacao> findAllByCnpjAtivoTrue(Pageable paginacao);
	
}
