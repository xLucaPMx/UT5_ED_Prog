package App;

public abstract class Coche extends Vehiculo{

    private int numPuertas;
    private TipoCombustible combustible;
    private int capacidadMaletero;
    private Traccion traccion;

    public Coche(String matricula, String marca, String modelo, int anyoFabricacion, double kilometraje, double precio, Estado estado, Persona titular, int numPuertas, TipoCombustible combustible, int capacidadMaletero, Traccion traccion) {
        super(matricula, marca, modelo, anyoFabricacion, kilometraje, precio, estado, titular);
        this.numPuertas = numPuertas;
        this.combustible = combustible;
        this.capacidadMaletero = capacidadMaletero;
        this.traccion = traccion;
    }

    @Override
    public NivelRiesgo calcularRiesgo(int experiencia) {
        return calcularRiesgoGeneral(experiencia);
    }
}
