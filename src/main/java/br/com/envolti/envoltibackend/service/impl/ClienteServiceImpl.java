package br.com.envolti.envoltibackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.envolti.envoltibackend.dto.FiltroPaginacaoDTO;
import br.com.envolti.envoltibackend.model.Cliente;
import br.com.envolti.envoltibackend.repository.ClienteRepository;
import br.com.envolti.envoltibackend.service.ClienteService;

@Service
public class ClienteServiceImpl extends AbstractService<Cliente, Integer> implements ClienteService {

	private ClienteRepository repository;

	@Autowired
	public ClienteServiceImpl(ClienteRepository repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<Cliente, Integer> getRepository() {
		return repository;
	}

	@Override
	public Page<Cliente> pesquisa(FiltroPaginacaoDTO dto) {
		System.out.println(dto.toString());
		Pageable pageable = PageRequest.of(dto.getPage(), dto.getSize(), Sort.by("nome"));
		return repository.pesquisa(dto.getNome() + "%", dto.getId(), pageable);
	}

	@Override
	public List<Cliente> listaClientes() {
		return repository.listaClientes();
	}

}