package br.com.envolti.envoltibackend.service;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.envolti.envoltibackend.dto.FiltroPaginacaoDTO;
import br.com.envolti.envoltibackend.model.Cliente;

public interface ClienteService extends BaseService<Cliente, Integer> {

	public Page<Cliente> pesquisa(FiltroPaginacaoDTO dto);
	
	List<Cliente> listaClientes();

}
