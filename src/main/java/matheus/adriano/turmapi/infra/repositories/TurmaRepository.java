package matheus.adriano.turmapi.infra.repositories;

import matheus.adriano.turmapi.domain.entities.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public  interface TurmaRepository extends JpaRepository<Turma,String> {
}
