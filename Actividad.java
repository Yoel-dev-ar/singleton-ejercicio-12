import java.time.LocalDate;
import java.time.LocalTime;

public class Actividad {
    private final LocalDate fecha;
    private final LocalTime hora;
    private final String sector;
    private final String descripcion;

    public Actividad(LocalDate fecha, LocalTime hora, String sector, String descripcion) {
        if (fecha == null || hora == null) {
            throw new IllegalArgumentException("La fecha y la hora son obligatorias.");
        }
        if (sector == null || sector.trim().isEmpty()) {
            throw new IllegalArgumentException("El sector no puede estar vacío.");
        }
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía.");
        }
        this.fecha = fecha;
        this.hora = hora;
        this.sector = sector.trim();
        this.descripcion = descripcion.trim();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getSector() {
        return sector;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "[" + fecha + " " + hora + "] (" + sector + ") - " + descripcion;
    }
}