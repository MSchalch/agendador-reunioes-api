package br.com.matheus.agendador_reunioes.application.web.controller;

import br.com.matheus.agendador_reunioes.application.web.dto.ColaboradorRequestDTO;
import br.com.matheus.agendador_reunioes.application.web.dto.ColaboradorResponseDTO;
import br.com.matheus.agendador_reunioes.domain.model.Colaborador;
import br.com.matheus.agendador_reunioes.ports.in.CadastrarColaboradorUseCase;
import br.com.matheus.agendador_reunioes.ports.in.ListarColaboradoresUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/colaboradores")
public class ColaboradorController {

    private final CadastrarColaboradorUseCase cadastrarColaboradorUseCase;
    private final ListarColaboradoresUseCase listarColaboradoresUseCase;

    public ColaboradorController(CadastrarColaboradorUseCase cadastrarColaboradorUseCase, ListarColaboradoresUseCase listarColaboradoresUseCase) {
        this.cadastrarColaboradorUseCase = cadastrarColaboradorUseCase;
        this.listarColaboradoresUseCase = listarColaboradoresUseCase;
    }

    @PostMapping
    public ResponseEntity<ColaboradorResponseDTO> cadastrar(@RequestBody ColaboradorRequestDTO request) {
        Colaborador colaboradorDomain = request.toDomain();
        Colaborador colaboradorSalvo = cadastrarColaboradorUseCase.executar(colaboradorDomain);
        ColaboradorResponseDTO response = ColaboradorResponseDTO.fromDomain(colaboradorSalvo);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ColaboradorResponseDTO>> listarTodos() {
        List<Colaborador> colaboradores = listarColaboradoresUseCase.executar();

        List<ColaboradorResponseDTO> responseList = colaboradores.stream()
                .map(ColaboradorResponseDTO::fromDomain)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responseList);
    }
}
