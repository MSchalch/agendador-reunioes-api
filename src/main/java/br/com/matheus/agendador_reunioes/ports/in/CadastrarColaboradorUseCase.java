package br.com.matheus.agendador_reunioes.ports.in;

import br.com.matheus.agendador_reunioes.domain.model.Colaborador;

public interface CadastrarColaboradorUseCase {
    Colaborador executar(Colaborador colaborador);
}
