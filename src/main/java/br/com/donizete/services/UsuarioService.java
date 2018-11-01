package br.com.donizete.services;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.donizete.dao.UsuarioDao;
import br.com.donizete.entities.Usuario;

@Path("/ws/usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioService {

	private UsuarioDao usuarioDao;

	public UsuarioService() {
		super();
		// TODO Auto-generated constructor stub
		try {
			usuarioDao = new UsuarioDao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@GET
	@Path("/busca/{nome}")
	public Usuario buscaUsuario(@PathParam("nome") String nome) {
		try {
			return usuarioDao.buscaUsuario(nome);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@POST
	@Path("/delete")
	public Boolean deleteUsuario(Usuario usuario) {
		try {
			return usuarioDao.deleteUsuario(usuario.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@POST
	@Path("/inserir")
	public Boolean inserirUsuario(Usuario usuario) {
		try {
			return usuarioDao.inserirUsuario(usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
