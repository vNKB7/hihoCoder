#!/usr/bin/env python2
#coding=utf8

while True:
    try:
        N = int(raw_input())
        list = [int(x) for x in raw_input().split()]
        i = len(list)-2
        last = list[-1]
        while i >= 0 and last > list[i]:
            last = list[i]
            i -= 1
        if i == -1:
            print str(list[0])
        else:
            print " ".join([str(x) for x in list[:i+1]])
    except EOFError:
        break