INSERT INTO ofCalculatorUser (USERNAME, PASSWORD) VALUES ('tom1', '1234');
INSERT INTO ofCalculatorUser (USERNAME, PASSWORD) VALUES ('tom2', '1234');
INSERT INTO ofCalculatorUser (USERNAME, PASSWORD) VALUES ('tom3', '1234');
INSERT INTO ofCalculatorUser (USERNAME, PASSWORD) VALUES ('admin', 'admin');


INSERT INTO ofRole (ROLE_NAME) VALUES ('ROLE_USER');
INSERT INTO ofRole (ROLE_NAME) VALUES ('ROLE_ADMIN');

INSERT INTO ofPermission (PERMISSION_NAME) VALUES ('ROLE_USER');
INSERT INTO ofPermission (PERMISSION_NAME) VALUES ('ROLE_ADMIN');


INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES ('1', '1');
INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES ('2', '1');
INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES ('3', '1');
INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES ('4', '2');

INSERT INTO ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) VALUES ('1', '1');
INSERT INTO ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) VALUES ('2', '1');
INSERT INTO ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) VALUES ('2', '2');
