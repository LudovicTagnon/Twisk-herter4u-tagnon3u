#include <stdlib.h>
#include <stdio.h>

#include "def.h"

#define SASENTREE 0
#define GUICHET1 1
#define ACTIVITE1 2
#define ACTIVITE2 3
#define GUICHET2 4
#define ACTIVITE3 5
#define SASSORTIE 6

#define num_sem_guichet1 1
#define num_sem_guichet2 2

void simulation(int ids){
    entrer(SASENTREE);
    delai(6, 3);
    transfert(SASENTREE, GUICHET1);
    
    P(ids, num_sem_guichet1);
        transfert(GUICHET1, ACTIVITE1);
        delai(6, 2);
    V(ids, num_sem_guichet1);

    transfert(ACTIVITE1,  ACTIVITE2);
    delai(6, 4);
    transfert(ACTIVITE2, GUICHET2);

    P(ids, num_sem_guichet2);
        transfert(GUICHET2, ACTIVITE3);
        delai(5, 3);
    V(ids, num_sem_guichet2);

    transfert(ACTIVITE3, SASSORTIE);
}