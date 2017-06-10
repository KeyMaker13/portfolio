#!/usr/bin/perl
use strict;
use warnings;
use File::Basename;

my $javaScriptFile = 'workPage.js';
open(my $jsFile, '>', $javaScriptFile) or die "Could not open file '$javaScriptFile' $!";


print $jsFile "function testExternalFile(){\n";
print $jsFile "	alert(); \n";
print $jsFile "alert(documentLibrary[0]); \n";
print $jsFile "} \n";
 
print $jsFile "function getDocumentOrder(index){ \n";
	
print $jsFile "	return documentOrder[index]; \n";
print $jsFile "} \n";

print $jsFile "function getDocumentOrderLength(){ \n";
	
print $jsFile "	return documentOrder.length; \n";
print $jsFile "} \n";

print $jsFile "function getDocumentOrderLastIndexOf(folderName){ \n";
	
print $jsFile "	return documentOrder.lastIndexOf(folderName); \n";
print $jsFile "} \n";

print $jsFile "function documentOrderPush(folderName){ \n";
		
print $jsFile "	documentOrder.push(folderName);	\n";
print $jsFile "} \n";

print $jsFile "function setDocumentOrder(docArray){ \n";
	
print $jsFile "	documentOrder = docArray; \n";
print $jsFile "} \n";

print $jsFile "function getDocumentLibrary(index){ \n";
		
print $jsFile "	return documentLibrary[index]; \n";
print $jsFile "} \n";

print $jsFile "function getDocumentNamesLastIndexOf(folderName){ \n";
	
print $jsFile "	return documentNames.lastIndexOf(folderName); \n";
print $jsFile "} \n";

print $jsFile "function getDocumentFiles(fileName){ \n";
	
print $jsFile "	return documentFiles[fileName]; \n";
print $jsFile "} \n";

print $jsFile "function getDocumentFolderNames(folderName){ \n";
	
print $jsFile "	return documentFolderNames[folderName]; \n";
print $jsFile "} \n";

print $jsFile "function getDocumentFileNames(fileName){ \n";
	
print $jsFile "	return documentFileNames[fileName]; \n";
print $jsFile "} \n";

print $jsFile "var documentOrder = new Array();\n";
print $jsFile "var documentLibrary = new Array();\n";
print $jsFile "var documentNames = new Array();\n";
print $jsFile "var documentFiles = {};\n";
print $jsFile "var documentFileNames = {};\n";
print $jsFile "var documentFolderNames = {};\n";



# 
# 
# $directoryName
# $pathOfDirectory 
# $pathOfDirectory 
# $pathToFile
# $fileName
#
# For each Directory 
# 	make variable name of directory
#	list files and directories with html
#	div id = currentDirectory
#	<label > $directoryName </label>
#   
#
#
#
#
# var directory = " "
# will contain list of directories or files
# each directory will have a list as so
#   "\"<div style=\'width:100%;height:60px;\'> +\" \n",
# 	"\"\t<div id =\'$directory\' style=\'width:250px;height:60px;\' onclick='openDocument(this.id)' > +\" \n", 
#	"\"\t\t<img id=\'folder\' src=\'documentFolder.png\' width=\'50\' height=\'50\' > +\" \n", 
#	"\"\t\t<label for=\'folder\'> $directoryName </label> +\" \n",
#	"\"\t</div> +\" \n",
#	"\"</div> +\" \n", 
#	"\"<br> +\" \n",
# 	"\" \";";
# 
# if its a file
# 	"\"<a id = \'$directory+$fileName\' href=\'#\' onclick=\'openFile(this.id)\'> $fileName </a> +\"\n",
# 
# var documentLibrary = new Array();
# documentLibrary.push(directory);
# 
# var documentNames = new Array();
# documentNames.push('directory');
# 
# var documentFiles = {};
# documentFiles["$directory+$fileName"] = "$pathToFile";
# 
# var documentFileNames = {};
# documentFileNames["$directory+$fileName"] = "$fileName";
# 
# var documentFolderNames = {};
# documentFolderNames["directory"] = "$directoryName";
# 
# 
# 
# 
# 
# 
# 




for (@ARGV) {
	variableNames($_);

}

for (@ARGV) {
	library($_);

}

#variableNames(@ARGV);



#library(@ARGV);

close $jsFile;


