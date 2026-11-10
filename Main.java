package Interpolacion;
public class Main {
    public static void main(String[] args) {
        // Datos originales del ejercicio.
        double[] x = {0.0, 1.0, 2.0, 4.0};
        double[] y = {1.0, 4.0, 9.0, 25.0};
        // Punto que se desea interpolar.
        double xEval = 3.0;
        // METODO DE NEWTON.
        System.out.println("METODO DE NEWTON");
        double[][] tabla = InterpolacionNewton.calcularDiferenciasDivididas(x, y);
        // Imprime la matriz de diferencias divididas.
        InterpolacionNewton.imprimirTabla(x, tabla);
        // Muestra los coeficientes del polinomio.
        System.out.println("\n--- COEFICIENTES DE NEWTON ---");
        for (int i = 0; i < x.length; i++) {
            System.out.printf("a_%d = %.4f%n", i, tabla[0][i]);
        }
        // Evalua el polinomio de Newton.
        double resultadoNewton = InterpolacionNewton.evaluarPolinomio(x, tabla, xEval);
        System.out.printf("\nResultado de Newton: %.4f%n", resultadoNewton);
        // METODO DE LAGRANGE.
        System.out.println("\nMETODO DE LAGRANGE");
        double resultadoLagrange = InterpolacionLagrange.interpolacionLagrange(x, y, xEval);

        System.out.printf("Resultado de Lagrange: %.4f%n", resultadoLagrange);

        // COMPARACION DE RESULTADOS.
        System.out.println("\n--- COMPARACION DE RESULTADOS ---");
        System.out.printf("Newton: %.4f%n", resultadoNewton);

        System.out.printf("Lagrange: %.4f%n", resultadoLagrange);

        System.out.printf("Diferencia absoluta: %.10f%n", Math.abs(resultadoNewton - resultadoLagrange));
    }
}