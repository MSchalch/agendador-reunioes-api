package br.com.matheus.agendador_reunioes.application.usecases;

import br.com.matheus.agendador_reunioes.domain.model.Sala;
import br.com.matheus.agendador_reunioes.ports.in.CadastrarSalaUseCase;
import br.com.matheus.agendador_reunioes.ports.in.ListarSalasUseCase;
import br.com.matheus.agendador_reunioes.ports.out.SalaRepositoryPort;

import java.util.List;

public class GerenciarSalaInteractor implements CadastrarSalaUseCase, ListarSalasUseCase {

    private final SalaRepositoryPort salaRepositoryPort;

    // A dependência é injetada via construtor.
    // O Spring vai fornecer a implementação real (o banco de dados) quando a aplicação rodar.
    public GerenciarSalaInteractor(SalaRepositoryPort salaRepositoryPort) {
        this.salaRepositoryPort = salaRepositoryPort;
    }

    @Override
    public Sala executar(Sala sala) {
        // Aqui é onde orquestramos as coisas.
        // Exemplo: Poderíamos verificar se já existe uma sala com o mesmo nome antes de salvar.

        return salaRepositoryPort.salvar(sala);
    }

    @Override
    public List<Sala> executar() {
        return salaRepositoryPort.listarTodas();
    }
}