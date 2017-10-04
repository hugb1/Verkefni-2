INSERT INTO banquets (name, location, street, price, maxppl, phonenr, email) VALUES
(
	'Harpa', 'Reykjavík', 'Austurbakki 2', 84830, 400, 5935464, 'harpa@harpa.is'
);

INSERT INTO banquets (name, location, street, price, maxppl, phonenr, email) VALUES
(
	'Hótel Vellir', 'Hafnafjörður', 'Tjarnarvöllum 3', 50000, 200, 5264321, 'hotelvellir@vellir.is'
);

INSERT INTO banquets (name, location, street, price, maxppl, phonenr, email) VALUES
(
	'Fjörukráin', 'Hafnafjörður', 'Víkingastræti 1-3', 34995, 100, 5651213, 'fjorukrain@fjara.is'
);

INSERT INTO banquets (name, location, street, price, maxppl, phonenr, email) VALUES
(
	'Salur Hraunbúa', 'Hafnafjörður', 'Hjallabraut 51', 67845, 110, 5650900, 'hraun@hraun.is'
);

INSERT INTO banquets (name, location, street, price, maxppl, phonenr, email) VALUES
(
	'Sólon', 'Reykjavík', 'Bankastræti 7a', 45654, 150, 5623232, 'solon@solon.is'
);

INSERT INTO banquets (name, location, street, price, maxppl, phonenr, email) VALUES
(
	'Hótel Cabin', 'Reykjavík', 'Borgartún 32', 78995, 100, 5116030, 'cabin@cabin.is'
);

INSERT INTO banquets (name, location, street, price, maxppl, phonenr, email) VALUES
(
	'Garðskálinn, Gerðarsafn', 'Kópavogur', 'Hamraborg 4', 39995, 50, 4417611, 'gardur@gardur.is'
);

INSERT INTO sportvenues (name, location, street, price, phonenr, email) VALUES
(
	'Stjarnan', 'Garðabær', 'Ásgarður', 139995, 5651940, 'stjarnan@stjarnan.is'
);

INSERT INTO sportvenues (name, location, street, price, phonenr, email) VALUES
(
	'Knattspyrnufélag Reykjavíkur', 'Reykjavík', 'Frostaskjól', 99995, 5105300, 'kr@kr.is'
);

INSERT INTO sportvenues (name, location, street, price, phonenr, email) VALUES
(
	'Íþróttafélagið Fylkir', 'Reykjavík', 'Fylkisvegi 6', 67567, 5715600, 'fylkir@fylkir.com'
);

INSERT INTO sportvenues (name, location, street, price, phonenr, email) VALUES
(
	'Knattspyrnufélagið Valur', 'Reykjavík', 'Hlíðarenda', 79995, 4148000, 'valur@valur.is'
);

INSERT INTO sportvenues (name, location, street, price, phonenr, email) VALUES
(
	'Fimleikafélag Hafnafjarðar', 'Hafnafjörður', 'Kaplakriki', 54995, 5504050, 'fh@fh.is'
);

INSERT INTO sportvenues (name, location, street, price, phonenr, email) VALUES
(
	'Knattspyrnufélagið Haukar', 'Hafnafjörður', 'Ásvöllum 1', 45499, 5258700, 'haukar@haukar.is'
);

UPDATE banquets SET location = 'Hafnarfjörður' WHERE banquetnumber = 4;

UPDATE banquets SET location = 'Hafnarfjörður' WHERE banquetnumber = 5;

UPDATE banquets SET location = 'Hafnarfjörður' WHERE banquetnumber = 6;

UPDATE sportvenues SET location = 'Hafnarfjörður' WHERE sportvenuenumber = 7;

UPDATE sportvenues SET location = 'Hafnarfjörður' WHERE sportvenuenumber = 8;















