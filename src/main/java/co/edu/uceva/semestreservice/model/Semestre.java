package co.edu.uceva.semestreservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "semestres")
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean activo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Long idPrograma;
    private Integer numeroSemestre;
}
