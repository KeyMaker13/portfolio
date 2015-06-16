#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>


struct product {
int type;
int number;
} p;

int main (int argc, char *argv[]) {

	int fdin,n;
	unsigned int sn;

	if ( (fdin = open(argv[1],O_RDONLY))  < 0) {
		perror("open error");
		exit(-1);
	}

	while ( (n = read(fdin,&p,sizeof(struct product))) == sizeof(struct product)) {
		printf("Product \t%d \tQuantity \t%d \n",p.type,p.number);	
		//if ( (n = read(fdin,&sn,sizeof(unsigned int)) != sizeof(unsigned int)  ) ) {
		//	close(fdin);
		//	exit(-1);
		//}
		lseek(fdin,sizeof(unsigned int)*p.number,SEEK_CUR);

	}

	if ( n != 0) {
		close(fdin);
		exit(-1);
	}


	return 0;
}
