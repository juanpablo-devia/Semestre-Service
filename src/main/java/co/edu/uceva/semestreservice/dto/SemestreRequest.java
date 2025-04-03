package co.edu.uceva.semestreservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SemestreRequest {
    private Boolean activo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Long idPrograma;
    private Integer numeroSemestre;
}