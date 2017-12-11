This is a	Java	console	application	("Dropbox	client")	that	allows	to	access	Dropbox	user's	account	and	retrieve	some	
information	using	Dropbox	HTTP	Core	API. Please	refer	to	the	Dropbox	Core API	developer	documentation	(https://www.dropbox.com/developers/)	for	API	
description.

The	"java-dropbox-client"	is	a	console	application	that	accepts	several	command	line	arguments. 
For creating jar file with its dependancies run following maven command: 
"mvn clean compile assembly:single"

The	application supports	following	commands:

•  help	-	prints command list
•  auth	-	authenticates	and	authorizes	the	access	to	Dropbox	account	
•  info	-	retrieves	and	prints	user's	account	information	
•  list	-	prints	files	and	folders	information	for	specified	path


1. Command:	auth	

This	command	helps	to	authenticate	and	authorize	Dropbox	user	resulting	in	the	authorization	code.	

Documentation:	
•  Specification:	https://www.dropbox.com/developers/documentation/http/documentation	(subtitle	
“Authorization”)	
•  Example:	see	the	“No	Redirect	Example”	from	https://dropbox.github.io/dropbox-sdk-java/api-docs/v3.0.x/com/dropbox/core/DbxWebAuth.html	

Synatx:
> java -jar dropbox-client.jar auth {appKey} {appSecret} 
where	
•  auth	-	the	command	name	(mandatory)	
•  {appKey}	-	the	Dropbox	application	key	(mandatory)	
•  {appSecret}	-	the	Dropbox	application	secret	code	(mandatory)	

Get	your	app	key	and	secret	from	the	Dropbox	developers	website:	
https://www.dropbox.com/developers/apps/create	(use	options	“Dropbox	API”	and	“Full	Dropbox”)

The	expected	output:
> java -jar dropbox-client.jar auth a1b2c3 abc123 

1. Go to: <authorize URL> 
2. Click "Allow" (you might have to log in first) 
3. Copy the authorization code and paste it here: 
Xu4Bcq1234567890AAAA1234567890ABCDEFGHIJKLM 
  
Your access token: Xu4Bcq1234567890AAAAAAAA1234567890abcdefghijklmnopqrstuvwxyz-djf 

Where	<authorize	URL>	should	lead	the	user	to	Dropbox	site	for	authorization.

2. Command:	info	

This	command	retrieves	information	about	Dropbox	user's	account.	
Documentation:	
•  Specification:	https://www.dropbox.com/developers/documentation/http/documentation#users-get_current_account	

Syntax:	
> java -jar dropbox-client.jar info {accessToken} {locale}
where	
•  info	-	the	command	name	(mandatory)	
•  {accessToken}	-	the	access	token,	which	could	be	generated	using	auth	command	(mandatory)	
•  {locale}	-	the	user’s	locale,	see	specification	(optional)	

The	expected	output	of	running	the	command	are	some	details	about	user	account:	
> java -jar dropbox-client.jar info Ab1Cd2Ef3Gh4Ij5 
 
User ID:        1234567 
Display name:   My Test Account 
Name:           <given_name> <surname> (<familiar_name>) 
E-mail:         test@example.com (verified) 
Country:        US 
Referral link:  https://...


3. Command:	list	

This	command	prints	the	list	of	files	and	folders	within	the	specified	directory	and	some	metadata	about	each	entry	
Documentation:	
•  Specification:	https://www.dropbox.com/developers/documentation/http/documentation#files-list_folder

Syntax:	
> java -jar dropbox-client.jar list {accessToken} {path} {locale} 

where	
•  info	-	the	command	name	(mandatory)	
•  {accessToken}	-	the	access	token,	which	could	be	generated	using	auth	command	(mandatory)	
•  {path}	-	the	path	to	a	file	or	folder	to	list	details	about	(mandatory)	
•  {locale}	-	the	user’s	locale,	see	specification	(optional)

Expected	output	for	a	folder:	
> java -jar dropbox-client.jar list Ab1Cd2Ef3Gh4Ij5 "/Docs" 

/Docs                   : dir
 - /Test                : dir 
 - /iffiles1.rar        : file, 309.5 KB, application/rar, modified at: "04-11-2012 11:50:19" 
 - /public-003.zip      : file, 1 MB, application/zip, modified at: "23-04-2013 22:12:40" 
 - /Test.java           : file, 99 bytes, text/x-java, modified at: "04-12-2012 11:47:59"

Expected	output	for	a	file:	
> java -jar dropbox-client.jar list Ab1Cd2Ef3Gh4Ij5 "/Docs/iffiles1.rar" 

/Docs/iffiles1.rar      : file, 309.5 KB, application/rar, modified at: "04-11-2012 11:50:19"


Format	for	the	folder	information	line	(just	for	clarification):	
<path>        : dir, modified at: <modified> 
Format	for	the	file	information	line	(just	for	clarification):	
<path>        : file, <size>, <mime_type>, modified at: <modified>
