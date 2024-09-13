package io.compiler.main;
import java.util.Scanner;

public class testeComandos {
    public static void main(String args[]) {
    Scanner _scTrx = new Scanner(System.in);
        double x;
        double y;

        System.out.println("Insira um valor para x: ");
        x=_scTrx.nextDouble();
        y = x + 10.5;
        System.out.println("O valor de y eh: ");
        System.out.println(y);
        if (x > 5) {
        System.out.println("x eh maior que 5");
        }
        else {
        System.out.println("x eh menor ou igual a 5");
        }
        while(y < 20) {
            y = y + 1;
            System.out.println("Dentro do while");
            System.out.println(y);
        }
        do {
            System.out.println("Dentro do do-while");
            y = y - 1;
            System.out.println(y);
} while(y > 15);_scTrx.close();
    }
}
