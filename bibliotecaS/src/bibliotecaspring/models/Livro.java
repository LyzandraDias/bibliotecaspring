package bibliotecaspring.models;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

import bibliotecaspring.daos.EmprestimoDAO;

public class Livro {
	
	private Long id;
	private String titulo;
	private String autor;
	private String editora;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar publicacao;
	private int edicao;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public Calendar getPublicacao() {
		return publicacao;
	}
	public void setPublicacao(Calendar dataPub) {
		this.publicacao = dataPub;
	}
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isDisponivel(){
		
		try {
			if(new EmprestimoDAO().getListaByLivro(this).isEmpty() || new EmprestimoDAO().getListaByLivro(this).size() == 0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			return true;
		}
	}
}


