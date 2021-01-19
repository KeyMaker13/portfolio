function testExternalFile(){
	alert();
	alert(documentLibrary[0]);
}
 
function getDocumentOrder(index){
	
	return documentOrder[index];
}

function getDocumentOrderLength(){
	
	return documentOrder.length;
}

function getDocumentOrderLastIndexOf(folderName){
	
	return documentOrder.lastIndexOf(folderName);
}

function documentOrderPush(folderName){
		
	documentOrder.push(folderName);	
}

function setDocumentOrder(docArray){
	
	documentOrder = docArray;
}

function getDocumentLibrary(index){
		
	return documentLibrary[index];
}

function getDocumentNamesLastIndexOf(folderName){
	
	return documentNames.lastIndexOf(folderName);
}

function getDocumentFiles(fileName){
	
	return documentFiles[fileName];
}

function getDocumentFolderNames(folderName){
	
	return documentFolderNames[folderName];
}

function getDocumentFileNames(fileName){
	
	return documentFileNames[fileName];
}

var collegeFiles = "<div style='width:100%;height:60px;'>" +
					"<div id ='cFiles' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
						"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
						"<label for='folder'>C Programming Files </label>" +
					"</div> " +
				"</div>" +
				" ";
				//"<div style='width:100%;height:60px;'>" +
				//	"<div id='javaFiles' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
				//		"<img id='folder' src='documentFolder.png' width='50' height='50' > " +
				//		"<label for='folder'>Java Programming Files </label>" +
				//	"</div>"+
				//"</div>";

var cFiles = 	"<div style='width:100%;height:60px;'>" +
					"<div id='advancedProgramming' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
						"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
						"<label for='folder'>Advanced Programming </label>" +
					"</div>" +
				"</div>" +
				" ";
				//"<div style='width:100%;height:60px;'>" +
				//	"<div id='computerArchitecture' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
				//		"<img id='folder' src='documentFolder.png' width='50' height='50' > " +
				//		"<label for='folder'> Computer Architecture </label>" +
				//	"</div>" +
				//"</div>";

var advancedProgramming = 	"<div style='width:100%;height:60px;'>" +
								"<div id='advancedProgrammingHomeworks' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
									"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
									"<label for='folder'>Homeworks </label>" +
								"</div>"+
							"</div>" +
							" ";
							//"<div style='width:100%;height:60px;'>" +
							//	"<div id='advancedProgrammingPractice' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
							//		"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
							//		"<label for='folder'>Practice </label>" +
							//	"</div>"+
							//"</div>" +
							//"<div style='width:100%;height:60px;'>" +
							//	"<div id='advancedProgrammingRecitations' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
							//		"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
							//		"<label for='folder'>Recitations </label>" +
							//		"</div>"+
							//"</div>";

var advancedProgrammingHomeworks =	"<div style='width:100%;height:60px;'>" +
										"<div id='advancedProgrammingHomeworksHw1' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
											"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
												"<label for='folder'>Homework 1 </label>" +
										"</div>"+
									"</div>" +
									"<div style='width:100%;height:60px;'>" +
										"<div id='advancedProgrammingHomeworksHw2' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
											"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
											"<label for='folder'>Homework 2</label>" +
										"</div>"+
									"</div>" +
									"<div style='width:100%;height:60px;'>" +
										"<div id='advancedProgrammingHomeworksHw3' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
											"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
											"<label for='folder'>Homework 3</label>" +
										"</div>"+
									"</div>" +
									"<div style='width:100%;height:60px;'>" +
										"<div id='advancedProgrammingHomeworksHw4' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
											"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
											"<label for='folder'>Homework 4</label>" +
										"</div>"+
									"</div>" +
									"<div style='width:100%;height:60px;'>" +
										"<div id='advancedProgrammingHomeworksHw4F' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
											"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
											"<label for='folder'>Homework 4 Final</label>" +
										"</div>"+
									"</div>" +									
									"<div style='width:100%;height:60px;'>" +
										"<div id='advancedProgrammingHomeworksHw5' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
											"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
											"<label for='folder'>Homework 5</label>" +
										"</div>"+
									"</div>" +
									"<div style='width:100%;height:60px;'>" +
										"<div id='advancedProgrammingHomeworksHw6' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
											"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
											"<label for='folder'>Homework 6</label>" +
										"</div>"+
									"</div>" +
									"<div style='width:100%;height:60px;'>" +
										"<div id='advancedProgrammingHomeworksHw6' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
											"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
											"<label for='folder'>Homework 7</label>" +
										"</div>"+
									"</div>" +
									"<div style='width:100%;height:60px;'>" +
										"<div id='advancedProgrammingHomeworksHw8' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
											"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
											"<label for='folder'>Homework 8</label>" +
										"</div>"+
									"</div>" +
									"<div style='width:100%;height:60px;'>" +
										"<div id='advancedProgrammingHomeworksHw9' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
											"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
											"<label for='folder'>Homework 9</label>" +
										"</div>"+
									"</div>";
									
