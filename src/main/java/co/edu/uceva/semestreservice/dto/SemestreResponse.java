package co.edu.uceva.semestreservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SemestreResponse {
    private Long id;
    private Boolean activo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Integer numeroSemestre;

    public SemestreResponse(Long id, Boolean activo, LocalDate fechaInicio, LocalDate fechaFin, Integer numeroSemestre) {
        this.id = id;
        this.activo = activo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numeroSemestre = numeroSemestre;
    }
}