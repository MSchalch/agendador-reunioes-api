package br.com.matheus.agendador_reunioes.application.web.dto;

import br.com.matheus.agendador_reunioes.domain.model.Colaborador;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColaboradorResponseDTO {

    private Long id;
    private String nome;
    private String email;

    public static ColaboradorResponseDTO fromDomain(Colaborador colaborador) {
        ColaboradorResponseDTO dto = new ColaboradorResponseDTO();
        dto.setId(colaborador.getId());
        dto.setNome(colaborador.getNome());
        dto.setEmail(colaborador.getEmail());
        return dto;
    }
}
