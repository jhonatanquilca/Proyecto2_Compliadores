/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import clases.Lenguaje;
import clases.Token;
import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Token tk = new Token("int i=5+a+b*3+(4/2);");
        String[][] tokens = tk.getToken();
        for (int i = 0; i < tokens.length; i++) {
            System.out.print(tokens[i][0]);
            System.out.print("--");
            System.out.println(tokens[i][1]);

        }
    }

}
