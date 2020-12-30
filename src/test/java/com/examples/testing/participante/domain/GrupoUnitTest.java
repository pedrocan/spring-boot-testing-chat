package com.examples.testing.participante.domain;

import com.examples.testing.chat.domain.ChatId;
import com.examples.testing.participante.Grupo;
import com.examples.testing.participante.GrupoId;
import com.examples.testing.participante.Participante;
import com.examples.testing.usuario.UsuarioId;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class GrupoUnitTest {

    @Test
    void itShouldChatIdNull() {

        IllegalArgumentException exception =  assertThrows(IllegalArgumentException.class, () -> {
           // ChatId chatId = new ChatId(UUID.randomUUID().toString());
            GrupoId grupoId = new GrupoId(UUID.randomUUID().toString());
            List<Participante> lista = new ArrayList<>();
            Grupo grupo = new Grupo(grupoId,null, lista );

        });

        assertEquals("Invalid ChatId", exception.getMessage());
    }

    @Test
    void itShouldInvalidListaNull() {

        IllegalArgumentException exception =  assertThrows(IllegalArgumentException.class, () -> {

            ChatId chatId = new ChatId(UUID.randomUUID().toString());
            GrupoId grupoId = new GrupoId(UUID.randomUUID().toString());
            Grupo grupo = new Grupo(grupoId,chatId, null );

        });

        assertEquals("Invalid null/size listaParticipantes", exception.getMessage());
    }

    @Test
    void itShouldInvalidSize() {

        IllegalArgumentException exception =  assertThrows(IllegalArgumentException.class, () -> {
            ChatId chatId = new ChatId(UUID.randomUUID().toString());
            GrupoId grupoId = new GrupoId(UUID.randomUUID().toString());
            UsuarioId usuarioId= new UsuarioId(UUID.randomUUID().toString());

            Participante participante = new Participante(usuarioId, Boolean.FALSE);

            List<Participante> lista = new ArrayList<>();
            lista.add(participante);

            Grupo grupo = new Grupo(grupoId, chatId, lista );

        });

        assertEquals("Invalid null/size listaParticipantes", exception.getMessage());
    }

    @Test
    void itShouldWithoutAdmin() {

        IllegalArgumentException exception =  assertThrows(IllegalArgumentException.class, () -> {
            ChatId chatId = new ChatId(UUID.randomUUID().toString());
            GrupoId grupoId = new GrupoId(UUID.randomUUID().toString());
            UsuarioId usuarioId= new UsuarioId(UUID.randomUUID().toString());
            UsuarioId usuarioId2= new UsuarioId(UUID.randomUUID().toString());
            Participante participante = new Participante(usuarioId, Boolean.FALSE);
            Participante participante2 = new Participante(usuarioId2, Boolean.FALSE);

            List<Participante> lista = new ArrayList<>();
            lista.add(participante);
            lista.add(participante2);

            Grupo grupo = new Grupo(grupoId, chatId, lista );

        });

        assertEquals("Invalid listaParticipanes without admin", exception.getMessage());
    }
}