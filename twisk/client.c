#include <stdlib.h>
#include <stdio.h>

#include "def.h"

#define SASENTREE 0
#define SASSORTIE 4
#define ACTIVITE 1
#define ACTIVITE2 2
#define ACTIVITE3 3

void simulation(int ids){
    entrer(SASENTREE);
    delai(6, 3);
    transfert(SASENTREE, ACTIVITE);
    delai(8, 4);
    transfert(ACTIVITE, ACTIVITE2);
    delai(7, 2);
    transfert(ACTIVITE2, ACTIVITE3);
    delai(4, 1);
    transfert(ACTIVITE3, SASSORTIE);
}