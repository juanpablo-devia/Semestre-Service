package co.edu.uceva.semestreservice.repository;

import co.edu.uceva.semestreservice.model.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemestreRepository extends JpaRepository<Semestre,Long> {
}
