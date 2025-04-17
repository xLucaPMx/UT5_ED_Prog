package App;

public class Deportiva extends Motocicleta {

    private double velocidadMaxima;
    private boolean tieneQuickShifter;

    public Deportiva(String matricula, String marca, String modelo, int anyoFabricacion, double kilometraje, double precio, Estado estado, Persona titular, int cilindrada, int peso, double alturaAsiento, TipoTransmision tipoTransmision, double velocidadMaxima, boolean tieneQuickShifter) {
        super(matricula, marca, modelo, anyoFabricacion, kilometraje, precio, estado, titular, cilindrada, peso, alturaAsiento, tipoTransmision);
        this.velocidadMaxima = velocidadMaxima;
        this.tieneQuickShifter = tieneQuickShifter;
    }

    @Override
    public NivelRiesgo calcularRiesgo(int experiencia) {
        return null;
    }

    @Override
    public double calcularDepreciacion() {
        double edad = 2025 - getAnyoFabricacion();
        double depreciacionEdad = Math.pow(0.85, edad);
        double depreciacionKm;
        if (velocidadMaxima > 400) {
            depreciacionKm = 1.1;
        } else {
            depreciacionKm = 0.95;
        }
        double factorKm = getKilometraje() * depreciacionKm / 10000;
        double valorActual = getPrecio() * depreciacionEdad * (1 - factorKm);
        return valorActual;
    }
}
