package co.edu.uceva.semestreservice.dto;

import java.util.List;

public class SemestrePageResponse {
    private List<SemestreResponse> contenido;
    private int totalPaginas;
    private long totalElementos;
    private int paginaActual;

    public SemestrePageResponse(List<SemestreResponse> contenido, int totalPaginas, long totalElementos, int paginaActual) {
        this.contenido = contenido;
        this.totalPaginas = totalPaginas;
        this.totalElementos = totalElementos;
        this.paginaActual = paginaActual;
    }

    public List<SemestreResponse> getContenido() {
        return contenido;
    }

    public void setContenido(List<SemestreResponse> contenido) {
        this.contenido = contenido;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public long getTotalElementos() {
        return totalElementos;
    }

    public void setTotalElementos(long totalElementos) {
        this.totalElementos = totalElementos;
    }

    public int getPaginaActual() {
        return paginaActual;
    }

    public void setPaginaActual(int paginaActual) {
        this.paginaActual = paginaActual;
    }
}