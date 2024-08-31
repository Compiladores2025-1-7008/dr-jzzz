### Ejercicios:

1. ¿Qué ocurre si en la primera sección se quitan las llaves al nombre de la macro letra? (0.5 pts)

Varias cosas, al ejecutar jflex, nos alerta que el macro letra no se ha utilizado, por lo que debe estar considerando esos simbolos como literales.
Luego al ejecutar el Lexer resultado con la cadena de pruba, no reconocio mas que el digito.
    
2. ¿Qué ocurre si en la segunda sección se quitan las llaves a las macros? (0.5 pts)

Igualmente alerta que los macros no han sido utilizados. Y el lexer no hizo match con ninguna cadena del input de prueba.

3. ¿Cómo se escribe un comentario en flex? (0.5 pts)

En jflex, igual que en java, usando /* */ y //


4. ¿Qué se guarda en yytext? (0.5 pts)

Un lexema, el actualmente siendo procesado.
    
5. ¿Qué pasa al ejecutar el programa e introducir cadenas de caracteres y de dígitos en el archivo de entrada? (0.5 pts)

Si una cadena contiene carcteres y digitos, separa las cadenas en las subsecciones de elementos contiguos del mismo tipo. (i.e  12ab43 se proceso como 12 ab 43)
    
6. ¿Qué ocurre si introducimos caracteres como "*" en el archivo de entrada? (0.5 pts)

Parece ignorarlos, aparecen en la salida pero no realiza ninguna accion sobre ellos.

7. Modificar al código anterior en un archivo nuevo, de tal manera que reconozca lo siguiente: (2 pts)
    - La expresión regular para los hexadecimales en lenguaje Java. 
    - 5 palabras reservadas del lenguaje Java.
    - Los identificadores válidos del lenguaje Java, con longitud máxima de 32 caracteres (Sugerencia: use el operador {m,n}).
    - Los espacios en blanco.
