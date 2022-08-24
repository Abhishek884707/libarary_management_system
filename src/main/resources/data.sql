insert into course (id, name, duration) values
(5001, 'M.Sc Integrated programme Information Systems' ,5),
(5002, 'M.Sc Integrated programme Software Systems' ,5),
(5003, 'Bachelors in Technology Computer Science' ,4),
(5004, 'Bachelors in Technology Mechanical Engg' ,4),
(5005, 'Bachelors in Technology Chemical Engg' ,4),
(5006, 'Bachelors in Technology Electrical & Electronics' ,4),
(5007, 'Bachelors in Technology Manufacture Engg' ,4);

insert into student (id, first_name, last_name, enrollment_number, course_id, pursuing_year, status, contact_number, father_name, mother_name) values
(1001, 'Abhishek Kumar', 'Mourya', 12345001 , 5001, 1, 0, '7986453249', 'Mahinder Mourya', 'ShashiKala Mourya'),
(1002, 'Akash', 'Kumar', 12345002 , 5002, 1, 0, '7986453249', '', ''),
(1003, 'Mahesh', 'Reddy', 12345003 , 5002, 1, 0, '7986453249', '', ''),
(1004, 'Ravi', 'Ranjan', 12345004 , 5003, 1, 0, '7986453249', '', ''),
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
(501, 'Java The Complete Reference', 5003, 'Herbert Schildt', 101, 1);

insert into borrowed (id, book_id, student_id, issued_date, fine, renewed_count) values
(6001, 501, 1001, '2022-08-21T00:00:00.000', 0, 1);