CREATE TABLE question (
    question_id NUMBER(4) NOT NULL,
    science_section VARCHAR2(30) DEFAULT 'general' NOT NULL,
    content_description VARCHAR2(1000) NOT NULL,
    CONSTRAINT question_id_con PRIMARY KEY(question_id)
);

CREATE TABLE user_info (
    user_id NUMBER(8) NOT NULL,
    nick_name VARCHAR2(20),
    first_name VARCHAR2(20),
    last_name VARCHAR2(20),
    CONSTRAINT  user_id_con PRIMARY KEY(user_id)
);
/*
CREATE TABLE answer (
    question_id NUMBER(4) NOT NULL,
    A VARCHAR2(50) NOT NULL,
    B VARCHAR2(50) NOT NULL,
    C VARCHAR2(50),
    D VARCHAR2(50),
    E VARCHAR2(50),
    F VARCHAR2(50),
    H VARCHAR2(50),
    I VARCHAR2(50),
    right_answer CHAR NOT NULL
);

CREATE TABLE user_statistic (
    user_id NUMBER(8) NOT NULL,
    question_id NUMBER(4) NOT NULL,
    answer CHAR NOT NULL,
    success CHAR NOT NULL,
    number_answers NUMBER(2) NOT NULL,
    number_right_answers NUMBER(2) NOT NULL
);
*/