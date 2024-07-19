-- DDL.sql
CREATE TABLE book_tbl_06(
                         book_no NUMBER PRIMARY KEY,
                         book_name VARCHAR2(50) NOT NULL,
                         book_coverimg VARCHAR2(20),
                         book_date DATE,
                         book_price NUMBER,
                         book_publisher VARCHAR2(50),
                         book_info VARCHAR2(2000)
                        );
                        
INSERT INTO book_tbl_06(
                         book_no,
                         book_name,
                         book_coverimg,
                         book_date,
                         book_price,
                         book_publisher,
                         book_info
                        )
        VALUES(
                100,
                '리눅스',
                '100.jpg',
                TO_DATE('2015/09/02','yyyy/MM/dd'),
                24000,
                '나룩스',
                '운영체제,DB기초, 네트워크기초, 개발환경구축'
            );
            
INSERT INTO book_tbl_06(
                         book_no,
                         book_name,
                         book_coverimg,
                         book_date,
                         book_price,
                         book_publisher,
                         book_info
                        )
        VALUES(
                101,
                '자바',
                '101.jpg',
                TO_DATE('2016/01/10','yyyy/MM/dd'),
                20000,
                '이자바',
                '프로그래밍 언어'
            );
            
            
INSERT INTO book_tbl_06(
                         book_no,
                         book_name,
                         book_coverimg,
                         book_date,
                         book_price,
                         book_publisher,
                         book_info
                        )
        VALUES(
                102,
                '자바웹프로그래밍',
                '102.jpg',
                TO_DATE('2016/10/30','yyyy/MM/dd'),
                25000,
                '김프로',
                '개발환경/서버프로그램/배치프로그램'
            );
            
            
INSERT INTO book_tbl_06(
                         book_no,
                         book_name,
                         book_coverimg,
                         book_date,
                         book_price,
                         book_publisher,
                         book_info
                        )
        VALUES(
                103,
                '오픈소스활용하기',
                '103.jpg',
                TO_DATE('2017/09/01','yyyy/MM/dd'),
                30000,
                '박오픈',
                '형상관리, 빌드, 배포'
            );
            
            
INSERT INTO book_tbl_06(
                         book_no,
                         book_name,
                         book_coverimg,
                         book_date,
                         book_price,
                         book_publisher,
                         book_info
                        )
        VALUES(
                104,
                'HTML',
                '104.jpg',
                TO_DATE('2018/04/04','yyyy/MM/dd'),
                10000,
                '홍길동',
                'HTML/CSS/JAVASCRIPT/JQUERY'
            );
            
            
            
CREATE TABLE rent_tbl_06(
                         rent_no NUMBER PRIMARY KEY,
                         book_no NUMBER NOT NULL,
                         rent_price NUMBER NOT NULL,
                         rent_date DATE NOT NULL,
                         rent_status CHAR(1) DEFAULT 0 NOT NULL 
                        );
                        
                        
                        
                        
INSERT INTO rent_tbl_06(
                         rent_no,
                         book_no,
                         rent_price,
                         rent_date,
                         rent_status
                        )
       VALUES(
               10001,
               100,
               2400,
               TO_DATE('2018/07/02','yyyy/MM/dd'),
               1
             );
             
             
INSERT INTO rent_tbl_06(
                         rent_no,
                         book_no,
                         rent_price,
                         rent_date,
                         rent_status
                        )
       VALUES(
               10002,
               101,
               2000,
               TO_DATE('2018/07/04','yyyy/MM/dd'),
               1
             );

             
INSERT INTO rent_tbl_06(
                         rent_no,
                         book_no,
                         rent_price,
                         rent_date,
                         rent_status
                        )
       VALUES(
               10003,
               100,
               2400,
               TO_DATE('2018/08/02','yyyy/MM/dd'),
               1
             );
             
INSERT INTO rent_tbl_06(
                         rent_no,
                         book_no,
                         rent_price,
                         rent_date,
                         rent_status
                        )
       VALUES(
               10004,
               100,
               2400,
               TO_DATE('2018/08/12','yyyy/MM/dd'),
               1
             );

             
INSERT INTO rent_tbl_06(
                         rent_no,
                         book_no,
                         rent_price,
                         rent_date,
                         rent_status
                        )
       VALUES(
               10005,
               102,
               2500,
               TO_DATE('2018/08/13','yyyy/MM/dd'),
               1
             );
             

INSERT INTO rent_tbl_06(
                         rent_no,
                         book_no,
                         rent_price,
                         rent_date,
                         rent_status
                        )
       VALUES(
               10006,
               103,
               3000,
               TO_DATE('2018/08/13','yyyy/MM/dd'),
               1
             );
             

INSERT INTO rent_tbl_06(
                         rent_no,
                         book_no,
                         rent_price,
                         rent_date,
                         rent_status
                        )
       VALUES(
               10007,
               103,
               3000,
               TO_DATE('2018/08/20','yyyy/MM/dd'),
               0
             );

INSERT INTO rent_tbl_06(
                         rent_no,
                         book_no,
                         rent_price,
                         rent_date,
                         rent_status
                        )
       VALUES(
               10008,
               100,
               2400,
               TO_DATE('2018/09/03','yyyy/MM/dd'),
               1
             );
             
INSERT INTO rent_tbl_06(
                         rent_no,
                         book_no,
                         rent_price,
                         rent_date,
                         rent_status
                        )
       VALUES(
               10009,
               100,
               2400,
               TO_DATE('2018/09/08','yyyy/MM/dd'),
               1
             );
             
INSERT INTO rent_tbl_06(
                         rent_no,
                         book_no,
                         rent_price,
                         rent_date,
                         rent_status
                        )
       VALUES(
               10010,
               100,
               2400,
               TO_DATE('2018/09/14','yyyy/MM/dd'),
               0
             );
             
INSERT INTO rent_tbl_06(
                         rent_no,
                         book_no,
                         rent_price,
                         rent_date,
                         rent_status
                        )
       VALUES(
               10011,
               102,
               2500,
               TO_DATE('2018/09/14','yyyy/MM/dd'),
               0
             );