/**
 * Escáner que detecta números y palabras
*/

%%

%public
%class Lexer
%standalone

digito=[0-9]
letra=[a-zA-Z]
inicioValido=({letra}|)
letraHexa=[a-fA-F]
palabra={letra}+
espacio=[ \t\n]
hexa=0x({letraHexa}|{digito})+
reservada=(while|for|if|else|void)

%%

{espacio} {/* La acción léxica puede ir vacía si queremos que el escáner ignore la regla*/}
{digito}+ { System.out.print("Encontré un número: "+yytext()+"\n"); }
{palabra} { System.out.print("Encontré una palabra: "+yytext()+"\n"); }