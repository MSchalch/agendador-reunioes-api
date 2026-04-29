package br.com.matheus.agendador_reunioes.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sala {

    private Long id;
    private String nome;
    private Integer capacidade;
    private List<Recurso> recursos;

    // --- AQUI ENTRAM AS REGRAS DE NEGÓCIO ---

    /**
     * RN02 - Validação de Capacidade
     * A própria sala sabe dizer se ela comporta uma certa quantidade de pessoas.
     */
    public boolean comporta(int quantidadeParticipantes) {
        if (this.capacidade == null) {
            return false;
        }
        return quantidadeParticipantes <= this.capacidade;
    }

    /**
     * Verifica se a sala possui um recurso específico.
     * Útil para o RF03 (Filtragem Inteligente).
     */
    public boolean possuiRecurso(Recurso recurso) {
        if (this.recursos == null || this.recursos.isEmpty()) {
            return false;
        }
        return this.recursos.contains(recurso);
    }
}