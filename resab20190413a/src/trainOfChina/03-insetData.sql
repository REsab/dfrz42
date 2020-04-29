
insert into TrainInfo values('k12','石家庄','武汉',1233,'13:00:00','01:00:00',2,140,1.4);
insert into TrainInfo values('k181','长沙','北京',1850,'22:14:00','06:40:00',1,120,0.7);
insert into TrainInfo values('T5','长沙','北京',1788,'18:30:00','23:10:00',1,180,1.3);
insert into TrainInfo values('T3','武汉','重庆',1455,'22:00:00','21:20:00',2,150,2);
insert into TrainInfo values('Z11','武汉','南京',1844,'19:30:00','14:20:00',2,135,2);

insert into TrainScheduler values('k181','2013-05-06','张亮',0,0,0);
insert into TrainScheduler values('k181','2013-05-07','张亮',0,0,0);
insert into TrainScheduler values('k181','2013-05-08','张亮',100,50,0);
insert into TrainScheduler values('T5','2013-05-06','刘军',100,50,0);
insert into TrainScheduler values('T5','2013-05-07','李章',122,34,6);
insert into TrainScheduler values('T5','2013-05-08','李章',300,200,50);
insert into TrainScheduler values('Z11','2013-05-06','杨过',0,0,0);
insert into TrainScheduler values('Z11','2013-05-07','杨过',20,9,0);
insert into TrainScheduler values('Z11','2013-05-08','杨过',100,80,0);

select *From TrainInfo;
select *From TrainScheduler;
