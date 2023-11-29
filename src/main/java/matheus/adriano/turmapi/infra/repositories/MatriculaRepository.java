package matheus.adriano.turmapi.infra.repositories;

import matheus.adriano.turmapi.domain.entities.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula,String> {
}
