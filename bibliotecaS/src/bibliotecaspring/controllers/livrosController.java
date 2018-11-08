package bibliotecaspring.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bibliotecaspring.daos.LivroDAO;
import bibliotecaspring.models.Livro;

@Controller
public class livrosController {

	@RequestMapping("/livros/form")
	public String form() {
		System.out.println("chamou meu método");
		return "livro/Form";
	}
	
	@PostMapping("/livros")
	public String adicionar(Livro livro) {
		System.out.println("chamou o método de adicionar");
		System.out.println(livro);
		LivroDAO livroDAO = new LivroDAO();
		livroDAO.inserir(livro);
		return "redirect:livros";
	}
	
	@GetMapping("/livros")
	public ModelAndView listar() {
		System.out.println("chamou o metódo listagem");
		LivroDAO livroDAO = new LivroDAO();
		List<Livro> lista = livroDAO.getLista();
		ModelAndView model = new ModelAndView("livro/listarLivros");
		model.addObject("livros", lista);
		return model;
		
	}
	
	@RequestMapping("/livros/remover")
	public String remover(Livro livro) {
		System.out.println("chamou o método remover.");
		LivroDAO livroDAO = new LivroDAO();
		livroDAO.remover(livro);
		
		return "redirect:../livro";
			
	}
}

