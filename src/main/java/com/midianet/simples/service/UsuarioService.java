package com.midianet.simples.service;

import com.midianet.simples.model.Usuario;
import com.midianet.simples.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> findAll() {
		return repository.findAll();
	}
	
	public Usuario findById(final Long id) {
		return repository.findOne(id);
	}

	@Transactional
	public void save(final Usuario usuario) {
		repository.save(usuario);
	}

	@Transactional
	public void delete(final Long id) {
		final Usuario current = findById(id);
		if(current != null) {
			repository.delete(id);
		}
	}

}