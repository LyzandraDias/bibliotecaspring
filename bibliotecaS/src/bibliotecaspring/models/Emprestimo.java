package bibliotecaspring.models;

import java.util.Calendar;

import bibliotecaspring.daos.AlunoDAO;
import bibliotecaspring.daos.LivroDAO;

public class Emprestimo {
	
	public final static int DIAS_DE_DURACAO = 14;
	public final static int MAXIMO_ALUNO = 3;
	
	private Calendar dataEmp;
	private Calendar dataDev;
	private Livro livro;  //Id do Livro
	private Aluno aluno;	 //Matricula do Aluno
	private boolean status;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Livro getLivro() {
		return this.livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Aluno getAluno() {
//		return this.aluno;
		return this.aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Calendar getDataEmp() {
		return dataEmp;
	}
	public void setDataEmp(Calendar dataEmp) {
		this.dataEmp = dataEmp;
	}
	public Calendar getDataDev() {
		return dataDev;
	}
	public void setDataDev(Calendar dataDev) {
		this.dataDev = dataDev;
	}
}

