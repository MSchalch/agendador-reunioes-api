package br.com.matheus.agendador_reunioes.ports.in;

import br.com.matheus.agendador_reunioes.domain.model.Sala;

import java.util.List;

public interface ListarSalasUseCase {
    List<Sala> executar();
}