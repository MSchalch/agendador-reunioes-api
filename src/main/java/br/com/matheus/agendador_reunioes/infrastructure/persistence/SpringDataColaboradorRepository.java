package br.com.matheus.agendador_reunioes.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataColaboradorRepository extends JpaRepository<ColaboradorEntity, Long> {
    // Caso precise de buscas customizadas (ex: findByEmail), elas entrariam aqui no futuro
}
