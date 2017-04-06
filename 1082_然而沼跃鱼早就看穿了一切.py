#!/usr/bin/env python2
#coding=utf8


while True:
    try:
        str = raw_input()
        tmp = str.lower()
        start = 0
        while start < len(str):
            start = tmp.find('marshtomp', start)
            if start == -1:
                break
            str = str[:start]+'fjxmlhx'+str[start+9:]
            start += 9

        print str


    except EOFError:
        break