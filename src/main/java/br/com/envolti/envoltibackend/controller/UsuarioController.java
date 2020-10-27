package br.com.envolti.envoltibackend.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.envolti.envoltibackend.dto.FiltroPaginacaoDTO;
import br.com.envolti.envoltibackend.dto.UsuarioDTO;
import br.com.envolti.envoltibackend.model.Usuario;
import br.com.envolti.envoltibackend.service.BaseService;
import br.com.envolti.envoltibackend.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/envolti-backend/usuario/")
@CrossOrigin(origins = "*")
@Api(value = "API rest usuario")
public class UsuarioController extends AbstractController<Usuario, Integer, UsuarioDTO> {

	@Autowired
	private UsuarioService service;

	@Override
	protected BaseService<Usuario, Integer> getService() {
		return service;
	}

	@Override
	protected Class<UsuarioDTO> getDtoClass() {
		return UsuarioDTO.class;
	}

	@Override
	protected Class<Usuario> getEntityClass() {
		return Usuario.class;
	}

	@RequestMapping(value = "pesquisar", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	@ApiOperation(value = "retorna a lista de pessoas")
	public Page<Usuario> pesquisar(HttpServletResponse resp, @RequestBody FiltroPaginacaoDTO dto) {
		try {
			return service.pesquisa(dto);
		} catch (Exception e) {
			System.out.println("ocorreu um erro ");
		}
		return null;
	}

}
