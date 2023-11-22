package matheus.adriano.turmapi.infra.repositories;

import matheus.adriano.turmapi.domain.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,String> {
}
