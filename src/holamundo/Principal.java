package holamundo;

public class Principal {
    public static void main(String[] args) {
        Funciones.saludar();

        int resultado = Funciones.sumar(5, 3);

        System.out.println("El resultado es: " + resultado);
    }
}