package App;

public class Berlina extends Coche{

    private double espacioInterior;
    private NivelConfort nivelConfort;

    public Berlina(String matricula, String marca, String modelo, int anyoFabricacion, double kilometraje, double precio, Estado estado, Persona titular, int numPuertas, TipoCombustible combustible, int capacidadMaletero, Traccion traccion, double espacioInterior, NivelConfort nivelConfort) {
        super(matricula, marca, modelo, anyoFabricacion, kilometraje, precio, estado, titular, numPuertas, combustible, capacidadMaletero, traccion);
        this.espacioInterior = espacioInterior;
        this.nivelConfort = nivelConfort;
    }

    @Override
    public double calcularDepreciacion() {
        double edad = 2025 - getAnyoFabricacion();
        double depreciacionEdad = Math.pow(0.85, edad);
        double depreciacionKm = getKilometraje() * 0.8 / 10000;
        double valorActual = getPrecio() * depreciacionEdad * (1 - depreciacionKm);
        return valorActual;
    }
}
