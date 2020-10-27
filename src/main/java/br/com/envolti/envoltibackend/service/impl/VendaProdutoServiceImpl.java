package br.com.envolti.envoltibackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.envolti.envoltibackend.model.Venda;
import br.com.envolti.envoltibackend.model.VendaProduto;
import br.com.envolti.envoltibackend.repository.VendaProdutoRepository;
import br.com.envolti.envoltibackend.service.VendaProdutoService;

@Service
public class VendaProdutoServiceImpl extends AbstractService<VendaProduto, Integer> implements VendaProdutoService {

	private VendaProdutoRepository repository;

	@Autowired
	public VendaProdutoServiceImpl(VendaProdutoRepository repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<VendaProduto, Integer> getRepository() {
		return repository;
	}

	@Override
	public List<VendaProduto> findByVenda(Venda venda) {
		return repository.findByVenda(venda);
	}

}