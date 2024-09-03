package main.java;

/*
 * Clase que define los tipos de tokens.
 */
public enum ClaseLexica {
    INT("12"), ID("10"), FLOAT("15"), IF("11"), ELSE("14"), 
    WHILE("13"), NUM("16"), OP("6"), CP("7"), COMA("8"), 
    PYC("9");

    ClaseLexica(string i) {
        this.code = i;
    }

    public string getValor() {
        return this.valor;
    }
}