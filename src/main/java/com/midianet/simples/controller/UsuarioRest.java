package com.midianet.simples.controller;

import com.midianet.simples.model.Usuario;
import com.midianet.simples.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class UsuarioRest {

    @Autowired
    private UsuarioService service;

    @RequestMapping(value = "/usuario/", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> list() {
        final List<Usuario> list = service.findAll();
        if(list.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);// HttpStatus.NOT_FOUND
        }
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> getUser(@PathVariable("id")final long id) {
        final Usuario u = service.findById(id);
        if (u == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(u, HttpStatus.OK);
    }

    @RequestMapping(value = "/usuario/", method = RequestMethod.POST)
    public ResponseEntity<Void> create (@RequestBody final Usuario user, final UriComponentsBuilder ucBuilder) {
        user.setId(null);
        service.save(user);
        final HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/usuario/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Usuario> update(@PathVariable("id") final long id, @RequestBody final Usuario user) {
        final Usuario current = service.findById(id);
        if (current == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        current.setUsername(user.getUsername());
        current.setAddress(user.getAddress());
        current.setEmail(user.getEmail());
        service.save(current);
        return new ResponseEntity(current, HttpStatus.OK);
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Usuario> delete(@PathVariable("id") final long id) {
        final Usuario current = service.findById(id);
        if (current == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}