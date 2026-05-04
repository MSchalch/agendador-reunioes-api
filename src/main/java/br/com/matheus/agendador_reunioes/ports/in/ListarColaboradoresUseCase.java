package br.com.matheus.agendador_reunioes.ports.in;

import br.com.matheus.agendador_reunioes.domain.model.Colaborador;

import java.util.List;

public interface ListarColaboradoresUseCase {
    List<Colaborador> executar();
}
