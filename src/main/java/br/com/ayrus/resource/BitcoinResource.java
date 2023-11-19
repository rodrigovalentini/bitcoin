package br.com.ayrus.resource;
import java.util.List;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import br.com.ayrus.model.Bitcoin;
import br.com.ayrus.service.BitcoinService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/bitcoins")
public class BitcoinResource {
	@Inject
	@RestClient
	BitcoinService bitcoinService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bitcoin> listar() {
		return bitcoinService.listAll();
	}
}
