#!/usr/bin/env python2
#coding=utf8
import random

# 他们家的python挂了吗？老是RE
while True:
    try:
        total = int(raw_input())
        for i in range(total):
            N, M = (int(x) for x in raw_input().split())
            missing = [0] + [int(x) for x in raw_input().split()] + [101]
            if M >= N:
                print 100
                continue
            # print missing
            max_day = max([missing[j] - missing[j-1] - 1 for j in range(1, len(missing))])
            for j in range(1, N-M+2):
                start = missing[j-1]
                end = missing[j+M]
                if end - start - 1 > max_day:
                    max_day = end - start - 1
            print max_day
    except EOFError:
        break

# with open('test.txt', 'w') as writeFile:
#     for i in range(100):
#         N = random.randint(1, 100)
#         M = random.randint(1, 100)
#         out = set()
#         while len(out) < N:
#             out.add(random.randint(1, 100))
#         out = list(out)
#         out = sorted(out)
#         out = [str(x) for x in out]
#         writeFile.write('%d %d\n' % (N, M))
#         writeFile.write('%s\n' % (' '.join(out)))







