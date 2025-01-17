-- Insert into USERS table first
INSERT INTO USERS (username, email, password)
VALUES 
('john_doe', 'john.doe@example.com', 'password123'),
('jane_smith', 'jane.smith@example.com', 'securepass456'),
('joe', 'pallagijoe@gmail.com', '$2b$12$B3P2TJLx3F4Bhn6jHglLSOSc1g3Ri64VvDIwXz6HOkvxCrTXrbszS'),
('alice_jones', 'alice.jones@example.com', 'mypassword789');

-- Then insert into TODO table
INSERT INTO TODO (title, description, completed, deadline, user_id) 
VALUES
('Buy Milk', 'Description for task 1', false, '2024-11-25', 1),
('Clean House', 'Description for task 2', true, '2024-11-30', 1),
('Read Book', 'Description for task 3', false, '2024-12-01', 2),
('Go to Gym', 'Description for task 4', false, '2024-12-05', 2),
('Cook Dinner', 'Description for task 5', false, '2024-12-10', 3),
('Call Mom', 'Description for task 6', false, '2024-12-15', 3);

-- Insert into LABEL table
INSERT INTO LABEL (title) 
VALUES ('Home'), ('Work');

-- Finally, insert into TODO_LABEL table
INSERT INTO TODO_LABEL (todo_id, label_id) 
VALUES 
(1, 1),
(6, 1),
(5, 2),
(2, 2);
