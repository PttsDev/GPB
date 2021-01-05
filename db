CREATE TABLE USER(
 UserID varchar(11) not null CONSTRAINT PK_User_UserID PRIMARY KEY,	#Es una cadena de caracteres?
 Name varchar(15) not null,
 Surname varchar(20) not null,
 DNI varchar(11) not null CONSTRAINT UQ_User_DNI UNIQUE,
 Email varchar() not null CONSTRAINT UQ_User_Email UNIQUE,
 password varchar() not null
);

CREATE TABLE STUDENT(
StuID varchar(11) not null CONSTRAINT PK_Student_StuID PRIMARY KEY
);
ALTER TABLE STUDENT ADD CONSTRAINT FK_Student_StuID FOREIGN KEY (StuID) referencers USER(UserID);

CREATE TABLE TEACHER(
TeaID varchar(11) not null CONSTRAINT PK_Teacher_TeaID PRIMARY KEY
);
ALTER TABLE TEACHER ADD CONSTRAINT FK_Teacher_TeaID FOREIGN KEY (TeaID) referencers USER(UserID);

CREATE TABLE SUBJECT(
SubjectID int not null CONSTRAINT PK_Subject_SubjectID PRIMARY KEY, 
Name varchar(50) not null
);

CREATE TABLE GROUP(
GroupID varchar(15) not null CONSTRAINT PK_Group_GroupID PRIMARY KEY,
Num tinyint not null,
Type varchar(5) not null,
SubjectID int not null CONSTRAINT FK_Group_SubjectID FOREIGN KEY references SUBJECT(SubjectID)
);

CREATE TABLE STUSUB(
SubjectID int not null CONSTRAINT FK_Stusub_SubjectID FOREIGN KEY references SUBJECT(SubjectID),
StuID varchar(11) not null CONSTRAINT FK_Stusub_StuID FOREIGN KEY references USER(UserID),
CONSTRAINT PK_Stusub_SubjectID_StuID PRIMARY KEY (SubjectID, StuID)
);

CREATE TABLE STUGRO(
GroupID varchar(15) not null CONSTRAINT FK_Stugro_GroupID FOREIGN KEY references GROUP(GroupID),
StuID varchar(11) not null CONSTRAINT FK_Stugro_StuID FOREIGN KEY references USER(UserID),
CONSTRAINT PK_Stugro_GroupID_StuID PRIMARY KEY (GroupID, StuID)
);

CREATE TABLE TEASUB(
SubjectID int not null CONSTRAINT FK_Teasub_SubjectID FOREIGN KEY references SUBJECT(SubjectID),
TeaID varchar(11) not null CONSTRAINT FK_Teasub_TeaID FOREIGN KEY references USER(UserID),
CONSTRAINT PK_Teasub_SubjectID_TeaID PRIMARY KEY (SubjectID, TeaID)
);

CREATE TABLE TEAGRO(
GroupID varchar(15) not null CONSTRAINT FK_Teagro_GroupID FOREIGN KEY references GROUP(GroupID),
TeaID varchar(11) not null CONSTRAINT FK_Teagro_TeaID FOREIGN KEY references USER(UserID),
CONSTRAINT PK_Teagro_GroupID_TeaID PRIMARY KEY (GroupID, TeaID)
);

CREATE TABLE ACTIVITY(	#pueden ser los parametros null   ???
ActivityID varchar(15) not null CONSTRAINT PK_Activity_ActivityID PRIMARY KEY,
Name varchar(50) not null,
ActDate date not null,
endTime time(7) not null,
Duration decimal(2,3) not null,
Comment varchar(500) null,
Colour varchar(11) not null 	#En codigo rgb: 255.255.255
);

CREATE TABLE PERSONALACTIVITY(
ActivityID varchar(15) not null CONSTRAINT FK_PA_ActivityID FOREIGN KEY references ACTIVITY(ActivityID),
StuID varchar(11) not null CONSTRAINT FK_PA_StuID FOREIGN KEY references USER(UserID),
CONSTRAINT PK_PA_ActivityID_StuID PRIMARY KEY (ActivityID, StuID)
);

CREATE TABLE LECTURE(
ActivityID varchar(15) not null CONSTRAINT PK_Lecture_ActivityID PRIMARY KEY,
Classroom varchar(5) null,	#AA000
GroupID varchar(15) not null CONSTRAINT FK_Lecture_GroupID FOREIGN KEY references GROUP(GroupID)
);
ALTER TABLE LECTURE ADD CONSTRAINT FK_Lecture_ActivityID FOREIGN KEY (ActivityID) references ACTIVITY(ActivityID);

CREATE TABLE TUTORSHIP(
ActivityID varchar(15) not null CONSTRAINT PK_Tutorship_ActivityID PRIMARY KEY,
Place varchar(50) null,
StuID varchar(11) not null CONSTRAINT FK_Tutorship_StuID FOREIGN KEY references USER(UserID),
TeaID varchar(11) not null CONSTRAINT FK_Tutorship_TeaID FOREIGN KEY references USER(UserID)
);
ALTER TABLE TUTORSHIP ADD CONSTRAINT FK_Tutorship_ActivityID FOREIGN KEY (ActivityID) references ACTIVITY(ActivityID);

CREATE TABLE MEETING(
ActivityID varchar(15) not null CONSTRAINT PK_Meeting_ActivityID PRIMARY KEY,
Place varchar(50) null,
TeaID varchar(11) not null CONSTRAINT FK_Meeting_TeaID FOREIGN KEY references USER(UserID)
);
ALTER TABLE MEETING ADD CONSTRAINT FK_Meeting_ActivityID FOREIGN KEY (ActivityID) references ACTIVITY(ActivityID);