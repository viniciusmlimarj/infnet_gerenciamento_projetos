package br.com.vinicius.infnet.trabalho.model.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Projeto")
public class Projeto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private boolean iniciado;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dataInicio;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dataFim;
	private Integer quantidadeHoras;
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario gerente;
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "idProjeto")
	private List<Tarefa> tarefas;
	@ManyToMany(cascade = CascadeType.DETACH)
	private List<Usuario> recursos;
	
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
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public LocalDate getDataFim() {
		return dataFim;
	}
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
	public Integer getQuantidadeHoras() {
		return quantidadeHoras;
	}
	public void setQuantidadeHoras(Integer quantidadeHoras) {
		this.quantidadeHoras = quantidadeHoras;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Usuario getGerente() {
		return gerente;
	}
	public void setGerente(Usuario gerente) {
		this.gerente = gerente;
	}
	public boolean isIniciado() {
		return iniciado;
	}
	public void setIniciado(boolean iniciado) {
		this.iniciado = iniciado;
	}
	public List<Tarefa> getTarefas() {
		return tarefas;
	}
	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
	public List<Usuario> getRecursos() {
		return recursos;
	}
	public void setRecursos(List<Usuario> recursos) {
		this.recursos = recursos;
	}
}