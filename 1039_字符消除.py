#!/usr/bin/env python2
#coding=utf8

def remove_length(str):
    pre = '0'

    pre_length = len(str)
    while True:
        new_str = ''
        flag = False
        pre = '0'
        for i in range(len(str)):
            if pre != str[i]:
                if flag:
                    new_str += pre
                flag = True
            else:
                flag = False
            pre = str[i]
        if len(str) == 1 or len(str) > 1 and str[-1] != str[-2]:
            new_str += str[-1]
        if len(str) == len(new_str):
            str = new_str
            break
        else:
            str = new_str

    print pre_length - len(str)


def max_remove(str):
    new_str



# while True:
#     try:
#         N = int(raw_input())
#         for i in range(N):
#             str = raw_input()
#             print max_remove(str)
#     except EOFError:
#         break



