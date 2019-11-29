-- Baseado em https://developer.twitter.com/en/docs/tweets/data-dictionary/overview/intro-to-tweet-json

PRAGMA foreign_keys = ON;

CREATE TABLE users (
	id INTEGER PRIMARY KEY NOT NULL,
	name VARCHAR(50) NOT NULL,
	screen_name VARCHAR(15) NOT NULL,
	location VARCHAR(255),
	url VARCHAR(255),
	description VARCHAR(255),
	followers INTEGER DEFAULT 0 NOT NULL,
	following INTEGER DEFAULT 0 NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE tweets (
	id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	text VARCHAR(140) NOT NULL,
	user INTEGER NOT NULL,
	retweet_count INTEGER DEFAULT 0 NOT NULL,
	favorite_count INTEGER DEFAULT 0 NOT NULL,
	FOREIGN KEY(user) REFERENCES users(id)	
);

CREATE TABLE friendships (
	userid1 INTEGER NOT NULL,
	userid2 INTEGER NOT NULL,
	FOREIGN KEY(userid1) REFERENCES users(id),
	FOREIGN KEY(userid2) REFERENCES users(id)
);

CREATE TABLE favorites (
	tweetid INTEGER NOT NULL,
	userid INTEGER NOT NULL,
	FOREIGN KEY(tweetid) REFERENCES tweets(id),
	FOREIGN KEY(userid) REFERENCES users(id)	
);

CREATE TABLE auth (
	userid INTEGER NOT NULL PRIMARY KEY,
	password VARCHAR(12),
	FOREIGN KEY(userid) REFERENCES users(id)
);