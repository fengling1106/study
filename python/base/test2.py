#oralce test
import mx.ODBC
import mx.ODBC.Windows
import sys
import os
import time
import datetime

db = mx.ODBC.Windows.DriverConnect( 'DSN=CITYMKT' )
cursor = db.cursor()
cursor.execute( 'select product_item_id, name from GZ999.UP_PRODUCT_ITEM  fetch first 5 rows only;' )
mx.ODBC.print_resultset( cursor )
cursor.close()
db.close()