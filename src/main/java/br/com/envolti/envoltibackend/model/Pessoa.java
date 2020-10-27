package br.com.envolti.envoltibackend.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pessoa")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) // json config
public class Pessoa extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 7371241296081749393L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pessoa")
	private Integer id;

	@Column(length = 60, nullable = false)
	private String nome;

	@Column(length = 1)
	private String sexo;

	@Column(length = 100)
	private String email;

	@Column(length = 60)
	private String naturalidade;

	@Column(length = 60)
	private String nacionalidade;

	@Column(length = 11, nullable = false, unique = true)
	private String cpf;

	@Column(nullable = false)
	private Date dataCadastro;

	@Column()
	private Date dataAtualizacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Pessoa(Integer id, String nome, String sexo, String email, String naturalidade, String nacionalidade,
			String cpf) {
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
		this.naturalidade = naturalidade;
		this.nacionalidade = nacionalidade;
		this.cpf = cpf;
	}

	public Pessoa() {
	}

}
