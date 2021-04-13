CREATE TABLE BOOK (
     ID              UUID NOT NULL,
     NAME            VARCHAR(255),
     AUTHOR          VARCHAR(255),
     DESCRIPTION     VARCHAR(255),
     DATE_CREATION   DATE,
     PRIMARY KEY (ID)
  );