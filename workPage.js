/* 	This is where all the work pages
 * 	will be contained
 * 	
 * 
 *  
 *  
 *  
 *  */


var documents = "<div style='width:100%;height:60px;background-color:orange;border:1px solid black;'>" +
					"<div id ='cFiles' style='background-color:blue;width:250px;height:60px;' onclick='openDocument(this.id)' >" +
						"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
						"<label for='folder'>C Programming Files </label>" +
					"</div> " +
				"</div>" +
				"<div style='width:100%;height:60px;background-color:orange;border:1px solid black;'>" +
					"<div id='javaFiles' style='background-color:blue;width:250px;height:60px;' onclick='openDocument(this.id)' >" +
						"<img id='folder' src='documentFolder.png' width='50' height='50' > " +
						"<label for='folder'>Java Programming Files </label>" +
					"</div>"+
				"</div>";

var cFiles = 	"<div style='width:100%;height:60px;background-color:orange;border:1px solid black;'>" +
					"<div id='advancedProgramming' style='background-color:blue;width:250px;height:60px;' onclick='openDocument(this.id)' >" +
						"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
						"<label for='folder'>Advanced Programming </label>" +
					"</div>" +
				"</div>" +
				"<div style='width:100%;height:60px;background-color:orange;border:1px solid black;'>" +
					"<div id='computerArchitecture' style='background-color:blue;width:250px;height:60px;' onclick='openDocument(this.id)' >" +
						"<img id='folder' src='documentFolder.png' width='50' height='50' > " +
						"<label for='folder'> Computer Architecture </label>" +
					"</div>" +
				"</div>";

var advancedProgramming = 	"<div style='width:100%;height:60px;background-color:orange;border:1px solid black;'>" +
								"<div id='advancedProgrammingHomeworks' style='background-color:blue;width:250px;height:60px;' onclick='openDocument(this.id)' >" +
									"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
									"<label for='folder'>Homeworks </label>" +
								"</div>"+
							"</div>" +
							"<div style='width:100%;height:60px;background-color:orange;border:1px solid black;'>" +
								"<div id='advancedProgrammingPractice' style='background-color:blue;width:250px;height:60px;' onclick='openDocument(this.id)' >" +
									"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
									"<label for='folder'>Practice </label>" +
								"</div>"+
							"</div>" +
							"<div style='width:100%;height:60px;background-color:orange;border:1px solid black;'>" +
								"<div id='advancedProgrammingRecitations' style='background-color:blue;width:250px;height:60px;' onclick='openDocument(this.id)' >" +
									"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
									"<label for='folder'>Recitations </label>" +
									"</div>"+
							"</div>";

var advancedProgrammingHomeworks =	"<div style='width:100%;height:60px;background-color:orange;border:1px solid black;'>" +
										"<div id='advancedProgrammingHomeworksHw1' style='background-color:blue;width:250px;height:60px;' onclick='openDocument(this.id)' >" +
											"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
												"<label for='folder'>Homework 1 </label>" +
										"</div>"+
									"</div>" +
									"<div style='width:100%;height:60px;background-color:orange;border:1px solid black;'>" +
										"<div id='advancedProgrammingHomeworksHw2' style='background-color:blue;width:250px;height:60px;' onclick='openDocument(this.id)' >" +
											"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
											"<label for='folder'>Homework 2</label>" +
										"</div>"+
									"</div>" +
									"<div style='width:100%;height:60px;background-color:orange;border:1px solid black;'>" +
										"<div id='advancedProgrammingHomeworksHw3' style='background-color:blue;width:250px;height:60px;' onclick='openDocument(this.id)' >" +
											"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
											"<label for='folder'>Homework 3</label>" +
										"</div>"+
									"</div>" +
									"<div style='width:100%;height:60px;background-color:orange;border:1px solid black;'>" +
										"<div id='advancedProgrammingHomeworksHw4' style='background-color:blue;width:250px;height:60px;' onclick='openDocument(this.id)' >" +
											"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
											"<label for='folder'>Homework 4</label>" +
										"</div>"+
									"</div>" +
									"<div style='width:100%;height:60px;background-color:orange;border:1px solid black;'>" +
										"<div id='advancedProgrammingHomeworksHw5' style='background-color:blue;width:250px;height:60px;' onclick='openDocument(this.id)' >" +
											"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
											"<label for='folder'>Homework 5</label>" +
										"</div>"+
									"</div>" +
									"<div style='width:100%;height:60px;background-color:orange;border:1px solid black;'>" +
										"<div id='advancedProgrammingHomeworksHw6' style='background-color:blue;width:250px;height:60px;' onclick='openDocument(this.id)' >" +
											"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
											"<label for='folder'>Homework 6</label>" +
										"</div>"+
									"</div>" +
									"<div style='width:100%;height:60px;background-color:orange;border:1px solid black;'>" +
										"<div id='advancedProgrammingHomeworksHw7' style='background-color:blue;width:250px;height:60px;' onclick='openDocument(this.id)' >" +
											"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
											"<label for='folder'>Homework 7</label>" +
										"</div>"+
									"</div>" +
									"<div style='width:100%;height:60px;background-color:orange;border:1px solid black;'>" +
										"<div id='advancedProgrammingHomeworksHw8' style='background-color:blue;width:250px;height:60px;' onclick='openDocument(this.id)' >" +
											"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
											"<label for='folder'>Homework 8</label>" +
										"</div>"+
									"</div>" +
									"<div style='width:100%;height:60px;background-color:orange;border:1px solid black;'>" +
										"<div id='advancedProgrammingHomeworksHw9' style='background-color:blue;width:250px;height:60px;' onclick='openDocument(this.id)' >" +
											"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
											"<label for='folder'>Homework 9</label>" +
										"</div>"+
									"</div>";

var advancedProgrammingHomeworksHw1 = 	"calendar.exe" +
										"<br>" +
										"<a id = 'advancedProgrammingHomeworksHw1Calendar_c' href='#' onclick='openFile(this.id)'> calendar.c </a>" +
										"<br>" +
										"calendar.txt" +
										"<br>" +
										"hw01F.c" +
										"<br>" +
										"hw-01-ch1-sp-calendar.pdf" +
										"<br>" +
										"output.txt";

var advancedProgrammingHomeworksHw2 =	"hw02.exe" +
										"<br>" +
										"<a id ='advancedProgrammingHomeworksHw2hw02_c' href='#' onclick='openFile(this.id)' >hw02.c </a>" +
										"<br>" +
										"hw-02-ch1-sp-GameofLife.pdf" +
										"<br>" +
										"output.txt";

var advancedProgrammingPractice = 	"fall2010MidtermOne.c" +
									"<br>" +
									"<div style='width:100%;height:60px;background-color:orange;border:1px solid black;'>" +
										"<div id='advancedProgrammingPracticeFinal' style='background-color:blue;width:250px;height:60px;' onclick='openDocument(this.id)' >" +
											"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
											"<label for='folder'>Final</label>" +
										"</div>"+
									"</div>" +
									"<br>" +
									"<div style='width:100%;height:60px;background-color:orange;border:1px solid black;'>" +
										"<div id='advancedProgrammingPracticeMidtermTwo' style='background-color:blue;width:250px;height:60px;' onclick='openDocument(this.id)' >" +
											"<img id='folder' src='documentFolder.png' width='50' height='50' >" +
											"<label for='folder'>Midterm Two</label>" +
										"</div>"+
									"</div>" +
									"<br>" +
									"TestingHaxPad.c";
									
										

		
		

	
								




