package br.com.ayrus.resource;

import java.time.LocalDate;

import br.com.ayrus.model.Ordem;
import br.com.ayrus.repository.OrdemRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/ordens")
public class OrdemResource {

	@Inject
	OrdemRepository ordemRepository;

	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public void Add(Ordem ordem) {
		ordem.setData(LocalDate.now());
		ordem.setStatus("ENVIADA");
		ordemRepository.persist(ordem);

	}
}
