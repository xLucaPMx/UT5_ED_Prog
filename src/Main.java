import App.*;
import utils.Validar;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Concesionario concesionario = new Concesionario();

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {

            mostrarMenu();

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarVehiculo();
                    break;
                case 2:
                    listarVehiculos();
                    break;
                case 3:
                    System.out.println("Introduce el modelo: ");
                    String modelo = scanner.nextLine();
                    buscarVehiculo(modelo);
                    break;
                case 4:
                    System.out.println("Introduce el modelo: ");
                    String modeloVenta = scanner.nextLine();
                    venderVehiculo(modeloVenta);
                    break;
                case 5:
                    System.out.println("DNI del Titular: ");
                    String idTitular = scanner.nextLine();
                    System.out.println("Modelo del vehículo: ");
                    String modeloVehiculo = scanner.nextLine();
                    asignarVehiculo(idTitular, modeloVehiculo);
                    break;
                case 6:
                    registrarTitular();
                    break;
                case 7:
                    salir = true;
                    System.out.println("¡Adiós!");
                    break;
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("1. Registrar Vehículo");
        System.out.println("2. Listar Vehículos");
        System.out.println("3. Buscar vehículo");
        System.out.println("4. Vender vehículo");
        System.out.println("5. Asignar vehículo");
        System.out.println("6. Registrar titular");
        System.out.println("7. Salir");
        System.out.println("¿Qué quieres hacer?");
    }

    public static void registrarVehiculo() {
        String marca, modelo, matricula;
        int anyoFabricacion;
        double precio, kilometraje;

        System.out.println("Tipo de Vehículo (TURISMO, MOTOCICLETA, CAMION): ");
        String tipo = scanner.nextLine().toUpperCase();
        TipoVehiculo tipoVehiculo;

        try {
            tipoVehiculo = TipoVehiculo.valueOf(tipo.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo no válido");
            return;
        }
        do {
            System.out.println("Matrícula: ");
            matricula = scanner.nextLine();
        } while (!Validar.validarMatricula(matricula));
        System.out.println("Marca: ");
        marca = scanner.nextLine();
        System.out.println("Modelo: ");
        modelo = scanner.nextLine();
        System.out.println("Año de fabricación: ");
        anyoFabricacion = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Kilometraje; ");
        kilometraje = scanner.nextDouble();
        System.out.println("Precio del vehículo: ");
        precio = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Vehiculos.Estado del vehículo (DISPONIBLE/VENDIDO): ");
        String estadoVehiculo = scanner.nextLine();
        Estado estado;
        try {
            estado = Estado.valueOf(estadoVehiculo.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Vehiculos.Estado del vehículo no válido");
            return;
        }

        Persona titular = registrarTitular();

        Vehiculo vehiculo = null;

        switch (tipoVehiculo) {
            case TURISMO:
                System.out.println("Número de puertas: ");
                int numPuertas = scanner.nextInt();
                scanner.nextLine();
                vehiculo = new Coche(matricula, marca, modelo, anyoFabricacion, kilometraje, precio, estado, titular, numPuertas);
                break;
            case MOTOCICLETA:
                System.out.println("Cilindrada: ");
                int cc = scanner.nextInt();
                scanner.nextLine();
                vehiculo = new Motocicleta(matricula, marca, modelo, anyoFabricacion, kilometraje, precio, estado, titular, cc);
                break;
            case CAMION:
                System.out.println("Toneladas: ");
                double toneladas = scanner.nextDouble();
                scanner.nextLine();
                vehiculo = new Camion(matricula, marca, modelo, anyoFabricacion, kilometraje, precio, estado, titular, toneladas);
                break;
        }

        if (vehiculo != null) {
            concesionario.registrarVehiculo(vehiculo);
            System.out.println("Vehículo registrado");
        }
    }

    public static void listarVehiculos() {
        for (Vehiculo v : concesionario.getVehiculos()) {
            System.out.println(v.toString());
        }
    }

    public static Vehiculo buscarVehiculo(String modelo) {
        Vehiculo vehiculoEncontrado = null;
        if (concesionario.getVehiculos().isEmpty()) {
            System.out.println("El concesionario está vacío.");
        }
        for (Vehiculo v : concesionario.getVehiculos()) {
            if (modelo.equals(v.getModelo())) {
                vehiculoEncontrado = v;
                System.out.println(v);
            }
        }
        if (vehiculoEncontrado == null) {
            System.out.println("No hay vehículos registrados asociados a ese modelo");
        }
        return vehiculoEncontrado;
    }

    public static boolean venderVehiculo(String modelo) {
        boolean vehiculoEncontrado = false;
        Vehiculo vehiculoVenta = null;

        for (Vehiculo v : concesionario.getVehiculos()) {
            if (v.getModelo().equals(modelo)) {
                vehiculoEncontrado = true;
            }
        }
        if (vehiculoEncontrado) {
            concesionario.getVehiculos().remove(vehiculoVenta);
            System.out.println("Vehículo vendido");
        } else {
            System.out.println("Vehículo no encontrado");
        }
        return vehiculoEncontrado;
    }

    public static void asignarVehiculo(String dni, String modelo) {
        boolean valido = true;
        if (concesionario.getVehiculos().isEmpty()) {
            System.out.println("No hay vehículos registrados");
            valido = false;
        }
        Vehiculo vehiculoEncontrado = buscarVehiculo(modelo);
        if (vehiculoEncontrado == null) {
            System.out.println("Vehículo no encontrado");
            valido = false;
        }
        Persona titular = concesionario.buscarTitular(dni);
        if (titular == null) {
            System.out.println("Titular no encontrado");
            valido = false;
        }
        if (valido) {
            vehiculoEncontrado.setTitular(titular);
            System.out.println("Vehículo asignado al titular");
        }
    }

    public static Persona registrarTitular() {
        String nombre, apellidos, dni, fechaCaducidad;
        int anyoNacimiento;

        System.out.println("Nombre: ");
        nombre = scanner.nextLine();
        System.out.println("Apellidos: ");
        apellidos = scanner.nextLine();

        do {
            System.out.println("DNI: ");
            dni = scanner.nextLine();
            if (!Validar.validarDNI(dni)) {
                System.out.println("Error en los datos introducidos");
            }
        } while (!Validar.validarDNI(dni));

        System.out.println("Fecha de caducidad (DD-MM-YYYY): ");
        fechaCaducidad = scanner.nextLine();
        System.out.println("Año de nacimiento: ");
        anyoNacimiento = scanner.nextInt();

        Persona persona = new Persona(nombre, apellidos, dni, fechaCaducidad, anyoNacimiento);
        System.out.println("¡Titular registrado!");
        return persona;
    }
}