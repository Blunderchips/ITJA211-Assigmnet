drop table Books;
drop table Bookings;
drop table Students;

/**
 * Author:  Matthew Van der Bijl - xq9x3wv31
 * Created: 20 Feb 2017
 */
CREATE TABLE Books (
    id              INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
                        (START WITH 1, INCREMENT BY 1), /* PK */
    title           VARCHAR(64),
    ISBN            VARCHAR(32),
    author          VARCHAR(64),
    yearPublished   INTEGER,
    edition         INTEGER,
    category        VARCHAR(32),
    publisher       VARCHAR(32),
    numCopies       INTEGER
);

CREATE TABLE Students (
    id              INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
                        (START WITH 1, INCREMENT BY 1), /* PK */
    title           VARCHAR(32),
    studentNumber   VARCHAR(64),
    firstName       VARCHAR(64),
    surname         VARCHAR(64),
    cellNumber      VARCHAR(10),
    address         VARCHAR(64)
);

CREATE TABLE Bookings (
    id              INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY 
                        (START WITH 1, INCREMENT BY 1), /* PK */
    bookingDate     VARCHAR(64),
    reference       VARCHAR(64),
    ISBN            VARCHAR(64),
    bookTitle       VARCHAR(64),
    studentName     VARCHAR(64),
    studentSurname  VARCHAR(32)
);

insert into Bookings (bookingDate, reference, ISBN, bookTitle, studentName, studentSurname)
values ('12-02-1956', '1234567890', '978-1-775-78603-0', 'dadsadsasd', 'sdf', 'sdf');


insert into Books (title, ISBN, author, yearPublished, edition, category, publisher, numCopies) 
values ('Basic Programming Principles', '978-1-775-78603-0', 'CM Pretorius and HG Erasmus', 2012, 2, 'textbook', 'Pearson Education', 5);

insert into Books (title, ISBN, author, yearPublished, edition, category, publisher, numCopies) 
values ('The Project Workout', '978-0-273-72389-9', 'Robert Buttrick', 2009, 4, 'textbook', 'Pearson Education', 4);

insert into Books (title, ISBN, author, yearPublished, edition, category, publisher, numCopies) 
values ('Essentials of Systems Analysis and Design', '978-1-292-07661-4', 'Joseph S. Valacich, Joey F. George, Jeffrey A. Hoffer', 2015, 6, 'textbook', 'Pearson Education', 21);

insert into Books (title, ISBN, author, yearPublished, edition, category, publisher, numCopies) 
values ('Interaction Design', '978-1-119-08879-0', 'Preece, Sharp, Rogers', 2015, 4, 'textbook', 'John Wiley & Sons', 3);

insert into Books (title, ISBN, author, yearPublished, edition, category, publisher, numCopies) 
values ('CompTIA Network+', '978-0-470-42747-7', 'Todd Lammle', 2009, 1, 'textbook', 'Wiley Publishing', 19);

insert into Books (title, ISBN, author, yearPublished, edition, category, publisher, numCopies) 
values ('Data Structures and Algorithms in Java', '978-1-292-04009-7', 'Peter Drake', 2014, 1, 'textbook', 'Pearson Education', 9);

insert into Books (title, ISBN, author, yearPublished, edition, category, publisher, numCopies) 
values ('Database Systems', '978-1-292-06118-4', 'Thomas Connolly, Carolyn Begg', 2015, 6, 'textbook', 'Pearson Education', 12);

insert into Books (title, ISBN, author, yearPublished, edition, category, publisher, numCopies) 
values ('The Object-Oriented Thought Process', '978-0-321-86127-6', 'Matt Weisfeld', 2013, 4, 'textbook', 'Addison-Wesley', 18);

insert into Books (title, ISBN, author, yearPublished, edition, category, publisher, numCopies) 
values ('Principles of Information Systems', '978-1-4737-4928-3', 'Ralph M. Stair, George W. Reynolds', 2016, 1, 'textbook', 'Cengage Learing', 0);

insert into Books (title, ISBN, author, yearPublished, edition, category, publisher, numCopies) 
values ('Programming Logic & Design', '978-0-13-398507-8', 'Tony Gaddis', 2016, 4, 'textbook', 'Pearson Education', 22);

insert into Books (title, ISBN, author, yearPublished, edition, category, publisher, numCopies) 
values ('Database Design and Development', '1-403-91601-2', 'Paul Beyon-Davies', 2004, 3, 'textbook', 'Palgrave Macmilian', 1);


insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', 'Q7NBAFKVPS', 'Brett', 'Soucie', '0835121030', '49 Linden Avenue'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mrs.', 'FDCOSF76EF', 'Oralia', 'Beaudoin', '0833361073', '74 Valley Drive'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Miss.', 'MQQQTRGNS5', 'Anna', 'Joe', '0831061020', '83 Cedar Avenue'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', 'C0EFPKE143', 'Marlon', 'Barrette', '0799371027', '31 Street South'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mrs.', 'HO7ID3PJ0S', 'Marita', 'Guilbault', '0794001046', '8 Lawrence Street'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', 'IKS73CPN4D', 'Daryl', 'Norden', '0834791043', '70 Magnolia Court'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mrs.', '7R7TMLMJR4', 'Melva', 'Stillings', '0796611077', '62 Carriage Drive'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mrs.', 'J15T269DKR', 'Eugenie', 'Spore', '0836191089', '76 Elmwood Avenue'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mrs.', 'O9J9UNS4D1', 'Delicia', 'Parillo', '0831911011', '2 Primrose Lane'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Miss.', '2KR5H2R701', 'Blythe', 'Mcguffey', '0791751036', '78 White Street'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', 'EQ570NVA8H', 'Neil', 'Minns', '0838311036', '58 Amherst Street'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mrs.', '57JCSVKNQK', 'Joya', 'Mellin', '0796161041', '2 Park Street'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Miss.', '3EAVKFL4FB', 'Daphine', 'Feiler', '0832671031', '12 Cedar Court'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', 'EL7BRT941V', 'Antione', 'Wynne', '0798911041', '91 Durham Court'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Miss.', 'QRU1RH7EVH', 'Amber', 'Hardage', '0838041044', '84 Summit Street'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', 'IVVBQ1I012', 'Raleigh', 'Saxon', '0791581058', '34 Oak Street'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mrs.', 'GQVE95SFT0', 'Willow', 'Brasher', '0832231067', '10 Street'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Miss.', '46H7KED146', 'Berneice', 'Astudillo', '0797921087', '28 Cypress Court'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mrs.', 'D6VORD44PO', 'Shavon', 'Custard', '0837991047', '10 East Street'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mrs.', 'AOHMRC1KPH', 'Norma', 'Heintzelman', '0794831041', '83 Street East'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Miss.', 'GNLG5QVV6N', 'Regenia', 'Brosnan', '0838581026', '50 Valley View Road'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', 'MR3NHHV04F', 'Bryon', 'Lamagna', '0798761058', '51 Division Street'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', 'GCHVCAKLEH', 'Frankie', 'Christopher', '0796741082', '53 Vine Street'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mrs.', '3OII8PLNIS', 'Rosanna', 'Severs', '0796241030', '97 Tanglewood Drive'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mrs.', '5LMAND7RO1', 'Elana', 'Ringwood', '0792171048', '98 Center Street'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', '3RHOKEV5S4', 'Rodolfo', 'Mose', '0796471078', '78 Harrison Avenue'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mrs.', 'NRSP1II5F6', 'Isaura', 'Brumfield', '0831651082', '85 Cambridge Road'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Miss.', '1RUP8C3F0S', 'Rebekah', 'Veal', '0799281068', '10 Winding Way'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', 'HA1BJQNDF4', 'Angelo', 'Session', '0831991031', '67 New Street'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', 'R3TCGGVI4F', 'Arlie', 'Lape', '0839451041', '24 Mulberry Court'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', '5GDRS4ECC0', 'Jerrold', 'Vick', '0798951059', '39 Maiden Lane'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', '7D0HUOUELR', 'Aron', 'Dugan', '079726101', '81 Canterbury Road'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', 'OOL05U0IJD', 'Darius', 'Haymaker', '079740101', '32 Pine Street'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', 'KSMRQEQO93', 'Vern', 'Hensley', '0837321050', '72 Oak Avenue'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', 'PTRE29U2GM', 'Lee', 'Moffit', '0837981031', '69 Street East'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', 'KJOGQCI9L2', 'Clayton', 'Novotny', '0795371018', '82 Maple Avenue'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', 'VH89LSIE5Q', 'Deon', 'Rehkop', '0839181038', '98 Lilac Lane'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', 'Q3HGJDJ2AF', 'Matthew', 'Rank', '0832061068', '24 Street West'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', 'CJ9H1SIRSL', 'Elmer', 'Triplett', '0794221043', '62 Devonshire Drive'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', 'K3PII6LKGL', 'Ellis', 'Munyon', '0832271034', '91 Hanover Court'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', 'J7QMF7FUP1', 'Elton', 'Beauchesne', '0793171012', '56 Woodland Road'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', 'A0G0KJ61C3', 'Frances', 'Baumgartner', '0835201020', '24 Hawthorne Lane'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Miss.', 'UDORO8G1R7', 'Jacque', 'Buono', '0838641030', '72 Route 64'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mrs.', 'TDLKT5BBOM', 'Jettie', 'Tumlin', '0836791084', '48 Route 1'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mrs.', 'V8NCNPS9BR', 'Trinity', 'Ruggiero', '0835561023', '39 Hickory Lane'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mrs.', 'AHT2M8HP8K', 'Madelene', 'Kohlmeier', '0832981051', '2 Riverside Drive'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Miss.', 'TF3GB7BDK0', 'Lilliam', 'Bechtol', '0836611073', '55 B Street'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mrs.', '1O1E8ODVL9', 'Danette', 'Roy', '0798811026', '64 Belmont Avenue'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mrs.', 'EOFL7OJ4D4', 'Ligia', 'Mccaslin', '0792921047', '11 Madison Court'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', '3A4KK67UFK', 'Darell', 'Um', '0831751039', '49 Somerset Drive'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', '5TG7EKF7PF', 'Johnathon', 'Manzer', '083393105', '52 Windsor Drive'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', 'GJ2BTR7AIT', 'Anibal', 'Alsop', '0794501014', '60 Chestnut Street'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', '84RS7VCDP6', 'Andre', 'Brumm', '0795091027', '65 Cross Street'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mrs.', '4RO2COKUH4', 'Tomoko', 'Ringgold', '0831701054', '97 Hartford Road'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Miss.', 'OPUTFT8GKK', 'Sherise', 'Fagin', '0796611068', '76 Brown Street'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', 'UDEUS876LR', 'Emmett', 'Hausmann', '0794201068', '7 King Street'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mrs.', '178FL42NIC', 'Margarita', 'Culpepper', '0839691029', '46 Route 100'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', 'J77QOCR9DJ', 'Owen', 'Hersh', '0837591013', '71 Hillside Avenue'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mr.', '71LHVME499', 'Jean', 'Villani', '0799531014', '97 Deerfield Drive'); 

insert into Students (title, studentNumber, firstName, surname, cellNumber, address)
values ('Mrs.', '6EC9MBUTHO', 'Luna', 'Mulkey', '083881102', '86 Grove Street'); 