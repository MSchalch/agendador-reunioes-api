package br.com.matheus.agendador_reunioes.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Colaborador {

    private Long id;
    private String nome;
    private String email;

    // --- REGRAS DE NEGÓCIO E VALIDAÇÕES ---

    /**
     * Validação simples de domínio para garantir a integridade do dado.
     * O próprio colaborador sabe dizer se o e-mail dele tem um formato mínimo aceitável.
     */
    public boolean possuiEmailValido() {
        if (this.email == null || this.email.isBlank()) {
            return false;
        }
        // Uma validação básica. Em um cenário real, poderia usar um Regex mais complexo.
        return this.email.contains("@") && this.email.contains(".");
    }

    /**
     * Regra para formatar o nome do colaborador para um padrão visual.
     * Útil para garantir que no banco e nas listagens o nome fique padronizado.
     */
    public void padronizarNome() {
        if (this.nome != null && !this.nome.trim().isEmpty()) {
            String[] partes = this.nome.trim().split("\\s+");
            StringBuilder nomePadronizado = new StringBuilder();

            for (String parte : partes) {
                nomePadronizado.append(parte.substring(0, 1).toUpperCase())
                        .append(parte.substring(1).toLowerCase())
                        .append(" ");
            }
            this.nome = nomePadronizado.toString().trim();
        }
    }
}