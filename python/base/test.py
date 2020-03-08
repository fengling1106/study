#oralce test
import ibm_db
import sys
import os
import time
import datetime


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