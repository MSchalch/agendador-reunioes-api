package br.com.matheus.agendador_reunioes.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reuniao {

    private Long id;
    private String tema;
    private Sala sala;
    private Colaborador responsavel;
    private LocalDateTime horarioInicio;
    private LocalDateTime horarioFim;
    private List<Colaborador> participantes = new ArrayList<>();

    // --- REGRAS DE NEGÓCIO E VALIDAÇÕES ---

    /**
     * Valida todas as regras de negócio essenciais para que uma reunião possa existir.
     * Pode ser chamado antes de enviar os dados para o banco.
     */
    public void validarAgendamento() {
        validarResponsavel();
        validarHorarios();
        validarCapacidadeSala();
    }

    private void validarResponsavel() {
        if (this.responsavel == null) {
            throw new IllegalArgumentException("A reunião precisa ter um colaborador responsável.");
        }
    }

    private void validarHorarios() {
        if (this.horarioInicio == null || this.horarioFim == null) {
            throw new IllegalArgumentException("Os horários de início e fim são obrigatórios.");
        }

        // RN05 - Não agendar no passado
        if (this.horarioInicio.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Não é possível agendar uma reunião no passado.");
        }

        // RN04 (Parte 1) - Início antes do fim
        if (!this.horarioInicio.isBefore(this.horarioFim)) {
            throw new IllegalArgumentException("O horário de início deve ser obrigatoriamente anterior ao horário de fim.");
        }

        // RN04 (Parte 2) - Duração mínima de 15 minutos
        Duration duracao = Duration.between(this.horarioInicio, this.horarioFim);
        if (duracao.toMinutes() < 15) {
            throw new IllegalArgumentException("A reunião deve ter uma duração mínima de 15 minutos.");
        }
    }

    private void validarCapacidadeSala() {
        if (this.sala == null) {
            throw new IllegalArgumentException("A reunião precisa ter uma sala definida.");
        }

        // RN02 - Validação de Capacidade (Considera a lista de convidados + o responsável)
        int totalPessoas = this.participantes.size() + 1;

        if (!this.sala.comporta(totalPessoas)) {
            throw new IllegalArgumentException(
                    "A quantidade de pessoas (" + totalPessoas +
                            ") excede a capacidade da sala (" + this.sala.getCapacidade() + ")."
            );
        }
    }
}