var advancedProgrammingHomeworksHw1 = 	"<a id = 'advancedProgrammingHomeworksHw1Calendar_c' href='#' onclick='openFile(this.id)'> calendar.c </a>" +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw1Calendar_txt' href='#' onclick='openFile(this.id)' > calendar.txt </a>" +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw1Hw01F_c' href='#' onclick='openFile(this.id)' > hw01F.c </a>" +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw1Hw-01-ch1-sp-calendar_pdf' href='#' onclick='openFile(this.id)'> hw-01-ch1-sp-calendar.pdf </a> " +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw1output_txt' href='#' onclick='openFile(this.id)' > output.txt </a>";

var advancedProgrammingHomeworksHw2 =	"<a id = 'advancedProgrammingHomeworksHw2hw02_c' href='#' onclick='openFile(this.id)' > hw02.c </a>" +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw2Hw-02-ch1-sp-GameofLife_pdf' href='#' onclick='openFile(this.id)' > hw-02-ch1-sp-GameofLife.pdf </a>" +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw2Output_txt' href='#' onclick='openFile(this.id)' >  output.txt </a>";

var advancedProgrammingHomeworksHw3 = 	"<a id = 'advancedProgrammingHomeworksHw3Computer_gif' href='#' onclick='openFile(this.id)' > computer.gif </a> " +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw3hw03_c' href='#' onclick='openFile(this.id)'> hw03.c </a> " +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw3Hw-03-ch2-sp-wordsearch-string-pointer_pdf' href='#' onclick='openFile(this.id)' > hw-03-ch2-sp-wordsearch-string-pointer.pdf </a>" +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw3Output_txt' href='#' onclick='openFile(this.id)'> output.txt </a> ";

var advancedProgrammingHomeworksHw4 = 	"<a id = 'advancedProgrammingHomeworksHw4Hw04_c' href='#' onclick='openFile(this.id)' > hw04.c </a> " +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw4Hw-04-ch2-sp-payroll_pdf' href='#' onclick='openFile(this.id)'> hw-04-ch2-sp-payroll.pdf </a> " +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw4Output_txt' href='#' onclick='openFile(this.id)' > output.txt </a>" +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw4Valgrindoutput_txt' href='#' onclick='openFile(this.id)'> valgrindOutput.txt </a> ";										

var advancedProgrammingHomeworksHw4F = 	"<a id = 'advancedProgrammingHomeworksHw4FHw04FinalVersion_c' href='#' onclick='openFile(this.id)' > hw04FinalVersion.c </a> " +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw4FHw-04-ch2-sp-payroll_pdf' href='#' onclick='openFile(this.id)'> hw-04-ch2-sp-payroll.pdf </a> " +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw4FOutput_txt' href='#' onclick='openFile(this.id)' > output.txt </a>" +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw4FValgrindoutput_txt' href='#' onclick='openFile(this.id)'> valgrind output.txt </a> ";

var advancedProgrammingHomeworksHw5 =	"<a id = 'advancedProgrammingHomeworksHw5ErrorOutput_txt' href='#' onclick='openFile(this.id)' > errorOutput.txt </a> " +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw5Hangman_c' href='#' onclick='openFile(this.id)'> hangman.c </a> " +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw5Hw-05-ch3-fall-hangman_pdf' href='#' onclick='openFile(this.id)' > hw-05-ch3-fall-hangman.pdf </a>" +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw5Makefile_txt' href='#' onclick='openFile(this.id)'> Makefile.txt </a> " +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw5RandWord_c' href='#' onclick='openFile(this.id)'> randword.c </a> " +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw5RandWord_h' href='#' onclick='openFile(this.id)'> randword.h </a> " +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw5Words_txt' href='#' onclick='openFile(this.id)'> words.txt </a> ";

