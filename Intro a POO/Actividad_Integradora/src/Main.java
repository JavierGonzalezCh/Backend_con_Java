import logica.EmpleadoServices;
import modelos.Empleado;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  private static final EmpleadoServices empleadoServices = new EmpleadoServices();

  public static void main(String[] args) {
    ArrayList<Empleado> empleados = new ArrayList<>();
    ArrayList<Empleado> empleadosFiltrados = new ArrayList<>();

    empleados.add(new Empleado("Juan", 30, 2500f, "Desarrollo"));
    empleados.add(new Empleado("Ana", 25, 2000f, "Diseño"));
    empleados.add(new Empleado("Luis", 35, 3500f, "Gerencia"));

    menu(empleados, empleadosFiltrados);
  }

  private static void menu(ArrayList<Empleado> empleados, ArrayList<Empleado> empleadosFiltrados) {
    Scanner sc = new Scanner(System.in);
    int opcion;

    do {
      System.out.println("Ingresa el número correspondiente a la opción deseada:");
      System.out.println("1. Mostrar todos los empleados");
      System.out.println("2. Crear empleado");
      System.out.println("3. Filtrar empleados");
      System.out.println("4. Ordenar empleados");
      System.out.println("5. Incrementar salario");
      System.out.println("6. Limpiar Filtros");
      System.out.println("7. Salir");
      opcion = sc.nextInt();
      sc.nextLine();

      switch (opcion) {
        case 1:
          if (empleadosFiltrados.isEmpty()) {
            empleadoServices.mostrarEmpleados(empleados);
          } else {
            empleadoServices.mostrarEmpleados(empleadosFiltrados);
          }
          break;

        case 2:
          crearEmpleado(sc, empleados);
          break;

        case 3:
          buscarEmpleado(sc, empleados);
          break;

        case 4:
          System.out.println("Ingrese el criterio de ordenación (nombre, salario, edad, departamento):");
          String criterioOrden = sc.nextLine();
          empleadosFiltrados = new ArrayList<>(empleados);
          empleadoServices.mostrarEmpleados(empleadoServices.ordenarEmpleados(empleadosFiltrados, criterioOrden));
          break;

        case 5:
          incrementarSalario(sc, empleados);
          break;

        case 6:
          empleadosFiltrados = new ArrayList<>(empleados);
          System.out.println("Filtros limpiados. Mostrando todos los empleados:");
          empleadoServices.mostrarEmpleados(empleadosFiltrados);
          break;

        case 7:
          System.out.println("Saliendo del sistema...");
          break;

        default:
          System.out.println("Opción no válida, intente nuevamente.");
          break;
      }
      System.out.println();
    } while (opcion != 7);

    sc.close();
  }

  private static void crearEmpleado(Scanner sc, ArrayList<Empleado> empleados) {
    System.out.println("Ingresa el nombre del empleado: ");
    String nombre = sc.nextLine();
    if (empleadoServices.buscarEmpleado(empleados, nombre) == null) {
      System.out.println("Ingresa el edad del empleado: ");
      int edad = sc.nextInt();
      System.out.println("Ingresa el departamento del empleado: ");
      sc.nextLine();
      String departamento = sc.nextLine();
      System.out.println("Ingresa el salario del empleado: ");
      float salario = sc.nextFloat();
      Empleado empleado = new Empleado(nombre, edad, salario, departamento);
      empleados.add(empleado);
      System.out.println("Empleado creado correctamente");
      System.out.println(empleado.toString());
    } else {
      System.out.println("Ya existe un empleado con ese nombre");
    }
  }

  private static void buscarEmpleado(Scanner sc, ArrayList<Empleado> empleados) {
    System.out.println("Ingrese el criterio de filtro (nombre, salario, edad, departamento):");
    String criterioFiltro = sc.nextLine();
    switch (criterioFiltro.toLowerCase()) {
      case "nombre", "departamento":
        System.out.println("Ingrese el " + criterioFiltro.toLowerCase() + ":");
        String valorFiltro = sc.nextLine();
        empleadoServices.mostrarEmpleados(empleadoServices.filtrarEmpleados(empleados, criterioFiltro, valorFiltro));
        break;
      case "salario", "edad":
        System.out.println("Ingrese el" + criterioFiltro.toLowerCase() + "mínimo:");
        int valorMin = sc.nextInt();
        System.out.println("Ingrese el" + criterioFiltro.toLowerCase() + "maximo:");
        int valorMax = sc.nextInt();
        sc.nextLine();
        empleadoServices
            .mostrarEmpleados(empleadoServices.filtrarEmpleados(empleados, criterioFiltro, valorMax, valorMin));
        break;
      default:
        System.out.println("Criterio de filtro no válido.");
        break;
    }
  }

  private static void incrementarSalario(Scanner sc, ArrayList<Empleado> empleados) {
    System.out.println("Ingrese el nombre del empleado para incrementar su salario:");
    String nombreEmpleado = sc.nextLine();
    System.out.println("Ingrese el porcentaje de incremento:");
    int incremento = sc.nextInt();
    sc.nextLine();
    Empleado empleado = empleadoServices.buscarEmpleado(empleados, nombreEmpleado);
    if (empleado != null) {
      empleadoServices.aumentarSalario(empleado, incremento);
      System.out.println("Salario incrementado exitosamente.");
    } else {
      System.out.println("Empleado no encontrado.");
    }
  }
}