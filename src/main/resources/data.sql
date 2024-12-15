INSERT INTO todo (title, description, completed, deadline) VALUES 
('Buy Milk', 'Description for task 1', false, '2024-11-25'),
('Clean House', 'Description for task 2', true, '2024-11-30');

INSERT INTO label (title) VALUES ('Home'), ('Work');

INSERT INTO todo_label (todo_id, label_id) VALUES 
(1, 1),
(2, 2);

INSERT INTO USERS (username, email, password)
VALUES ('john_doe', 'john.doe@example.com', 'password123');

INSERT INTO USERS (username, email, password)
VALUES ('jane_smith', 'jane.smith@example.com', 'securepass456');

INSERT INTO USERS (username, email, password)
VALUES ('alice_jones', 'alice.jones@example.com', 'mypassword789');