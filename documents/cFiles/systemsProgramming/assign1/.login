stty -istrip
#stty erase '^H'
setenv NNTPSERVER news.cs.utsa.edu

if ( $TERM != "xterm" ) then
	if ( -f "/usr/bin/tset" ) then
		set noglob
		eval `/usr/bin/tset -s -r -m :?xterm`
		unset noglob
	endif
endif

/usr/bin/rtin -v -Z

last | head
echo ''
w
echo ''

