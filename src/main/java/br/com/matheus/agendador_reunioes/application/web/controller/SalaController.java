package br.com.matheus.agendador_reunioes.application.web.controller;

import br.com.matheus.agendador_reunioes.application.web.dto.SalaRequestDTO;
import br.com.matheus.agendador_reunioes.application.web.dto.SalaResponseDTO;
import br.com.matheus.agendador_reunioes.domain.model.Sala;
import br.com.matheus.agendador_reunioes.ports.in.CadastrarSalaUseCase;
import br.com.matheus.agendador_reunioes.ports.in.ListarSalasUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/salas")
public class SalaController {

    private final CadastrarSalaUseCase cadastrarSalaUseCase;
    private final ListarSalasUseCase listarSalasUseCase;

    public SalaController(CadastrarSalaUseCase cadastrarSalaUseCase, ListarSalasUseCase listarSalasUseCase) {
        this.cadastrarSalaUseCase = cadastrarSalaUseCase;
        this.listarSalasUseCase = listarSalasUseCase;
    }

    @PostMapping
    public ResponseEntity<SalaResponseDTO> cadastrar(@RequestBody SalaRequestDTO request) {
        // 1. Converte o JSON (DTO) para Domínio Puro
        Sala salaDomain = request.toDomain();

        // 2. O Caso de Uso faz toda a mágica (regras, salvar no banco)
        Sala salaSalva = cadastrarSalaUseCase.executar(salaDomain);

        // 3. Converte o resultado de volta para JSON (DTO)
        SalaResponseDTO response = SalaResponseDTO.fromDomain(salaSalva);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<SalaResponseDTO>> listarTodas() {
        List<Sala> salas = listarSalasUseCase.executar();

        List<SalaResponseDTO> responseList = salas.stream()
                .map(SalaResponseDTO::fromDomain)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responseList);
    }
}