var advancedProgrammingHomeworksHw6 =	"<a id = 'advancedProgrammingHomeworksHw6Driver_c' href='#' onclick='openFile(this.id)' > driver.c </a> " +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw6Hw-06-ch5-recursion_pdf' href='#' onclick='openFile(this.id)'> hw-06-ch5-recursion.pdf </a> " +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw6Makefile_txt' href='#' onclick='openFile(this.id)' > Makefile.txt </a>" +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw6Mnemonics_c' href='#' onclick='openFile(this.id)'> mnemonics.c </a> " +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw6Mnemonics_h' href='#' onclick='openFile(this.id)'> mnemonics.h </a> " +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw6Output_txt' href='#' onclick='openFile(this.id)'> output.txt </a> " +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw6ValgrindOutput_txt' href='#' onclick='openFile(this.id)'> valgrindOutput.txt </a> ";
										
var advancedProgrammingHomeworksHw7 = 	"<a id = 'advancedProgrammingHomeworksHw7Driver_c' href='#' onclick='openFile(this.id)'> driver.c </a> " +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw7GdbOutput_txt' href='#' onclick=''> gdbOutput.txt </a> " +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw7hw-07-fall-use-scanner.pdf' href='#' onclick=''> </a> " +
										"<br>" ;
										
								
/*

"<a id = '' href='#' onclick=''> </a> " +
"<br>" +

hw07
│   │   │   │   ├── driver.c +
│   │   │   │   ├── gdbOutput.txt +
│   │   │   │   ├── hw-07-fall-use-scanner.pdf
│   │   │   │   ├── Makefile.txt
│   │   │   │   ├── scanadt.c
│   │   │   │   ├── scanadt.h
│   │   │   │   ├── student1.dat
│   │   │   │   ├── student1.dat.txt
│   │   │   │   ├── student2.dat
│   │   │   │   ├── student2.dat.txt
│   │   │   │   ├── testscan.c
│   │   │   │   └── valgrindOutput.txt
│   │   │   ├── hw08
│   │   │   │   ├── arraybuf.c
│   │   │   │   ├── buffer.h
│   │   │   │   ├── doublebuf.c
│   │   │   │   ├── editor.c
│   │   │   │   ├── hw-08-sp-ddl-array-ex13.pdf
│   │   │   │   ├── listbuf.c
│   │   │   │   ├── Makefile
│   │   │   │   ├── Makefile.txt
│   │   │   │   ├── stackbuf.c
│   │   │   │   ├── stack.c
│   │   │   │   └── stack.h
│   │   │   └── hw09
│   │   │       ├── gdbOutput.txt
│   │   │       ├── hw09.c
│   │   │       ├── hw-09-tree.pdf
│   │   │       ├── Makefile
│   │   │       ├── Makefile.txt
│   │   │       ├── output.txt
│   │   │       ├── scanadt.c
│   │   │       ├── scanadt.h
│   │   │       └── valgrindOutput.txt
*/
										
										
										
										
var advancedProgrammingPractice = 	"fall2010MidtermOne.c" +
									"<br>" +
									"<div style='width:100%;height:60px;'>" +
										"<div id='advancedProgrammingPracticeFinal' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
											"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
											"<label for='folder'>Final</label>" +
										"</div>"+
									"</div>" +
									"<br>" +
									"<div style='width:100%;height:60px;'>" +
										"<div id='advancedProgrammingPracticeMidtermTwo' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
											"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
											"<label for='folder'>Midterm Two</label>" +
										"</div>"+
									"</div>" +
									"<br>" +
									"TestingHaxPad.c";
									
var currentProjects = 		"<div style='width:100%;height:60px;'>" +
								"<div id ='rubixCube' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
									"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
									"<label for='folder'>Rubix Cube </label>" +
								"</div> " +
							"</div>";

var rubixCube = 	"<a id = 'rubixCube_HTML' href='#' onclick='openFile(this.id)' > index.html </a> ";
						
									
var documentOrder = new Array();

var documentLibrary = new Array();
documentLibrary.push(collegeFiles);
documentLibrary.push(cFiles);
documentLibrary.push(advancedProgramming);
documentLibrary.push(advancedProgrammingHomeworks);
documentLibrary.push(advancedProgrammingHomeworksHw1);
documentLibrary.push(advancedProgrammingHomeworksHw2);
documentLibrary.push(advancedProgrammingHomeworksHw3);
documentLibrary.push(advancedProgrammingHomeworksHw4);
documentLibrary.push(advancedProgrammingHomeworksHw4F);
documentLibrary.push(advancedProgrammingHomeworksHw5);
documentLibrary.push(advancedProgrammingHomeworksHw6);

