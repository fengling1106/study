#oralce test
import cx_Oracle
#db=cx_Oracle.connect('AUDIT1/lscxdb@135.10.54.28:1521')
db=cx_Oracle.connect('mma','mma123','10.196.120.6:1521/ORCL11G')
cr=db.cursor()
sql='select name from tb_myabc'
cr.execute(sql)
rs=cr.fetchall()
print "print all:(%s)" %rs
for x in rs:
    print x
db.close()
