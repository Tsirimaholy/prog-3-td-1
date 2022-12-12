CREATE TABLE book_categories
(
    book_id     INTEGER NOT NULL references book(id),
    category_id INTEGER NOT NULL references category(id)
);