CREATE TABLE employee
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    role VARCHAR(250) DEFAULT NULL
);

INSERT INTO employee (name, email, role) VALUES
    ('Nguyen Van A', 'nv@gmail.com', 'manager'),
    ('Le Thi B', 'ltb@gmail.com', 'leader'),
    ('Tran Van C', 'tvc@gmail.com', 'member');