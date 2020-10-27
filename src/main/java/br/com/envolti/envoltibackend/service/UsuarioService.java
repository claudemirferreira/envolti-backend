package br.com.envolti.envoltibackend.service;

import org.springframework.data.domain.Page;

import br.com.envolti.envoltibackend.dto.FiltroPaginacaoDTO;
import br.com.envolti.envoltibackend.model.Pessoa;
import br.com.envolti.envoltibackend.model.Usuario;

public interface UsuarioService extends BaseService<Usuario, Integer> {

	public Page<Usuario> pesquisa(FiltroPaginacaoDTO dto);

}