# Accepts one argument: the full path to a directory.
# Returns: nothing.
sub variableNames {
    my $path = shift;
	
	my $dirName = $path;
	$dirName =~ s/\///g;
	$dirName =~ s/-//g;
	$dirName =~ s/&//g;
	
	
    # Open the directory.
    opendir (DIR, $path)
        or die "Unable to open $path: $!";

    # Read in the files.
    # You will not generally want to process the '.' and '..' files,
    # so we will use grep() to take them out.
    # See any basic Unix filesystem tutorial for an explanation of the+m.
    my @files = grep { !/^\.{1,2}$/ } readdir (DIR);

    # Close the directory.
    closedir (DIR);

    # At this point you will have a list of filenames
    #  without full paths ('filename' rather than
    #  '/home/count0/filename', for example)
    # You will probably have a much easier time if you make
    #  sure all of these files include the full path,
    #  so here we will use map() to tack it on.
    #  (note that this could also be chained with the grep
    #   mentioned above, during the readdir() ).
    @files = map { $path . '/' . $_ } @files;
	
	print $jsFile "var $dirName = ";
	# making variableNames
	for (@files) {
		my $id = $_;
		
		$id =~ s/\///g;
		$id =~ s/-//g;
		$id =~ s/&//g;
		
		my $id2 = $id;
		$id2 =~ s/\.//g;
		
		
		if (-d $_){
			print $jsFile "\"<div style=\'width:100%;height:60px;\'>\" + \n";
			
			print $jsFile "\t\"<div id=\'",$id,"\' style=\'width:250px;height:60px;\' onclick=\'openDocument(this.id)\' >\" + \n";
			
			print $jsFile "\t\t\"<img id=\'folder\' src=\'documentFolder.png\' width=\'50\' height=\'50\' >\" + \n";
			
			print $jsFile "\t\t\"<label for=\'folder\'>", basename($_)," </label>\" + \n";
			
			print $jsFile "\t\"</div>\"+ \n";
			
			print $jsFile "\"</div>\" + \n";
			print $jsFile "\"<br>\" + \n";
			
			
			
			
		}else {
		
			print $jsFile "\"<div style=\'width:100%;height:60px;\'>\" + \n";
			print $jsFile "\"<img id=\'file\' src=\'file.png\' width=\'50\' height=\'50\' >\" + \n";
			print $jsFile "\"<a id = \'",$id2,"\' href=\'#\' onclick=\'openFile(this.id)\' style=\'text-decoration:none;\'>", basename($_) ,"  </a>\" +  \n";
			print $jsFile "\"</div>\"+ \n";
			print $jsFile "\"<br>\" + \n";
		
			
		
		}
		
	}
	
	print $jsFile " \" \"; \n";
	
		
    for (@files) {
				
		# If the file is a directory
        if (-d $_) {
            # Here is where we recurse.
            # This makes a new call to process_files()
            # using a new directory we just found.
            			
			variableNames ($_);

        # If it isn't a directory, lets just do some
        # processing on it.
        } else { 
            # Do whatever you want here =) 
            # A common example might be to rename the file.
			
        }
    }
}


sub library {
    my $path = shift;
	
		
	my $dirName = $path;
	$dirName =~ s/\///g;
	$dirName =~ s/-//g;
	$dirName =~ s/&//g;
	
	
    # Open the directory.
    opendir (DIR, $path)
        or die "Unable to open $path: $!";

    # Read in the files.
    # You will not generally want to process the '.' and '..' files,
    # so we will use grep() to take them out.
    # See any basic Unix filesystem tutorial for an explanation of the+m.
    my @files = grep { !/^\.{1,2}$/ } readdir (DIR);

    # Close the directory.
    closedir (DIR);

    # At this point you will have a list of filenames
    #  without full paths ('filename' rather than
    #  '/home/count0/filename', for example)
    # You will probably have a much easier time if you make
    #  sure all of these files include the full path,
    #  so here we will use map() to tack it on.
    #  (note that this could also be chained with the grep
    #   mentioned above, during the readdir() ).

	


    @files = map { $path . '/' . $_ } @files;
	
	print $jsFile "documentLibrary.push($dirName);\n";
	print $jsFile "documentNames.push(\'$dirName\');\n";
	
	
	for (@files){
		my $id2 = $_;
		$id2 =~ s/-//g;
		
		$id2 =~ s/\///g;
		$id2 =~ s/&//g;
		
		my $id3 = $id2;
		$id3 =~ s/\.//g;
		
		if (-d $_){
			print $jsFile "documentFolderNames[\'",$id2,"\'] = \"", basename($_) , "\";\n";
			
			
			
		} else {
			print $jsFile "documentFiles[\"",$id3,"\"] = \"$_\";\n";
			print $jsFile "documentFileNames[\"",$id3,"\"] = \"", basename($_) ,"\";\n";
		}
	
	}
	
	
	
	
	
    for (@files) {
		
			
        # If the file is a directory
        if (-d $_) {
            
			
			library ($_);

        # If it isn't a directory, lets just do some
        # processing on it.
        } else { 
            # Do whatever you want here =) 
            # A common example might be to rename the file.
			
        }
    }
}

