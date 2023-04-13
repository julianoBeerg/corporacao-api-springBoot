package br.com.magna.corporacaoapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magna.corporacaoapi.entity.Corporacao;

public interface CorporacaoRepository extends JpaRepository<Corporacao, Long> {
	 
	Page<Corporacao> findAllByCnpjAtivoTrue(Pageable paginacao);
	
//	@Query("SELECT c FROM Corporacao c"
//			+ "WHERE "
//			+ "lower(c.razaoSocial) LIKE %:razaoSocial%")
//	Page<Corporacao> acharMusicaPelaRazaoSocial(Pageable paginacao, String razaoSocial);
}
