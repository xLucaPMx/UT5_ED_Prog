package App;

public class Persona {

    private String nombre;
    private String apellidos;
    private String dni;
    private String fechaCaducidad;
    private int anyioNacimiento;

    public Persona(String nombre, String apellidos, String dni, String fechaCaducidad, int anyioNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaCaducidad = fechaCaducidad;
        this.anyioNacimiento = anyioNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getAnyioNacimiento() {
        return anyioNacimiento;
    }

    public void setAnyioNacimiento(int anyioNacimiento) {
        this.anyioNacimiento = anyioNacimiento;
    }


}
