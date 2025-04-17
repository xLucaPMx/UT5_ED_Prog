package App;

public class SUV extends Coche{

    private boolean capacidadOffroad;
    private double alturaLibreSuelo;
    protected Traccion traccion;

    public SUV(String matricula, String marca, String modelo, int anyoFabricacion, double kilometraje, double precio, Estado estado, Persona titular, int numPuertas, TipoCombustible combustible, int capacidadMaletero, Traccion traccion, boolean capacidadOffroad, double alturaLibreSuelo) {
        super(matricula, marca, modelo, anyoFabricacion, kilometraje, precio, estado, titular, numPuertas, combustible, capacidadMaletero, traccion);
        this.capacidadOffroad = capacidadOffroad;
        this.alturaLibreSuelo = alturaLibreSuelo;
    }

    public Traccion getTraccion() {
        return traccion;
    }

    public void setTraccion(Traccion traccion) {
        this.traccion = traccion;
    }

    @Override
    public NivelRiesgo calcularRiesgo(int experiencia) {
        NivelRiesgo riesgo = calcularRiesgoGeneral(experiencia);

        if (getTraccion() == Traccion.CUATRO_X_CUATRO && experiencia >= 3){
            riesgo = NivelRiesgo.BAJO;
        }
        return riesgo;
    }

    @Override
    public double calcularDepreciacion() {
        double edad = 2025 - getAnyoFabricacion();
        double depreciacionEdad = Math.pow(0.85, edad);
        double depreciacionKm;
        if (getTraccion() == Traccion.CUATRO_X_CUATRO){
            depreciacionKm = 1.05;
        }else {
            depreciacionKm = 0.75;
        }
        double factorDepreciacion = getKilometraje() * depreciacionKm / 10000;
        double valorActual = getPrecio() * depreciacionEdad * (1 - factorDepreciacion);
        return valorActual;
    }
}
