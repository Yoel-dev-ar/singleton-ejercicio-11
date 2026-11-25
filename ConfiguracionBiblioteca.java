public class ConfiguracionBiblioteca {
    private static ConfiguracionBiblioteca instancia;

    private String nombreBiblioteca;
    private int maxLibrosPorSocio;
    private int plazoDevolucionDias;

    private ConfiguracionBiblioteca() {
        this.nombreBiblioteca = "Biblioteca Central";
        this.maxLibrosPorSocio = 3;
        this.plazoDevolucionDias = 15;
    }

    public static ConfiguracionBiblioteca getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionBiblioteca();
        }
        return instancia;
    }

    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setNombreBiblioteca(String nombreBiblioteca) {
        if (nombreBiblioteca == null || nombreBiblioteca.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la biblioteca no puede estar vacío.");
        }
        this.nombreBiblioteca = nombreBiblioteca.trim();
    }

    public int getMaxLibrosPorSocio() {
        return maxLibrosPorSocio;
    }

    public void setMaxLibrosPorSocio(int maxLibrosPorSocio) {
        if (maxLibrosPorSocio <= 0) {
            throw new IllegalArgumentException("La cantidad máxima de libros debe ser mayor a cero.");
        }
        this.maxLibrosPorSocio = maxLibrosPorSocio;
    }

    public int getPlazoDevolucionDias() {
        return plazoDevolucionDias;
    }

    public void setPlazoDevolucionDias(int plazoDevolucionDias) {
        if (plazoDevolucionDias <= 0) {
            throw new IllegalArgumentException("El plazo de devolución debe ser mayor a cero.");
        }
        this.plazoDevolucionDias = plazoDevolucionDias;
    }

    public void mostrarResumen(String modulo) {
        System.out.println("[" + modulo + "] " + nombreBiblioteca
                + " | Máx. libros: " + maxLibrosPorSocio
                + " | Plazo: " + plazoDevolucionDias + " días");
    }
}