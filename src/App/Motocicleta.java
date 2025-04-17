package App;

public abstract class Motocicleta extends Vehiculo{

    private int cilindrada;
    private int peso;
    private double alturaAsiento;
    private TipoTransmision tipoTransmision;

    public Motocicleta(String matricula, String marca, String modelo, int anyoFabricacion, double kilometraje, double precio, Estado estado, Persona titular, int cilindrada, int peso, double alturaAsiento, TipoTransmision tipoTransmision) {
        super(matricula, marca, modelo, anyoFabricacion, kilometraje, precio, estado, titular);
        this.cilindrada = cilindrada;
        this.peso = peso;
        this.alturaAsiento = alturaAsiento;
        this.tipoTransmision = tipoTransmision;
    }
}
