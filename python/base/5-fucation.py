# -*- coding: utf-8 -*-
import sys

def max(a, b):
    if a > b:
        return a
    else:
        return b
 
a = 4
b = 5
print(max(a, b))

# 在 python 中，类型属于对象，变量是没有类型的：

def func ():
	  print "this module="+__name__
	  print "this module="+func.__name__