package com.examples.testing.chat.application.create;

import com.examples.testing.chat.domain.Chat;
import com.examples.testing.chat.domain.ChatId;
import com.examples.testing.grupo.domain.Grupo;
import com.examples.testing.grupo.domain.GrupoId;
import com.examples.testing.grupo.domain.Participante;
import com.examples.testing.usuario.UsuarioId;

import java.util.ArrayList;
import java.util.List;

public class ChatRequest {

        String id;
        String name;
        GrupoDTO grupo;

        public ChatRequest(){}

         static final class GrupoDTO {

            String grupoId;
            String chatId;
            List<ParticipanteDTO> listaParticipantes = new ArrayList<>();

            public GrupoDTO(){}

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

            public List<ParticipanteDTO> getListaParticipantes() {
                return listaParticipantes;
            }

            public void setListaParticipantes(List<ParticipanteDTO> listaParticipantes) {
                this.listaParticipantes = listaParticipantes;
            }

             static final class ParticipanteDTO {

                private String usuarioId;
                private boolean esAdministrador;

                public ParticipanteDTO(){}

                 public ParticipanteDTO(String usuarioId, boolean esAdministrador) {
                     this.usuarioId = usuarioId;
                     this.esAdministrador = esAdministrador;
                 }

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

        public GrupoDTO getGrupo() {
            return grupo;
        }

        public void setGrupo(GrupoDTO grupo) {
            this.grupo = grupo;
        }

        Chat fromChatDTO(){

            ChatId chatId = new ChatId(this.id);

            return new Chat(chatId, getName());
        }

        Grupo fromGrupoDTO(){

            GrupoId grupoId = new GrupoId(getGrupo().getGrupoId());

            List<Participante> lista = new ArrayList<>();

            for(GrupoDTO.ParticipanteDTO participanteDTO : getGrupo().getListaParticipantes()){

                lista.add(new Participante(new UsuarioId(participanteDTO.getUsuarioId()),participanteDTO.esAdministrador));
            }

            return new Grupo(grupoId, new ChatId(this.id), lista);

        }


      public static ChatRequest of(Chat chat , Grupo grupo){

         List<GrupoDTO.ParticipanteDTO> lista = new ArrayList<>();

         for(Participante participante: grupo.getListaParticipantes()){

             lista.add(new GrupoDTO.ParticipanteDTO(participante.getUsuarioId().value(), participante.esAdministrador()));

         }

         GrupoDTO grupoDTO = new GrupoDTO();
         grupoDTO.setChatId(chat.id().value());
         grupoDTO.setGrupoId(grupo.getGrupoId().value());
         grupoDTO.setListaParticipantes(lista);

          ChatRequest request = new ChatRequest();

          request.setId(chat.id().value());
          request.setName(chat.name());

          request.setGrupo(grupoDTO);

          return request;

        }

    }

