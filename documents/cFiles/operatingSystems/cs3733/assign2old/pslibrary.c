#include <stdlib.h>
#include <stdio.h>
#include "pslibrary.h"

#define READY 0
#define RUNNING 1
#define WAITING 2
#define DONE 3

static char stateChars[] ={'r','R','w',0};

void part0(char *s1, char *s2){
   // set up strings
   char *sc1 = "RRwwwwwRRRRRRRRR";
   char *sc2 = "rrRRRRwwwwwwwwrrRRRRRRR";

   // copy first
   while (*sc1) {
      *s1 = *sc1;
      *s1++;
      *sc1++;
   }	*s1= '\0';
	
   // copy second
   while (*sc2) {
      *s2 = *sc2;
      *s2++;
      *sc2++;
   }	*s2 = '\0';	
	
   return;

}

void fcfsa(char *s1,char *s2,int x1,int y1,int z1,int x2,int y2,int z2){
   /* here we go first come first server */
   /* so x1 , y1, x2, y2, z1, z2 */
   int tempv; 
   int tempv2;
   int x1t = x1;
   int y1t = y1; 
   int z1t = z1;
   int x2t = x2; 
   int y2t = y2;
   int z2t = z2;

   /* new way just copying over the variables with temp ones in the method */

   while ( x1t > 0 ) {
      *s1 = 'R';
      *s1++;
      *s2 = 'r';
      *s2++;
      x1t--;
   }

   while ( x2t > 0 ) {
      if ( y1t > 0 ) {
         *s1 = 'w';
         *s1++;
	 y1t--;
      }
      else if ( (y1t == 0) && (z1t > 0) ) {
         *s1 = 'r';
	 *s1++;
      }
         *s2 = 'R';
         *s2++;
         x2t--;
   }

   while (z1t > 0) {
      if ( y1t > 0 ) {
         *s1 = 'w';
         *s1++;
         y1t--;
         if ( y2t > 0 ) {
            *s2 = 'w';
	    *s2++;
	    y2t--;
	 }
	 else if ( (y2t == 0) && (z2t > 0) ) {
	    *s2 = 'R';
	    *s2++;
	    z2t--;
	 }

      }
      else if ( y1t == 0) {
         *s1 = 'R';
	 *s1++;
	 z1t--;
	 if ( y2t > 0 ) {
	    *s2 = 'w';
	    *s2++;
	    y2t--;
	 }
	 else if ( (y2t == 0 ) && (z2t > 0) )  {
	    *s2 = 'r';
	    *s2++;
	 }

      }

   }

   while (z2t > 0 ) {
      *s2 = 'R';
      *s2++;
      z2t--;
   }

   *s1 = '\0';
   *s2 = '\0';
}

void display(char *heading, char *s1, char *s2){
   char *s1c = s1; 
   float num = (22.0/23.0);
   // number of 'r' in first string
   int rs1 = 0;
   int rs2 = 0;
   int s1l = 0; 
   int s2l = 0; 
   int brs1 = 0; 
   int brs2 = 0;
   char *s2c = s2;
   float n1 = 0.0; 
   float n2 = 0.0;
   float fn1 = 0.0; 
   float fn2 = 0.0;
   float finalnum;

   printf("\n");
   printf("%s",heading);
   printf("%s\n",s1);
   printf("%s\n",s2);

   while (*s1c != '\0'){
      if ( *s1c == 'r') {
         rs1++;
      }
      if ( *s1c == 'R') {
         brs1++;
      }
      *s1c++;
      s1l++;
   }

   // number of 'r' in second string
   while ( *s2c != '\0') {
      if ( *s2c == 'r') {
         rs2++;
      }
      if ( *s2c == 'R') {
         brs2++;
      }
         *s2c++;
         s2l++;
   }
	
   n1 += rs1;
   n2 += rs2;

   int finallen = 0;
   if (s1l > s2l){
      finallen = s1l;
   }
   else if ( s2l > s1l) {
      finallen = s2l;
   } else {
      finallen = s1l;
   }
   fn1 += brs1;
   fn2 += brs2;

   finalnum = ( fn1 + fn2  )/finallen;
   printf("%d %d %.1lf %.5f \n", rs1, rs2, (n1 + n2)/2.0, finalnum);
}

