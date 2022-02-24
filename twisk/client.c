#include <stdlib.h>
#include <stdio.h>

#include "def.h"

#define SASENTREE 0
#define SASSORTIE 2
#define ACTIVITE 1

void simulation(int ids){
    entrer(SASENTREE);
    delai(6, 3);
    transfert(SASENTREE, ACTIVITE);
    delai(8, 4);
    transfert(ACTIVITE, SASSORTIE);
}