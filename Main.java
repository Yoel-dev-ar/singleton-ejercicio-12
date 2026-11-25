import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        RegistroActividades registro = RegistroActividades.getInstancia();

        // Tres sectores distintos registrando sobre la misma instancia
        registro.registrar(LocalDate.now(), LocalTime.of(9, 15), "Préstamos", "Préstamo de 'Clean Code' a socio #101");
        registro.registrar(LocalDate.now(), LocalTime.of(9, 40), "Atención a socios", "Alta de socio #102");
        registro.registrar(LocalDate.now(), LocalTime.of(10, 5), "Devoluciones", "Devolución de 'Patrones de Diseño'");
        registro.registrar(LocalDate.now(), LocalTime.of(10, 20), "Préstamos", "Préstamo de 'Java Efectivo' a socio #102");

        System.out.println("Total de eventos: " + registro.totalEventos());
        System.out.println("\n--- Historial completo ---");
        for (Actividad a : registro.obtenerHistorial()) {
            System.out.println(a);
        }

        System.out.println("\n--- Solo sector Préstamos ---");
        for (Actividad a : registro.filtrarPorSector("Préstamos")) {
            System.out.println(a);
        }

        // Intento de modificar la lista devuelta
        try {
            registro.obtenerHistorial().clear();
        } catch (UnsupportedOperationException e) {
            System.out.println("\nColección protegida: no se puede modificar desde fuera.");
        }
    }
}