

select * from StudentInfo

--添加自增列
alter table  studentinfo
		add studentID int identity(1,1)

select * from StudentInfo


--自增列改为主键 
select * from grade
alter table grade 
add constraint PK_Grade_GradeID primary key (GradeId);
select * from grade