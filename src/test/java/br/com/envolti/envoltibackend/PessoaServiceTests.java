package br.com.envolti.envoltibackend;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.envolti.envoltibackend.model.Pessoa;
import br.com.envolti.envoltibackend.service.PessoaService;

@SpringBootTest
class PessoaServiceTests {

	@Autowired
	PessoaService service;

	@Test
	void incluirPessoa() {
		Pessoa p = new Pessoa(null, "Claudemir", "M", "claudemir@g,ail.com", "Manaus", "Brasileiro", "12345678901");
		assertNotNull(service.salvar(p));
	}

	@Test
	void incluirPessoaComCpfExistente() {
		Pessoa p = new Pessoa(null, "Claudemir", "M", "claudemir@g,ail.com", "Manaus", "Brasileiro", "12345678901");
		assertNotNull(service.findByCpf(p.getCpf()));

	}

}
