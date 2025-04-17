package App;

public class Deportivo extends Coche{

    private double aceleracion0a100;
    private int potenciaCV;
    private boolean tieneModoPista;

    public Deportivo(String matricula, String marca, String modelo, int anyoFabricacion, double kilometraje, double precio, Estado estado, Persona titular, int numPuertas, TipoCombustible combustible, int capacidadMaletero, Traccion traccion, double aceleracion0a100, int potenciaCV, boolean tieneModoPista) {
        super(matricula, marca, modelo, anyoFabricacion, kilometraje, precio, estado, titular, numPuertas, combustible, capacidadMaletero, traccion);
        this.aceleracion0a100 = aceleracion0a100;
        this.potenciaCV = potenciaCV;
        this.tieneModoPista = tieneModoPista;
    }

    @Override
    public NivelRiesgo calcularRiesgo(int experiencia) {
        NivelRiesgo riesgo = calcularRiesgoGeneral(experiencia);

        if (experiencia < 5 && potenciaCV > 400){
            riesgo = NivelRiesgo.ALTO;
        }
        return riesgo;
    }

    @Override
    public double calcularDepreciacion() {
        double edad = 2025 - getAnyoFabricacion();
        double depreciacionEdad = Math.pow(0.85, edad);
        double depreciacionKm;
        if (potenciaCV > 400){
            depreciacionKm = 1.1;
        }else {
            depreciacionKm = 0.9;
        }
        double factorKm = getKilometraje() * depreciacionKm / 10000;
        double valorActual = getPrecio() * depreciacionEdad * (1 - factorKm);
        return valorActual;
    }
}
