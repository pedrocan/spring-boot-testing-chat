package com.examples.testing.grupo.infrastructure.persistence;

import com.examples.testing.grupo.domain.Grupo;
import com.examples.testing.grupo.domain.GrupoId;
import com.examples.testing.grupo.domain.GrupoRepository;
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
