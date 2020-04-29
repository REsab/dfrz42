select * from card

select * from Record
select * from Computer






--(1)查询指定卡的本月上机次数;.   卡号为 0023_ABC

select * from Record 
			where  datepart(mm,EndTime)=datepart(mm,GETDATE())   
				and cardid='0023_ABC'



--(2) 24小时之内上机的人员姓名列表;


select UserName from Record join Card
			on dateadd(dd,-1,getdate())<BeginTime  and Record.CardId= Card.ID
				--开始时间在一天前以后  



----(3)本周上机人员、费用汇总;

select sum(fee) from Record R  join card C on
 dateadd(dd,-1-datepart (dw,getdate()),getdate())<begintime

		    


-- (4)卡号第6位和第7位是"AB"的人员的消费情况;

select Fee from record
		where CHARINDEX('A',Cardid)=6 
				and  CHARINDEX('B',Cardid)=7