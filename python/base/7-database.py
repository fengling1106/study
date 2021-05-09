#oralce test
import cx_Oracle
import time
import datetime
import ibm_db

import mx.ODBC
import mx.ODBC.Windows
import sys
import os
import datetime

#oralce test
import ibm_db

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

conn = ibm_db.connect("dsn=CITYMKT", "fengling", "HEar%305")
server = ibm_db.server_info(conn)

if server:
    print "DBMS_NAME: string(%d) \"%s\"" % (len(server.DBMS_NAME), server.DBMS_NAME)
    print "DBMS_VER: string(%d) \"%s\"" % (len(server.DBMS_VER), server.DBMS_VER)
    print "DB_NAME: string(%d) \"%s\"" % (len(server.DB_NAME), server.DB_NAME)
    ibm_db.close(conn)
else:
    print "Error."
    

db = mx.ODBC.Windows.DriverConnect( 'DSN=CITYMKT' )
cursor = db.cursor()
cursor.execute( 'select product_item_id, name from GZ999.UP_PRODUCT_ITEM  fetch first 5 rows only;' )
mx.ODBC.print_resultset( cursor )
cursor.close()
db.close()


try:
		conn=ibm_db.connect("DATABASE=GZDMT;HOSTNAME=135.10.44.169;PORT=50000;PROTOCOL=TCPIP;UID=fengling;PWD=HEar%305;", "", "")
except: 
		print "no connection:",ibm_db.conn_errormsg()
else:
		print "The connection was successful"


file_object = open('thefile.txt','a')

 
stmt=ibm_db.exec_immediate(conn,'select * from fengling.tbl_fl_arpu_07 fetch first 5 rows only')
r = ibm_db.fetch_both(stmt)
while(r):
		print r[0], r[1], r[2]
		r = ibm_db.fetch_both(stmt)
		all_the_text = r[0]+','+r[1]+','+r[2]+'\r\n'
		file_object.write(all_the_text)
ibm_db.close(conn)

file_object.close( )