// part1
void proto (char *s1, char *s2, int quantum, int x1, int y1, int z1, int x2, int y2, int z2) {
                                              /* this prototype is genius! */
   int i;                                   /* next string position (time) */
   int state1 = READY;                            /* start with both ready */
   int state2 = READY;
   int cpuLeft1 = x1;                       /* P1 next CPU burst remaining */
   int cpuLeft2 = x2;                       /* P2 next CPU burst remaining */
   int ioLeft1 = y1;        /* P1 next IO burst remaining, 0 if no more IO */
   int ioLeft2 = y2;        /* P2 next IO burst remaining, 0 if no more IO */
   int qleft;                                         /* quantum remaining */

   for (i=0; (state1 != DONE) || (state2 != DONE); i++) {
                                /* running process completes its CPU burst */
      if ((state1 == RUNNING) && (cpuLeft1== 0)) {
                                                         
         if (ioLeft1 == 0) {
            state1 = DONE;
            s1[i] = stateChars[state1];            /* terminate the string */
         }
         else
            state1 = WAITING;
      }  
      else if ((state2 == RUNNING) && (cpuLeft2 == 0)) {
                                                                    /* ... */
         if (ioLeft2 == 0){
            state2 = DONE;
            s2[i] = stateChars[state2];
         }
	 else
            state2 = WAITING;
      }  
                                     /* running process has quantum expire */
      if ((state1 == RUNNING) && (qleft == 0) ) {
         /* ... */         
         state1 = READY;
      }  
      if ((state2 == RUNNING) && (qleft == 0) ) {
         /* ... */
         state2 = READY;
      }  
                                                     /* handle IO complete */
      if ((state1 == WAITING) && (ioLeft1 == 0)) {
         state1 = READY;
         cpuLeft1 = z1;
         
      }  
      if ((state2 == WAITING) && (ioLeft2 == 0)) {
         /* ... */
         state2 = READY;
         cpuLeft2 = z2;
      }  
                                    /* if both ready, depends on algorithm */
      if ( (state1 == READY) && (state2 == READY) ) {
         state1 = RUNNING;
         /* ... */
         
      }  
                                     /* handle one ready and CPU available */
      else if ( (state1 == READY) && (state2 != RUNNING)) {
         state1 = RUNNING;
         qleft = quantum;
      }  
      else if ( (state2 == READY) && (state1 != RUNNING)) {
         /* ...*/
         state2 = RUNNING;
         qleft = quantum;
         
      }  
         /* insert chars in string, but avoid putting in extra string terminators */
      if (state1 != DONE)
         s1[i] = stateChars[state1];
      if (state2 != DONE)
         s2[i] = stateChars[state2];
                                                        /* decrement counts */
      qleft--;                   /* OK to decrement even if nothing running */
      if (state1 == RUNNING)
         cpuLeft1--;
      if (state1 == WAITING)
         ioLeft1--;
      if (state2 == RUNNING)
         cpuLeft2--;
      if (state2 == WAITING)
         ioLeft2--;
   }                                               /* end of main for loop */

}

