package biohw3;

public class MotifFinding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		/* Part A */
			/* A1 */
			System.out.println("Inputing this Alignment");
			System.out.println("-----------------------");
			System.out.println("GTGTAGC"); //1
			System.out.println("GTGTTGT"); //2
			System.out.println("GGGTTGC"); //3
			System.out.println("GTGTAGC"); //4
			System.out.println("GTGCTGC"); //5
			System.out.println("GTGTAGC"); //6
			System.out.println("TTGTTGC"); //7
			System.out.println("GTGTAGC"); //8
			System.out.println("ATGTTGC"); //9
			System.out.println("GTGGTGC"); //10
			System.out.println("GTGTTCC"); //11
			System.out.println("GCGTTGC"); //12
			System.out.println("GTGTTAC"); //13
			System.out.println("GCGTTGC"); //14
			System.out.println("GTGCTGC"); //15
			System.out.println("GTTTTGC"); //16
			System.out.println("TTGTTGC"); //17
			System.out.println("GTCTTGC"); //18
			System.out.println("GTGATGC"); //19
			System.out.println("GTGTTGA"); //20
			System.out.println("-----------------------");
			System.out.println("Outputing Frequency ");
			
			String[][] alignment = new String[7][20];
			/* 1 */
			alignment[0][0] = "GTGTAGC";
			//System.out.println(alignment[0][0]);
			/* 2 */
			alignment[0][1] = "GTGTTGT";
			
			/* 3 */
			alignment[0][2] = "GGGTTGC";
		
			/* 4 */
			alignment[0][3] = "GTGTAGC";
			
			/* 5 */
			alignment[0][4] = "GTGCTGC";
			
			/* 6 */
			alignment[0][5] = "GTGTAGC";
			
			/* 7 */
			alignment[0][6] = "TTGTTGC";
			
			/* 8 */
			alignment[0][7] = "GTGTAGC";
			
			/* 9 */
			alignment[0][8] = "ATGTTGC";
			
			/* 10 */
			alignment[0][9] = "GTGGTGC";
			
			/* 11 */
			alignment[0][10] = "GTGTTCC";
			
			/* 12 */
			alignment[0][11] = "GCGTTGC";
			
			/* 13 */
			alignment[0][12] = "GTGTTAC";
			
			/* 14 */
			alignment[0][13] = "GCGTTGC";
			
			/* 15 */
			alignment[0][14] = "GTGCTGC";
			
			/* 16 */
			alignment[0][15] = "GTTTTGC";
			
			/* 17 */
			alignment[0][16] = "TTGTTGC";
			
			/* 18 */
			alignment[0][17] = "GTCTTGC";
			
			/* 19 */
			alignment[0][18] = "GTGATGC";
			
			/* 20 */
			alignment[0][19] = "GTGTTGA";
			
			int i = 0;
			int i2 = 0;
			
			int[][] prob = new int[4][7];
			/* A C G T */
			
			char a = 'A';
			char c = 'C';
			char g = 'G';
			char t = 'T';
			
			int numA = 0;
			int numC = 0;
			int numG = 0;
			int numT = 0;
			
			/* 1st letter */
			for (i2 = 0; i2 < 7 ; i2++){
				for (i = 0; i < 20; i++){
					if (alignment[0][i].charAt(i2) == (a)){
						numA++;
					}
					if (alignment[0][i].charAt(i2) == (c)){
						numC++;
					}
					if (alignment[0][i].charAt(i2) == (g)){
						numG++;
					}
					if (alignment[0][i].charAt(i2) == (t)){
						numT++;
					}	
				}
				prob[0][i2] = numA;
				prob[1][i2] = numC;
				prob[2][i2] = numG;
				prob[3][i2] = numT;
				numA = 0;
				numC = 0;
				numG = 0;
				numT = 0;
			}
			
			
			System.out.println("");
			System.out.println("    1    2    3    4    5    6    7");
			System.out.print("A: ");
			for (i = 0; i < 7; i++){
				
					//System.out.print(String.format("%.2f", prob[0][i]/20.0)+" ");
					//System.out.print(String.format("%.2f", (prob[0][i]+1.0)/(20.0+4.0))+" ");
					System.out.print(String.format("%.2f", (prob[0][i]+.25)/(20.0+1))+" ");
				
			}
			System.out.println("");
			System.out.print("C: ");
			for (i = 0; i < 7; i++){
				
				//System.out.print(String.format("%.2f", prob[1][i]/20.0)+" ");
				//System.out.print(String.format("%.2f", (prob[1][i]+1.0)/(20.0+4.0))+" ");
				System.out.print(String.format("%.2f", (prob[1][i]+.25)/(20.0+1))+" ");
			}
			System.out.println("");
			System.out.print("G: ");
			for (i = 0; i < 7; i++){
				
				//System.out.print(String.format("%.2f", prob[2][i]/20.0)+" ");
				//System.out.print(String.format("%.2f", (prob[2][i]+1.0)/(20.0+4.0))+" ");
				System.out.print(String.format("%.2f", (prob[2][i]+.25)/(20.0+1))+" ");
			}
			System.out.println("");
			System.out.print("T: ");
			for (i = 0; i < 7; i++){
				
				//System.out.print(String.format("%.2f", prob[3][i]/20.0)+" ");
				//System.out.print(String.format("%.2f", (prob[3][i]+1.0)/(20.0+4.0))+" ");
				System.out.print(String.format("%.2f", (prob[3][i]+.25)/(20.0+1))+" ");
			}
			
			System.out.println("");
			System.out.print("H: ");
			
			double[] storehval = new double[7];
			double[][] storeprob = new double[4][7];
			double hvalue = 0.0;
			double aval = 0.0;
			double cval = 0.0;
			double gval = 0.0;
			double tval = 0.0;
			for (i = 0; i < 7; i++){
				
				aval = (prob[0][i]+.25)/(20.0+1);
				cval = (prob[1][i]+.25)/(20.0+1);
				gval = (prob[2][i]+.25)/(20.0+1);
				tval = (prob[3][i]+.25)/(20.0+1);
				
				storeprob[0][i] = aval;
				storeprob[1][i] = cval;
				storeprob[2][i] = gval;
				storeprob[3][i] = tval;
				
				hvalue = (-aval*(Math.log(aval)/Math.log(2)) ) + (-cval*(Math.log(cval)/Math.log(2)) ) + (-gval*(Math.log(gval)/Math.log(2))) + (-tval*(Math.log(tval)/Math.log(2)));
				storehval[i] = hvalue;
				System.out.print(String.format("%.2f", hvalue)+" ");
				
			}
			
			System.out.println("");
			System.out.print("I: ");
			
			for (i = 0; i < 7; i++){
				
				System.out.print(String.format("%.2f", (2.0 - storehval[i])) + " ");
			}
			
			
			int check = -1;
			System.out.println("");
			//System.out.println("");
			//System.out.println("Best sequence");
			/*
			for (i = 0; i < 7; i++){
				
				if ((prob[0][i] > prob[1][i]) && (prob[0][i] > prob[2][i]) && (prob[0][i] > prob[3][i])){
					
					check = 1;
				} else if ((prob[1][i] > prob[0][i]) && (prob[1][i] > prob[2][i]) && (prob[1][i] > prob[3][i])){
					
					check = 2;
				} else if ((prob[2][i] > prob[1][i]) && (prob[2][i] > prob[0][i]) && (prob[2][i] > prob[3][i])){
					
					check = 3;
				} else if ((prob[3][i] > prob[1][i]) && (prob[3][i] > prob[2][i]) && (prob[3][i] > prob[0][i])){
					
					check = 4;
				}
					
				if (check == 1){
					System.out.print("A ");
				} else if (check == 2){
					System.out.print("C ");
				} else if (check == 3){
					System.out.print("G ");
				} else if (check == 4){
					System.out.print("T ");
				}	
			}
			*/
			
			
			/* A2 */
			System.out.println("");
			System.out.println("A2");
			
			String[][] sequence2 = new String[200][20];
			
			/* 1 */
			sequence2[0][0] = "CGAGTTCCTTTCATCCTTAGGCCGGCTTGAGATATCCGTTGCAGGTGTGCATTGCCCGCATCTCCCGCCGTAGTTATGTCTGGTCTCACAATGGCTTCTGAGTCTTATTTGCCCCTTCTGTTATGGTTTATAATCACCGACACTTGTGTAGCAAGACTGTCAAGGGGTCAAGAGGTATTTGACATTTCGCAAGGCGGGGT";
			
			/* 2 */
			sequence2[0][1] = "ACAATGGTTGCATTATCCTGGCTGGGAACTGTATCGTACGCGATAGTCACGTTTGTTCAAGAACGCAGGTCCACAAAAATGCTACGTGTTGTATACAGGTGCTTACCACGTCGCTGCACGGCTTGTACTTGCTGCATCCGTGTGACAGGAGGCTAGAAGCAGTGAGGCCAAGGTTGCCTTGACTTCCAAACTTGCGACCC";
			
			/* 3 */
			sequence2[0][2] = "ATGCATGCTTGCCCTGTGGATGATTTGGCTACGCATCCGCTCTTAGCCTTGAAGACACGACACAGGCGTGGAAAGGGTAACCCTGGCGGCCCTGATTGACATGCGCTCTGAACGGACTTCAAGGGAGGACTACAAGTGGGGTTGCCCGTCATACATACACGTGATGCCTCTTACGGACCATCAACGCGTAACGCGTGAGT";
	
			/* 4 */
			sequence2[0][3] = "CGAGCCTAGACTCGTAATTTCGGTCACACATGCTGCTATTGACCTACCACCAGGACTATGAGGTCTGTCGCATACATCATCAAAGCCTGGAAGGCCGATCTATGTAGGGCCTTCTAGTCCAGGAAGCACCTGATTCAAGTCACATGTTCCTTGCCCAAACGTCGACATGGTGTAGCGGGACCTGTGTTATACAAACCATA";
			
			/* 5 */
			sequence2[0][4] = "GCCTGTTAAGGTTCCTCGTCGAAAGCCTGGGGGGGGGTTGTGCTGCCTAAAAACACAATGTTAAGGACTGAATTCTGCCAAGTCACTTTCGCAAAACACTTTGTGTGATGGGACACTTAGTAAAAGGGTAGGCTTCTTGATTCAGAATTACGTCGCTCAATGAGGATTTGCTGGGAGCGAGGAGTGCTGTCTAACCTATT";
	
			/* 6 */
			sequence2[0][5] = "GCCCTCGCTACGTGGCATACCCAGGTTCCTAATACGGTACTTGCGTATTGAAGTCTCAGAATTATCTCCTCTGCTGGCAGGGTCGATCTAGTTCAAGATTAGATAATGGGCAATAGGACGTGTGTGCGGTCCTGACACCTGGCGGTTTGTACAGATAAGACCCTCGCGGGGCGCAGGTGTAGCCTCTCAGCATGTGATAC";
	
			/* 7 */
			sequence2[0][6] = "TTGGAACGCGCTGGTCACGAGAGGGACTATGACTCCCAGCTAATACATGGTCATGAGAGGCGTGTTCCGATAGAGCCGGTGGGGGGTTCCCACGGGTTAAATCGGATGTAAACTGTTGTTGTGATCGTGTCGAGCTATACTAACGTATACAACTTAATAAGGATAATTCCTGTGCCAGATACGGTTACTTGTTGCAGTTG";
			
			/* 8 */
			sequence2[0][7] = "TTTGAATCACCATCCTCTATTACCTACTAAGCTCTTGGCCTGACAAAGCTCAGACCCCGCCGGGCAAAGAATTTCGAGCACTTACGGTACAAATGACCGCATGGAAGGAATCGAAATGAACACACCGGTACATCGACCCGTGACACGTTCTCTCTAGATGTGTAGCTAAGAGCCGGATCGCAATGGCGTCGGGCTCCATC";
			
			/* 9 */
			sequence2[0][8] = "TCCGCCAAGACTACACTTTTATTGCAACGCATCTGTTCGATATAGCCAAGTCCTATGGGACAATCTTCCATCTTATGTTGCGGTTTGTAGCCGTGTCAGGGCATGGGCTGGCTCCCATGTTGAAGATTGCCGGCTTGATCAGTGCGCGTCAACATGAAACGAATTGACCAAATTGTACGCAACAGGCCGTTGATCAACGC";
	
			/* 10 */
			sequence2[0][9] = "GTCTGAGATTTCAATCCGATCTCCACCACAAAATACTACGCCCCCAGGGCCATTTCTCCCTCGATGAAGTGAGCTCTTGTTGTGGTGCTCCATAATGCGTCTTCTTGTAGCAATACTAGCATTCTGTACCCCGGAGAACTACGCTCAGGCTGTATTGTTGCCGGAACGTTAGCAATCTCATACAGGACCAATGTGGAGGC";
	
			/* 11 */
			sequence2[0][10] = "AAATTCATGAGTCATGAAAGCCGGCGCTCCTGAACATGGACGGCTAGTTCCTTCAGTGTTCCGTTCGGCCAACCGCAGTCCAGACCGTCCATGATCTGCTAACAGGTACCTGGTAGGCGTGAGAGTGCTAATCAACATAACTCTCTCCATACCATTCGCCCGGTAACCAGTCTGTACGACTTGTTGAGTACTTCTTGGTG";
	
			/* 12 */
			sequence2[0][11] = "TCCCGACTCCCCGCAGGCAGTGCACGGTGTTAAGCTACGTTCCGCAGACAGTATAATATCAGCCTTAGAAGCCGTGCTTGGTTTCAACTGCCCCAAGTAATCAAGTAGTAACTCGCTGACACGAAGAGGTGCCTGACAATACCCATGTAAGACCTACACCACCTACAGCGTTGCCAAGGTGGTTTGCGAGTGCGTTTCTT";
	
			/* 13 */
			sequence2[0][12] = "TTCCGGGAACCCAAGAACAAAGCTGGAGACACGCTCGTGAGGTCTCTATGAAACAAGTTCTCTCTCGTCAGTAGGTAGGGTTGCCTAAAACCGTACTCTTCCATTATATCCAGGTTTGGTAGACCTACCGGTGGAAAATCATACTAACGACTAATAACTTGGTAGAGTAACCCAATGTGTTACGCGCTTCTTTCGGGGGC";
			
			/* 14 */
			sequence2[0][13] = "TTCAACAGGGGTGGGTGCGCCACATAGCCGCCGCTGCGTTTACGAACTCAACCATGAGATTGACCGAGGCACCGGTTGCTTGGTAAGTTCTCAAGAGAGCCACTATATAGATCTCTTATCGGCGGCGGTCGCGGGGGGGGAACTTTCCCTAACAGGCCTCCTTCCATGATCGTGTACAACGAATCTTGCGTTGCGAGGGG";
	
			/* 15 */
			sequence2[0][14] = "AGAGAGCGGGGGTGTCCGTCGGCCCTTTACCACAGTGCTGCTACTGTATATGTGCCCCTACACTTTGCTGGGGGCTTGTCGCCGGGTAAAAAGAAGAGGCGTTCTACAGTATCACATCGTCGAAGCACTAACAATCCCTTTGGCAGGGTTAGGAGGGCGTTCCGTATGTAAACAGAGATCCGAGTTCGAGAGGTGGACCA";
	
			/* 16 */
			sequence2[0][15] = "TGGGAGGTTTTGCGCCTGTCCGCGTTGGCGTGTAAGATGATTAACGGCGACTTGACAATCTAGCGCTGAGGGGCTGATCTTGGTATCTCGTACGAATGGGCGACGAAAGGCGCCCACATCTCGTAAATCTCGGCGGGTCCCGTTCGGTTAGTACAGAGAAGGACGAATTTGGGTCACTACACGTACTCGTCTCGACGACT";
	
			/* 17 */
			sequence2[0][16] = "CAATTCTTGTTGCGCAACCCGAGTTCGCCCAGTATCCGCATAGGTCTGATTAGAGTAGTAGTGTCTCAGTATCGATCCGTGTAGATCTTTATAGATAGGCAACTGAGAGGACCTAGGCGCAACCAATTGCTACGCTCTCCCTGACACAGACAGAAATTACTCGAACTTCCACGTCGGATGCTACAGAGCTGACAACTAAT";
	
			/* 18 */
			sequence2[0][17] = "GACCTTGAAGCGCAGTCTCCACCATGTGAGGATGTCGAGGCTTGTCTTTTTCTGAGCACCACCGCCGAACGCCGACACGTCGTGTCTGCCATTGCGTTACACATCGGCCCAACAGAGAACTTACATCAGGGTGTTTCCTCAGATACTGCAGGAACTGTCTTGCGCCAACGATAGACGCAAAGAAATCTTGAAACACCGGA";
	
			/* 19 */
			sequence2[0][18] = "CTTGGAACGGCTCACAACAGCTTTTGCGCAACAAGCCTATATAGAATCAATGCCGCCAGGGAGTAAACCGATCCCCGCTTGGCGCATCGCTTACGAGGTCCTGGTCGCGAGGGTCCTGCATTCTAGCGTAAGGAATCCAGCAACTGGTTTGCTTAAGATATACCGTGGACGCGTGATGCAGCAGGACACACTGACAGGGG";
			
			/* 20 */
			sequence2[0][19] = "AAACAGACACTGTTAGCAACCTTTCACGGCGTATGATGACCAGTTCAGCTCCTCCCGGGTTCCGATAGTGTTGAGTAGCCGCGTAGCGGTTGTAGTGGGCTAGTCGTTTACTGATTTGTTTCCCCGAGTGGCTGAGAGAAGAAAAGCTTAGACAGCAGCTGTCGCGGGCTCAGGCTTGCAGGGGGCCCCGATTCACCCAA";
	
			/* Finding where the locations of the subsequence is at */
			
			/* Sequence 1 */
			double maxprob = 1.0;
			double oldmaxprob = 1.0;
			int tracker = 0;
			int i3 = 0;
			int seven = 7;
			int valplusseven = 0;
			int i4 = 0;
		for (i4 = 0; i4 < 20; i4++){
			for (i = 0; i < (200-6) ; i++){
				
				i3 = 0;
				//System.out.println("" + i);
				valplusseven = i + seven;
				for (i2 = i; i2 < (valplusseven); i2++){
					//System.out.println(""+ (i2 + seven));
					if ( sequence2[0][i4].substring(i2, i2+1).equals("A")){
						
						oldmaxprob += oldmaxprob*storeprob[0][i3];
						//System.out.println(storeprob[0][i2]+"");
					} else
					if ( sequence2[0][i4].substring(i2, i2+1).equals("C")){
						//System.out.println(storeprob[1][i2]+"");
						oldmaxprob += oldmaxprob*storeprob[1][i3];
					} else
					if ( sequence2[0][i4].substring(i2, i2+1).equals("G") ){
						//System.out.println(storeprob[2][i2]+"");
						oldmaxprob += oldmaxprob*storeprob[2][i3];
					} else
					if ( sequence2[0][i4].substring(i2, i2+1).equals("T") ){
						//System.out.println(storeprob[3][i2]+"");
						oldmaxprob += oldmaxprob*storeprob[3][i3];
					}
						//System.out.println("" + i3);
						i3++;
				}
				i3 = 0;
				//System.out.println(oldmaxprob + "");
				
				if (i == 0){
					maxprob = oldmaxprob;
					tracker = i;
				}
				
				else {
					
					if (oldmaxprob > maxprob){
					
						maxprob = oldmaxprob;
						tracker = i;
					}
				}
				
				oldmaxprob = 1;
				
			}
			System.out.println("Sequence " + (i4+ 1));
			System.out.println(sequence2[0][i4]);
			System.out.println("Best matched sequence: " + sequence2[0][i4].substring(tracker,tracker+7));
			System.out.println("Max Prob" + maxprob);
			System.out.println("tracker = " + tracker);
			System.out.println("");
		}
			
	}
}	