documentLibrary.push(advancedProgrammingPractice);
documentLibrary.push(currentProjects);
documentLibrary.push(rubixCube);


var documentNames = new Array();
documentNames.push('collegeFiles');
documentNames.push('cFiles');
documentNames.push('advancedProgramming');
documentNames.push('advancedProgrammingHomeworks');
documentNames.push('advancedProgrammingHomeworksHw1');
documentNames.push('advancedProgrammingHomeworksHw2');
documentNames.push('advancedProgrammingHomeworksHw3');
documentNames.push('advancedProgrammingHomeworksHw4');
documentNames.push('advancedProgrammingHomeworksHw4F');
documentNames.push('advancedProgrammingHomeworksHw5');
documentNames.push('advancedProgrammingHomeworksHw6');

documentNames.push('advancedProgrammingPractice');
documentNames.push('currentProjects');
documentNames.push('rubixCube');


//This is where the src to the files will be
var documentFiles = {};

/* advancedProgramming/Homeworks/hw01/ */
documentFiles["advancedProgrammingHomeworksHw1Calendar_c"] = "documents/cFiles/advancedProgramming/Homeworks/hw01/calendar.c";
documentFiles["advancedProgrammingHomeworksHw1Calendar_txt"] = "documents/cFiles/advancedProgramming/Homeworks/hw01/calendar.txt";
documentFiles["advancedProgrammingHomeworksHw1Hw01F_c"] = "documents/cFiles/advancedProgramming/Homeworks/hw01/hw01F.c";
documentFiles["advancedProgrammingHomeworksHw1Hw-01-ch1-sp-calendar_pdf"] = "documents/cFiles/advancedProgramming/Homeworks/hw01/hw-01-ch1-sp-calendar.pdf";
documentFiles["advancedProgrammingHomeworksHw1output_txt"] = "documents/cFiles/advancedProgramming/Homeworks/hw01/output.txt";

/* advancedProgramming/Homeworks/hw02/ */
documentFiles["advancedProgrammingHomeworksHw2hw02_c"] = "documents/cFiles/advancedProgramming/Homeworks/hw02/hw02.c";
documentFiles["advancedProgrammingHomeworksHw2Hw-02-ch1-sp-GameofLife_pdf"] = "documents/cFiles/advancedProgramming/Homeworks/hw02/hw-02-ch1-sp-GameofLife.pdf";
documentFiles["advancedProgrammingHomeworksHw2Output_txt"] = "documents/cFiles/advancedProgramming/Homeworks/hw02/output.txt";

/* advancedProgramming/Homeworks/hw03/ */
documentFiles["advancedProgrammingHomeworksHw3Computer_gif"] = "documents/cFiles/advancedProgramming/Homeworks/hw03/computer.gif";
documentFiles["advancedProgrammingHomeworksHw3hw03_c"] = "documents/cFiles/advancedProgramming/Homeworks/hw03/hw03.c";
documentFiles["advancedProgrammingHomeworksHw3Hw-03-ch2-sp-wordsearch-string-pointer_pdf"] = "documents/cFiles/advancedProgramming/Homeworks/hw03/hw-03-ch2-sp-wordsearch-string-pointer.pdf";
documentFiles["advancedProgrammingHomeworksHw3Output_txt"] = "documents/cFiles/advancedProgramming/Homeworks/hw03/output.txt";

/* advancedProgramming/Homeworks/hw04 */
documentFiles["advancedProgrammingHomeworksHw4Hw04_c"] = "documents/cFiles/advancedProgramming/Homeworks/hw04/hw04.c";
documentFiles["advancedProgrammingHomeworksHw4Hw-04-ch2-sp-payroll_pdf"] = "documents/cFiles/advancedProgramming/Homeworks/hw04/hw-04-ch2-sp-payroll.pdf";
documentFiles["advancedProgrammingHomeworksHw4Output_txt"] = "documents/cFiles/advancedProgramming/Homeworks/hw04/output.txt";
documentFiles["advancedProgrammingHomeworksHw4Valgrindoutput_txt"] = "documents/cFiles/advancedProgramming/Homeworks/hw04/valgrindOutput.txt";

