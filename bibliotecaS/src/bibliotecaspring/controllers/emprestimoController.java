package bibliotecaspring.controllers;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bibliotecaspring.daos.EmprestimoDAO;
import bibliotecaspring.models.Emprestimo;

@Controller
public class emprestimoController {

	@RequestMapping("/emprestimos/form")
	public String form() {
		System.out.println("chamou meu método");
		return "emprestimo/Form";
	}
	
	@PostMapping("/emprestimos")
	public String adicionar(Emprestimo emprestimo) {
		System.out.println("chamou o método de adicionar");
		System.out.println(emprestimo);
		EmprestimoDAO alunoDAO = new EmprestimoDAO();
		alunoDAO.inserir(emprestimo);
		return "redirect:emprestimos";
	}
	
	@GetMapping("/emprestimos")
	public ModelAndView listar() {
		System.out.println("chamou o metódo listagem");
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		List<Emprestimo> lista = emprestimoDAO.getLista();
		ModelAndView model = new ModelAndView("emprestimo/listarEmprestimo");
		model.addObject("emprestimos", lista);
		return model;
		
	}
	
	@RequestMapping("/emprestimos/remover")
	public String remover(Emprestimo emprestimo) {
		System.out.println("chamou o método remover.");
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		emprestimoDAO.remover(emprestimo);
		
		return "redirect:../emprestimo";
			
	}
}
