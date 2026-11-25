Ejercicio 1: Configuración General de una Biblioteca (Patrón Singleton)
Temática
Gestión de Biblioteca — Administración centralizada de la configuración general compartida entre los módulos de préstamos y consultas.

Consigna

Configuración General de una Biblioteca

Contexto del problema: Una biblioteca utiliza una aplicación de escritorio para gestionar sus operaciones. Los módulos de préstamos y consultas necesitan conocer el nombre de la institución, la cantidad máxima de libros por socio y el plazo de devolución. Actualmente, cada módulo crea su propia configuración y los valores pueden quedar desactualizados.

Objetivo de aprendizaje: Implementar un Singleton básico que centralice la configuración y permita compartir una única instancia entre diferentes módulos.

Requisitos funcionales:

Consultar y modificar el nombre de la biblioteca, el máximo de libros por socio y el plazo de devolución.

Acceder a la configuración desde los módulos de préstamos y consultas.

Reflejar en ambos módulos las modificaciones realizadas.

Restricciones técnicas:

La clase de configuración debe impedir su instanciación directa desde el código cliente.

Debe proporcionar un método de acceso que retorne siempre la misma instancia.

Los atributos deben ser privados y rechazar nombres vacíos o valores numéricos menores o iguales a cero.

Se debe comprobar mediante una comparación de identidad que ambos módulos utilizan el mismo objeto.



Explicación lógica
Atributos: En la clase ConfiguracionBiblioteca se declaran nombreBiblioteca (private String), maxLibrosPorSocio (private int) y plazoDevolucionDias (private int) para almacenar los parámetros generales, junto con instancia (private static ConfiguracionBiblioteca) para mantener la única referencia en memoria.

Instancia única: El constructor se define como private para bloquear la creación de instancias externas con new e inicializar valores por defecto válidos. El método getInstancia() verifica si instancia es null, la crea una sola vez y devuelve siempre ese mismo objeto en llamadas posteriores.

Asignación y Acceso: En Main, se obtiene la referencia desde los módulos de préstamos y consultas, se comprueba con == que apuntan al mismo objeto y se modifican los valores desde un módulo verificando que el cambio se refleje de inmediato en el otro y que los setters rechacen nombres vacíos o números menores o iguales a cero.

Estructura del ejercicio
ConfiguracionBiblioteca.java: Implementa el Singleton con los parámetros de configuración y validaciones de entrada.

Main.java: Verifica la identidad de instancia, prueba la actualización compartida entre módulos y comprueba las validaciones.