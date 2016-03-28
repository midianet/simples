package com.midianet.simples.repository;


import com.midianet.simples.model.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario,Long> {

    List<Usuario> findAll();

    Usuario findOne(final Long id);

    Usuario save(final Usuario usuario);

    void delete(final Usuario usuario);

}