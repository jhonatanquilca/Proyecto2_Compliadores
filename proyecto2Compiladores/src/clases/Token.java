/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import javafx.scene.paint.Color;

/**
 *
 * @author Administrador
 */
public class Token {

    String sentencia = "";
    Set<String> VALUES;
//    TOKENS

    public String getSentencia() {
        return sentencia;
    }

    public void setSentencia(String sentencia) {
        VALUES = new HashSet<String>(Arrays.asList(sentencia.split("")));
        this.sentencia = sentencia;
    }

    public Token(String sentencia) {
        VALUES = new HashSet<String>(Arrays.asList(sentencia.split("")));

        this.sentencia = sentencia;
    }

    public boolean vacia() {
        return sentencia.equals("");
    }

    public String[] separateTocken() {
        Lenguaje leng = new Lenguaje();
        String aux = "";
        for (int i = 0; i < sentencia.length(); i++) {
            String tipoAct = leng.getTipo(sentencia.charAt(i) + "");
            String tipoAnt = (i == 0) ? "" : leng.getTipo(sentencia.charAt(i - 1) + "");
            if (i == 0) {
                aux += sentencia.charAt(i);
            } else if (tipoAct.equals(tipoAnt)) {
                aux += sentencia.charAt(i);
            } else if (leng.esEspacio(sentencia.charAt(i) + "")) {
            } else {
                aux += "§" + sentencia.charAt(i);

            }

        }

        return aux.split("§");
    }

    public String[][] getToken() {
        String[] tokens = separateTocken();
        String[][] resp = new String[tokens.length][2];
        for (int i = 0; i < tokens.length; i++) {
            resp[i][0] = getTipoToken(tokens[i]);
            resp[i][1] = tokens[i];

        }

        return resp;
    }

    private String getTipoToken(String token) {
        if (isEntero(token)) {
            return "ENTERO";
        } else if (isDouble(token)) {
            return "DOUBLE";
        } else if (isBolenano(token)) {
            return "BOLEANO";
        } else if (isFor(token)) {
            return "FOR";
        } else if (isNumero(token)) {
            return "NUMERO";
        } else if (isCoparacion(token) && token.length() > 1) {
            if (token.equals("!=")) {
                return "DIFERENTE";
            }
            if (token.equals("==")) {
                return "IGUAL";
            }

            if (token.equals(">=")) {
                return "MAYOR_I";
            }
            if (token.equals(">")) {
                return "MAYOR";
            }

            if (token.equals("<=")) {
                return "MENOR_I";
            }
            if (token.equals("<")) {
                return "MENOR";
            }
            return "";
        } else if (token.equals("(")) {
            return "PARENTESIS_A";
        } else if (token.equals(")")) {
            return "PARENTESIS_C";

        } else if (token.equals("=")) {
            return "ASIGNACION";
        } else if (token.equals(",")) {
            return "COMA";
        } else if (token.equals(";")) {
            return "P_COMA";
        } else if (isOperador(token)) {
            return "OPERADOR";
        } else if (isCadena(token)) {
            return "CADENA";
        } else if (isId(token)) {
            return "ID";
        } else {
            return "";
        }

    }

    public boolean isEntero(String t) {
        return t.equals("int");
    }

    public boolean isDouble(String t) {
        return t.equals("double");
    }

    public boolean isBolenano(String t) {
        return t.equals("bolean");
    }

    public boolean isFor(String t) {
        return t.equals("for");
    }

    public boolean isNumero(String t) {
        try {
            Integer.parseInt(t);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean isCoparacion(String t) {
        Lenguaje l = new Lenguaje();
        return l.esComparador(t);
    }

    public boolean isOperador(String t) {
        Lenguaje l = new Lenguaje();
        return l.esOperador(t);
    }

    public boolean isCadena(String t) {
        return t.charAt(0) == '"';
    }

    public boolean isId(String t) {
        try {
            Integer.parseInt(t);
            return false;
        } catch (Exception e) {
            return true;
        }

    }
}
