/*
TODO: Refinando la definición del tipo de variable más adecuado:
 De acuerdo a la naturaleza de los datos, procede a declarar una variable utilizando el tipo más apropiado. NO utilizar constantes.
 Declara una variable llamada mensajeBienvenida y asigna como valor "Bienvenido a Java". Asegúrate de elegir el tipo de variable más apropiado para almacenar un mensaje de texto.
 Declara una variable llamada temperaturaActual y asigna como valor "19". Selecciona el tipo de variable que permita representar la temperatura de manera precisa.
 Declara una variable llamada datoLogico y asigna como valor "true". Elige el tipo de variable adecuado para almacenar valores lógicos.
 Utiliza la función System.out.println() para imprimir cada variable declarada, concatenándola con un mensaje descriptivo que aporte contexto.
*/

public class EjercicioComplementario {
  public static void main(String[] args) {
    String mensajeBienvenida = "Bienvenido a Java";
    float temperaturaActual = 19f;
    boolean datoLogico = true;

    System.out.println(mensajeBienvenida + "la temperatura es: " + temperaturaActual + " el estado de la variable logica es  " + datoLogico);
  }
}
