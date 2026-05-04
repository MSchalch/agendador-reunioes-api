package br.com.matheus.agendador_reunioes.application.usecases;

import br.com.matheus.agendador_reunioes.domain.model.Colaborador;
import br.com.matheus.agendador_reunioes.ports.in.CadastrarColaboradorUseCase;
import br.com.matheus.agendador_reunioes.ports.in.ListarColaboradoresUseCase;
import br.com.matheus.agendador_reunioes.ports.out.ColaboradorRepositoryPort;

import java.util.List;

public class GerenciarColaboradorInteractor implements CadastrarColaboradorUseCase, ListarColaboradoresUseCase {
    private final ColaboradorRepositoryPort colaboradorRepositoryPort;

    public GerenciarColaboradorInteractor(ColaboradorRepositoryPort colaboradorRepositoryPort) {
        this.colaboradorRepositoryPort = colaboradorRepositoryPort;
    }

    @Override
    public Colaborador executar(Colaborador colaborador) {

        return colaboradorRepositoryPort.salvar(colaborador);
    }

    @Override
    public List<Colaborador> executar() {
        return colaboradorRepositoryPort.listarTodos();
    }
}
