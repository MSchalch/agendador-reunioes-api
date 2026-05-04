package br.com.matheus.agendador_reunioes.infrastructure.persistence;

import br.com.matheus.agendador_reunioes.domain.model.Colaborador;
import br.com.matheus.agendador_reunioes.ports.out.ColaboradorRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ColaboradorRepositoryAdapter implements ColaboradorRepositoryPort {

    private final SpringDataColaboradorRepository springDataRepository;

    public ColaboradorRepositoryAdapter(SpringDataColaboradorRepository springDataRepository) {
        this.springDataRepository = springDataRepository;
    }

    @Override
    public Colaborador salvar(Colaborador colaborador) {
        ColaboradorEntity entity = ColaboradorEntity.fromDomain(colaborador);
        ColaboradorEntity savedEntity = springDataRepository.save(entity);
        return savedEntity.toDomain();
    }

    @Override
    public List<Colaborador> listarTodos() {
        return springDataRepository.findAll().stream()
                .map(ColaboradorEntity::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Colaborador> buscarPorId(Long id) {
        return springDataRepository.findById(id)
                .map(ColaboradorEntity::toDomain);
    }
}