Ejercicio 2: Registro Centralizado de Actividades de la Biblioteca (Patrón Singleton)
Temática
Gestión de Biblioteca — Trazabilidad unificada de eventos generados por préstamos, devoluciones y atención a socios.

Consigna

Registro Centralizado de Actividades de la Biblioteca

Contexto del problema: Los sectores de préstamos, devoluciones y atención a socios registran sus actividades por separado. Esto dificulta reconstruir qué operaciones se realizaron y en qué orden. La biblioteca necesita un registro compartido durante la ejecución de la aplicación.

Objetivo de aprendizaje: Utilizar Singleton para centralizar la incorporación y consulta de eventos provenientes de distintos módulos.

Requisitos funcionales:

Registrar actividades con fecha, hora, sector y descripción.

Consultar el historial completo en el orden de incorporación.

Filtrar las actividades por sector.

Mostrar la cantidad total de eventos registrados.

Restricciones técnicas:

Debe existir una única instancia del registro de actividades.

Los tres sectores deben incorporar eventos al mismo registro.

La colección interna debe ser privada y no debe poder modificarse directamente desde las consultas.

No se permite resolver el ejercicio mediante una clase compuesta únicamente por métodos y atributos estáticos.



Explicación lógica
Atributos: En la clase RegistroActividades se declara actividades (private final List<Actividad>) para conservar el historial ordenado de eventos y instancia (private static RegistroActividades) para centralizar el acceso desde todos los sectores sin recurrir a una clase puramente estática.

Instancia única: El constructor es private para impedir instanciaciones directas fuera de la clase, e inicializa la lista interna vacía. getInstancia() entrega siempre la misma instancia compartida por los tres sectores.

Asignación y Acceso: En Main, los sectores de préstamos, devoluciones y atención a socios registran eventos sobre la misma instancia; luego se consulta el total de eventos, el historial completo en orden de llegada y el filtrado por sector, devolviendo vistas no modificables para proteger la colección interna.

Estructura del ejercicio
Actividad.java: Modela cada evento con fecha, hora, sector y descripción.

RegistroActividades.java: Implementa el Singleton, el registro ordenado, el filtrado por sector y la protección de la lista interna.

Main.java: Simula operaciones de los tres sectores, consulta el historial y verifica que la colección no pueda alterarse desde afuera.