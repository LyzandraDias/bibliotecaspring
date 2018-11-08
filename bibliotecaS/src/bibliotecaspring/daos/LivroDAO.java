package bibliotecaspring.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import bibliotecaspring.models.Livro;

public class LivroDAO {
	private Connection connection;

	public LivroDAO() {
		connection = ConnectionFactory.getConnection();
	}
	
	public boolean inserir(Livro livro) {

		String sql = "insert into livro (titulo, autor, editora, anoPublicacao, edicao) " + "values (?, ?, ?, ?, ?);";
	
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getAutor());
			stmt.setString(3, livro.getEditora());
			stmt.setDate(4, new java.sql.Date(livro.getPublicacao().getTimeInMillis()));
			stmt.setInt(5, livro.getEdicao());
			

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	public List<Livro> getLista() {
		List<Livro> result = new ArrayList<>();
	
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from livro");
			ResultSet rs = stmt.executeQuery();
	
			while (rs.next()) {
				// criando o objeto livro
				Livro livro = new Livro();
				livro.setId(rs.getLong("id"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setEditora(rs.getString("editora"));
				livro.setEdicao(rs.getInt("edicao"));
	
				// montando a data atrav�s do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("anoPublicacao"));
				livro.setPublicacao(data);
	
				// adicionando o objeto � lista
				result.add(livro);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean alterar(Livro livro) {
		String sql = "insert into Livro (titulo, autor, editora, anoPublica��o, edicao) values (?, ?, ?, ?, ?);";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getAutor());
			stmt.setString(3, livro.getEditora());
			stmt.setDate(4, new java.sql.Date(livro.getPublicacao().getTimeInMillis()));
			stmt.setInt(5, livro.getEdicao());
			stmt.setLong(6, livro.getId());
	
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean remover(Livro livro) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete" + "from livro where id=?");
			stmt.setLong(1, livro.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Livro getLivroById(long id) {
		Livro livro = new Livro();
	
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from livro where id=?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
	
			while (rs.next()) {
				// criando o objeto livro
				livro.setId(rs.getLong("id"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setEditora(rs.getString("editora"));
				livro.setEdicao(rs.getInt("edicao"));
	
				// montando a data atrav�s do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("anoPublicacao"));
				livro.setPublicacao(data);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livro;
	}
}