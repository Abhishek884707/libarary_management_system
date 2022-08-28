insert into course (id, name, duration) values
(5001, 'M.Sc Integrated programme Information Systems' ,5),
(5002, 'M.Sc Integrated programme Software Systems' ,5),
(5003, 'Bachelors in Technology Computer Science' ,4),
(5004, 'Bachelors in Technology Mechanical Engg' ,4),
(5005, 'Bachelors in Technology Chemical Engg' ,4),
(5006, 'Bachelors in Technology Electrical & Electronics' ,4),
(5007, 'Bachelors in Technology Manufacture Engg' ,4);

insert into group_name(id, group_name) values
(201, 'Group 33');

insert into student (id, first_name, last_name, enrollment_number, course_id, pursuing_year, status, contact_number, father_name, mother_name, group_name_id) values
(1001, 'Abhishek Kumar', 'Mourya', 12345001 , 5001, 5, 0, '7986453249', 'Mahinder Mourya', 'ShashiKala Mourya',201),
(1002, 'Akash', 'Kumar', 12345002 , 5002, 1, 0, '7986453249', '', '', 201),
(1003, 'Mahesh', 'Reddy', 12345003 , 5002, 1, 0, '7986453249', '', '', 201),
(1004, 'Ravi', 'Ranjan', 12345004 , 5003, 1, 0, '7986453249', '', '',201);


insert into student (id, first_name, last_name, enrollment_number, course_id, pursuing_year, status, contact_number, father_name, mother_name) values
(1005, 'Sanat', 'Mishra', 12345005 , 5003, 1, 0, '7986453249', '', ''),
(1006, 'Ankita', 'Sharma', 12345006 , 5004, 1, 0, '7986453249', '', ''),
(1007, 'Garvita', 'Singh', 12345007 , 5004, 1, 0, '7986453249', '', ''),
(1008, 'Parminder', 'Singh', 12345008, 5006, 1, 0, '7986453249', '', ''),
(1009, 'Gourav', 'Chouhan', 12345009 , 5006, 1, 0, '7986453249', '', ''),
(1010, 'Aditya', 'Verma', 12345010 , 5007, 1, 0, '7986453249', '', '');


insert into book_category (id, name) values
(101, 'Text'),
(102, 'Reference'),
(103, 'Journal'),
(104, 'NewsPaper');


insert into book (id, name, course_id, author_name, book_category_id, book_status) values
(501, 'Java The Complete Reference', 5003, 'Herbert Schildt', 101, 1),
(502, 'Book1', 5003, 'Author Name1', 101, 0),
(503, 'Book2', 5003, 'Author Name2', 101, 0),
(504, 'Book3', 5003, 'Author Name3', 101, 0),
(505, 'Book4', 5003, 'Author Name4', 101, 0),
(506, 'Book5', 5003, 'Author Name5', 101, 0),
(507, 'Book6', 5003, 'Author Name6', 101, 0),
(508, 'Book7', 5003, 'Author Name7', 101, 0),
(509, 'Book8', 5003, 'Author Name8', 101, 0),
(510, 'Book9', 5003, 'Author Name9', 101, 0),
(511, 'Book10', 5003, 'Author Name10', 102, 0),
(512, 'Book11', 5003, 'Author Name11', 103, 0),
(513, 'Book12', 5003, 'Author Name12', 102, 0),
(514, 'Book13', 5003, 'Author Name13', 103, 0),
(515, 'Book14', 5003, 'Author Name14', 104, 0),
(516, 'Book15', 5003, 'Author Name15', 104, 0),
(517, 'Book16', 5003, 'Author Name16', 103, 0),
(518, 'Book17', 5003, 'Author Name17', 102, 0),
(519, 'Book18', 5003, 'Author Name18', 104, 0);



insert into borrowed (id, book_id, student_id, issued_date, renewed_count) values
(6001, 501, 1001, '2022-08-16T00:00:00.000Z', 1);

