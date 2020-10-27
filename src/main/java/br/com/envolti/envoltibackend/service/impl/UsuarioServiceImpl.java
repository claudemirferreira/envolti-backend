package br.com.envolti.envoltibackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.envolti.envoltibackend.dto.FiltroPaginacaoDTO;
import br.com.envolti.envoltibackend.model.Pessoa;
import br.com.envolti.envoltibackend.model.Usuario;
import br.com.envolti.envoltibackend.repository.UsuarioRepository;
import br.com.envolti.envoltibackend.service.UsuarioService;

@Service
public class UsuarioServiceImpl extends AbstractService<Usuario, Integer> implements UsuarioService {

	private UsuarioRepository repository;

	@Autowired
	public UsuarioServiceImpl(UsuarioRepository repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<Usuario, Integer> getRepository() {
		return repository;
	}

	@Override
	public Page<Usuario> pesquisa(FiltroPaginacaoDTO dto) {
		System.out.println(dto.toString());
		Pageable pageable = PageRequest.of(dto.getPage(), dto.getSize(), Sort.by("nome"));
		return repository.pesquisa(dto.getNome() + "%", pageable);
	}

}