package productor;

import java.util.ArrayList;
import java.util.List;

public class Productor {

    public static void main(String[] args) {

        // Parametros de entrada
        String funcion = "7*x^1 + 8*x^2";
        double a = 5;
        double b = 10;
        int segmentos = 1000;

        // Generar los intervalos para cada nodo
        List<double[]> intervalos = generarIntervalos(a, b, segmentos);

        // Enviar tarea a los nodos
        for (int i = 0; i < intervalos.size(); i++) {
            Nodo nodo = new Nodo(i + 1, intervalos.get(i), funcion);
            nodo.ejecutarTarea();
        }
    }

    private static List<double[]> generarIntervalos(double a, double b, int segmentos) {
        List<double[]> intervalos = new ArrayList<>();

        double delta = (b - a) / segmentos;
        double x0 = a;

        for (int i = 0; i < segmentos; i++) {
            double x1 = x0 + delta;
            intervalos.add(new double[]{x0, x1});
            x0 = x1;
        }

        return intervalos;
    }
}
