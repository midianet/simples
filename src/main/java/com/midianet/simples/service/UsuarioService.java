package com.midianet.simples.service;

import com.midianet.simples.model.Usuario;
import com.midianet.simples.repository.UsuarioRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UsuarioService {

	private Logger log = Logger.getLogger(UsuarioService.class);

	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> findAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}

	public Usuario findById(final long id) {
		try {
			return repository.findOne(id);
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}

	@Transactional
	public void save(final Usuario usuario) {
		try {
			repository.save(usuario);
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}

	@Transactional
	public void delete(final long id) {
		final Usuario current = findById(id);
		if(current != null) {
			repository.delete(id);
		}
	}

}