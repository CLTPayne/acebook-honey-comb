DROP TABLE IF EXISTS posts;

CREATE TABLE posts (
  id bigserial PRIMARY KEY,
  content VARCHAR(250) NOT NULL,
  user_id bigserial REFERENCES users(id),
  time_created timestamp DEFAULT CURRENT_TIMESTAMP
);
