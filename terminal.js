// help commands to use for terminal
// help
// ls
// exit
// reboot
// games
// use cookies to store files 
// become a user on the pc

'use strict';


class Terminal { 
	
	
	constructor( ){
		
		
	}
	
	get help() {
		
		var t = ""+"\n"+
				"help"+"\n"+
				"ls"+"\n"+
				"cp"+"\n"+
				"mv"+"\n"+
				"rm"+"\n"+
				
				
				"cd"+"\n"+
				"mkdir"+"\n"+
				"rmdir"+"\n"+
				"find"+"\n"+
				
				
				"cat"+"\n"+
				"nano"+"\n"+
				"clear"+"\n"+
				"games"+"\n"+
				"neo"+"\n"+
				"jobs"+"\n"+
				
				
				"exit"+"\n"+
				"reboot"+"\n"+
				"shutdown"+"\n";
				
		
		return t;
	}
	
	get ls(){
		var t = "This is ls which scans the drive and displays the files and folders";
		
	}
	
	
}

const term = new Terminal();


function breakDownCMD(cmd){
	
	
	if (cmd === "help"){
	
		return term.help;
	}
	
	
	
}

function helpPrompt(){
	
	return term.help;
}

function terminalTest(){
	
	
	return term.help;
	
}





