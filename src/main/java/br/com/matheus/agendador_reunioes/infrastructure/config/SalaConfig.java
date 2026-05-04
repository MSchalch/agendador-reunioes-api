package br.com.matheus.agendador_reunioes.infrastructure.config;

import br.com.matheus.agendador_reunioes.application.usecases.GerenciarSalaInteractor;
import br.com.matheus.agendador_reunioes.ports.out.SalaRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalaConfig {

    @Bean
    public GerenciarSalaInteractor gerenciarSalaInteractor(SalaRepositoryPort salaRepositoryPort) {
        // O Spring injeta o SalaRepositoryAdapter automaticamente aqui
        return new GerenciarSalaInteractor(salaRepositoryPort);
    }
}