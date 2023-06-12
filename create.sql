/************************** 데이터베이스 생성 ******************************/
create database DB2023188606;

/******************* 데이터베이스 유저 생성 및 권한 부여 ********************/
create user DB2023188606@localhost identified by 'DB2023188606';
grant all privileges on DB2023188606.* to DB2023188606@localhost;

use DB2023188606;

/****************************** 테이블 생성 **********************************/

   #이화 호텔 직원의 데이터가 저장되는 테이블입니다.
   #직원 관리 및 식별을 위한 고유번호 (id) / 로그인 시 사용되는 id / 로그인 시 사용되는 비밀번호 / 직원의 성함 / 전화번호 / 생년월일 / 소속 부서 정보를 저장합니다.
create table DB2023_employee(  
   employeeID int,
   loginID varchar(15) not null,
   name varchar(15) not null,
   password varchar(15) not null,
   phone varchar(13) not null, 
   birthDate date not null,
   department varchar(15) not null,

   primary key(employeeid)
);

   #이화 호텔에 회원가입한 고객의 데이터가 저장되는 테이블입니다.
   #고객 관리 및 식별을 위한 고유번호 (id) / 로그인 시 사용되는 id / 로그인 시 사용되는 비밀번호 / 고객의 성함 /전화번호 / 생년월일 / 고객 등급 정보를 저장합니다.
create table DB2023_member(
   memberID int,
   loginID varchar(15) not null,
   name varchar(15) not null,
   password varchar(15) not null,
   phone varchar(13) not null,
   birthDate date not null,
   grade varchar(10),

   primary key(memberid)
);

   #호텔과 고객이 어플리케이션을 통해 주고받은 메시지 데이터가 저장되는 테이블입니다.
   #메시지 관리 및 식별을 위한 고유번호 (id) / 호텔과 메시지를 주고받는 고객의 고유번호 (FK) / (고객 입장에서) 보낸 메시지인지 (memSend) 받은 메시지인지 (memReceive) 구분하기 위해 메시지 상태를 표시하는 속성/ 메시지 내용 / 보낸 시간 정보를 저장합니다.
create table DB2023_message(
   messageID int,
   memberID int,
   messagestatus varchar(15) not null,
   content text,
   sendtime timestamp,
   
   primary key(messageID),
   foreign key(memberID) references DB2023_member(memberID),
   check(messagestatus in ('memsend','memreceive'))

);

   #이화호텔에 존재하는 객실 데이터를 저장하는 테이블입니다.
   #객실 고유 번호 / 침대 종류 / 수용 인원 / 가격 / 객실 종류 / 객실 이름 / 흡연가능여부 / 주차가능여부 정보를 저장합니다. 
create table DB2023_room(
    roomNo int,
    bedType varchar(10) not null,
    capacity int not null,
    price int not null,
    roomType varchar(5) not null, 
    roomSize int not null,
    roomName varchar(10) not null,
    nonSmoking boolean default 1,  
    parking boolean default 1,   

    primary key(roomNo),
    check(bedType in ('Single','Double','Twin','Triple','Suite')) 
);

   #고객이 어플리케이션을 통해 신청한 객실 예약 데이터가 저장되는 테이블입니다.
   #예약 신청 관리 및 식별을 위한 고유번호 (id) / 예약할 객실 번호(FK) / 체크인 날짜 / 체크아웃 날짜 / 예약 신청한 날짜+시간 / 예약자의 고유번호 (FK) / 요구사항 / 조식신청여부 / 예약 신청 상태(승인/거절/대기/취소) / 동반 손님 인원 정보를 저장합니다.
create table DB2023_reservation(
    reservedNo int,
    roomNo int not null,
    checkIn date not null,
    checkOut date not null,
    reservedDate timestamp not null,
    memberID int,
    requirement varchar(20),
    breakfast varchar(10),
    reservedStatus varchar(5) not null,
    guestNo int not null,
    
    primary key(reservedNo),
    foreign key(roomNo) references DB2023_room(roomNo),
    foreign key(memberID) references DB2023_member(memberID),
    check(reservedStatus in ('승인','대기','거절','취소'))
);


/****************************** 데이터 삽입 **********************************/

INSERT INTO DB2023_employee VALUES 
(00001, 'horton7', 'Kerry', 'N86JeHOBP2', '010-4223-0857','1992-10-09', 'front office'),
(00002, 'aperry', 'Amanda', 'TX4q7VG5Tub$', '010-3376-5432', '1987-06-17', 'front office'),
(00003, 'hugo12', 'Dave', 'y7TC6Qs7seB', '010-4432-1223', '1988-10-02', 'housekeeping'),
(00004, 'foos12', 'Doreen', 'RQ#8b42d24r$', '010-3325-8764', '1989-01-12', 'security'),
(00005, 'wcampbell', 'Gilbert', 'sDw8!SSTH2', '010-9873-6522', '1985-04-30', 'hr'),
(00006, 'perryf', 'Lakita', '853U6!zhN98', '010-5427-6538', '1991-03-04', 'security');

