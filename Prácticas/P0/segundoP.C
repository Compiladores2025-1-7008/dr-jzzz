#include <stdio.h>

#undef DEBUG


#ifndef DEBUG
    #define DEBUG 1
#endif

#if DEBUG == 0
    #error "Debugging is disabled! Define DEBUG with a non-zero value."
#endif

#pragma message("Hello, world!")

int main() {
    #pragma message("Dentro de main")
    
    printf("Debug mode is: %d\n", DEBUG);

    return 0;
}