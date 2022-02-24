#! /bin/bash

#  
# Liste les IPCs d'un login particulier
# et genere la commande pour la suppression
# (ou l'execute directement # à decommenter )
#

if [[ $# == 0 ]]
then 
   proprio="colotte";
   echo "proprietaire par defaut : $proprio";
   echo "(Rappel de l'usage : Script  [login du proprio])";
else
   proprio=$1;
   echo "proprietaire : $proprio";
fi

echo "[a copier-coller :]"
ipcs -m | awk '{if($3==proprio){printf("ipcrm -m %d \n", $2);}}' proprio=$proprio ;
ipcs -s | awk '{if($3==proprio){printf("ipcrm -s %d \n", $2);}}' proprio=$proprio ;
ipcs -q | awk '{if($3==proprio){printf("ipcrm -q %d \n", $2);}}' proprio=$proprio ;

#ou le faire
#`ipcs -m | awk '{if($3==proprio){printf("ipcrm -m %d \n", $2);}}' proprio=$proprio `;
#`ipcs -s | awk '{if($3==proprio){printf("ipcrm -s %d \n", $2);}}' proprio=$proprio `;
#`ipcs -q | awk '{if($3==proprio){printf("ipcrm -q %d \n", $2);}}' proprio=$proprio `;

exit 0 ;
