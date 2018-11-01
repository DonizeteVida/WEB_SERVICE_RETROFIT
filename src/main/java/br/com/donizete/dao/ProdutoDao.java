package br.com.donizete.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.donizete.config.ConnectionDB;
import br.com.donizete.entities.Produto;

public class ProdutoDao {

	private Connection con;
	private PreparedStatement ps;

	public ProdutoDao() throws SQLException {
		con = ConnectionDB.getConnection();
	}

	public List<Produto> buscaProdutos() throws SQLException {
		String sql = "SELECT * FROM produto;";

		ps = con.prepareStatement(sql);

		List<Produto> produtos = new ArrayList<>();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			produtos.add(new Produto(rs.getInt("id"), rs.getString("nome"), rs.getFloat("preco")));
		}

		return produtos;
	}

	public List<Produto> buscaProdutos(Integer id_usuario) throws SQLException {
		String sql = "SELECT t.id, p.nome, p.preco FROM produto AS p " + "INNER JOIN terc AS t ON t.id_produto = p.id "
				+ "WHERE t.id_usuario = ? ORDER BY t.id;";

		ps = con.prepareStatement(sql);

		ps.setInt(1, id_usuario);

		List<Produto> produtos = new ArrayList<>();

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			produtos.add(new Produto(rs.getInt("id"), rs.getString("nome"), rs.getFloat("preco")));
		}

		return produtos;
	}

	public Boolean inserirProdutoUsuario(Integer id_produto, Integer id_usuario) throws SQLException {
		String sql = "INSERT INTO terc(id_usuario, id_produto) VALUES (?,?);";

		ps = con.prepareStatement(sql);

		ps.setInt(1, id_usuario);

		ps.setInt(2, id_produto);

		return ps.executeUpdate() > 0;
	}

	public Boolean deletarProdutos(Integer id) throws SQLException {
		String sql = "DELETE FROM terc WHERE id = ?;";

		ps = con.prepareStatement(sql);

		ps.setInt(1, id);

		return ps.executeUpdate() > 0;
	}

}
