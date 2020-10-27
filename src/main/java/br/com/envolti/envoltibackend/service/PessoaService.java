package br.com.envolti.envoltibackend.service;

import org.springframework.data.domain.Page;

import br.com.envolti.envoltibackend.dto.FiltroPaginacaoDTO;
import br.com.envolti.envoltibackend.model.Pessoa;

public interface PessoaService extends BaseService<Pessoa, Integer> {

	Page<Pessoa> pesquisa(FiltroPaginacaoDTO dto);
	Pessoa salvar(Pessoa entity);
	Pessoa findByCpf(String cpf);

}
