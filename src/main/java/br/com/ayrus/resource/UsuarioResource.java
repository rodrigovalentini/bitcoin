package br.com.ayrus.resource;

import java.util.List;

import br.com.ayrus.model.Usuario;
import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/usuarios")
public class UsuarioResource {
	
	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public void Add(Usuario usuario) {
		Usuario.add(usuario);
	}
	
	@GET
	@RolesAllowed("admin")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> gettAll() {
		return Usuario.listAll();
	}

}
