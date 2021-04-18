# -*- coding: utf-8 -*-

import sys


list=[1, 2, 3, 4]
it = iter(list)    # 创建迭代器对象

for x in it:
    print (x)
    
class MyNumbers:
    def _iter_(self):
        self.a = 1
        return self
    
    def _next_(self):
        n = self.a
        self.a += 1
        return n
        
mynum = MyNumbers()
myiter = iter(mynum)
print(next(myiter))    
#for k in myiter:
#    print (k)
#    if k == 5:
#        break    
    
it2 = iter(list)  
while True:
    try:
        print (next(it2))
    except StopIteration:
        sys.exit()    
        

