package br.com.donizete.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.donizete.config.ConnectionDB;
import br.com.donizete.entities.Usuario;

public class UsuarioDao {

	private Connection con;
	private PreparedStatement ps;

	public UsuarioDao() throws SQLException {
		con = ConnectionDB.getConnection();
	}

	public Usuario buscaUsuario(String nome) throws SQLException {
		String sql = "SELECT * FROM usuario WHERE nome LIKE ?;";

		ps = con.prepareStatement(sql);

		ps.setString(1, nome);

		ResultSet rs = ps.executeQuery();

		Usuario u = null;

		if (rs.next()) {
			u = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("senha"));
		}

		return u;
	}

	public Boolean deleteUsuario(Integer id) throws SQLException {
		String sql = "DELETE FROM usuario WHERE id = ?;";

		ps = con.prepareStatement(sql);

		ps.setInt(1, id);

		return ps.executeUpdate() > 0;
	}

	public Boolean inserirUsuario(Usuario usuario) throws SQLException {
		String sql = "INSERT INTO usuario(nome, senha) VALUES (?, ?);";

		ps = con.prepareStatement(sql);

		ps.setString(1, usuario.getNome());
		ps.setString(2, usuario.getSenha());

		return ps.executeUpdate() > 0;
	}

}
