package com.midianet.simples.controller;

import com.midianet.simples.model.Usuario;
import com.midianet.simples.rep.UsuarioDTO;
import com.midianet.simples.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRest {

    @Autowired
    private UsuarioService service;

    private static Usuario toEntity(final UsuarioDTO dto) {
        final Usuario entity = new Usuario();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setLogin(dto.getLogin());
        entity.setSenha(dto.getSenha());
        entity.setEmail(dto.getEmail());
        entity.setAtivo(dto.isAtivo());
        return entity;
    }

    private static UsuarioDTO toDTO(final Usuario entity) {
        final UsuarioDTO dto = new UsuarioDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setLogin(entity.getLogin());
        dto.setSenha(entity.getSenha());
        dto.setEmail(entity.getEmail());
        dto.setAtivo(entity.isAtivo());
        return dto;
    }

    private static List<Usuario> toEntity(final List<UsuarioDTO> listDTO) {
        final List<Usuario> listEntity = new ArrayList();
        if (listDTO != null) {
            listDTO.forEach(dto -> listEntity.add(toEntity(dto)));
        }
        return listEntity;
    }

    private static List<UsuarioDTO> toDTO(final List<Usuario> listEntity) {
        final List<UsuarioDTO> listDTO = new ArrayList();
        if (listEntity != null) {
            listEntity.forEach(entity -> listDTO.add(toDTO(entity)));
        }
        return listDTO;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<UsuarioDTO>> list() {
        final List<Usuario> list = service.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);// HttpStatus.NOT_FOUND
        } else {
            return new ResponseEntity(toDTO(list), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioDTO> getUser(@PathVariable("id") final long id) {
        final Usuario u = service.findById(id);
        if (u == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(toDTO(u), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@Validated @RequestBody final UsuarioDTO usuario, final UriComponentsBuilder ucBuilder) {
        usuario.setId(null);
        //throw new NegocioException("Falho a validação");
        service.save(toEntity(usuario));
        final HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(usuario.getId()).toUri());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UsuarioDTO> update(@PathVariable("id") final long id, @RequestBody final UsuarioDTO usuario) {
        final Usuario current = service.findById(id);
        if (current == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        current.setLogin(usuario.getLogin());
        current.setNome(usuario.getNome());
        current.setEmail(usuario.getEmail());
        current.setSenha(usuario.getSenha());
        current.setAtivo(usuario.isAtivo());
        service.save(current);
        return new ResponseEntity(toDTO(current), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UsuarioDTO> delete(@PathVariable("id") final long id) {
        final Usuario current = service.findById(id);
        if (current == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}