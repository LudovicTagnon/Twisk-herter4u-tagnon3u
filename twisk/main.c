#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#include "def.h"

//Les define dépendent du monde
#define NBCLIENT 5
#define NBETAPE 7
#define NBGUICHET 2
#define NBJETONS 2, 1

//Les lignes main ne changent pas quelque soit le monde
int main(int argc, char const *argv[])
{
    //Tableau des jetons de guichet
    int tabJetonsGuichet[NBGUICHET] = {NBJETONS};

    //Tableau des numéros des clients + lancement de la simulation
    int *tab = start_simulation(NBETAPE, NBGUICHET, NBCLIENT, tabJetonsGuichet);
    printf("Nombre des clients :");
    for (int i = 0; i < NBETAPE; i++){
        printf("%i ", tab[i]);
    }
    printf("\n");


    //Tableau des emplacement des clients
    int *client = ou_sont_les_clients(NBETAPE, NBCLIENT);

    printf("Emplacements des clients : \n");

    // Boucle qui tourne jusqu'à que la dernière activité est tous les clients
    while (client[(NBETAPE-1)*(NBCLIENT + 1)] < NBCLIENT){
        client = ou_sont_les_clients(NBETAPE, NBCLIENT);    //Raffraichit le tableau avec la nouvelle position des clients

        for (int i = 0; i < NBETAPE; i++){      //Affichage des clients en fonction du nombre de clients dans l'activité (ou le guichet)
            //Affichage de si i est un SAS ou une activité(ou guichet)
            if(i == 0){
                printf("Etape %d (SasEntree): %d client : ", i, client[NBCLIENT*i+i]);
            }
            else if (i == NBETAPE-1){
                printf("Etape %d (SasSortie): %d client : ", i, client[NBCLIENT*i+i]);
            }else{
                printf("Etape %d : %d client : ", i, client[NBCLIENT*i+i]);
            }
            
            //Affichage des clients dans l'activité (ou guichet) i
            for(int j = 0; j < client[NBCLIENT*i+i]; j++){
                printf("%d ", client[NBCLIENT*i+1+i+j]);
            }
            printf("\n");
        }
        printf("\n");
        
        //On met le prog en pause 1s
        sleep(1);
    }

    //Nettoyage du tableau des clients
    nettoyage();

    return 0;
}
