package br.com.envolti.envoltibackend.service;

import org.springframework.data.domain.Page;

import br.com.envolti.envoltibackend.dto.FiltroPaginacaoDTO;
import br.com.envolti.envoltibackend.model.Venda;

public interface VendaService extends BaseService<Venda, Integer> {

	public Page<Venda> pesquisa(FiltroPaginacaoDTO dto);
	
	public Venda getByIdPg(Integer id);

}
