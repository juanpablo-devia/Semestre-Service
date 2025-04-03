package co.edu.uceva.semestreservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "semestre")
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean activo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private long idPrograma;
    private Integer numeroSemestre;
}
