UPDATE book
SET author_id = ROUND(RANDOM() * 10) + 1
WHERE author_id IS NULL;