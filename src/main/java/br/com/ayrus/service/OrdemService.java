package br.com.ayrus.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import br.com.ayrus.model.Ordem;
import br.com.ayrus.model.Usuario;
import br.com.ayrus.repository.OrdemRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.SecurityContext;

@ApplicationScoped
public class OrdemService {

	@Inject
	OrdemRepository ordemRepository;
	public void Add(SecurityContext securityContext, Ordem ordem) {
		Optional<Usuario> usuarioOptional = Usuario
				.findByIdOptional(ordem.getUserId());
		Usuario usuario = usuarioOptional.orElseThrow();

		if (!usuario.getUsername()
				.equals(securityContext.getUserPrincipal().getName())) {
			throw new RuntimeException(
					"Usuário logado diferente do usuário do cadastro.");
		}
		ordem.setData(LocalDate.now());
		ordem.setStatus("ENVIADA");
		ordemRepository.persist(ordem);
	}
	
	public List<Ordem> getAll() {
		return ordemRepository.listAll();
	}

}