void sjf(char *s1, char *s2, int x1, int y1, int z1, int x2, int y2, int z2){
                                              /* this prototype is genius! */
   int i;                                   /* next string position (time) */
   int state1 = READY;                            /* start with both ready */
   int state2 = READY;
   int cpuLeft1 = x1;                       /* P1 next CPU burst remaining */
   int cpuLeft2 = x2;                       /* P2 next CPU burst remaining */
   int ioLeft1 = y1;        /* P1 next IO burst remaining, 0 if no more IO */
   int ioLeft2 = y2;        /* P2 next IO burst remaining, 0 if no more IO */
   int qleft;                                         /* quantum remaining */

   for (i=0; (state1 != DONE) || (state2 != DONE); i++) {
                                /* running process completes its CPU burst */
      if ((state1 == RUNNING) && (cpuLeft1== 0)) {
                                                         
         if (ioLeft1 == 0) {
            state1 = DONE;
            s1[i] = stateChars[state1];            /* terminate the string */
         }
         else
            state1 = WAITING;
      }  
      else if ((state2 == RUNNING) && (cpuLeft2 == 0)) {
                                                                    /* ... */
         if (ioLeft2 == 0){
            state2 = DONE;
            s2[i] = stateChars[state2];
         }
	 else
            state2 = WAITING;
      }  
                                     /* running process has quantum expire */
      if ((state1 == RUNNING) && (qleft == 0) ) {
         /* ... */         
         state1 = READY;
      }  
      if ((state2 == RUNNING) && (qleft == 0) ) {
         /* ... */
         state2 = READY;
      }  
                                                     /* handle IO complete */
      if ((state1 == WAITING) && (ioLeft1 == 0)) {
         state1 = READY;
         cpuLeft1 = z1;
         
      }  
      if ((state2 == WAITING) && (ioLeft2 == 0)) {
         /* ... */
         state2 = READY;
         cpuLeft2 = z2;
      }  
                                    /* if both ready, depends on algorithm */
      if ( (state1 == READY) && (state2 == READY) ) {
         //state1 = RUNNING;
         /* ... */
         if ( cpuLeft1 < cpuLeft2 ) {
            state1 = RUNNING;
         } else if ( cpuLeft1 > cpuLeft2 ) {
            state2 = RUNNING;
         } else {
            state1 = RUNNING;
         }
      }  
                                     /* handle one ready and CPU available */
      else if ( (state1 == READY) && (state2 != RUNNING)) {
         state1 = RUNNING;
         //qleft = quantum;
      }  
      else if ( (state2 == READY) && (state1 != RUNNING)) {
         /* ...*/
         state2 = RUNNING;
        // qleft = quantum;
         
      }  
         /* insert chars in string, but avoid putting in extra string terminators */
      if (state1 != DONE)
         s1[i] = stateChars[state1];
      if (state2 != DONE)
         s2[i] = stateChars[state2];
                                                        /* decrement counts */
      qleft--;                   /* OK to decrement even if nothing running */
      if (state1 == RUNNING)
         cpuLeft1--;
      if (state1 == WAITING)
         ioLeft1--;
      if (state2 == RUNNING)
         cpuLeft2--;
      if (state2 == WAITING)
         ioLeft2--;
   }                                               /* end of main for loop */     

}

void psjf(char *s1, char *s2, int x1, int y1, int z1, int x2, int y2, int z2){
                                              /* this prototype is genius! */
   int i;                                   /* next string position (time) */
   int state1 = READY;                            /* start with both ready */
   int state2 = READY;
   int cpuLeft1 = x1;                       /* P1 next CPU burst remaining */
   int cpuLeft2 = x2;                       /* P2 next CPU burst remaining */
   int ioLeft1 = y1;        /* P1 next IO burst remaining, 0 if no more IO */
   int ioLeft2 = y2;        /* P2 next IO burst remaining, 0 if no more IO */
   int qleft;                                         /* quantum remaining */

   for (i=0; (state1 != DONE) || (state2 != DONE); i++) {
                                /* running process completes its CPU burst */
      if ((state1 == RUNNING) && (cpuLeft1== 0)) {
                                                         
         if (ioLeft1 == 0) {
            state1 = DONE;
            s1[i] = stateChars[state1];            /* terminate the string */
         }
         else
            state1 = WAITING;
      }  
      else if ((state2 == RUNNING) && (cpuLeft2 == 0)) {
                                                                   /* ... */
         if (ioLeft2 == 0){
            state2 = DONE;
            s2[i] = stateChars[state2];
         }
	 else
            state2 = WAITING;
      }  
                                    /* running process has quantum expire */
      if ((state1 == RUNNING) && (qleft == 0) ) {
         /* ... */         
         state1 = READY;
      }  
      if ((state2 == RUNNING) && (qleft == 0) ) {
         /* ... */
         state2 = READY;
      }  
                                                     /* handle IO complete */
      if ((state1 == WAITING) && (ioLeft1 == 0)) {
         state1 = READY;
         cpuLeft1 = z1;
         
      }  
      if ((state2 == WAITING) && (ioLeft2 == 0)) {
         /* ... */
         state2 = READY;
         cpuLeft2 = z2;
      }

      if ((state1 == RUNNING) && (cpuLeft2 < cpuLeft1) && (cpuLeft2 != 0)){
         state2 = RUNNING;
         state1 = READY;
      }
      if ((state2 == RUNNING) && (cpuLeft1 <= cpuLeft2) && (cpuLeft1 != 0)){
         state1 = RUNNING;
         state2 = READY;
      }  
                                    /* if both ready, depends on algorithm */
      if ( (state1 == READY) && (state2 == READY) ) {
         //state1 = RUNNING;
         /* ... */
         if ( cpuLeft1 < cpuLeft2 ) {
            state1 = RUNNING;
         } else if ( cpuLeft1 > cpuLeft2 ) {
            state2 = RUNNING;
         } else {
            state1 = RUNNING;
         }
      }  
                                      /* handle one ready and CPU available */
      else if ( (state1 == READY) && (state2 != RUNNING)) {
         state1 = RUNNING;
         //qleft = quantum;
      }  
      else if ( (state2 == READY) && (state1 != RUNNING)) {
         /* ...*/
         state2 = RUNNING;
        // qleft = quantum;
         
      }  
   /* insert chars in string, but avoid putting in extra string terminators */
      if (state1 != DONE)
         s1[i] = stateChars[state1];
      if (state2 != DONE)
         s2[i] = stateChars[state2];
                                                        /* decrement counts */
      qleft--;                   /* OK to decrement even if nothing running */
      if (state1 == RUNNING)
         cpuLeft1--;
      if (state1 == WAITING)
         ioLeft1--;
      if (state2 == RUNNING)
         cpuLeft2--;
      if (state2 == WAITING)
         ioLeft2--;
   }                                               /* end of main for loop */     
 
}

