package personajes;

public class Caracteristicas {
    private double velocidad;
    private double fuerza;
    private double resistencia;
    private double destreza;

    public Caracteristicas(double velocidad, double fuerza, double resistencia, double destreza) {
        this.velocidad = velocidad;
        this.fuerza = fuerza;
        this.resistencia = resistencia;
        this.destreza = destreza;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getFuerza() {
        return fuerza;
    }

    public void setFuerza(double fuerza) {
        this.fuerza = fuerza;
    }

    public double getResistencia() {
        return resistencia;
    }

    public void setResistencia(double resistencia) {
        this.resistencia = resistencia;
    }

    public double getDestreza() {
        return destreza;
    }

    public void setDestreza(double destreza) {
        this.destreza = destreza;
    }

    public double getCaracteristica(String nombreCaracteristica) {
        switch (nombreCaracteristica) {
            case "Velocidad":
                return velocidad;
            case "Fuerza":
                return fuerza;
            case "Resistencia":
                return resistencia;
            case "Destreza":
                return destreza;
            default:
                throw new IllegalArgumentException("Caracter�stica no v�lida");
        }
    }

    @Override
    public String toString() {
        return "Velocidad: " + velocidad + "\nDestreza: " + destreza + "\nFuerza: " + fuerza + "\nResistencia: "
                + resistencia;
    }
}
