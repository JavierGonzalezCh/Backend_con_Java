import modelos.Equipo;
import modelos.Jugador;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  private static ArrayList<Equipo> equipos = new ArrayList<Equipo>();
  private static ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int opcion = 0;
    do {
      System.out.println("Elige una opción:");
      System.out.println("1. Crear Jugador");
      System.out.println("2. Crear Equipo");
      System.out.println("3. Asignar Jugador a Equipo");
      System.out.println("4. Mostrar lista de jugadores");
      System.out.println("5. Mostrar lista de equipos");
      System.out.println("6. Salir");
      opcion = Integer.valueOf(sc.nextLine());
      sc.nextLine();

      switch (opcion) {
        case 1:
          crearJugador(sc);
          break;
        case 2:
          crearEquipo(sc);
          break;
        case 3:
          asignarJugadorAEquipo(sc);
          break;
        case 4:
          mostrarJugadores();
          break;
        case 5:
          mostrarEquipos();
          break;
        case 6:
          System.out.println("Finalizar programa");
          break;
        default:
          System.out.println("Opcion invalida");
          break;
      }
    } while (opcion != 6);
  }

  public static void crearJugador(Scanner sc) {
    System.out.println("Ingrese el nombre del jugador:");
    String nombre = sc.nextLine();
    if(equipos.isEmpty()){
      System.out.println("No equipos disponibles");
      Jugador jugador = new Jugador(nombre);
      jugadores.add(jugador);
    } else {
      mostrarEquipos();
      System.out.println("Elije el equipo: ");
      String nombre_equipo = sc.nextLine();
      Equipo equipo = buscarEquipo(nombre_equipo);
      Jugador jugador = new Jugador(nombre, equipo);
      jugadores.add(jugador);
    }
  }

  public static void crearEquipo(Scanner sc) {
    System.out.println("Ingrese el nombre del equipo:");
    String nombre = sc.nextLine();
    Equipo equipo = new Equipo(nombre);
    equipos.add(equipo);
  }

  public static void mostrarEquipos() {
    if(equipos.isEmpty()){
      System.out.println("No equipos disponibles");
    } else {
      for ( Equipo equipo : equipos ){
        System.out.println(equipo.getNombre());
      }
    }
  }

  public static void mostrarJugadores() {
    if(jugadores.isEmpty()){
      System.out.println("No jugadores disponibles");
    } else {
      for ( Jugador jugador : jugadores ){
        System.out.print(jugador.getNombre() + " -- ");
        if (jugador.getEquipo() != null) {
          System.out.println(jugador.getEquipo().getNombre());
        } else {
          System.out.println("Sin Equipo");
        }
      }
    }
  }

  public static Equipo buscarEquipo(String nombre) {
    for (int i = 0; i < equipos.size(); i++) {
      if (equipos.get(i).getNombre().equals(nombre)) {
        return equipos.get(i);
      }
    }
    return null;
  }

  public static Jugador buscarJugador(String nombre) {
    for (int i = 0; i < jugadores.size(); i++) {
      if (jugadores.get(i).getNombre().equals(nombre)) {
        return jugadores.get(i);
      }
    }
    return null;
  }

  public static void asignarJugadorAEquipo(Scanner sc) {
    mostrarJugadores();
    System.out.println("Seleccione un jugador:");
    String nombreJugador = sc.nextLine();
    Jugador jugador = buscarJugador(nombreJugador);
    mostrarEquipos();
    System.out.println("Ingrese el nombre del equipo:");
    String nombreEquipo = sc.nextLine();
    Equipo equipo = buscarEquipo(nombreEquipo);
    if(equipo == null || jugador == null){
      System.out.println("El jugador o el equipo no existe");
    } else {
      jugador.setEquipo(equipo);
      System.out.println("El jugador: " + jugador.getNombre() + " fue asignado al equipo " + equipo.getNombre());
    }
  }
}