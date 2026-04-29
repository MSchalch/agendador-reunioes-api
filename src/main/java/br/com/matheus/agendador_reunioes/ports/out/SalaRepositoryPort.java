package br.com.matheus.agendador_reunioes.ports.out;

import br.com.matheus.agendador_reunioes.domain.model.Sala;

import java.util.List;
import java.util.Optional;

public interface SalaRepositoryPort {
    Sala salvar(Sala sala);
    List<Sala> listarTodas();
    Optional<Sala> buscarPorId(Long id);
    // Mais tarde podemos adicionar: buscarPorCapacidadeERecursos(...)
}