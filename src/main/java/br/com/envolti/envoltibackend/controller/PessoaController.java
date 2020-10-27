package br.com.envolti.envoltibackend.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.envolti.envoltibackend.dto.FiltroPaginacaoDTO;
import br.com.envolti.envoltibackend.dto.PessoaDTO;
import br.com.envolti.envoltibackend.model.Pessoa;
import br.com.envolti.envoltibackend.response.Response;
import br.com.envolti.envoltibackend.service.BaseService;
import br.com.envolti.envoltibackend.service.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/envolti-backend/pessoa/")
@CrossOrigin(origins = "*")
@Api(value = "API rest pessoa")
public class PessoaController extends AbstractController<Pessoa, Integer, PessoaDTO> {

	@Autowired
	private PessoaService service;

	@Override
	protected BaseService<Pessoa, Integer> getService() {
		return service;
	}

	@Override
	protected Class<PessoaDTO> getDtoClass() {
		return PessoaDTO.class;
	}

	@Override
	protected Class<Pessoa> getEntityClass() {
		return Pessoa.class;
	}

	@RequestMapping(value = "", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<PessoaDTO>> save(HttpServletResponse resp, @Valid @RequestBody PessoaDTO obj) {

		Response<PessoaDTO> response = new Response<PessoaDTO>();
		try {
			
			PessoaDTO dto = toDto(service.salvar(toEntity(obj)));
			response.setContent(dto);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(response);
		}
	}

	@RequestMapping(value = "pesquisar", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	@ApiOperation(value = "retorna a lista de pessoas")
	public Page<Pessoa> pesquisar(HttpServletResponse resp, @RequestBody FiltroPaginacaoDTO dto) {
		try {
			return service.pesquisa(dto);
		} catch (Exception e) {
			System.out.println("ocorreu um erro ");
		}
		return null;
	}

}
