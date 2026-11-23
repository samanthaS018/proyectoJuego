
package holamundo;

import processing.core.PApplet;

public class proyectoMatrices extends PApplet {

    // Cantidad de filas y columnasS
    int totalFilas = 5;
    int totalColumnas = 5;
    int totalCuadros = totalFilas * totalColumnas;

    // Caracteristicas de los cuadrados
    float ANCHO = 50;
    float ALTO = 50;
    float ESQUINAS = 8;
    float SEPARACION = 10;
    float MARGEN = 20;

    // Matriz que guarda los datos de cada cuadrado
    float[][] cuadradosVal;

    public static void main(String[] args) {
        PApplet.main(proyectoMatrices.class.getName());
    }

    public void settings() {
        size(600, 600);
    }

    public void setup() {

        cuadradosVal = new float[totalCuadros][5];

        int contador = 0;
        int i = 0;

        while (i < totalFilas) {
            int j = 0;

            while (j < totalColumnas) {
            //guarda la info de cada cuadrito[5](ancho,separacion,etc)
                cuadradosVal[contador][0] =
                    MARGEN + j * (ANCHO + SEPARACION);

                cuadradosVal[contador][1] =
                    MARGEN + i * (ALTO + SEPARACION);

                cuadradosVal[contador][2] = ANCHO;
                cuadradosVal[contador][3] = ALTO;
                cuadradosVal[contador][4] = ESQUINAS;

                contador++;
                j++;
            }

            i++;
        }
    }

    public void draw() {

        background(240);

        int contador = 0;

        while (contador < totalCuadros) {

            // Dibuja cada cuadrado y revisa el mouse
            drawQuad(cuadradosVal[contador]);

            contador++;
        }
    }

    //  revisa si el mouse esta sobre el cuadrado
    public boolean mouseIsOver(float[] parametros) {

        boolean isInRangeX =
            (mouseX > parametros[0] &&
             mouseX <= parametros[0] + parametros[2]);

        boolean isInRangeY =
            (mouseY > parametros[1] &&
             mouseY <= parametros[1] + parametros[3]);

        return isInRangeX && isInRangeY;
    }

    //  decide el color y dibuja el cuadrado
    public void drawQuad(float[] parametros) {

        if (mouseIsOver(parametros)) {
            fill(255, 150, 150);
        } else {
            fill(189, 113, 113);
        }
        // info que se guardo en cuadradoVal
        rect(
            parametros[0],
            parametros[1],
            parametros[2],
            parametros[3],
            parametros[4]
        );
    }
}