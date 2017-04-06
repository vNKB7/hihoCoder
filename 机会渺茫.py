#!/usr/bin/env python2
#coding=utf8

def divisor(num):
    count = 0
    index = 1
    while index * index <= num:
        if num % index == 0:
            count += 2
            if index * index == num:
                count -= 1
        index += 1
    return count

def GCD(m, n):
    if n == 0:
        return m
    else:
        return GCD(n, m % n)


while True:
    try:
        N, M = [int(x) for x in raw_input().split()]
        N_d = divisor(N)
        M_d = divisor(M)
        gcd_d = divisor(GCD(N,M))
        A = N_d * M_d
        B = gcd_d
        g = GCD(A, B)
        A /= g
        B /= g
        print '%d %d' % (A, B)

    except EOFError:
        break
