package co.edu.uceva.semestreservice.controller;

import co.edu.uceva.semestreservice.dto.SemestreRequest;
import co.edu.uceva.semestreservice.dto.SemestreResponse;
import co.edu.uceva.semestreservice.model.Semestre;
import co.edu.uceva.semestreservice.service.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/semestres")
public class SemestreController {

    @Autowired
    private SemestreService semestreService;

    // Crear semestre
    @PostMapping
    public ResponseEntity<SemestreResponse> saveSemestre(@RequestBody SemestreRequest request) {
        Semestre semestre = new Semestre();
        semestre.setActivo(request.getActivo());
        semestre.setFechaInicio(request.getFechaInicio());
        semestre.setFechaFin(request.getFechaFin());
        semestre.setIdPrograma(request.getIdPrograma());
        semestre.setNumeroSemestre(request.getNumeroSemestre());

        Semestre guardado = semestreService.saveSemestre(semestre);
        SemestreResponse response = new SemestreResponse(
                guardado.getId(),
                guardado.getActivo(),
                guardado.getFechaInicio(),
                guardado.getFechaFin(),
                guardado.getNumeroSemestre()
        );

        return ResponseEntity.ok(response);
    }

    // Obtener todos los semestres
    @GetMapping
    public List<SemestreResponse> getAllSemestres() {
        return semestreService.getAllSemestres().stream()
                .map(s -> new SemestreResponse(
                        s.getId(),
                        s.getActivo(),
                        s.getFechaInicio(),
                        s.getFechaFin(),
                        s.getNumeroSemestre()))
                .collect(Collectors.toList());
    }

    // Obtener semestre por ID
    @GetMapping("/{id}")
    public ResponseEntity<SemestreResponse> getSemestreById(@PathVariable Long id) {
        Semestre s = semestreService.getSemestreById(id);
        SemestreResponse response = new SemestreResponse(
                s.getId(),
                s.getActivo(),
                s.getFechaInicio(),
                s.getFechaFin(),
                s.getNumeroSemestre()
        );
        return ResponseEntity.ok(response);
    }

    // Actualizar semestre
    @PutMapping("/{id}")
    public ResponseEntity<SemestreResponse> updateSemestre(@PathVariable Long id, @RequestBody SemestreRequest request) {
        Semestre semestre = new Semestre();
        semestre.setActivo(request.getActivo());
        semestre.setFechaInicio(request.getFechaInicio());
        semestre.setFechaFin(request.getFechaFin());
        semestre.setIdPrograma(request.getIdPrograma());
        semestre.setNumeroSemestre(request.getNumeroSemestre());

        Semestre actualizado = semestreService.updateSemestre(id, semestre);
        SemestreResponse response = new SemestreResponse(
                actualizado.getId(),
                actualizado.getActivo(),
                actualizado.getFechaInicio(),
                actualizado.getFechaFin(),
                actualizado.getNumeroSemestre()
        );

        return ResponseEntity.ok(response);
    }

    // Eliminar semestre
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSemestre(@PathVariable Long id) {
        semestreService.deleteSemestre(id);
        return ResponseEntity.noContent().build();
    }
}