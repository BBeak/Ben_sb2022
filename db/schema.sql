DROP DATABASE IF EXISTS Ben_sb2022;
CREATE DATABASE Ben_sb2022; 
USE Ben_sb2022;

#create article table
CREATE TABLE article (
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regdate DATETIME NOT NULL,
	updatedate DATETIME NOT NULL,
	title CHAR(100),
	`body` TEXT NOT NULL 
);


#creat article test data
INSERT INTO article 
SET regdate = NOW(),
updateDate = NOW(),
title = 'title1',
`body` = 'body1';

INSERT INTO article 
SET regdate = NOW(),
updateDate = NOW(),
title = 'title2',
`body` = 'body2';

INSERT INTO article 
SET regdate = NOW(),
updateDate = NOW(),
title = 'title3',
`body` = 'body3';

SELECT * FROM article;






