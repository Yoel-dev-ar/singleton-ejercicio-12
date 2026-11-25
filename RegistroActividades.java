import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegistroActividades {
    private static RegistroActividades instancia;
    private final List<Actividad> actividades;

    private RegistroActividades() {
        this.actividades = new ArrayList<>();
    }

    public static RegistroActividades getInstancia() {
        if (instancia == null) {
            instancia = new RegistroActividades();
        }
        return instancia;
    }

    public void registrar(LocalDate fecha, LocalTime hora, String sector, String descripcion) {
        actividades.add(new Actividad(fecha, hora, sector, descripcion));
    }

    public List<Actividad> obtenerHistorial() {
        return Collections.unmodifiableList(new ArrayList<>(actividades));
    }

    public List<Actividad> filtrarPorSector(String sector) {
        if (sector == null || sector.trim().isEmpty()) {
            return Collections.emptyList();
        }
        String buscado = sector.trim().toLowerCase();
        List<Actividad> filtradas = new ArrayList<>();
        for (Actividad act : actividades) {
            if (act.getSector().toLowerCase().equals(buscado)) {
                filtradas.add(act);
            }
        }
        return Collections.unmodifiableList(filtradas);
    }

    public int totalEventos() {
        return actividades.size();
    }
}