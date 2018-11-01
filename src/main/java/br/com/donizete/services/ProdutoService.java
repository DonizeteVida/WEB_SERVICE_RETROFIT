package br.com.donizete.services;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.donizete.dao.ProdutoDao;
import br.com.donizete.entities.Produto;

@Path("/ws/produto")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoService {

	private ProdutoDao produtoDao;

	public ProdutoService() {
		try {
			produtoDao = new ProdutoDao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@GET
	@Path("/busca")
	public List<Produto> buscaProdutos() {
		try {
			return produtoDao.buscaProdutos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@GET
	@Path("/busca/{id}")
	public List<Produto> buscaProdutosUsuario(@PathParam("id") Integer id_usuario) {
		try {
			return produtoDao.buscaProdutos(id_usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@GET
	@Path("/inserir/{id_usuario}/{id_produto}")
	public Boolean inserirProdutosUsuario(@PathParam("id_usuario") Integer id_usuario,
			@PathParam("id_produto") Integer id_produto) {
		try {
			return produtoDao.inserirProdutoUsuario(id_produto, id_usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@GET
	@Path("/delete/{id}")
	public Boolean deleteProduto(@PathParam("id") Integer id) {
		try {
			return produtoDao.deletarProdutos(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
