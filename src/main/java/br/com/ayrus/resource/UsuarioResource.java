package br.com.ayrus.resource;

import br.com.ayrus.model.Usuario;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/usuarios")
public class UsuarioResource {
	
	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public void Add(Usuario usuario) {
		Usuario.persist(usuario);
	}

}
