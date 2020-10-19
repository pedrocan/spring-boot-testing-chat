package com.examples.testing.participante;

import com.examples.testing.usuario.UsuarioId;
import java.util.Map;

public class ListaParticipantes {

    private Map<UsuarioId,Participante> listaParticipantes;

    public ListaParticipantes(Map<UsuarioId,Participante> listaParticipantes) {

        this.listaParticipantes = listaParticipantes;

    }

    public void anhadirParticipante(UsuarioId usuarioId, Participante participante) {
        if(listaParticipantes != null) {
            listaParticipantes.put(usuarioId,participante);
        }
    }

    public void eliminarParticipante(UsuarioId usuarioId){
        if(listaParticipantes != null) {
            listaParticipantes.remove(usuarioId);
        }
    }

    public void establecerAdministrador(UsuarioId usuarioId, boolean esAdmin){
        if(listaParticipantes != null) {
            listaParticipantes.get(usuarioId).marcarAdmistrador(esAdmin);
        }
    }
}
