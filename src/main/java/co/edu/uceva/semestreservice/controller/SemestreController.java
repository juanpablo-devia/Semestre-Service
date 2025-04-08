package co.edu.uceva.semestreservice.controller;

import co.edu.uceva.semestreservice.dto.*;
import co.edu.uceva.semestreservice.model.Semestre;
import co.edu.uceva.semestreservice.service.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/semestre-service")
public class SemestreController {

    @Autowired
    private SemestreService semestreService;

    @PostMapping("/semestres")
    public ResponseEntity<SemestreResponse> saveSemestre(@RequestBody SemestreRequest request) {
        Semestre semestre = new Semestre();
        semestre.setActivo(request.getActivo());
        semestre.setFechaInicio(request.getFechaInicio());
        semestre.setFechaFin(request.getFechaFin());
        semestre.setIdPrograma(request.getIdPrograma());
        semestre.setNumeroSemestre(request.getNumeroSemestre());

        Semestre saved = semestreService.saveSemestre(semestre);
        return ResponseEntity.ok(new SemestreResponse(saved.getId(), saved.getActivo(), saved.getFechaInicio(), saved.getFechaFin(), saved.getNumeroSemestre()));
    }

    @GetMapping("/semestres")
    public List<SemestreResponse> getAllSemestres() {
        return semestreService.getAllSemestres().stream()
                .map(s -> new SemestreResponse(s.getId(), s.getActivo(), s.getFechaInicio(), s.getFechaFin(), s.getNumeroSemestre()))
                .collect(Collectors.toList());
    }

    @GetMapping("/semestres/{id}")
    public ResponseEntity<SemestreResponse> getSemestreById(@PathVariable Long id) {
        Semestre s = semestreService.getSemestreById(id);
        return ResponseEntity.ok(new SemestreResponse(s.getId(), s.getActivo(), s.getFechaInicio(), s.getFechaFin(), s.getNumeroSemestre()));
    }

    @PutMapping("/semestres/{id}")
    public ResponseEntity<SemestreResponse> updateSemestre(@PathVariable Long id, @RequestBody SemestreRequest request) {
        Semestre semestre = new Semestre();
        semestre.setActivo(request.getActivo());
        semestre.setFechaInicio(request.getFechaInicio());
        semestre.setFechaFin(request.getFechaFin());
        semestre.setIdPrograma(request.getIdPrograma());
        semestre.setNumeroSemestre(request.getNumeroSemestre());

        Semestre updated = semestreService.updateSemestre(id, semestre);
        return ResponseEntity.ok(new SemestreResponse(updated.getId(), updated.getActivo(), updated.getFechaInicio(), updated.getFechaFin(), updated.getNumeroSemestre()));
    }

    @DeleteMapping("/semestres/{id}")
    public ResponseEntity<DeleteResponse> deleteSemestre(@PathVariable Long id) {
        semestreService.deleteSemestre(id);
        return ResponseEntity.ok(new DeleteResponse("Semestre con ID " + id + " eliminado correctamente"));
    }

    @GetMapping("/semestre/page/{page}")
    public ResponseEntity<SemestrePageResponse> getSemestresPaginados(@PathVariable int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Semestre> semestres = semestreService.getSemestresPaginados(pageable);

        List<SemestreResponse> lista = semestres.getContent().stream()
                .map(s -> new SemestreResponse(
                        s.getId(),
                        s.getActivo(),
                        s.getFechaInicio(),
                        s.getFechaFin(),
                        s.getNumeroSemestre()))
                .collect(Collectors.toList());

        SemestrePageResponse respuesta = new SemestrePageResponse(
                lista,
                semestres.getTotalPages(),
                semestres.getTotalElements(),
                semestres.getNumber()
        );

        return ResponseEntity.ok(respuesta);
    }
}