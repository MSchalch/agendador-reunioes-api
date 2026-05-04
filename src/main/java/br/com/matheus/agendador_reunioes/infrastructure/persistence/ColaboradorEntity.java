package br.com.matheus.agendador_reunioes.infrastructure.persistence;

import br.com.matheus.agendador_reunioes.domain.model.Colaborador;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "colaboradores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    // Converte do Domínio (Java puro) para Entidade (JPA)
    public static ColaboradorEntity fromDomain(Colaborador colaborador) {
        return new ColaboradorEntity(
                colaborador.getId(),
                colaborador.getNome(),
                colaborador.getEmail()
        );
    }

    // Converte da Entidade (JPA) para Domínio (Java puro)
    public Colaborador toDomain() {
        return new Colaborador(
                this.id,
                this.nome,
                this.email
        );
    }
}