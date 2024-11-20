package modelos;

public class Jugador {
  private String nombre;
  private Equipo equipo;

  public Jugador(){
  }
  public Jugador(String nombre) {
    this.nombre = nombre;
    this.equipo = null;
  }

  public Jugador(String nombre, Equipo equipo) {
    this.nombre = nombre;
    this.equipo = equipo;
  }

  public Equipo getEquipo() {
    return equipo;
  }

  public void setEquipo(Equipo equipo) {
    this.equipo = equipo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
}
