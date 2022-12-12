-- this migration add a foreign key that reference author.id to `book` table
alter table book
    add column author_id integer references author(id);