#!/usr/bin/env python2
#coding=utf8

def KMP(S, T):
    pass


while True:
    try:
        N = int(raw_input())
        for _ in range(N):
            S = raw_input()
            T = raw_input()
            print KMP(S, T)
    except EOFError:
        break


