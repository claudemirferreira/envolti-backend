package br.com.envolti.envoltibackend.service;

import org.springframework.data.domain.Page;

import br.com.envolti.envoltibackend.dto.FiltroPaginacaoDTO;
import br.com.envolti.envoltibackend.model.Produto;

public interface ProdutoService extends BaseService<Produto, Integer> {

	public Page<Produto> pesquisa(FiltroPaginacaoDTO dto);

}
