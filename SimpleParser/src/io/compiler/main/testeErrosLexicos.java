package io.compiler.main;

import java.util.Scanner;

public class testeErrosLexicos {
    public static void main(String args[]) {
        Scanner _scTrx = new Scanner(System.in);
        int x;

        x = _scTrx.nextInt();
        System.out.println(x);
        x = 3;
        _scTrx.close();
    }
}
