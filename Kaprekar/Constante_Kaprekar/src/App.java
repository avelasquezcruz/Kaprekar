/*
 * Exercicio 1. O matemático indio Ramchandra Kaprekar descubriu en 1949 unha curiosa característica do número 6174. 
 * Este número coñécese como constante de Kaprekar na súa honra.

Este número ten a seguinte propiedade:

    Elixe un número de catro díxitos que teña polo menos dous diferentes (é valido colocar o díxito 0 ao principio, polo que o número 0009 é válido).

    Coloca os seus díxitos en orde ascendente e en orde descendente para formar dous novos números. Podes engadir os díxitos 0 que necesites ao principio.

    Resta o menor ao maior.

    Volve ao paso 2.

Este proceso coñécese como a rutina Kaprekar, e sempre chegará ao número 6174 en coma moito 7 iteracións. 
Unha vez que o resultado da operación do paso 3 de ese número, o proceso parará.

Por exemplo, o número 3542 alcanzará a constante de Kaprekar en 3 iteracións:

5432 − 2345 = 3087
8730 − 0378 = 8352
8532 − 2358 = 6174

Os únicos díxitos de catro cifras para os que a rutina non alcanza este número son os repdigits, 
é dicir, aqueles nas que as súas catro cifras son iguais (como 1111), pois na primeira iteración alcanzarase o valor 0 e xa non se pode saír del. 
Por iso se pide no paso 1 explicitamente que o número inicial tivera polo menos dous díxitos diferentes.

Aquí tes dous exemplos máis:

2111 − 1112 = 0999
9990 − 0999 = 8991
9981 − 1899 = 8082
8820 − 0288 = 8532
8532 − 2358 = 6174


9831 − 1389 = 8442
8442 − 2448 = 5994
9954 − 4599 = 5355
5553 − 3555 = 1998
9981 − 1899 = 8082
8820 − 0288 = 8532
8532 − 2358 = 6174

Pídese un programa que reciba un número e indique o número de iteracións necesarias para calcular a constante de Kaprekar.
 Para os números repdigits deberase indicar -1, e se se introduce a constante de Kaprekar deberase indicar o número 0.
 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca un número de cuatro dígitos: ");
        int n = scanner.nextInt();

        if (esRepdigit(n)) {
            System.out.println("El número es un repdigit. Resultado: -1");
            return;
        }

        if (n == 6174) {
            System.out.println("El número ya es la constante de Kaprekar. Iteraciones: 0");
            return;
        }

        int iteraciones = 0;
        while (n != 6174) {
            iteraciones++;
            int menor = ordenarAscendente(n);
            int mayor = ordenarDescendente(n);
            n = mayor - menor;
            System.out.println(mayor + " - " + menor + " = " + n);
        }

        System.out.println("Número de iteraciones: " + iteraciones);
    }

    private static boolean esRepdigit(int n) {
        int primerDigito = n % 10;
        for (int i = 0; i < 3; i++) {
            n /= 10;
            if (n % 10 != primerDigito) {
                return false;
            }
        }
        return true;
    }

    private static int ordenarAscendente(int n) {
        int[] digitos = extraerDigitos(n);
        ordenar(digitos, true);
        return reconstruirNumero(digitos);
    }

    private static int ordenarDescendente(int n) {
        int[] digitos = extraerDigitos(n);
        ordenar(digitos, false);
        return reconstruirNumero(digitos);
    }

    private static int[] extraerDigitos(int n) {
        int[] digitos = new int[4];
        for (int i = 3; i >= 0; i--) {
            digitos[i] = n % 10;
            n /= 10;
        }
        return digitos;
    }

    private static void ordenar(int[] digitos, boolean ascendente) {
        for (int i = 0; i < digitos.length - 1; i++) {
            for (int j = 0; j < digitos.length - i - 1; j++) {
                if ((ascendente && digitos[j] > digitos[j + 1]) || (!ascendente && digitos[j] < digitos[j + 1])) {
                    int temp = digitos[j];
                    digitos[j] = digitos[j + 1];
                    digitos[j + 1] = temp;
                }
            }
        }
    }

    private static int reconstruirNumero(int[] digitos) {
        int numero = 0;
        for (int digito : digitos) {
            numero = numero * 10 + digito;
        }
        return numero;
    }
}
