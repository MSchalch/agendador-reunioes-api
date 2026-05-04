package br.com.matheus.agendador_reunioes.infrastructure.persistence;

import br.com.matheus.agendador_reunioes.domain.model.Sala;
import br.com.matheus.agendador_reunioes.ports.out.SalaRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class SalaRepositoryAdapter implements SalaRepositoryPort {

    private final SpringDataSalaRepository springDataRepository;

    public SalaRepositoryAdapter(SpringDataSalaRepository springDataRepository) {
        this.springDataRepository = springDataRepository;
    }

    @Override
    public Sala salvar(Sala sala) {
        // Converte o Domínio puro para Entidade JPA
        SalaEntity entity = SalaEntity.fromDomain(sala);

        // Salva no banco de dados usando Spring
        SalaEntity savedEntity = springDataRepository.save(entity);

        // Converte de volta para Domínio puro e retorna
        return savedEntity.toDomain();
    }

    @Override
    public List<Sala> listarTodas() {
        return springDataRepository.findAll().stream()
                .map(SalaEntity::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Sala> buscarPorId(Long id) {
        return springDataRepository.findById(id)
                .map(SalaEntity::toDomain);
    }
}
