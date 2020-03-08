#DB2数据与写csv数据
import ibm_db
import sys
import os
import time
import datetime
import csv

try:
		conn=ibm_db.connect("DATABASE=testdb;HOSTNAME=localhost;PORT=50000;PROTOCOL=TCPIP;UID=valen;PWD=kingling819@;", "", "")
except: 
		print "no connection:",ibm_db.conn_errormsg()
else:
		print "The connection was successful"


file_object = open('call_result.txt','a')

str_sql= "select region_code, call_time from valen.tbl_my_test b "
cresult="" 

file_csv=open('my.csv', 'wb')
writer = csv.writer(file_csv)
writer.writerow(['Column1', 'Column2'])

stmt=ibm_db.exec_immediate(conn,str_sql)
r = ibm_db.fetch_both(stmt)
while(r):
		#print str(r[0]), str(r[1])
		cresult = cresult+str(r[0])+','+str(r[1])+'\r\n'
		writer.writerow([str(r[0]),str(r[1])])
		
		r = ibm_db.fetch_both(stmt)
ibm_db.close(conn)

print cresult
file_object.write(cresult)
file_object.close( )

file_csv.close( )