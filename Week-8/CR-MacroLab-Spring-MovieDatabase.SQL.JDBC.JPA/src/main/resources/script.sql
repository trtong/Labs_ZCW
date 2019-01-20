INSERT into movies (title, runtime, genre, imdb_score, rating)
VALUES ('Howard the Duck', 110, 'Sci-Fi', 4.6, 'PG');

INSERT into movies (title, runtime, genre, imdb_score, rating)
VALUES ('Lavalantula', 83, 'Horror', 4.7, 'TV-14');

INSERT into movies (title, runtime, genre, imdb_score, rating)
VALUES ('Starship Troopers', 129, 'Sci-Fi', 7.2, 'PG-13');

INSERT into movies (title, runtime, genre, imdb_score, rating)
VALUES ('Waltz With Bashir', 90, 'Documentary', 8.0, 'R');

INSERT into movies (title, runtime, genre, imdb_score, rating)
VALUES ('Spaceballs', 96, 'Comedy', 7.1, 'PG');

INSERT into movies (title, runtime, genre, imdb_score, rating)
VALUES ('Monsters Inc.', 92, 'Animation', 8.1, 'G');

INSERT into movies (title, runtime, genre, imdb_score, rating)
VALUES ('Finding Nemo', 101, 'Animation', 8.1, 'G');

INSERT into movies (title, runtime, genre, imdb_score, rating)
VALUES ('Just Go With It', 117, 'Comedy', 6.4, 'PG-13');

INSERT into movies (title, runtime, genre, imdb_score, rating)
VALUES ('Dodgeball', 117, 'Comedy', 6.7, 'PG-13');

SELECT *
FROM movies
WHERE Genre = 'Sci-Fi';

SELECT *
FROM movies
WHERE imdb_score >= 6.5;

SELECT *
FROM movies
WHERE rating = 'G' OR rating = 'PG'
AND runtime < 100;

-- avg runtimes of movies rated below 7.5, grouped by genre
SELECT AVG(runtime)
FROM movies
WHERE rating < 7.5
GROUP BY genre;

UPDATE movies
SET rating = 'R'
WHERE title = 'Starship Troopers';

SELECT id, rating, title
FROM movies
WHERE Genre = 'Horror' AND Genre = 'Documentary';

-- avg min max IMBD score for movies of each rating
SELECT rating, MIN(imdb_score) as "MIN IMDB SCORE", MAX(imdb_score) as "MAX IMDB SCORE", ROUND(AVG(imdb_score), 2) as "AVG IMDB SCORE", COUNT(*) as "NUM MOVIES"
FROM movies
GROUP BY rating;

-- Use HAVING COUNT(*) > 1
SELECT rating, MIN(imdb_score) as "MIN IMDB SCORE", MAX(imdb_score) as "MAX IMDB SCORE", ROUND(AVG(imdb_score), 2) as "AVG IMDB SCORE"
FROM movies
GROUP BY rating
HAVING count(*) > 1;

DELETE FROM movies
WHERE rating = 'R';
