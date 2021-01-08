CREATE TABLE IF NOT EXISTS USER (
 UserID VARCHAR(11) ,	
 Name varchar(15) not null,
 Surname varchar(20) not null,
 DNI varchar(11) not null UNIQUE,
 Email varchar(50) not null UNIQUE,
 password varchar(25) not null,
 CONSTRAINT PK_User_UserID PRIMARY KEY (UserID)
);

CREATE TABLE IF NOT EXISTS STUDENT(
StuID varchar(11), 
CONSTRAINT PK_Student_StuID PRIMARY KEY (StuID)
);


CREATE TABLE IF NOT EXISTS TEACHER(
TeaID varchar(11), 
CONSTRAINT PK_Teacher_TeaID PRIMARY KEY (TeaID)
);

CREATE TABLE IF NOT EXISTS SUBJECT(
SubjectID int, 
Name varchar(50) not null,
CONSTRAINT PK_Subject_SubjectID PRIMARY KEY (SubjectID)
);

CREATE TABLE IF NOT EXISTS GRUPS(
GroupID varchar(15),
Num int not null,
Type varchar(5) not null,
SubjectID int not null,
CONSTRAINT PK_Group_GroupID PRIMARY KEY (GroupID),
CONSTRAINT FK_Group_SubjectID FOREIGN KEY (SubjectID) references SUBJECT(SubjectID)
);

CREATE TABLE IF NOT EXISTS STUSUB(
SubjectID int,
StuID varchar(11),
CONSTRAINT FK_Stusub_SubjectID FOREIGN KEY (SubjectID) references SUBJECT(SubjectID),
CONSTRAINT FK_Stusub_StuID FOREIGN KEY (StuID) references USER(UserID),
CONSTRAINT PK_Stusub_SubjectID_StuID PRIMARY KEY (SubjectID, StuID)
);

CREATE TABLE IF NOT EXISTS STUGRO(
GroupID varchar(15),
StuID varchar(11),
CONSTRAINT FK_Stugro_GroupID FOREIGN KEY (GroupID) references GRUPS(GroupID),
CONSTRAINT FK_Stugro_StuID FOREIGN KEY (StuID) references STUDENT(StuID),
CONSTRAINT PK_Stugro_GroupID_StuID PRIMARY KEY (GroupID, StuID)
);

CREATE TABLE IF NOT EXISTS TEASUB(
SubjectID int ,
TeaID varchar(11),
CONSTRAINT FK_Teasub_SubjectID FOREIGN KEY (SubjectID) references SUBJECT(SubjectID),
CONSTRAINT FK_Teasub_TeaID FOREIGN KEY (TeaID) references TEACHER(TeaID),
CONSTRAINT PK_Teasub_SubjectID_TeaID PRIMARY KEY (SubjectID, TeaID)
);

CREATE TABLE IF NOT EXISTS TEAGRO(
GroupID varchar(15),
TeaID varchar(11),
CONSTRAINT FK_Teagro_GroupID FOREIGN KEY (GroupID) references GRUPS(GroupID),
CONSTRAINT FK_Teagro_TeaID FOREIGN KEY (TeaID) references TEACHER(TeaID),
CONSTRAINT PK_Teagro_GroupID_TeaID PRIMARY KEY (GroupID, TeaID)
);

CREATE TABLE IF NOT EXISTS ACTIVITY(	#pueden ser los parametros null   ???
ActivityID varchar(15),
Name varchar(50) not null,
ActDate date not null,
endTime time(6) not null,
Duration decimal(4,3) not null,
Comment varchar(500) null,
Colour varchar(11) not null, 	#En codigo rgb: 255.255.255
CONSTRAINT PK_Activity_ActivityID PRIMARY KEY (ActivityID)
);

CREATE TABLE IF NOT EXISTS PERSONALACTIVITY(
ActivityID varchar(15),
StuID varchar(11),
CONSTRAINT FK_PA_ActivityID FOREIGN KEY (ActivityID) references ACTIVITY(ActivityID),
CONSTRAINT FK_PA_StuID FOREIGN KEY (StuID) references STUDENT(StuID),
CONSTRAINT PK_PA_ActivityID_StuID PRIMARY KEY (ActivityID, StuID)
);

CREATE TABLE IF NOT EXISTS LECTURE(
ActivityID varchar(15),
Classroom varchar(5) ,	#AA000
GroupID varchar(15) not null,
CONSTRAINT PK_Lecture_ActivityID PRIMARY KEY (ActivityID),
CONSTRAINT FK_Lecture_GroupID FOREIGN KEY (GroupID) references GRUPS(GroupID)
);

CREATE TABLE IF NOT EXISTS TUTORSHIP(
ActivityID varchar(15),
Place varchar(50) ,
StuID varchar(11) not null,
TeaID varchar(11) not null,
CONSTRAINT FK_Tutorship_StuID FOREIGN KEY (StuID) references STUDENT(StuID),
CONSTRAINT FK_Tutorship_TeaID FOREIGN KEY (TeaID) references TEACHER(TeaID),
CONSTRAINT PK_Tutorship_ActivityID PRIMARY KEY (ActivityID)
);

CREATE TABLE IF NOT EXISTS MEETING(
ActivityID varchar(15),
Place varchar(50),
TeaID varchar(11) not null,
CONSTRAINT FK_Meeting_TeaID FOREIGN KEY (TeaID) references TEACHER(TeaID),
CONSTRAINT PK_Meeting_ActivityID PRIMARY KEY (ActivityID)
);

#-------------------------

ALTER TABLE STUDENT ADD CONSTRAINT FK_Student_StuID FOREIGN KEY (StuID) references USER(UserID);
ALTER TABLE TEACHER ADD CONSTRAINT FK_Teacher_TeaID FOREIGN KEY (TeaID) references USER(UserID);
ALTER TABLE LECTURE ADD CONSTRAINT FK_Lecture_ActivityID FOREIGN KEY (ActivityID) references ACTIVITY(ActivityID);
ALTER TABLE TUTORSHIP ADD CONSTRAINT FK_Tutorship_ActivityID FOREIGN KEY (ActivityID) references ACTIVITY(ActivityID);
ALTER TABLE MEETING ADD CONSTRAINT FK_Meeting_ActivityID FOREIGN KEY (ActivityID) references ACTIVITY(ActivityID);
