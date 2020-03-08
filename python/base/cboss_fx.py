#oralce test
import cx_Oracle
import time
import datetime

#db=cx_Oracle.connect('AUDIT1/lscxdb@135.10.54.28:1521')
db=cx_Oracle.connect('fengling','RIght%147','135.10.55.80:1521/JYCBOSS')

today = datetime.date.today()
yesterday = today - datetime.timedelta(days=1) 
print yesterday.strftime("%Y%m%d")

dd=('to_date(\''+yesterday.strftime("%Y%m%d")+'\''+',\'yyyymmdd'+'\')')
sql='insert into monitor_cboss_trans \
 select /*+append parallel(t,16) nologging */sysdate,cutoffday,bipcode,activitycode,count(1) num from CBOSS.home_busi_record_201503 t \
 where resp_code=2998 and cutoffday='+dd+' group by bipcode,activitycode,cutoffday order by num desc'
#pr={'stat_date':dt}
print dd
pr={'rq':dd}
cr=db.cursor()
#sql='insert into monitor_cboss_trans \
# select /*+append parallel(t,16) nologging */sysdate,cutoffday,bipcode,activitycode,count(1) num from CBOSS.home_busi_record_201503 t \
# where resp_code=2998 and cutoffday=%s group by bipcode,activitycode,cutoffday order by num desc'
#cr.execute(sql)
#rs=cr.fetchall()
#print "print all:(%s)" %rs
#for x in rs:
#    print x
#db.commit()

#sql = "insert into monitor_cboss_trans(montime,cutoffday,bipcode,activitycode,num) values(sysdate,sysdate,'BIP2B542', 'T2001542', 1000)"
sql = "insert into monitor_cboss_trans(montime,cutoffday,bipcode,activitycode,num) values(sysdate,sysdate,:1, :2, :3)"
params=('BIP2B542',	'T2001542',	1000)
cr.execute(sql,params)
db.commit()
db.close()