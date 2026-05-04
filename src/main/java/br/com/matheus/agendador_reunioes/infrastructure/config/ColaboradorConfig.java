package br.com.matheus.agendador_reunioes.infrastructure.config;

import br.com.matheus.agendador_reunioes.application.usecases.GerenciarColaboradorInteractor;
import br.com.matheus.agendador_reunioes.ports.out.ColaboradorRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ColaboradorConfig {

    @Bean
    public GerenciarColaboradorInteractor gerenciarColaboradorInteractor(ColaboradorRepositoryPort colaboradorRepositoryPort) {
        return new GerenciarColaboradorInteractor(colaboradorRepositoryPort);
    }
}
