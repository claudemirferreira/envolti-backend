package br.com.envolti.envoltibackend.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.envolti.envoltibackend.dto.FiltroPaginacaoDTO;
import br.com.envolti.envoltibackend.model.Pessoa;
import br.com.envolti.envoltibackend.repository.PessoaRepository;
import br.com.envolti.envoltibackend.service.PessoaService;

@Service
public class PessoaServiceImpl extends AbstractService<Pessoa, Integer> implements PessoaService {

	private PessoaRepository repository;

	@Autowired
	public PessoaServiceImpl(PessoaRepository repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<Pessoa, Integer> getRepository() {
		return repository;
	}

	@Override
	public Page<Pessoa> pesquisa(FiltroPaginacaoDTO dto) {
		System.out.println(dto.toString());
		Pageable pageable = PageRequest.of(dto.getPage(), dto.getSize(), Sort.by("nome"));
		return repository.pesquisa(dto.getNome() + "%", pageable);
	}

	public Pessoa salvar(Pessoa entity) {
		if (entity.getId() == null || entity.getId() == 0)
			entity.setDataCadastro(new Date());
		else
			entity.setDataAtualizacao(new Date());

		return repository.save(entity);
	}

	@Override
	public Pessoa findByCpf(String cpf) {
		return repository.findByCpf(cpf);
	}

}