import App.NivelRiesgo;
import App.Persona;
import App.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Concesionario {

    private List<Vehiculo> vehiculos;
    private static final int MAX_VEHICULOS = 100;

    public Concesionario() {
        this.vehiculos = new ArrayList<>();
    }

    public NivelRiesgo calcularRiesgo(int anyosExperiencia) {
        NivelRiesgo riesgo = NivelRiesgo.BAJO;

        if (anyosExperiencia < 3) {
            riesgo = NivelRiesgo.ALTO;
        } else if (anyosExperiencia <= 10) {
            riesgo = NivelRiesgo.MEDIO;
        }
        return riesgo;
    }

    public boolean registrarVehiculo(Vehiculo vehiculo) {
        boolean registro = false;
        if (vehiculos.size() < MAX_VEHICULOS) {
            vehiculos.add(vehiculo);
            registro = true;
        }
        return registro;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public Persona buscarTitular(String dni) {
        Persona titularEncontrado = null;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getTitular().getDni().equals(dni)) {
                titularEncontrado = vehiculo.getTitular();
            }
        }
        return titularEncontrado;
    }
}


