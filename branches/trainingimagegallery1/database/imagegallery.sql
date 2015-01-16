CREATE TABLE category_img(
    id NUMBER(3) PRIMARY KEY
    , cat_name VARCHAR2(50)
    , description VARCHAR(1000)
    , date_create DATE
);
CREATE TABLE store_img(
    img_no NUMBER(5) PRIMARY KEY
    , img_name VARCHAR2(50) NOT NULL
    , img_description VARCHAR2(1000)
    , img_date_create DATE
    , img_size NUMBER(5)
    , img_user_upload VARCHAR2(50)
    , category_id NUMBER(3) NOT NULL 
    , file_img BLOB
    , FOREIGN KEY (category_id)  REFERENCES category_img(id)
);
CREATE SEQUENCE store_id_seq
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
CREATE SEQUENCE Category_id_seq
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