INSERT INTO DB2023_member VALUES 
(00001, 'leda7', 'Ivan', '4EPuz3$', '010-3322-4758', '2001-04-30', 'bronze'),
(00002, 'gluli0', 'Milton', 'sV5nw2', '010-2744-9982', '1989-09-10', 'bronze'),
(00003, 'sky01', 'Ethan', 'WB3k8N', '010-8473-1942', '1999-12-24', 'gold'),
(00004, 'cg777', 'Conan', 'nXaB7B28', '010-7432-3379', '2003-05-05', 'VIP'),
(00005, 'haru12', 'Amanda', '27L9vyST', '010-4432-3849', '1995-11-15', 'silver');

INSERT INTO DB2023_message VALUES 
(40001, '00001', 'memsend', 'I want to keep my luggage', '2023-04-20 09:20:00'),
(40002, '00002', 'memsend', 'the light is out', '2023-04-19 22:18:00'),
(40003, '00003', 'memsend', 'do not disturb tomorrow morning', '2023-04-19 20:15:00'),
(40004, '00004', 'memreceive', 'Repairman will visit your room as soon as possible', '2023-04-19 22:20:00'),
(40005, '00005', 'memreceive', 'Your order is accepted', '2023-04-19 20:17:00');


insert into DB2023_room values
(101,'Single',1,45000,'시티뷰',7,'스탠다드룸',0,0),
(102,'Single',1,45000,'시티뷰',7,'스탠다드룸',1,0),
(103,'Single',1,45000,'시티뷰',7,'스탠다드룸',1,0),
(104,'Double',2,70000,'시티뷰',10,'슈페리어룸',1,1),
(201,'Double',2,70000,'시티뷰',10,'슈페리어룸',1,1),
(202,'Double',2,70000,'시티뷰',10,'슈페리어룸',0,1),
(203,'Twin',2,70000,'시티뷰',10,'슈페리어룸',1,1),
(204,'Twin',2,70000,'시티뷰',10,'슈페리어룸',1,1),
(301,'Triple',3,100000,'한강뷰',12,'디럭스룸',0,1),
(302,'Triple',3,100000,'한강뷰',12,'디럭스룸',1,1),
(303,'Suite',4,200000,'한강뷰',15,'스위트룸',1,1);

insert into DB2023_reservation values
(00001,102,'2023-03-20','2023-03-21','2023-03-19 15:20:04',00001,'','조식신청','승인',1),
(00002,203,'2023-04-05','2023-04-06','2023-04-01 15:25:04',00003,'','조식신청 안함','승인',2),
(00003,302,'2023-04-25','2023-04-26','2023-04-10 15:10:01',00004,'발렛파킹해주세요','조식신청','승인',3);


/****************************** view 생성 **********************************/

   # 예약 신청 정보와 예약된 해당 객실의 정보를 같이 보여주기 위한 view 입니다.
CREATE VIEW DB2023_reservedRoom AS
   SELECT reservedNo,roomNo,reservedDate,checkIn,checkOut,requirement,breakfast,guestNo,
   bedType,capacity,roomType,roomSize,roomName,nonSmoking,parking,price
   FROM DB2023_reservation AS re NATURAL JOIN DB2023_room AS ro;

   # 예약 신청 정보와 예약자의 성함, 전화번호를 같이 보여주기 위한 view 입니다.
CREATE VIEW DB2023_MemberReservationView AS 
   SELECT member.name, member.phone, reservation.reservedNo, reservation.roomNo, 
   reservation.checkIn, reservation.checkOut, reservation.reservedDate, 
   reservation.memberID, reservation.reservedStatus, reservation.requirement 
   FROM DB2023_member AS member 
   JOIN DB2023_reservation AS reservation ON member.memberID = reservation.memberID;


/****************************** index 생성 **********************************/

CREATE UNIQUE INDEX loginID ON DB2023_employee(loginID);
CREATE UNIQUE INDEX loginID ON DB2023_member(loginID);
CREATE INDEX messagestatus ON DB2023_message(messagestatus);
CREATE INDEX checkIn ON DB2023_reservation(checkIn);
CREATE INDEX checkOut ON DB2023_reservation(checkOut);

/****************************** 테이블 확인 **********************************/
 
select * from DB2023_employee;
select * from DB2023_member;
select * from DB2023_message;
select * from DB2023_room;
select * from DB2023_reservation;