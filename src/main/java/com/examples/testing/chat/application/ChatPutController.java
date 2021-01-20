package com.examples.testing.chat.application;

import com.examples.testing.chat.application.create.ChatCreator;


import com.examples.testing.chat.application.create.ChatRegistrationRequest;
import com.examples.testing.chat.domain.Chat;
import com.examples.testing.chat.domain.ChatId;
import com.examples.testing.grupo.domain.Grupo;
import com.examples.testing.grupo.domain.GrupoId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public final class ChatPutController {

    private final ChatCreator chatCreator;

    @Autowired
    public ChatPutController(ChatCreator chatCreator){
        this.chatCreator = chatCreator;
    }

    @PutMapping(value = "/chats")
    public ResponseEntity<String> createChat(@RequestBody Request request) {

        System.out.println("ID : " + request.getId());
        System.out.println("NAME : " + request.getName());
        System.out.println("Grupo <------> : " );
        System.out.println("GrupoId <------> : " + request.getGrupo().getGrupoId());
        System.out.println("ChatId <------> : " + request.getGrupo().getChatId());
        System.out.println("ListaParticipantes <------> : " + request.getGrupo().getListaParticipantes());

        for(Request.Grupo.Participante participante: request.getGrupo().getListaParticipantes() ){
            System.out.println("UsuarioId <------> : " +  participante.getUsuarioId());
            System.out.println("esAdministrador <------> :" + participante.esAdministrador);
        }

      //  Chat chat = new Chat(new ChatId(request.getId()),request.getName());
      //  Grupo grupo = new Grupo(new GrupoId(request.getGrupo().getGrupoId()),new ChatId(request.getGrupo().getChatId()), request.getGrupo().getListaParticipantes());

      //  chatCreator.createChat(new ChatRegistrationRequest(chat, grupo);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    static final class Request {

        String id;
        String name;
        Grupo grupo;

        static final class Grupo {

            String grupoId;
            String chatId;
            List<Participante> listaParticipantes = new ArrayList<>();

            public String getGrupoId() {
                return grupoId;
            }

            public void setGrupoId(String grupoId) {
                this.grupoId = grupoId;
            }

            public String getChatId() {
                return chatId;
            }

            public void setChatId(String chatId) {
                this.chatId = chatId;
            }

            public List<Participante> getListaParticipantes() {
                return listaParticipantes;
            }

            public void setListaParticipantes(List<Participante> listaParticipantes) {
                this.listaParticipantes = listaParticipantes;
            }

            static final class Participante{

                private String usuarioId;
                private boolean esAdministrador;

                public String getUsuarioId() {
                    return usuarioId;
                }

                public void setUsuarioId(String usuarioId) {
                    this.usuarioId = usuarioId;
                }

                public boolean isEsAdministrador() {
                    return esAdministrador;
                }

                public void setEsAdministrador(boolean esAdministrador) {
                    this.esAdministrador = esAdministrador;
                }
            }
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Grupo getGrupo() {
            return grupo;
        }

        public void setGrupo(Grupo grupo) {
            this.grupo = grupo;
        }
    }

}
