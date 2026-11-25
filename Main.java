// Main.java
public class Main {
    public static void main(String[] args) {
        ConfiguracionBiblioteca configPrestamos = ConfiguracionBiblioteca.getInstancia();
        ConfiguracionBiblioteca configConsultas = ConfiguracionBiblioteca.getInstancia();

        // Comprobación de identidad (misma referencia en memoria)
        System.out.println("¿Misma instancia? " + (configPrestamos == configConsultas));

        configPrestamos.mostrarResumen("Préstamos");
        configConsultas.mostrarResumen("Consultas");

        // Modificación desde un módulo reflejada en el otro
        configPrestamos.setNombreBiblioteca("Biblioteca Popular del Este");
        configPrestamos.setMaxLibrosPorSocio(5);
        configPrestamos.setPlazoDevolucionDias(10);

        configConsultas.mostrarResumen("Consultas tras cambio");

        // Prueba de validaciones
        try {
            configConsultas.setMaxLibrosPorSocio(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Validación correcta: " + e.getMessage());
        }
    }
}