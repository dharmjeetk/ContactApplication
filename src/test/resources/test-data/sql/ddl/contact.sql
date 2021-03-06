CREATE TABLE CONTACT
(
CONTACT_ID INTEGER NOT NULL,
EMAIL_ID VARCHAR(140),
FIRST_NAME VARCHAR(140) NOT NULL,
LAST_NAME VARCHAR(140),
PHONE_NUMBER VARCHAR(70),
STATUS VARCHAR(1) NOT NULL
);

ALTER TABLE CONTACT ADD PRIMARY KEY(CONTACT_ID);
ALTER TABLE CONTACT ADD CONSTRAINT CHK_STATUS_FLAG CHECK (STATUS IN ('A','I'));
COMMIT;