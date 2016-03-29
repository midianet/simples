package com.midianet.simples.mapper;

import com.midianet.simples.rep.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioMapper {

    public static com.midianet.simples.model.Usuario toEntity(final Usuario dto){
        final com.midianet.simples.model.Usuario entity = new com.midianet.simples.model.Usuario();
        entity.setId   (dto.getId());
        entity.setNome (dto.getNome());
        //entity.setLogin(dto.getLogin());
        //entity.setSenha(dto.getSenha());
        entity.setEmail(dto.getEmail());
        //entity.setAtivo(dto.isAtivo());
        return entity;
    }

    public static Usuario toDTO(final com.midianet.simples.model.Usuario entity ){
        final Usuario dto = new Usuario();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        //dto.setLogin(entity.getLogin());
        //dto.setSenha(entity.getSenha());
        //dto.setEmail(entity.getEmail());
        //dto.setAtivo(entity.isAtivo());
        return dto;
    }

    public static List<com.midianet.simples.model.Usuario> toEntity(final List<Usuario> listDTO){
        final List<com.midianet.simples.model.Usuario> listEntity = new ArrayList();
        if(listDTO != null) {
            listDTO.forEach(dto -> listEntity.add(toEntity(dto)));
        }
        return listEntity;
    }

    public static List<Usuario> toDTO(final List<com.midianet.simples.model.Usuario> listEntity){
        final List<Usuario> listDTO = new ArrayList();
        if(listEntity != null){
            listEntity.forEach(entity -> listDTO.add(toDTO(entity));
        }
        return listDTO;
    }

}
