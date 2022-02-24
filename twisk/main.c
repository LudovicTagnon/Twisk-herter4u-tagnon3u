#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#include "def.h"

#define NBCLIENT 5
#define NBETAPE 5

// TAILLE DU TABLEAU ou_sont_les_clients : NBETAPE * (NBCLIENT + 1)

int main(int argc, char const *argv[])
{
    // TABLEAU DES NUMEROS
    int *tab = start_simulation(NBETAPE, 0, NBCLIENT, NULL);

    printf("Nombre des clients : ");
    for (int i = 0; i < NBCLIENT; i++)
    {
        printf("%i ", tab[i]);
    }
    printf("\n");

    // TABLEAU DES EMPLACEMENTS

    int *client = ou_sont_les_clients(NBETAPE, NBCLIENT);

    printf("Emplacements des clients : \n");

    while (client[(NBETAPE-1)*(NBCLIENT + 1)    ] < NBCLIENT){
        client = ou_sont_les_clients(NBETAPE, NBCLIENT);

        for (int i = 0; i < NBETAPE; i++){
            printf("Etape %d : %d client : ", i, client[NBCLIENT*i+i]);
            for(int j = 0; j < client[NBCLIENT*i+i]; j++){
                printf("%d ", client[NBCLIENT*i+1+i+j]);
            }
            printf("\n");
        }
        printf("\n");
        
        
        sleep(1);
    }

    // NETTOYAGE
    nettoyage();

    return 0;
}
