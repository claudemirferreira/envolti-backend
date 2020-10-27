package br.com.envolti.envoltibackend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.envolti.envoltibackend.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

	@Query("SELECT u FROM Pessoa u WHERE nome like ?1 ")
	Page<Pessoa> pesquisa(String nome, Pageable pageable);	
	
	Pessoa findByCpf(String cpf);

}