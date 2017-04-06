#!/usr/bin/env python2
#coding=utf8


def remove_max(str):
    if not str:
        return str
    new_str = ''
    #这里用栈不行，为什么
    str = '^{}$'.format(str)
    slow = fast = 0
    while fast < len(str):
        if str[fast] == str[slow]:
            fast += 1
        elif fast - slow == 1:
            new_str += str[slow]
            slow = fast
            fast += 1
        else:
            slow = fast
            fast += 1
    return new_str[1:]


def remove_length(str):
    s = str
    length1 = length2 = len(str)
    length2 += 1
    while length2 > len(str):
        length2 = len(str)
        str = remove_max(str)
    # print '{}-{}-{}'.format(s, str, length1 - len(str))
    return length1 - len(str)

while True:
    try:
        N = int(raw_input())
        for i in range(N):
            str = raw_input()
            max_reomve = 0
            for i in range(len(str)):
                for c in 'ABC':
                    new_str = str[:i] + c +str[i:]
                    tmp = remove_length(new_str)
                    if tmp > max_reomve:
                        max_reomve = tmp
                        if max_reomve == len(str)+1:
                            break
            print max_reomve
    except EOFError:
        break

