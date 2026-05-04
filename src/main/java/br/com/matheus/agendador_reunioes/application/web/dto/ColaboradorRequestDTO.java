package br.com.matheus.agendador_reunioes.application.web.dto;

import br.com.matheus.agendador_reunioes.domain.model.Colaborador;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColaboradorRequestDTO {

    private String nome;
    private String email;

    public Colaborador toDomain() {
        Colaborador colaborador = new Colaborador();
        colaborador.setNome(this.nome);
        colaborador.setEmail(this.email);
        return colaborador;
    }
}
