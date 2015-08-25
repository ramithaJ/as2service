

DELETE FROM USER_ADDRESSES;
DELETE FROM USER_ALERTS;
DELETE FROM USER_AREA_OF_INTEREST;
DELETE FROM USER_SOCIETY_DETAILS;
DELETE FROM ALERTS;
DELETE FROM SOCIETIES;
DELETE FROM AREA_OF_INTEREST;
DELETE FROM OBJECT_TYPES;
DELETE FROM ADDRESS_TYPE;
DELETE FROM ACTIONS;
DELETE FROM ROLE_PERMISSIONS;
DELETE FROM PERMISSION_GROUPS;
DELETE FROM PERMISSIONS;
DELETE FROM ROLES;


-- Master user
INSERT INTO USERS(USER_ID,FIRST_NAME,LAST_NAME,PRIMARY_EMAIL_ADDR) VALUES(0,'as2','system','as2system@wiley.com');


-- Alerts

INSERT INTO ALERTS (ALERT_CD,ALERT_NAME,CREATED_DATE,CREATED_BY) VALUES ('AIPR','Article in Peer Review',SYSDATE,0);
INSERT INTO ALERTS (ALERT_CD,ALERT_NAME,CREATED_DATE,CREATED_BY) VALUES ('AACC','Article Accepted',SYSDATE,0);
INSERT INTO ALERTS (ALERT_CD,ALERT_NAME,CREATED_DATE,CREATED_BY) VALUES ('CORREC','Correction Received',SYSDATE,0);
INSERT INTO ALERTS (ALERT_CD,ALERT_NAME,CREATED_DATE,CREATED_BY) VALUES ('EVIEW','Early View',SYSDATE,0);
INSERT INTO ALERTS (ALERT_CD,ALERT_NAME,CREATED_DATE,CREATED_BY) VALUES ('ISPO','Issue Published Online',SYSDATE,0);
INSERT INTO ALERTS (ALERT_CD,ALERT_NAME,CREATED_DATE,CREATED_BY) VALUES ('CAL','Citation Alerts',SYSDATE,0);
INSERT INTO ALERTS (ALERT_CD,ALERT_NAME,CREATED_DATE,CREATED_BY) VALUES ('PR','Proofs Ready',SYSDATE,0);
INSERT INTO ALERTS (ALERT_CD,ALERT_NAME,CREATED_DATE,CREATED_BY) VALUES ('PS','Proofs Sent',SYSDATE,0);
INSERT INTO ALERTS (ALERT_CD,ALERT_NAME,CREATED_DATE,CREATED_BY) VALUES ('AIOL','Article is OnlineOpen',SYSDATE,0);
INSERT INTO ALERTS (ALERT_CD,ALERT_NAME,CREATED_DATE,CREATED_BY) VALUES ('ALM','Article Level Matrix',SYSDATE,0);
INSERT INTO ALERTS (ALERT_CD,ALERT_NAME,CREATED_DATE,CREATED_BY) VALUES ('ASUB','Article Submitted',SYSDATE,0);
INSERT INTO ALERTS (ALERT_CD,ALERT_NAME,CREATED_DATE,CREATED_BY) VALUES ('AAPO','Accepted Article Published Online',SYSDATE,0);
INSERT INTO ALERTS (ALERT_CD,ALERT_NAME,CREATED_DATE,CREATED_BY) VALUES ('DWMLA','Display warning to authors for missing license agreement',SYSDATE,0);



-- Object Types

INSERT INTO OBJECT_TYPES (OBJECT_TYPE_CD,OBJECT_TYPE,CREATED_DATE,CREATED_BY) VALUES ('ART','ARTICLE',SYSDATE,0);
INSERT INTO OBJECT_TYPES (OBJECT_TYPE_CD,OBJECT_TYPE,CREATED_DATE,CREATED_BY) VALUES ('BK','BOOK',SYSDATE,0);
INSERT INTO OBJECT_TYPES (OBJECT_TYPE_CD,OBJECT_TYPE,CREATED_DATE,CREATED_BY) VALUES ('JNL','JOURNAL',SYSDATE,0);

-- Address_Type

