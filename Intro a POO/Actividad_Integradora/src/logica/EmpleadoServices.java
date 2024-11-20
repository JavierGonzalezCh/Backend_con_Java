package logica;

import modelos.Empleado;

import java.util.ArrayList;

public class EmpleadoServices {
  public void mostrarEmpleados(ArrayList<Empleado> empleados) {
    int fila = 1;
    System.out.printf("|%-5s|%-20s|%-5s|%-15s|%-5s|%n", "Fila", "Nombre", "Edad", "Departamento", "Salario");
    System.out.println("==========================================================");

    for (Empleado empleado : empleados) {
      System.out.printf("|%-5d|%-20s|%-5d|%-15s|%-5.2f|%n", fila, empleado.getNombre(), empleado.getEdad(),
                        empleado.getDepartamento(), empleado.getSalario());
      System.out.println("==========================================================");
      fila++;
    }
  }

  public Empleado buscarEmpleado(ArrayList<Empleado> empleados, String nombre) {
    boolean empleadoEncontrado = false;
    int index = 0;

    while (!empleadoEncontrado && index < empleados.size()) {
      if (empleados.get(index).getNombre().toLowerCase().equals(nombre.toLowerCase())) {
        empleadoEncontrado = true;
      } else {
        index++;
      }
    }
    return empleadoEncontrado ? empleados.get(index) : null;
  }

  public ArrayList<Empleado> ordenarEmpleados(ArrayList<Empleado> empleados, String atributo) {
    int n = empleados.size();
    switch (atributo.toLowerCase()) {
      case "nombre":
        for (int i = 0; i < n - 1; i++) {
          for (int j = 0; j < n - i - 1; j++) {
            if (empleados.get(j).getNombre().compareTo(empleados.get(j + 1).getNombre()) > 0) {
              Empleado temp = empleados.get(j);
              empleados.set(j, empleados.get(j + 1));
              empleados.set(j + 1, temp);
            }
          }
        }
        break;
      case "departamanto":
        for (int i = 0; i < n - 1; i++) {
          for (int j = 0; j < n - i - 1; j++) {
            if (empleados.get(j).getDepartamento()
                .compareTo(empleados.get(j + 1).getDepartamento()) > 0) {
              Empleado temp = empleados.get(j);
              empleados.set(j, empleados.get(j + 1));
              empleados.set(j + 1, temp);
            }
          }
        }
        break;
      case "edad":
        for (int i = 0; i < n - 1; i++) {
          for (int j = 0; j < n - i - 1; j++) {
            if (empleados.get(j).getEdad() < empleados.get(j + 1).getEdad()) {
              Empleado temp = empleados.get(j);
              empleados.set(j, empleados.get(j + 1));
              empleados.set(j + 1, temp);
            }
          }
        }
        break;
      case "salario":
        for (int i = 0; i < n - 1; i++) {
          for (int j = 0; j < n - i - 1; j++) {
            if (empleados.get(j).getSalario() < empleados.get(j + 1).getSalario()) {
              Empleado temp = empleados.get(j);
              empleados.set(j, empleados.get(j + 1));
              empleados.set(j + 1, temp);
            }
          }
        }
        break;
      default:
        System.out.println("Atributo inválido");
        return empleados;
    }
    return empleados;
  }

  public ArrayList<Empleado> filtrarEmpleados(ArrayList<Empleado> empleados, String atributo, String valor) {
    ArrayList<Empleado> empleadosFiltrados = new ArrayList<Empleado>();
    if (atributo.equalsIgnoreCase("nombre")) {
      for (Empleado empleado : empleados) {
        if (empleado.getNombre().equalsIgnoreCase(valor)) {
          empleadosFiltrados.add(empleado);
        }
      }
    } else if (atributo.equalsIgnoreCase("departamento")) {
      for (Empleado empleado : empleados) {
        if (empleado.getDepartamento().equalsIgnoreCase(valor)) {
          empleadosFiltrados.add(empleado);
        }
      }
    } else {
      System.out.println("El atributo ingresado no es valido");
    }
    return empleadosFiltrados;
  }

  public ArrayList<Empleado> filtrarEmpleados(ArrayList<Empleado> empleados, String atributo, int valorMax,
                                              int valorMin) {
    ArrayList<Empleado> empleadosFiltrados = new ArrayList<Empleado>();
    if (atributo.equalsIgnoreCase("edad")) {
      for (Empleado empleado : empleados) {
        if (empleado.getEdad() >= valorMin && empleado.getEdad() <= valorMax) {
          empleadosFiltrados.add(empleado);
        }
      }
    } else if (atributo.equalsIgnoreCase("salario")) {
      for (Empleado empleado : empleados) {
        if (empleado.getSalario() >= valorMin && empleado.getSalario() <= valorMax) {
          empleadosFiltrados.add(empleado);
        }
      }
    } else {
      System.out.println("El atributo ingresado no es valido");
    }
    return empleadosFiltrados;
  }

  public Empleado aumentarSalario(Empleado empleado, int incremento) {
    float salarioActual = empleado.getSalario();
    float totalIncremento = salarioActual * (incremento / 100f);
    empleado.setSalario(salarioActual + totalIncremento);
    return empleado;
  }
}
