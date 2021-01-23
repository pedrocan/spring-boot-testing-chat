package com.examples.testing.chat.application.create.request;

public class ParticipanteDTO {

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
