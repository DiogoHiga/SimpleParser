package io.compiler.main;

import org.antlr.v4.runtime.*;
import io.compiler.core.UFABCGrammarLexer;
import io.compiler.core.UFABCGrammarParser;
import io.compiler.core.ast.Program;
import io.compiler.core.exceptions.UFABCSemanticException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            UFABCGrammarLexer lexer;
            UFABCGrammarParser parser;

            System.out.println("Digite o nome do arquivo: ");
            String arquivo = scanner.nextLine();

            // Inicializa o lexer
            lexer = new UFABCGrammarLexer(CharStreams.fromFileName(arquivo));

            // Cria o fluxo de tokens e o parser
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            parser = new UFABCGrammarParser(tokenStream);

            System.out.println("UFABC compiler");
            parser.programa(); // Executa a análise

            System.out.println("Compilation Successfully!");

            // Geração do código
            Program program = parser.getProgram();
            try {
                // Diretório onde o arquivo será salvo
                String directory = "src/io/compiler/main/";
                File f = new File(directory + program.getName() + ".java");
                FileWriter fr = new FileWriter(f);
                PrintWriter pr = new PrintWriter(fr);
                pr.println("package io.compiler.main;");
                pr.println(program.generateTarget());
                pr.close();
                scanner.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        } catch (UFABCSemanticException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (RuntimeException ex) {
            // Captura qualquer exceção lançada durante o processo
            System.err.println(ex.getMessage());
        }
    }
}
