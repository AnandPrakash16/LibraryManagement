CREATE TABLE Library (
     id integer PRIMARY KEY,
     libraryName text NOT NULL,
	libraryOwner text NOT NULL
   );

   
CREATE TABLE Book (
    id integer PRIMARY KEY,
    bookName text NOT NULL,
publisher text NOT NULL,
avalable text NOT NULL,
category text NOT NULL
);

