package com.examples.testing.participante;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ParticipanteRepository extends CrudRepository<ListaParticipantes, UUID> {


}
