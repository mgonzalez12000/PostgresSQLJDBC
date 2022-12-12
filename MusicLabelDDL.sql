CREATE TABLE Home (
address VARCHAR (100),
PRIMARY KEY (address)
);

CREATE TABLE Musician (
ssn INT,
name VARCHAR (25),
home_address VARCHAR (100) NOT NULL,
PRIMARY KEY (ssn),
FOREIGN KEY (home_address) REFERENCES Home(address)
);

CREATE TABLE Instrument (
inst_id INT,
name VARCHAR (25),
musical_key VARCHAR (6),
PRIMARY KEY (inst_id)
);

CREATE TABLE Album (
format VARCHAR (2),
unique_id INT,
title VARCHAR (25),
copyright_date DATE,
album_id INT UNIQUE,
musician_ssn INT NOT NULL,
PRIMARY KEY (unique_id),
FOREIGN KEY (musician_ssn) REFERENCES Musician (ssn)
);

CREATE TABLE Song (
title VARCHAR (25),
author VARCHAR (25),
album_unique_id INT NOT NULL,
PRIMARY KEY (title),
FOREIGN KEY (album_unique_id) REFERENCES Album (unique_id)
);

CREATE TABLE Phone (
phone_num VARCHAR (12),
home_address VARCHAR (100) NOT NULL,
PRIMARY KEY (phone_num),
FOREIGN KEY (home_address) REFERENCES Home (address)
);

CREATE TABLE Plays (
musician_ssn INT,
inst_id INT,
PRIMARY KEY (musician_ssn, inst_id),
FOREIGN KEY (musician_ssn) REFERENCES Musician (ssn),
FOREIGN KEY (inst_id) REFERENCES Instrument (inst_id)
);

CREATE TABLE Performs (
musician_ssn INT,
song_title VARCHAR (25),
PRIMARY KEY (musician_ssn, song_title),
FOREIGN KEY (song_title) REFERENCES Song (title),
FOREIGN KEY (musician_ssn) REFERENCES Musician (ssn)
);

insert into Home values ('1923 Maple St. Los Angeles, CA 90021');
insert into Home values ('9021 Johnson Ave. New York City, NY 10011');
insert into Home values ('2105 Gates St. Los Angeles, CA 90011');

insert into Musician values (561983892, 'Benito Ocasio', '1923 Maple St. Los Angeles, CA 90021');
insert into Musician values (624972441, 'George Miller', '9021 Johnson Ave. New York City, NY 10011');
insert into Musician values (362554118, 'Brenda Lee', '2105 Gates St. Los Angeles, CA 90011');

insert into Instrument values (1, 'Flute', 'C');
insert into Instrument values (20, 'Trumpet', 'B-flat');
insert into Instrument values (5, 'Piano', 'E-flat');

insert into Album values ('CD', 102, 'Un Verano Sin Ti', '2022-05-06', 1, 561983892);
insert into Album values ('CD', 10, 'Nectar','2020-09-25', 3, 624972441);
insert into Album values ('MC', 2, 'Emotions', '1961-04-03', 2, 362554118);

insert into Song values ('Efecto', 'Bad Bunny', 102);
insert into Song values ('Like You Do', 'Joji', 10);
insert into Song values ('If You Love Me', 'Brenda Lee', 2);

insert into Phone values ('323-123-0192', '1923 Maple St. Los Angeles, CA 90021');
insert into Phone values ('213-093-4021', '9021 Johnson Ave. New York City, NY 10011');
insert into Phone values ('203-293-4021', '2105 Gates St. Los Angeles, CA 90011');

insert into Plays values (561983892, 1);
insert into Plays values (624972441, 20);
insert into Plays values (362554118, 5);

insert into Performs values (561983892, 'Efecto');
insert into Performs values (362554118, 'If You Love Me');
insert into Performs values (624972441, 'Like You Do');
