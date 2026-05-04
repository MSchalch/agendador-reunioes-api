package br.com.matheus.agendador_reunioes.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataSalaRepository extends JpaRepository<SalaEntity, Long> {
    // O Spring faz os inserts e selects por baixo dos panos aqui
}