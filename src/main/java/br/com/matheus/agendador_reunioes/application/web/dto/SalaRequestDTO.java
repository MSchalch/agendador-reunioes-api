package br.com.matheus.agendador_reunioes.application.web.dto;

import br.com.matheus.agendador_reunioes.domain.model.Recurso;
import br.com.matheus.agendador_reunioes.domain.model.Sala;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SalaRequestDTO {
    private String nome;
    private Integer capacidade;
    private List<Recurso> recursos;

    // Metodo utilitário para converter o DTO no nosso modelo de Domínio
    public Sala toDomain() {
        Sala sala = new Sala();
        sala.setNome(this.nome);
        sala.setCapacidade(this.capacidade);
        sala.setRecursos(this.recursos);
        return sala;
    }
}