/* advancedProgramming/Homeworks/hw04F */
documentFiles["advancedProgrammingHomeworksHw4FHw04FinalVersion_c"] = "documents/cFiles/advancedProgramming/Homeworks/hw04F/hw04FinalVersion.c";
documentFiles["advancedProgrammingHomeworksHw4FHw-04-ch2-sp-payroll_pdf"] = "documents/cFiles/advancedProgramming/Homeworks/hw04F/hw-04-ch2-sp-payroll.pdf";
documentFiles["advancedProgrammingHomeworksHw4FOutput_txt"] = "documents/cFiles/advancedProgramming/Homeworks/hw04F/output.txt";
documentFiles["advancedProgrammingHomeworksHw4FValgrindoutput_txt"] = "documents/cFiles/advancedProgramming/Homeworks/hw04F/valgrind output.txt";

/* advancedProgramming/Homeworks/hw05 */
documentFiles["advancedProgrammingHomeworksHw5ErrorOutput_txt"] = "documents/cFiles/advancedProgramming/Homeworks/hw05/errorOutput.txt";
documentFiles["advancedProgrammingHomeworksHw5Hangman_c"] = "documents/cFiles/advancedProgramming/Homeworks/hw05/hangman.c";							
documentFiles["advancedProgrammingHomeworksHw5Hw-05-ch3-fall-hangman_pdf"] = "documents/cFiles/advancedProgramming/Homeworks/hw05/hw-05-ch3-fall-hangman.pdf";							
documentFiles["advancedProgrammingHomeworksHw5Makefile_txt"] = "documents/cFiles/advancedProgramming/Homeworks/hw05/Makefile.txt";
documentFiles["advancedProgrammingHomeworksHw5RandWord_c"] = "documents/cFiles/advancedProgramming/Homeworks/hw05/randword.c";
documentFiles["advancedProgrammingHomeworksHw5RandWord_h"] = "documents/cFiles/advancedProgramming/Homeworks/hw05/randword.h";				
documentFiles["advancedProgrammingHomeworksHw5Words_txt"] = "documents/cFiles/advancedProgramming/Homeworks/hw05/words.txt";		
																				
/* advancedProgramming/Homeworks/hw06 */																			
documentFiles["advancedProgrammingHomeworksHw6Driver_c"] = "documents/cFiles/advancedProgramming/Homeworks/hw06/driver.c";
documentFiles["advancedProgrammingHomeworksHw6Hw-06-ch5-recursion_pdf"] = "documents/cFiles/advancedProgramming/Homeworks/hw06/hw-06-ch5-recursion.pdf";
documentFiles["advancedProgrammingHomeworksHw6Makefile_txt"] = "documents/cFiles/advancedProgramming/Homeworks/hw06/Makefile.txt";
documentFiles["advancedProgrammingHomeworksHw6Mnemonics_c"] = "documents/cFiles/advancedProgramming/Homeworks/hw06/mnemonics.c";
documentFiles["advancedProgrammingHomeworksHw6Mnemonics_h"] = "documents/cFiles/advancedProgramming/Homeworks/hw06/mnemonics.h";
documentFiles["advancedProgrammingHomeworksHw6Output_txt"] = "documents/cFiles/advancedProgramming/Homeworks/hw06/output.txt";
documentFiles["advancedProgrammingHomeworksHw6ValgrindOutput_txt"] = "documents/cFiles/advancedProgramming/Homeworks/hw06/valgrindOutput.txt";										
																				
/* currentProjects/rubixcube/index.html */
documentFiles["rubixCube_HTML"] = "currentProjects/rubixcube/index.html";


var documentFileNames = {};
/* advancedProgramming/Homeworks/hw01 */
documentFileNames["advancedProgrammingHomeworksHw1Calendar_c"] = "Calendar.c";
documentFileNames["advancedProgrammingHomeworksHw1Calendar_txt"] = "Calendar.txt";
documentFileNames["advancedProgrammingHomeworksHw1Hw01F_c"] = "Hw01F.c";
documentFileNames["advancedProgrammingHomeworksHw1Hw-01-ch1-sp-calendar_pdf"] = "Hw-01-ch1-sp-calendar.pdf";
documentFileNames["advancedProgrammingHomeworksHw1output_txt"] = "output.txt";

/* advancedProgramming/Homeworks/hw02 */
documentFileNames["advancedProgrammingHomeworksHw2hw02_c"] = "hw02.c";
documentFileNames["advancedProgrammingHomeworksHw2Hw-02-ch1-sp-GameofLife_pdf"] = "hw-02-ch1-sp-GameofLife.pdf";
documentFileNames["advancedProgrammingHomeworksHw2Output_txt"] = "output.txt";

