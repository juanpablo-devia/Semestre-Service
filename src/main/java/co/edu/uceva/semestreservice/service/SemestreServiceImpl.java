package co.edu.uceva.semestreservice.service;

import co.edu.uceva.semestreservice.exception.ResourceNotFoundException;
import co.edu.uceva.semestreservice.model.Semestre;
import co.edu.uceva.semestreservice.repository.SemestreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemestreServiceImpl implements SemestreService {

    @Autowired
    private SemestreRepository semestreRepository;

    @Override
    public Semestre saveSemestre(Semestre semestre) {
        return semestreRepository.save(semestre);
    }

    @Override
    public List<Semestre> getAllSemestres(){
        return semestreRepository.findAll();
    }

    @Override
    public Semestre getSemestreById(Long id){
        return semestreRepository.findById(id).orElse(null);
    }

    @Override
    public Semestre updateSemestre(Long id, Semestre semestre) {
        Semestre existente = semestreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Semestre con ID " + id + " no encontrado"));

        existente.setActivo(semestre.getActivo());
        existente.setFechaInicio(semestre.getFechaInicio());
        existente.setFechaFin(semestre.getFechaFin());
        existente.setIdPrograma(semestre.getIdPrograma());
        existente.setNumeroSemestre(semestre.getNumeroSemestre());

        return semestreRepository.save(existente);
    }

    @Override
    public void deleteSemestre(Long id) {
        Semestre existente = semestreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Semestre con ID " + id + " no encontrado"));

        semestreRepository.deleteById(id);
    }

}
