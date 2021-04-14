CREATE TABLE BOOK (
     ID              UUID NOT NULL,
     NAME            VARCHAR(255),
     AUTHOR          VARCHAR(255),
     CATEGORY        VARCHAR(255),
     DESCRIPTION     VARCHAR(255),
     EDITION         INT,
     DATE_CREATION   DATE,
     PRIMARY KEY (ID)
  );