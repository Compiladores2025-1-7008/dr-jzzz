#include <stdio.h>
#include <stdlib.h>
//#define PI 3.1415926535897 
#ifdef PI
#define area(r) ( PI * r * r)
#else
#define area(r) (3.1416* r * r)
#endif
/*
* Es te es un programa de prueba, para verificar
* el funcionamiento del sistema de procesamiento de lenguaje
*/
int main ( void ) {
printf("Hola Mundo!\n"); // Funcion para imprimir hola mundo
float mi_area = area(3); // soy un comentario . . .
printf("Resultado : %f \n", mi_area);
return 0;
}