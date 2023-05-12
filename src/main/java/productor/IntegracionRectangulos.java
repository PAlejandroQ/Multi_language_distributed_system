package productor;



public class IntegracionRectangulos {



    public static double integrar(String funcion, double a, double b, int n) throws Exception {
        double h = (b - a) / n;
        double sum = 0.0;

        FuncionParser parser = new FuncionParser();
        for (int i = 0; i < n; i++) {
            double x1 = a + i * h;
            double x2 = x1 + h;
            double fx1 = parser.evaluar(funcion, x1);
            double fx2 = parser.evaluar(funcion, x2);
            sum += fx1;
            sum += fx2;
        }

        return (h / 2) * sum;
    }
}

