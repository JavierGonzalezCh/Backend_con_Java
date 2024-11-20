package modelos;

public class Empleado {
  private String nombre;
  private int edad;
  private float salario;
  private String departamento;

  public Empleado() {
  }

  public Empleado(String nombre, int edad, float salario, String departamento) {
    this.nombre = nombre;
    this.edad = edad;
    this.salario = salario;
    this.departamento = departamento;
  }

  @Override
  public String toString() {
    return String.format("Nombre: %s Edad: %d Departamento: %s Salario: %.2f%n",
                         this.nombre,
                         this.edad,
                         this.departamento,
                         this.salario);
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public float getSalario() {
    return salario;
  }

  public void setSalario(float salario) {
    this.salario = salario;
  }

  public String getDepartamento() {
    return departamento;
  }

  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }
}
