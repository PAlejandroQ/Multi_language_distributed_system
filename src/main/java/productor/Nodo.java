package productor;

import java.util.concurrent.Callable;

public class Nodo implements Callable<Double> {

    private final int id;
    private final double[] intervalo;
    private final String funcion;

    private int nThreads;
    public Nodo(int id, double[] intervalo, String funcion) {
        this.id = id;
        this.intervalo = intervalo;
        this.funcion = funcion;
        this.nThreads = 3;
    }

    @Override
    public Double call() throws Exception {
        // Parsear la función
        FuncionParser parser = new FuncionParser();

        // Integrar la función en el intervalo
        IntegracionRectangulos integracion = new IntegracionRectangulos();
        double resultado = integracion.integrar(this.funcion,intervalo[0], intervalo[1],nThreads);

        // Imprimir resultado
        System.out.println("Nodo " + id + ": Resultado = " + resultado);

        return resultado;
    }

    public void ejecutarTarea() {

    }
}
