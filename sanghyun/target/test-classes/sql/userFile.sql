CREATE TABLE userfile (
	fileUid		VARCHAR(30)  NOT NULL,
	userId 		VARCHAR(20)  NOT NULL,
	fileName    	VARCHAR(20)  NOT NULL,
	fileSize   	VARCHAR(30)  NOT NULL,
	fileType   	VARCHAR(20)  NOT NULL,
	regDate 		DATETIME     NOT NULL
);

select *
from userfile;

 INSERT INTO userfile (fileUid, userId, fileName, fileSize, fileType, regDate)
 VALUES ('20171211091321', 'pus5684', 'report13', '32 MB', 'xls' ,now());