INSERT INTO ADDRESS_TYPE (ADDRESS_TYPE_CD,NAME,DESCRIPTION,CREATED_DATE,CREATED_BY) VALUES ('Physical','Primary address','Customer Primary Address',SYSDATE,0);
INSERT INTO ADDRESS_TYPE (ADDRESS_TYPE_CD,NAME,DESCRIPTION,CREATED_DATE,CREATED_BY) VALUES ('Mailing','Mailing address','Customer Mailing Address',SYSDATE,0);
INSERT INTO ADDRESS_TYPE (ADDRESS_TYPE_CD,NAME,DESCRIPTION,CREATED_DATE,CREATED_BY) VALUES ('Billing','Billing address','Customer Billing Address',SYSDATE,0);
INSERT INTO ADDRESS_TYPE (ADDRESS_TYPE_CD,NAME,DESCRIPTION,CREATED_DATE,CREATED_BY) VALUES ('Shipping','Shipping address','Customer Shipping Address',SYSDATE,0);



-- Actions 

INSERT INTO ACTIONS (ACTION_CD,ACTION_NAME,DESCRIPTION,CREATED_DATE,CREATED_BY) VALUES ('INS','INSERT','insert data into entities',SYSDATE,0);
INSERT INTO ACTIONS (ACTION_CD,ACTION_NAME,DESCRIPTION,CREATED_DATE,CREATED_BY) VALUES ('UPD','UPDATE','update data in entities',SYSDATE,0);
INSERT INTO ACTIONS (ACTION_CD,ACTION_NAME,DESCRIPTION,CREATED_DATE,CREATED_BY) VALUES ('DEL','DELETE','delete data from entities',SYSDATE,0);
INSERT INTO ACTIONS (ACTION_CD,ACTION_NAME,DESCRIPTION,CREATED_DATE,CREATED_BY) VALUES ('PWDRES','RESET','reset the password',SYSDATE,0);




-- Roles

INSERT INTO ROLES (ROLE_NAME,DESCRIPTION,ROLE_TYPE,CREATED_DATE,CREATED_BY) VALUES ('Author','Author new content and submit to Wiley,Sign copyright license etc','External',SYSDATE,0);
INSERT INTO ROLES (ROLE_NAME,DESCRIPTION,ROLE_TYPE,CREATED_DATE,CREATED_BY) VALUES ('Super Admins','Helps manage all admin roles. Responsible for maintaining user roles and permissions.','Internal',SYSDATE,0);
INSERT INTO ROLES (ROLE_NAME,DESCRIPTION,ROLE_TYPE,CREATED_DATE,CREATED_BY) VALUES ('AOS Admin','Responsible for providing customer support.  Help resolve login/user account, OO, OA, License related  issues.','Internal',SYSDATE,0);
INSERT INTO ROLES (ROLE_NAME,DESCRIPTION,ROLE_TYPE,CREATED_DATE,CREATED_BY) VALUES ('Product Support Admins','Responsible for maintaining products. Maintain non-reference product details which is specific for Author Services.','Internal',SYSDATE,0);
INSERT INTO ROLES (ROLE_NAME,DESCRIPTION,ROLE_TYPE,CREATED_DATE,CREATED_BY) VALUES ('Marketing Admins','Responsible for maintaining static information and help content.','Internal',SYSDATE,0);
INSERT INTO ROLES (ROLE_NAME,DESCRIPTION,ROLE_TYPE,CREATED_DATE,CREATED_BY) VALUES ('Production Editors','Helps manage licenses (Copyrights)','Internal',SYSDATE,0);

-- Permissions

INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('MUA','Manage User Account',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('FBJ','Find/Browse Journal',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('FBA','Find/Browse Articles',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('VAD','View Article Details',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('IC','Invite Colleague',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('VFA','View Full Article',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('AAN','Access Alerts/Notifications',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('OO','Order OnlineOpen',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('SORCA','Send OnlineOpen Request to Corresponding Author',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('POA','Pay for Open Access',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('TPS','Track Production Statuses',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('TPPS','Track Post Production Statuses (PMC)',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('SL','Sign License',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('UL','Update License',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('AR','Access Reports',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('RAP','Request Additional Permissions',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('MA','Merge user Account',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('CUR','Create User Roles',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('BP','Build Profile',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('MUR','Modify User Roles',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('MADUA','Manage AS 2.0/DAAS User Accounts',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('SADU','Search AS2.0/DAAS Users',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('SJD','Search Journal Data',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('SAD','Search Article Data',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('MJS','Manage Journal Settings',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('MAS','Manage Article Settings',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('CENT','Create Email Notification Template',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('MENT','Modify Email Notification Template',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('CENS','Create Email Notification Schedule',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('MENS','Modify Email Notification Schedule',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('IU','Imitate User (Proxy User)',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('ARAU','Assign/Reassign Article to User',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('AAR','Access Admin Reports',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('CSC','Create Static Content',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('MSC','Modify Static Content',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('MUP','Modify User''s Permissions',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('VENT','View Email Notification Template',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('VENS','View Email Notification Schedule',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('VCH','View Communication History',SYSDATE,0);
INSERT INTO PERMISSIONS (PERMISSION_CD,PERMISSION_NAME,CREATED_DATE,CREATED_BY) VALUES ('SREN','Send/Resend Email Notification',SYSDATE,0);



-- Permission_groups

INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('MUA','System',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('BP','System',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('FBJ','System',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('FBA','System',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('VAD','System',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('IC','Article',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('VFA','Article',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('AAN','Article',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('OO','Article',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('SORCA','Article',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('POA','Article',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('TPS','Article',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('TPPS','Article',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('SL','Article',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('UL','Article',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('AR','Article',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('RAP','System',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('MA','System',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('CUR','Admin',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('MUR','Admin',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('MADUA','Admin',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('SADU','Admin',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('SJD','Admin',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('SAD','Admin',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('MJS','Admin',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('MAS','Admin',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('CENT','Admin',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('MENT','Admin',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('CENS','Admin',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('MENS','Admin',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('IU','Admin',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('ARAU','Admin',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('AAR','Admin',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('CSC','Admin',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('MSC','Admin',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('MUP','Admin',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('VENT','Admin',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('VENS','Admin',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('VCH','Admin',SYSDATE,0);
INSERT INTO PERMISSION_GROUPS (PERMISSION_CD,PERMISSION_GROUP_CD,CREATED_DATE,CREATED_BY) VALUES ('SREN','Admin',SYSDATE,0);


--- Role_Permissions

-- Author 1

INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (1,'BP',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (1,'FBA',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (1,'FBJ',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (1,'MA',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (1,'MUA',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (1,'RAP',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (1,'VAD',SYSDATE,0);

-- Super Admins 2

INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (2,'AAR',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (2,'ARAU',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (2,'CENS',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (2,'CENT',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (2,'CSC',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (2,'CUR',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (2,'IU',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (2,'MAS',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (2,'MADUA',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (2,'MENS',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (2,'MENT',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (2,'MJS',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (2,'MSC',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (2,'MUP',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (2,'MUR',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (2,'SADU',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (2,'SAD',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (2,'SREN',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (2,'SJD',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (2,'VCH',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (2,'VENS',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (2,'VENT',SYSDATE,0);


--  AOS Admin 3

INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (3,'AAR',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (3,'ARAU',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (3,'IU',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (3,'MADUA',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (3,'MUP',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (3,'SADU',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (3,'SAD',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (3,'SREN',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (3,'SJD',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (3,'VCH',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (3,'VENS',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (3,'VENT',SYSDATE,0);


-- Prod Support 4

INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (4,'AAR',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (4,'CENS',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (4,'CENT',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (4,'MAS',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (4,'MENS',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (4,'MENT',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (4,'MJS',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (4,'SADU',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (4,'SAD',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (4,'SREN',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (4,'SJD',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (4,'VCH',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (4,'VENS',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (4,'VENT',SYSDATE,0);


--  Marketing Admin 5

INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (5,'AAR',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (5,'CENS',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (5,'CENT',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (5,'CSC',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (5,'MENS',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (5,'MENT',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (5,'MSC',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (5,'SADU',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (5,'SAD',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (5,'SREN',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (5,'SJD',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (5,'VCH',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (5,'VENS',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (5,'VENT',SYSDATE,0);


--  Prod Editors 6

INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (6,'AAR',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (6,'SADU',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (6,'SAD',SYSDATE,0);
INSERT INTO ROLE_PERMISSIONS (ROLE_ID,PERMISSION_CD,CREATED_DATE,CREATED_BY) VALUES (6,'SJD',SYSDATE,0);


-- Lookup VALUES

Insert into LOOKUP_VALUES (LOOKUP_KEY,LOOKUP_NAME,LOOKUP_VALUE,CREATED_DATE,CREATED_BY) VALUES ('ADMACC','ACC1','Provide User Support',SYSDATE,0);
Insert into LOOKUP_VALUES (LOOKUP_KEY,LOOKUP_NAME,LOOKUP_VALUE,CREATED_DATE,CREATED_BY) VALUES ('ADMACC','ACC2','Provide Product Support',SYSDATE,0);
Insert into LOOKUP_VALUES (LOOKUP_KEY,LOOKUP_NAME,LOOKUP_VALUE,CREATED_DATE,CREATED_BY) VALUES ('ADMACC','ACC3','Provide OnlineOpen Support',SYSDATE,0);
Insert into LOOKUP_VALUES (LOOKUP_KEY,LOOKUP_NAME,LOOKUP_VALUE,CREATED_DATE,CREATED_BY) VALUES ('ADMACC','ACC4','Provide Open Access Support',SYSDATE,0);
Insert into LOOKUP_VALUES (LOOKUP_KEY,LOOKUP_NAME,LOOKUP_VALUE,CREATED_DATE,CREATED_BY) VALUES ('ADMACC','ACC5','Provide License Support',SYSDATE,0);
Insert into LOOKUP_VALUES (LOOKUP_KEY,LOOKUP_NAME,LOOKUP_VALUE,CREATED_DATE,CREATED_BY) VALUES ('TITLE','TITLE1','Mr',SYSDATE,0);
Insert into LOOKUP_VALUES (LOOKUP_KEY,LOOKUP_NAME,LOOKUP_VALUE,CREATED_DATE,CREATED_BY) VALUES ('TITLE','TITLE2','Mrs',SYSDATE,0);
Insert into LOOKUP_VALUES (LOOKUP_KEY,LOOKUP_NAME,LOOKUP_VALUE,CREATED_DATE,CREATED_BY) VALUES ('TITLE','TITLE3','Miss',SYSDATE,0);
Insert into LOOKUP_VALUES (LOOKUP_KEY,LOOKUP_NAME,LOOKUP_VALUE,CREATED_DATE,CREATED_BY) VALUES ('TITLE','TITLE4','Ms',SYSDATE,0);
Insert into LOOKUP_VALUES (LOOKUP_KEY,LOOKUP_NAME,LOOKUP_VALUE,CREATED_DATE,CREATED_BY) VALUES ('TITLE','TITLE5','Dr',SYSDATE,0);
Insert into LOOKUP_VALUES (LOOKUP_KEY,LOOKUP_NAME,LOOKUP_VALUE,CREATED_DATE,CREATED_BY) VALUES ('SUFFIX','SUFFIX1','Jr',SYSDATE,0);
Insert into LOOKUP_VALUES (LOOKUP_KEY,LOOKUP_NAME,LOOKUP_VALUE,CREATED_DATE,CREATED_BY) VALUES ('SUFFIX','SUFFIX2','Sr',SYSDATE,0);
Insert into LOOKUP_VALUES (LOOKUP_KEY,LOOKUP_NAME,LOOKUP_VALUE,CREATED_DATE,CREATED_BY) VALUES ('SUFFIX','SUFFIX3','Miss',SYSDATE,0);
Insert into LOOKUP_VALUES (LOOKUP_KEY,LOOKUP_NAME,LOOKUP_VALUE,CREATED_DATE,CREATED_BY) VALUES ('SUFFIX','SUFFIX4','Ms',SYSDATE,0);
Insert into LOOKUP_VALUES (LOOKUP_KEY,LOOKUP_NAME,LOOKUP_VALUE,CREATED_DATE,CREATED_BY) VALUES ('SUFFIX','SUFFIX5','Dr',SYSDATE,0);


