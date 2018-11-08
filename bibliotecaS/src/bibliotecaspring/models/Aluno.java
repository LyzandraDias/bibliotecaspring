package bibliotecaspring.models;

import java.util.Calendar;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import bibliotecaspring.daos.EmprestimoDAO;

public class Aluno {
	
private Long id;
	
	private String matricula;
	private String nome;
	private String cpf;
	private String endereco;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataNascimento;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public List<Emprestimo> getEmprestimos(){
		return new EmprestimoDAO().getListaByAluno(this);
	}
	public boolean isStatus(){
		for(Emprestimo emp : this.getEmprestimos()){
			if(!emp.isStatus()){
				return emp.isStatus();
			}
		}
		return true;
	}
}


