create database db_jornal_do_brasil;
use db_jornal_do_brasil;


CREATE TABLE address (
	idAddress INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	number VARCHAR(9999) NOT NULL,
	complement VARCHAR(45) NOT NULL,
	district VARCHAR(45) NOT NULL,
	city VARCHAR(45) NOT NULL,
	state VARCHAR(45) NOT NULL,
	zipCode VARCHAR(9) NOT NULL
);

CREATE TABLE configuration (
	idConfig INT PRIMARY KEY  NOT NULL AUTO_INCREMENT,
	notification BOOL NOT NULL,
	sound BOOL NOT NULL,
	showProfilePhoto BOOL NOT NULL,
	showdescription BOOL NOT NULL,
	showNumber BOOL NOT NULL,
	showEmail BOOL NOT NULL,
	theme ENUM("Dark","White") NOT NULL
);

CREATE TABLE user (
	idUser INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	name VARCHAR(45) NOT NULL,
	surname VARCHAR(45) NOT NULL,
	email VARCHAR(45) NOT NULL,
	phone VARCHAR(11) NOT NULL,
	password VARCHAR(45) NOT NULL,
	acceptTerms BOOL NOT NULL,
	description VARCHAR(45) NOT NULL,
	profilePhoto VARCHAR(45) NOT NULL,
	address INT NOT NULL,
	configuration INT NOT NULL,

	FOREIGN KEY (configuration) REFERENCES configuration(idConfig),
	FOREIGN KEY (address) REFERENCES address(idAddress)
);

CREATE TABLE publication(
	idPubli INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	title VARCHAR(45) NOT NULL,
	category ENUM("Política","Business","Internacional","Esportes","Saúde","Tecnologia","Entretenimento","Estilo","Gastronomia") NOT NULL,
	path VARCHAR(45) NOT NULL,
	author INT NOT NULL,
	date DATE NOT NULL,

	FOREIGN KEY (author) REFERENCES user(idUser)
);
 