/* advancedProgramming/Homeworks/hw03 */
documentFileNames["advancedProgrammingHomeworksHw3Computer_gif"] = "computer.gif";
documentFileNames["advancedProgrammingHomeworksHw3hw03_c"] = "hw03.c";
documentFileNames["advancedProgrammingHomeworksHw3Hw-03-ch2-sp-wordsearch-string-pointer_pdf"] = "hw-03-ch2-sp-wordsearch-string-pointer.pdf";
documentFileNames["advancedProgrammingHomeworksHw3Output_txt"] = "output.txt";

/* advancedProgramming/Homeworks/hw04 */
documentFileNames["advancedProgrammingHomeworksHw4Hw04_c"] = "hw04.c";
documentFileNames["advancedProgrammingHomeworksHw4Hw-04-ch2-sp-payroll_pdf"] = "hw-04-ch2-sp-payroll.pdf";
documentFileNames["advancedProgrammingHomeworksHw4Output_txt"] = "output.txt";
documentFileNames["advancedProgrammingHomeworksHw4Valgrindoutput_txt"] = "valgrindOutput.txt";

/* advancedProgramming/Homeworks/hw04F */
documentFileNames["advancedProgrammingHomeworksHw4FHw04FinalVersion_c"] = "hw04FinalVersion.c";
documentFileNames["advancedProgrammingHomeworksHw4FHw-04-ch2-sp-payroll_pdf"] = "hw-04-ch2-sp-payroll.pdf";
documentFileNames["advancedProgrammingHomeworksHw4FOutput_txt"] = "output.txt";
documentFileNames["advancedProgrammingHomeworksHw4FValgrindoutput_txt"] = "valgrind output.txt";

/* advancedProgramming/Homeworks/hw05 */
documentFileNames["advancedProgrammingHomeworksHw5ErrorOutput_txt"] = "errorOutput.txt";
documentFileNames["advancedProgrammingHomeworksHw5Hangman_c"] = "hangman.c";							
documentFileNames["advancedProgrammingHomeworksHw5Hw-05-ch3-fall-hangman_pdf"] = "hw-05-ch3-fall-hangman.pdf";							
documentFileNames["advancedProgrammingHomeworksHw5Makefile_txt"] = "Makefile.txt";
documentFileNames["advancedProgrammingHomeworksHw5RandWord_c"] = "randword.c";
documentFileNames["advancedProgrammingHomeworksHw5RandWord_h"] = "randword.h";				
documentFileNames["advancedProgrammingHomeworksHw5Words_txt"] = "words.txt";		

/* advancedProgramming/Homeworks/hw06 */
documentFileNames["advancedProgrammingHomeworksHw6Driver_c"] = "driver.c";
documentFileNames["advancedProgrammingHomeworksHw6Hw-06-ch5-recursion_pdf"] = "hw-06-ch5-recursion.pdf";
documentFileNames["advancedProgrammingHomeworksHw6Makefile_txt"] = "Makefile.txt";
documentFileNames["advancedProgrammingHomeworksHw6Mnemonics_c"] = "mnemonics.c";
documentFileNames["advancedProgrammingHomeworksHw6Mnemonics_h"] = "mnemonics.h";
documentFileNames["advancedProgrammingHomeworksHw6Output_txt"] = "output.txt";
documentFileNames["advancedProgrammingHomeworksHw6ValgrindOutput_txt"] = "valgrindOutput.txt";	

/* currentProjects/rubixcube/ */
documentFileNames["rubixCube_HTML"] = "index.html";

var documentFolderNames = {};
documentFolderNames["collegeFiles"] = "College Files";
documentFolderNames["cFiles"] = "C Programming Files";


/* Advanced Programming */
documentFolderNames['advancedProgramming'] = "Advanced Programming";
documentFolderNames['advancedProgrammingHomeworks'] = "Homeworks";
documentFolderNames['advancedProgrammingHomeworksHw1'] = "Homework 1";
documentFolderNames['advancedProgrammingHomeworksHw2'] = "Homework 2";
documentFolderNames['advancedProgrammingHomeworksHw3'] = "Homework 3";
documentFolderNames['advancedProgrammingHomeworksHw4'] = "Homework 4";
documentFolderNames['advancedProgrammingHomeworksHw4F'] = "Homework 4 Final";
documentFolderNames['advancedProgrammingHomeworksHw5'] = "Homework 5";
documentFolderNames['advancedProgrammingHomeworksHw6'] = "Homework 6";
documentFolderNames['advancedProgrammingPractice'] = "Practice";

/* current projects */
documentFolderNames["currentProjects"] = "Current Projects";
documentFolderNames["rubixCube"] = "Rubix Cube";



									

		
		

	
								




