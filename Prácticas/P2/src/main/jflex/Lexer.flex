/**
 * Escáner que detecta el lenguaje C_1
*/

package main.jflex;

import main.java.ClaseLexica;
import main.java.Token;

%%

%{

public Token actual;

%}

%public
%class Lexer
%standalone
%unicode

espacio=[ \t\n\z]+
prInt=int
prFloat=float
prIf=if
prElse=else
prWhile=while
number=([1-9][0-9]*|0)(.[0-9]*)?([eE][+-]?[0-9]+)?
id=[_a-zA-Z][_a-zA-Z0-9]*
pyc=;
coma=,
Lpar=\(
Rpar=\)

%%

{prInt} {
    Token actual = new Token(ClaseLexica.INT, yytext());
    System.out.println(actual.toString());
}
{prFloat} {
    Token actual = new Token(ClaseLexica.FLOAT, yytext());
    System.out.println(actual.toString());
}
{prIf} {
    Token actual = new Token(ClaseLexica.IF, yytext());
    System.out.println(actual.toString());
}
{prElse} {
    Token actual = new Token(ClaseLexica.ELSE, yytext());
    System.out.println(actual.toString());
}
{prWhile} {
    Token actual = new Token(ClaseLexica.WHILE, yytext());
    System.out.println(actual.toString());
}
{number} {
    Token actual = new Token(ClaseLexica.NUM, yytext());
    System.out.println(actual.toString());
}
{id} {
    Token actual = new Token(ClaseLexica.ID, yytext());
    System.out.println(actual.toString());
}
{pyc} {
    Token actual = new Token(ClaseLexica.PYC, yytext());
    System.out.println(actual.toString());
}
{coma} {
    Token actual = new Token(ClaseLexica.COMA, yytext());
    System.out.println(actual.toString());
}
{Lpar} {
    Token actual = new Token(ClaseLexica.LPAR, yytext());
    System.out.println(actual.toString());
}
{Rpar} {
    Token actual = new Token(ClaseLexica.RPAR, yytext());
    System.out.println(actual.toString());
}

{espacio} {/* La acción léxica puede ir vacía si queremos que el escáner ignore la regla */}