void rr(char *s1, char *s2, int quantum, int x1, int y1, int z1, int x2, int y2, int z2){
 /* i think this prototype must be modified a little more for round robbin */
 /* there must be another if statement to check for io waiting and quantum */
                                                                       /*  */
                                              /* this prototype is genius! */
   int i;                                   /* next string position (time) */
   int state1 = READY;                            /* start with both ready */
   int state2 = READY;
   int cpuLeft1 = x1;                       /* P1 next CPU burst remaining */
   int cpuLeft2 = x2;                       /* P2 next CPU burst remaining */
   int ioLeft1 = y1;        /* P1 next IO burst remaining, 0 if no more IO */
   int ioLeft2 = y2;        /* P2 next IO burst remaining, 0 if no more IO */
   int qleft;                                         /* quantum remaining */

   for (i=0; (state1 != DONE) || (state2 != DONE); i++) {
                                /* running process completes its CPU burst */
      if ((state1 == RUNNING) && (cpuLeft1 == 0)) {
                                                         
         if (ioLeft1 == 0) {
            state1 = DONE;
            s1[i] = stateChars[state1];            /* terminate the string */
         }
         else
            state1 = WAITING;
      }  
      else if ((state2 == RUNNING) && (cpuLeft2 == 0)) {
                                                                    /* ... */
         if (ioLeft2 == 0){
            state2 = DONE;
            s2[i] = stateChars[state2];
         }
	 else
            state2 = WAITING;
      }  
                                     /* running process has quantum expire */
      if ((state1 == RUNNING) && (qleft == 0) ) {
         /* ... */
         state1 = READY;
         if (state2 == READY) {
           state2 = RUNNING;
           qleft = quantum;
         }         
         //state2 = RUNNING;
      }  
      if ((state2 == RUNNING) && (qleft == 0) ) {
         /* ... */
         state2 = READY;
         if (state1 == READY) {
           state1 = RUNNING;
           qleft = quantum;
         }
         //state1 = RUNNING;
      }  
                                                     /* handle IO complete */
      if ((state1 == WAITING) && (ioLeft1 == 0)) {
         state1 = READY;
         cpuLeft1 = z1;
         
      }  
      if ((state2 == WAITING) && (ioLeft2 == 0)) {
         /* ... */
         state2 = READY;
         cpuLeft2 = z2;
      } 
                                    /* if both ready, depends on algorithm */
      if ( (state1 == READY) && (state2 == READY) ) {
         state1 = RUNNING;
         qleft = quantum;
         /* ... */
      }  
                                     /* handle one ready and CPU available */
      else if ((state1 == READY) && (state2 != RUNNING)) {
         state1 = RUNNING;
         qleft = quantum;
	 //if (state2 == DONE){ state2 = READY; }
         
      }  
      else if ((state2 == READY) && (state1 != RUNNING)) {
         /* ... */
         state2 = RUNNING;
         qleft = quantum;
	 //if (state1 == DONE){ state1 = READY; }         
      }  

   /* insert chars in string, but avoid putting in extra string terminators */
      if (state1 != DONE)
         s1[i] = stateChars[state1];
      if (state2 != DONE)
         s2[i] = stateChars[state2];
                                                        /* decrement counts */
      qleft--;                   /* OK to decrement even if nothing running */
      if (state1 == RUNNING)
         cpuLeft1--;
      if (state1 == WAITING)
         ioLeft1--;
      if (state2 == RUNNING)
         cpuLeft2--;
      if (state2 == WAITING)
         ioLeft2--;
   }                                                /* end of main for loop */     
     
} 


