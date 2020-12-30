package com.examples.testing.participante.infrastructure.persistence;

import com.examples.testing.participante.Grupo;
import com.examples.testing.participante.GrupoId;
import com.examples.testing.participante.GrupoRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public final class InMemoryGrupoRepository implements GrupoRepository {

    private final Map<GrupoId, Grupo> grupos = new HashMap<>();

    @Override
    public GrupoId save(Grupo grupo) {

        grupos.put(grupo.getGrupoId(), grupo);
        return grupo.getGrupoId();
    }
}
