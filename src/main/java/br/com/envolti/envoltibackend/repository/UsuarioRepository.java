package br.com.envolti.envoltibackend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.envolti.envoltibackend.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query("SELECT u FROM Usuario u WHERE nome like ?1 ")
	Page<Usuario> pesquisa(String nome, Pageable pageable);

}