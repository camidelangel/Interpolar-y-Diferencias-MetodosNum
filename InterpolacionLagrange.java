package Interpolacion;

public class InterpolacionLagrange {
    // Valida que los arreglos contengan datos correctos.
    private static void validarDatos(double[] x, double[] y) {

        if (x == null || y == null || x.length == 0 || y.length == 0) {
            throw new IllegalArgumentException("Los arreglos no pueden ser nulos ni estar vacios.");
        }

        if (x.length != y.length) {
            throw new IllegalArgumentException("Los arreglos x y y deben tener el mismo tamano.");
        }
         // Verifica que no existan nodos repetidos.
        for (int i = 0; i < x.length; i++) {
            for (int j = i + 1; j < x.length; j++) {

                if (x[i] == x[j]) {

                    throw new IllegalArgumentException("Nodos de x repetidos: " + x[i]);
                }
            }
        }
    }

    // Calcula la interpolacion mediante el metodo de Lagrange.
    public static double interpolacionLagrange(double[] x, double[] y, double xEval) {
        validarDatos(x, y);
        double resultado = 0.0;
        int n = x.length;
        // Recorre cada nodo.
        for (int i = 0; i < n; i++) {
            double termino = y[i];
            // Calcula el producto del polinomio base.
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    // Formula corregida de la productoria Li(x).
                    termino *= (xEval - x[j]) / (x[i] - x[j]);
                }
            }
            // Acumula cada termino del polinomio.
            resultado += termino;
        }
        return resultado;
    }
}
