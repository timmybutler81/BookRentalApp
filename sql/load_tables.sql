-- Load Membership Types Test Data
INSERT INTO Membership_Type (membership_name, rental_duration_days)
VALUES ('Regular', 7),
       ('Premium', 14);

-- Load Book Test Data
INSERT INTO Book (title, author, genre, isbn, publisher, published_year, availability_status)
VALUES ('To Kill a Mockingbird', 'Harper Lee', 'Fiction', '9780061120084', 'J.B. Lippincott & Co.', 1960, 'Available'),
       ('1984', 'George Orwell', 'Dystopian', '9780451524935', 'Secker & Warburg', 1949, 'Available'),
       ('Pride and Prejudice', 'Jane Austen', 'Romance', '9780141439518', 'T. Egerton', 1813, 'Available');

-- Load Users Test Data
INSERT INTO User (first_name, last_name, email, phone, membership_type_id, date_of_registration)
VALUES ('Tim', 'Butler', 'timbutler@gmail.com', '4073551000', 1, '2024-12-20'),
       ('Jacob', 'Grimm', 'jacobgrimm@gmail.com', '0987654321', 2, '2024-10-10');