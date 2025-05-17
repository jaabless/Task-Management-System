USE task_manager_db;

--add values in tasks table
INSERT INTO tasks (title, description, due_date, status)
VALUES
('Design UI', 'Create wireframes and mockups', '2025-05-20', 'Pending'),
('Develop Backend', 'Setup database and DAO layer', '2025-05-22', 'In Progress'),
('Test Application', 'Write unit and integration tests', '2025-05-25', 'Completed');