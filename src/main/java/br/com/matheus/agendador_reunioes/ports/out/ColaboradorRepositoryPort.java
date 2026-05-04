package br.com.matheus.agendador_reunioes.ports.out;

import br.com.matheus.agendador_reunioes.domain.model.Colaborador;

import java.util.List;
import java.util.Optional;

public interface ColaboradorRepositoryPort {
    Colaborador salvar(Colaborador colaborador);
    List<Colaborador> listarTodos();
    Optional<Colaborador> buscarPorId(Long id);
}
