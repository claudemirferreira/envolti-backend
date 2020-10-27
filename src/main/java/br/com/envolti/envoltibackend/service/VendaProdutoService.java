package br.com.envolti.envoltibackend.service;

import java.util.List;

import br.com.envolti.envoltibackend.model.Venda;
import br.com.envolti.envoltibackend.model.VendaProduto;

public interface VendaProdutoService extends BaseService<VendaProduto, Integer> {
	
	List<VendaProduto> findByVenda(Venda venda);

}
