CREATE TABLE banquets
(
	banquetnumber SERIAL PRIMARY KEY,
	name text NOT NULL,
	location text NOT NULL,
	street text NOT NULL,
	price int NOT NULL,
	maxppl int NOT NULL,
	phonenr int NOT NULL,
	email text UNIQUE NOT NULL
);

CREATE TABLE sportvenues
(
	sportvenuenumber SERIAL PRIMARY KEY,
	name text NOT NULL,
	location text NOT NULL,
	street text NOT NULL,
	price int NOT NULL,
	phonenr int NOT NULL,
	email text UNIQUE NOT NULL
);

CREATE TABLE banquetbookings
(
	id SERIAL PRIMARY KEY,
	name text NOT NULL,
	kennitala char(10) NOT NULL,
	email text UNIQUE NOT NULL,
	phonenr int NOT NULL,
	banquetnumber int NOT NULL
);

CREATE TABLE sportvenuebookings
(
	id SERIAL PRIMARY KEY,
	name text NOT NULL,
	kennitala char(10) NOT NULL,
	email text UNIQUE NOT NULL,
	phonenr int NOT NULL,
	sportvenuenumber int NOT NULL
);

INSERT INTO banquets (name, location, street, price, maxppl, phonenr, email) VALUES
(
	'Glersalurinn', 'Reykjavík', 'Tjarnargata 5', 43636, 150, 6547654, 'hans@gmail.com'
);

INSERT INTO banquets (name, location, street, price, maxppl, phonenr, email) VALUES
(
	'Tjörnin', 'Kópavogur', 'Guðrúnartún 2', 74995, 100, 8765654, 'gretar@gmail.com'
);

INSERT INTO sportvenues (name, location, street, price, phonenr, email) VALUES
(
	'Kórinn', 'Kópavogur', 'Vallakór 12-14', 99324, 5647383, 'korinn@kor.is'
);

INSERT INTO sportvenues (name, location, street, price, phonenr, email) VALUES
(
	'Fífan', 'Kópavogur', 'Dalsmári 5', 67894, 5642346, 'fifan@fifan.is'
);







