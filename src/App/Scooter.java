package App;

public class Scooter extends Motocicleta{

    private int espacioBajoAsiento;

    public Scooter(String matricula, String marca, String modelo, int anyoFabricacion, double kilometraje, double precio, Estado estado, Persona titular, int cilindrada, int peso, double alturaAsiento, TipoTransmision tipoTransmision, int espacioBajoAsiento) {
        super(matricula, marca, modelo, anyoFabricacion, kilometraje, precio, estado, titular, cilindrada, peso, alturaAsiento, tipoTransmision);
        this.espacioBajoAsiento = espacioBajoAsiento;
    }

    @Override
    public NivelRiesgo calcularRiesgo(int experiencia) {
        NivelRiesgo riesgo = calcularRiesgoGeneral(experiencia);

        if (experiencia < 5){
            riesgo = NivelRiesgo.ALTO;
        }
        return riesgo;
    }

    @Override
    public double calcularDepreciacion() {
        double edad = 2025 - getAnyoFabricacion();
        double depreciacionEdad = Math.pow(0.85, edad);
        double depreciacionKm = getKilometraje() * 1.2 / 10000;
        double valorActual = getPrecio() * depreciacionEdad * (1 - depreciacionKm);
        return valorActual;
    }
}
