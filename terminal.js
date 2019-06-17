// help commands to use for terminal
// help
// ls
// exit
// reboot
// games
// use cookies to store files 
// become a user on the pc


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
		
		// set path with cookies setCookie("path=root/test","type=folder",30);
		setCookie("path=root;type=folder;current=no;", "data=test;", 5);
		setCookie("path=root\test;type=folder;current=no;", "data=none;", 5);
		setCookie("path=root\test_html;type=file;current=no;", "data='testtext';", 5);
		

		return t;
	}

	get cp(){
		var t = "This is to copy a file."

		return t;
	}
	
	
}

const term = new Terminal();


function breakDownCMD(cmd){
	
	var t = cmd.trimRight();
	
	if (t === "help"){
	
		//setCookie("test","true",15);
		//alert(getCookie("test"));
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

function setCookie(cname, cvalue, exdays) {
  var d = new Date();
  d.setTime(d.getTime() + (exdays*24*60*60*1000));
  var expires = "expires="+ d.toUTCString();
  document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}


function getCookie(cname) {
  var name = cname + "=";
  var decodedCookie = decodeURIComponent(document.cookie);
  var ca = decodedCookie.split(';');
  for(var i = 0; i <ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}

function terminalTest(){
	
	
	return term.help;
	
}





