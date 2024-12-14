INSERT INTO todo (title, description, completed, deadline) VALUES 
('Buy Milk', 'Description for task 1', false, '2024-11-25'),
('Clean House', 'Description for task 2', true, '2024-11-30');

INSERT INTO label (title) VALUES ('Home'), ('Work');

INSERT INTO todo_label (todo_id, label_id) VALUES 
(1, 1),
(2, 2);

INSERT INTO "USER" (username, email, password) VALUES ('username', 'user@gmail.com', '$2a$10$3');

