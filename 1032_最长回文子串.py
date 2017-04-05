#!/usr/bin/env python2
#coding=utf8



def manacher(s):
    s = '#'.join('^{}$'.format(s))
    mx = 0
    index = -1
    P = [0] * len(s)
    for i in range(1, len(s)-1):
        if mx > i:
            j = 2*index-i
            if P[j] > mx-i:
                P[i] = mx-i
                while s[i+P[i]+1] == s[i-P[i]-1]:
                    P[i] += 1
            else:
                P[i] = P[j]
        else:
            while s[i+P[i]+1] == s[i-P[i]-1]:
                P[i] += 1
        if i + P[i] > mx:
            mx = i + P[i]
            index = i
    return max(P)

while True:
    try:
        N = int(raw_input())
        for _ in range(N):
            str = raw_input()
            if len(str) == 1:
                print 1
            else:
                print manacher(str)

    except EOFError:
        break