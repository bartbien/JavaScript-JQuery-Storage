CREATE DATABASE IF NOT EXISTS webapisamples;
USE webapisamples;

CREATE TABLE links
(
	linkID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	linkAddress VARCHAR (100),
	linkDesctiption VARCHAR (100)
)

insert into links values (NULL, 'http://www.google.com', 'most popular search engine');
insert into links values (NULL, 'http://www.yahoo.com', 'yahoo - nice service');
insert into links values (NULL, 'http://www.phoenixjcam.com', 'nice web page xD');

INSERT INTO `webapisamples`.`links` (`linkID`, `linkAddress`, `linkDescription`) VALUES 
(NULL, 'http://www.w3schools.com/', 'webpages'), 
(NULL, 'http://www.tutorialspoint.com/', 'almost everything ');



drop database if exists webapisamples;
























