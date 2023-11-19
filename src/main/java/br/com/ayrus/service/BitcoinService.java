package br.com.ayrus.service;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import br.com.ayrus.model.Bitcoin;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/bitcoins")
@RegisterRestClient(configKey = "bitcoin-api")
public interface BitcoinService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bitcoin> listAll();
}
