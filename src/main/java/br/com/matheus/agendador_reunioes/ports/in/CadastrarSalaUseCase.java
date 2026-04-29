package br.com.matheus.agendador_reunioes.ports.in;

import br.com.matheus.agendador_reunioes.domain.model.Sala;

public interface CadastrarSalaUseCase {
    Sala executar(Sala sala);
}
