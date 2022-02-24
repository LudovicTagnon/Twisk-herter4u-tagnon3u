#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#include "def.h"

// TAILLE DU TABLEAU ou_sont_les_clients : nbEtapes * (nbClient + 1)

int main(int argc, char const *argv[])
{

    // VARIABLES
    int nbClient = 6;
    int nbEtapes = 3;
    int tailleEmpClient = (nbEtapes) * (nbClient + 1);

    // TABLEAU DES NUMEROS
    int *tab = start_simulation(nbEtapes, 0, nbClient, NULL);

    printf("Nombre des clients : ");
    for (int i = 0; i < nbClient; i++)
    {
        printf("%i ", tab[i]);
    }
    printf("\n");

    // TABLEAU DES EMPLACEMENTS

    int *client = ou_sont_les_clients(nbEtapes, nbClient);

    printf("Emplacements des clients : \n");

    while (client[(nbEtapes-1)*(nbClient + 1)] < nbClient){
        client = ou_sont_les_clients(nbEtapes, nbClient);
        for (int i = 0; i < tailleEmpClient; i++){
            if (i % (nbClient + 1) == 0){
                printf("\n");
            }
            printf("%i ", client[i]);
        }
        printf("\n");

        printf("1 : %d, 2 : %d, 3 : %d\n", client[0], client[nbClient+1], client[nbClient*2+2]);
        sleep(1);
    }

    // NETTOYAGE
    nettoyage();

    return 0;
}
