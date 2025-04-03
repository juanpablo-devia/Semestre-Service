package co.edu.uceva.semestreservice.service;

import co.edu.uceva.semestreservice.model.Semestre;

import java.util.List;

public interface SemestreService {

    Semestre saveSemestre(Semestre semestre);
    List<Semestre> getAllSemestres();
    Semestre getSemestreById(Long id);
    Semestre updateSemestre(Long id, Semestre semestre);
    void deleteSemestre(Long id);
}