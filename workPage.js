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
				"<div style='width:100%;height:60px;'>" +
					"<div id='javaFiles' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
						"<img id='folder' src='documentFolder.png' width='50' height='50' > " +
						"<label for='folder'>Java Programming Files </label>" +
					"</div>"+
				"</div>";

var cFiles = 	"<div style='width:100%;height:60px;'>" +
					"<div id='advancedProgramming' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
						"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
						"<label for='folder'>Advanced Programming </label>" +
					"</div>" +
				"</div>" +
				"<div style='width:100%;height:60px;'>" +
					"<div id='computerArchitecture' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
						"<img id='folder' src='documentFolder.png' width='50' height='50' > " +
						"<label for='folder'> Computer Architecture </label>" +
					"</div>" +
				"</div>";

var advancedProgramming = 	"<div style='width:100%;height:60px;'>" +
								"<div id='advancedProgrammingHomeworks' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
									"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
									"<label for='folder'>Homeworks </label>" +
								"</div>"+
							"</div>" +
							"<div style='width:100%;height:60px;'>" +
								"<div id='advancedProgrammingPractice' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
									"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
									"<label for='folder'>Practice </label>" +
								"</div>"+
							"</div>" +
							"<div style='width:100%;height:60px;'>" +
								"<div id='advancedProgrammingRecitations' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
									"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
									"<label for='folder'>Recitations </label>" +
									"</div>"+
							"</div>";

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
										"<div id='advancedProgrammingHomeworksHw7' style='width:250px;height:60px;' onclick='openDocument(this.id)' >" +
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

var advancedProgrammingHomeworksHw4 = 	"<a id = 'advancedProgrammingHomeworksHw4Hw04.c' href='#' onclick='openFile(this.id)' > hw04.c </a> " +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw4Hw-04-ch2-sp-payroll_pdf' href='#' onclick='openFile(this.id)'> hw-04-ch2-sp-payroll.pdf </a> " +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw4Output_txt' href='#' onclick='openFile(this.id)' > output.txt </a>" +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw4Valgrindoutput_txt' href='#' onclick='openFile(this.id)'> valgrindOutput.txt </a> ";										
										
										
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

documentLibrary.push(advancedProgrammingPractice);


var documentNames = new Array();
documentNames.push('collegeFiles');
documentNames.push('cFiles');
documentNames.push('advancedProgramming');
documentNames.push('advancedProgrammingHomeworks');
documentNames.push('advancedProgrammingHomeworksHw1');
documentNames.push('advancedProgrammingHomeworksHw2');
documentNames.push('advancedProgrammingHomeworksHw3');
documentNames.push('advancedProgrammingHomeworksHw4');



documentNames.push('advancedProgrammingPractice');


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
documentFiles["advancedProgrammingHomeworksHw4Hw04.c"] = "documents/cFiles/advancedProgramming/Homeworks/hw04/hw04.c";
documentFiles["advancedProgrammingHomeworksHw4Hw-04-ch2-sp-payroll_pdf"] = "documents/cFiles/advancedProgramming/Homeworks/hw04/hw-04-ch2-sp-payroll.pdf";
documentFiles["advancedProgrammingHomeworksHw4Output_txt"] = "documents/cFiles/advancedProgramming/Homeworks/hw04/output.txt";
documentFiles["advancedProgrammingHomeworksHw4Valgrindoutput_txt"] = "documents/cFiles/advancedProgramming/Homeworks/hw04/valgrindOutput.txt";


var documentFileNames = {};
documentFileNames["advancedProgrammingHomeworksHw1Calendar_c"] = "Calendar.c";
documentFileNames["advancedProgrammingHomeworksHw1Calendar_txt"] = "Calendar.txt";
documentFileNames["advancedProgrammingHomeworksHw1Hw01F_c"] = "Hw01F.c";
documentFileNames["advancedProgrammingHomeworksHw1Hw-01-ch1-sp-calendar_pdf"] = "Hw-01-ch1-sp-calendar.pdf";
documentFileNames["advancedProgrammingHomeworksHw1output_txt"] = "output.txt";


var documentFolderNames = {};
documentFolderNames["collegeFiles"] = "College Files";
documentFolderNames["cFiles"] = "C Programming Files";


documentFolderNames['advancedProgramming'] = "Advanced Programming";
documentFolderNames['advancedProgrammingHomeworks'] = "Homeworks";
documentFolderNames['advancedProgrammingHomeworksHw1'] = "Homework 1";
documentFolderNames['advancedProgrammingHomeworksHw2'] = "Homework 2";
documentFolderNames['advancedProgrammingHomeworksHw3'] = "Homework 3";
documentFolderNames['advancedProgrammingHomeworksHw4'] = "Homework 4";
documentFolderNames['advancedProgrammingPractice'] = "Practice";



									

		
		

	
								




