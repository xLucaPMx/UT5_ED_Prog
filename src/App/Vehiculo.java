package App;

public abstract class Vehiculo implements Valorable{

    private String matricula;
    private String marca;
    private String modelo;
    private int anyoFabricacion;
    private double kilometraje;
    private double precio;
    private Estado estado;
    private Persona titular;

    public Vehiculo(String matricula, String marca, String modelo, int anyoFabricacion, double kilometraje, double precio, Estado estado, Persona titular) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anyoFabricacion = anyoFabricacion;
        this.kilometraje = kilometraje;
        this.precio = precio;
        this.estado = estado;
        this.titular = titular;
    }
    protected NivelRiesgo calcularRiesgoGeneral(int experiencia) {
        if (experiencia < 3) {
            return NivelRiesgo.ALTO;
        } else if (experiencia <= 10) {
            return NivelRiesgo.MEDIO;
        } else {
            return NivelRiesgo.BAJO;
        }
    }
    public abstract NivelRiesgo calcularRiesgo(int experiencia);

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnyoFabricacion() {
        return anyoFabricacion;
    }

    public void setAnyoFabricacion(int anyoFabricacion) {
        this.anyoFabricacion = anyoFabricacion;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }
}
