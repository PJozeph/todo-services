-- Insert into USERS table first
INSERT INTO USERS (username, email, password)
VALUES 
('john_doe', 'john.doe@example.com', 'password123'),
('jane_smith', 'jane.smith@example.com', 'securepass456'),
('alice_jones', 'alice.jones@example.com', 'mypassword789');

-- Then insert into TODO table
INSERT INTO TODO (title, description, completed, deadline, user_id) 
VALUES
('Buy Milk', 'Description for task 1', false, '2024-11-25', 1),
('Clean House', 'Description for task 2', true, '2024-11-30', 1);

-- Insert into LABEL table
INSERT INTO LABEL (title) 
VALUES ('Home'), ('Work');

-- Finally, insert into TODO_LABEL table
INSERT INTO TODO_LABEL (todo_id, label_id) 
VALUES 
(1, 1),
(2, 2);
