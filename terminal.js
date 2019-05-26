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
		
		var t =	"These are the following commands for this Terminal."+"<br>"+
				"help "+"ls "+"cp "+"mv "+"rm "+"cd "+"<br>"+
				"mkdir "+"rmdir "+"find "+ "cat "+"nano "+"clear "+"<br>"+
				"games "+"neo "+"jobs "+"exit "+"reboot "+"shutdown "+"<br>";
				
		return t;
	}
	
	get ls(){
		var t = "This is ls which scans the drive and displays the files and folders."+"<br>";
			
		return t;
	}
	
	
}

const term = new Terminal();


function breakDownCMD(cmd){
	
	var t = cmd.trimRight();
	
	if (t === "help"){
	
		return term.help;
	} else if (t === "ls") {
		
		return term.ls;
	} else {
		
		return -1;
	}
	
	
	
	
}

function helpPrompt(){
	
	return term.help;
}

function terminalTest(){
	
	
	return term.help;
	
}





