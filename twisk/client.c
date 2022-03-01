#include <stdlib.h>
#include <stdio.h>

#include "def.h"

#define SASENTREE 0
#define GUICHET 1
#define ACTIVITE 2
#define SASSORTIE 3

#define num_sem_guichet 1

void simulation(int ids){
    entrer(SASENTREE);
    delai(6, 3);
    transfert(SASENTREE, GUICHET);
    
    P(ids, num_sem_guichet);
        transfert(GUICHET, ACTIVITE);
        delai(6, 2);
    V(ids, num_sem_guichet);

    transfert(ACTIVITE, SASSORTIE);
}