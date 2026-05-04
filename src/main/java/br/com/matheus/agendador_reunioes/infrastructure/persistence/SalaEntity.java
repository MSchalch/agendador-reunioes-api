package br.com.matheus.agendador_reunioes.infrastructure.persistence;

import br.com.matheus.agendador_reunioes.domain.model.Recurso;
import br.com.matheus.agendador_reunioes.domain.model.Sala;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "salas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer capacidade;

    @ElementCollection(targetClass = Recurso.class)
    @CollectionTable(name = "sala_recursos", joinColumns = @JoinColumn(name = "sala_id"))
    @Enumerated(EnumType.STRING)
    private List<Recurso> recursos;

    // Métodos utilitários para converter de Domínio para Entidade e vice-versa
    public static SalaEntity fromDomain(Sala sala) {
        return new SalaEntity(sala.getId(), sala.getNome(), sala.getCapacidade(), sala.getRecursos());
    }

    public Sala toDomain() {
        return new Sala(this.id, this.nome, this.capacidade, this.recursos);
    }
}
