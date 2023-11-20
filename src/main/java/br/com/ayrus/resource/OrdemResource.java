package br.com.ayrus.resource;

import java.util.List;

import br.com.ayrus.model.Ordem;
import br.com.ayrus.service.OrdemService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

@Path("/ordens")
public class OrdemResource {

	@Inject
	OrdemService ordemService;

	@POST
	@Transactional
	@RolesAllowed("user")
	@Consumes(MediaType.APPLICATION_JSON)
	public void Add(@Context SecurityContext securityContext, Ordem ordem) {
		ordemService.Add(securityContext, ordem);
	}
	
	@GET
	@RolesAllowed("admin")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ordem> getAll() {
		return ordemService.getAll();
	}
}
