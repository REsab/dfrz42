select * from card

select * from Record
select * from Computer






--(1)��ѯָ�����ı����ϻ�����;.   ����Ϊ 0023_ABC

select * from Record 
			where  datepart(mm,EndTime)=datepart(mm,GETDATE())   
				and cardid='0023_ABC'



--(2) 24Сʱ֮���ϻ�����Ա�����б�;


select UserName from Record join Card
			on dateadd(dd,-1,getdate())<BeginTime  and Record.CardId= Card.ID
				--��ʼʱ����һ��ǰ�Ժ�  



----(3)�����ϻ���Ա�����û���;

select sum(fee) from Record R  join card C on
 dateadd(dd,-1-datepart (dw,getdate()),getdate())<begintime

		    


-- (4)���ŵ�6λ�͵�7λ��"AB"����Ա���������;

select Fee from record
		where CHARINDEX('A',Cardid)=6 
				and  CHARINDEX('B',Cardid)=7