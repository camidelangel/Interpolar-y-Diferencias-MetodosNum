# Práctica: Interpolación de Lagrange vs. Diferencias Divididas de Newton

## Descripción general del proyecto

El presente proyecto tiene como objetivo implementar y comparar dos métodos numéricos utilizados para la 
interpolación de datos: el método de **Interpolación de Lagrange** y el método de **Diferencias Divididas de Newton**.

Ambos métodos permiten construir un polinomio de interpolación a partir de un conjunto de puntos conocidos, 
con la finalidad de calcular un valor aproximado para una posición en la que no se cuenta con un dato directamente. 
Para realizar esta práctica se desarrollaron dos clases en Java, una para cada método, además de una clase principal encargada de ejecutar 
los procedimientos y mostrar los resultados en consola.

El programa utiliza un mismo conjunto de datos para ambos métodos, lo que permite comprobar que, aunque los 
procedimientos matemáticos son diferentes, los dos pueden obtener el mismo polinomio de interpolación y producir resultados equivalentes 
al evaluar un mismo punto.

También se incluye la construcción de la tabla de diferencias divididas de Newton, donde se muestran los 
coeficientes necesarios para formar el polinomio. De esta manera, el proyecto permite observar el funcionamiento de 
cada algoritmo, comparar sus resultados y analizar sus diferencias en cuanto al procedimiento y esfuerzo computacional.


## Estructura del proyecto

```text
Interpolacion/
│
├── InterpolacionLagrange.java
├── InterpolacionNewton.java
├── Main.java
└── README.md
```

## Descripción de las clases

### 1. InterpolacionLagrange.java

Contiene la implementación del método de interpolación de Lagrange.
Su función principal es calcular el polinomio utilizando los puntos proporcionados y evaluar el resultado en un valor específico de x.

Se corrigió la operación del término de Lagrange para que se realice correctamente el producto de los factores:

```java
termino *= (xEval - x[j]) / (x[i] - x[j]);
```

Además, se consideran validaciones para evitar arreglos vacíos, tamaños diferentes y valores repetidos en las coordenadas x.

### 2. InterpolacionNewton.java

Contiene la implementación del método de diferencias divididas de Newton. 
Esta clase construye la tabla de diferencias divididas, obtiene los coeficientes del polinomio y realiza su evaluación en el punto indicado.

También permite imprimir la tabla en consola para observar cómo se calculan las diferencias divididas de primer, segundo y tercer orden.

### 3. Main.java

Es la clase principal del programa. Se encarga de definir los datos de entrada, 
establecer el valor donde se desea evaluar el polinomio, ejecutar ambos métodos y mostrar los resultados obtenidos para realizar la comparación.

## Datos de prueba

Para realizar las pruebas se utilizaron los siguientes puntos:

| Punto | x | y |
|---|---:|---:|
| 1 | 0.0 | 1.0 |
| 2 | 1.0 | 4.0 |
| 3 | 2.0 | 9.0 |
| 4 | 4.0 | 25.0 |

El valor que se desea calcular es:

```java
double xEval = 3.0;
```

Los datos corresponden a la función:

\[
f(x)=(x+1)^2
\]

Por lo tanto, el resultado esperado al evaluar en x = 3 es 16.

## Tabla de diferencias divididas de Newton

Al utilizar los datos anteriores, se obtiene la siguiente tabla:

| x | f(x) | Primera diferencia | Segunda diferencia | Tercera diferencia |
|---:|---:|---:|---:|---:|
| 0.0 | 1.0 | 3.0 | 1.0 | 0.0 |
| 1.0 | 4.0 | 5.0 | 1.0 | |
| 2.0 | 9.0 | 8.0 | | |
| 4.0 | 25.0 | | | |

Los coeficientes obtenidos para el polinomio de Newton son:

```text
1.0, 3.0, 1.0, 0.0
```

El polinomio resultante es:

\[
P(x)=1+3x+x(x-1)
\]

Al simplificar:

\[
P(x)=x^2+2x+1
\]

## Resultados obtenidos

Al evaluar ambos métodos en x = 3, se obtienen los siguientes resultados:

| Método | Resultado |
|---|---:|
| Interpolación de Lagrange | 16.0000 |
| Diferencias Divididas de Newton | 16.0000 |
| Diferencia entre resultados | 0.0000 |

Los dos métodos proporcionan el mismo resultado, lo que permite comprobar que ambos
procedimientos construyen el mismo polinomio interpolante para los datos utilizados.

## Análisis 

- **Lagrange:** La evaluación mediante los ciclos anidados presenta una complejidad de \(O(n^2)\).
- **Newton:** La construcción de la tabla de diferencias divididas presenta una complejidad de \(O(n^2)\).
  Una vez obtenidos los coeficientes, la evaluación del polinomio tiene una complejidad de \(O(n)\).

Una ventaja del método de Newton es que permite incorporar nuevos puntos aprovechando los coeficientes anteriores, 
sin tener que reconstruir todo el polinomio desde cero.

## Cómo ejecutar el proyecto

1. Descargar o clonar el repositorio.
2. Abrir los archivos `.java` en un entorno de desarrollo compatible con Java.
3. Verificar que las tres clases se encuentren dentro del mismo proyecto.
4. Ejecutar el archivo `Main.java`.
5. Observar en la consola la tabla de diferencias divididas y los resultados de ambos métodos.

## Conclusión

La realización de esta práctica permitió comprender cómo funcionan los métodos de interpolación de Lagrange y diferencias divididas de Newton, así como su aplicación para encontrar valores a partir de puntos conocidos.

También se comprobó que ambos métodos pueden obtener el mismo resultado, aunque utilizan procedimientos diferentes. Finalmente, se identificó que Newton ofrece una ventaja cuando se agregan nuevos puntos, ya que permite aprovechar los coeficientes calculados anteriormente.

---
## Datos
Métodos Numéricos  

Interpolación de Lagrange vs. Diferencias Divididas de Newton  

Camila amor del angel cervantes 
