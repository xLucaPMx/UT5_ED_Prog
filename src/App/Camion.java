package App;

public class Camion extends Vehiculo {

    private double capacidadCarga;
    private int numEjes;
    private double longitudRemolque;
    private int potenciaMotor;

    public Camion(String matricula, String marca, String modelo, int anyoFabricacion, double kilometraje, double precio, Estado estado, Persona titular, double capacidadCarga, int numEjes, double longitudRemolque, int potenciaMotor) {
        super(matricula, marca, modelo, anyoFabricacion, kilometraje, precio, estado, titular);
        this.capacidadCarga = capacidadCarga;
        this.numEjes = numEjes;
        this.longitudRemolque = longitudRemolque;
        this.potenciaMotor = potenciaMotor;
    }

    @Override
    public NivelRiesgo calcularRiesgo(int experiencia) {
        NivelRiesgo riesgo = calcularRiesgoGeneral(experiencia);
        if (experiencia < 5) {
            riesgo = NivelRiesgo.ALTO;
        }
        return riesgo;
    }

    @Override
    public double calcularDepreciacion() {
        double edad = 2025 - getAnyoFabricacion();
        double depreciacionEdad = Math.pow(0.9, edad);
        double depreciacionKm = getKilometraje() * 0.6;
        double valorActual = getPrecio() * depreciacionEdad * (1 - depreciacionKm / 10000);
        return valorActual;
    }
}
