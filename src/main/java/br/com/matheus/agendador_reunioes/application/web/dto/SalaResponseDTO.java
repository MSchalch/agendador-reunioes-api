package br.com.matheus.agendador_reunioes.application.web.dto;

import br.com.matheus.agendador_reunioes.domain.model.Recurso;
import br.com.matheus.agendador_reunioes.domain.model.Sala;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SalaResponseDTO {
    private Long id;
    private String nome;
    private Integer capacidade;
    private List<Recurso> recursos;

    // Método utilitário para converter do Domínio para DTO
    public static SalaResponseDTO fromDomain(Sala sala) {
        SalaResponseDTO dto = new SalaResponseDTO();
        dto.setId(sala.getId());
        dto.setNome(sala.getNome());
        dto.setCapacidade(sala.getCapacidade());
        dto.setRecursos(sala.getRecursos());
        return dto;
    }
}