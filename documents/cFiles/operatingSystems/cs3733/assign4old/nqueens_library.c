#include <stdio.h>
#include <stdlib.h>
#include "nqueens_library.h"
#include <string.h>
int generate_n_queens_serial(int n, int print_flag){
   
   
   return 0;
}

void get_array_string(int *list,int n,char *s){
   int *lc = malloc(sizeof(int) *n);
   lc = list;
   printf("value of lc[0] is : %d\n",lc[0]);
   int i = 0;
   int dr;
   int length = 0;   
   while( i < n ){
      //printf("in lc = %d\n",lc[i]);
      dr = lc[i];
      length += sprintf(s + strlen(s),"    %d",dr);   
      //dr = i;
      i++;
   }
}

int next_permutation(int *list, int n){
   
   int t;
   
   t = n;
   
   int i = 0;
   
   while( i < t ){
      printf("value of t: %d\n",i);
      *list = i;
      *list++;
      i++;
   } 
   return 0;
}
