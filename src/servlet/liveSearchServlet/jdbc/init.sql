CREATE DATABASE IF NOT EXISTS webapisamples;
USE webapisamples;

CREATE TABLE ajaxonkeyup
(
	ajax_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	ajax_user VARCHAR (20)
)

INSERT INTO ajaxonkeyup VALUES(NULL, 'ann');

INSERT INTO `webapisamples`.`ajaxonkeyup` (`ajax_id`, `ajax_user`) VALUES (NULL, 'john'), (NULL, 'bart');

INSERT INTO `webapisamples`.`ajaxonkeyup` VALUES (NULL, 'greg'), (NULL, 'julia'), (NULL, 'robert'), (NULL, 'kris')


drop database if exists webapisamples;
























