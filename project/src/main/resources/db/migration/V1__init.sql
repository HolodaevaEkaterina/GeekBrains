create table authors (id bigserial primary key, name varchar(255));
insert into authors (name)
values
('Tolstoy'),
('Stephen King'),
('Rowling'),
('Ray Bradbury');

create table books (id bigserial primary key, title varchar(255), author_id bigint references authors (id));
insert into books (title, author_id)
values
('Harry Potter', 3),
('War and Peace', 1),
('Anna Karenina', 1),
('It', 2),
('The Shining', 2),
('Fahrenheit 451', 4),
('Dandelion Wine', 4),
('childhood', 1);
