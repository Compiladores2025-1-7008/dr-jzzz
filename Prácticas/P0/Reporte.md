### 3. Use el siguiente comando para ejecutar el preprocesador: cpp programa.c > programa.i


#### a Localice el archivo stdio.h en su sistema y examine su contenido.
/usr/include/stdio.h

#### b Compare el contenido de programa.i con stdio.h. Describa las similitudes mas notables entre ambos
archivos.
Las definiciones en stdio.h estan en dentro de programa.i ( en general todo  su contenido excepto por comentarios y directivas )

#### c Explique que ocurre durante la ejecucion del comando  cpp.
Durante la ejecucion del preprocesador se analisa y procesa el archivo .c para "expandir" o realizar las directivas.


### 4. Compile el archivo preprocesado usando el comando: gcc -Wall -S programa.i

#### a Describa la funcion de la opcion -Wall.
Esta opcion activa varias alertas opcionales en el compilador.

#### b Explique el proposito de la opcion -S.
Detiene la ejecucion de gcc al compilar a codigo ensamblador.

#### c Indique que contiene el archivo de salida y cual es su extension.
La extension de la salida es .s y el archivo contiene el resultado de compilar el programa a codigo ensamblador.

#### d Identifique que programa es invocado por gcc al usar la opcion -S.
Compilador


### 5. Ensamble el archivo usando: as programa.s -o programa.o

#### a Explique que se espera que contenga el archivo .o
Codigo maquina

#### b Describa de manera general el contenido del archivo .o y por que es importante.
Si lo abro con un procesador de texto, se muestran muchos simbolos cripticos y la version de gcc

#### c Identifique que programa se invoca con el comando as.
Ensamblador


### 6 Encuentre las rutas en su sistema para los siguientes archivos:

- Scrt1.o
/usr/lib64/Scrt1.o

- crti.o
/usr/lib64/crti.o

- crtbeginS.o
/usr/lib/gcc/x86_64-redhat-linux/14/crtbeginS.o

- crtendS.o
/usr/lib/gcc/x86_64-redhat-linux/14/crtendS.o

- crtn.o
/usr/lib64/crtn.o


### 7 Ejecute el siguiente comando, sustituyendo las rutas que encontró en el paso anterior:
ld -o ejecutable -dynamic-linker /lib/ld-linux-x86-64.so.2 /usr/lib64/Scrt1.o /usr/lib64/crti.o programa.o -lc /usr/lib64/crtn.o

#### a Si el comando ld arroja errores, investigue como enlazar un programa utilizando  ld.
-

#### b Describa el resultado obtenido al ejecutar el comando anterior.
Un ejecutable.


### 10 Quite el comentario de la macro #define PI

#### b ¿Cambio algo en la ejecucion final?
Si, las ultimas 3 decimas eran distintas.


### 11. Escribe un segundo programa en lenguaje C

#### a Explique la utilidad general de las directivas usadas y su funcion en particular para su programa.
Utilice #undef, que de existir, elimina una definicion, esto para garantizar que no estuviera definida.

Use tambien #ifndef, muy similar a #ifdef, pero entra a la estructura de control cuando la palabra no esta definida.

Tambien use #pragma que manda un mensaje al momento de compilar.

Tambien use #error, para mandar un error y detener compilacion.

### Punto Extra:

- Scrt1.o
Inicialización de entorno y pila de ejecucion

- crti.o
Inicializacion del programa.
Incluye prologo y epiligo del programa.

- crtbeginS.o
Define constructures y destructores

- crtendS.o
Constructores y destructores

- crtn.o
Finaliza entorno de ejecucion.