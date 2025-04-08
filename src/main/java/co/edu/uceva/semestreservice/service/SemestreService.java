package co.edu.uceva.semestreservice.service;

import co.edu.uceva.semestreservice.model.Semestre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SemestreService {
    Semestre saveSemestre(Semestre semestre);
    List<Semestre> getAllSemestres();
    Semestre getSemestreById(Long id);
    Semestre updateSemestre(Long id, Semestre semestre);
    void deleteSemestre(Long id);
    Page<Semestre> getSemestresPaginados(Pageable pageable);
}