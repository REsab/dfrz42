

select * from StudentInfo

--���������
alter table  studentinfo
		add studentID int identity(1,1)

select * from StudentInfo


--�����и�Ϊ���� 
select * from grade
alter table grade 
add constraint PK_Grade_GradeID primary key (GradeId);
select * from grade