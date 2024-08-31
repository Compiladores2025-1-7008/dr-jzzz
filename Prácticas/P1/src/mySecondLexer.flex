/**
 * Escáner que detecta números y palabras
*/

%%

%public
%class Lexer
%standalone

digito=[0-9]
letra=[a-zA-Z]
idChar=({letra}|{digito}|_|\$)
inicioValido=({letra}|_|\$)
letraHexa=[a-fA-F]

javaId={inicioValido}({idChar}){2,31}
espacio=[ \t\n]+
hexa=0x({letraHexa}|{digito})+
reservada=(while|for|if|else|void)

%%

{espacio} { System.out.print("Encontré un espacio: "+yytext()+"\n");}
{reservada} { System.out.print("Encontré una palabra reservada: "+yytext()+"\n");}
{hexa} {System.out.print("Encontré un número hexadecimal: "+yytext()+"\n");}
{javaId} {System.out.print("Encontré un posible identificador: "+yytext()+"\n");}
