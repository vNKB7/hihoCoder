#!/usr/bin/env python2
#coding=utf8


# while True:
#     try:
#         N = int(raw_input())
#         army = []
#         for _ in range(N):
#             army.append([int(x) for x in raw_input().split()])
#         M = int(raw_input())
#         operator = []
#         for _ in range(M):
#             operator.append([int(x) for x in raw_input().split()])
#         t = 0
#         magic = 0
#         for i in range(len(operator)):
#             offset = operator[i][0] - t
#             t = operator[i][0]
#             for j in range(len(army)):
#                 army[j][0] = min(army[j][0] + offset * army[j][2], army[j][1])
#             for j in range(operator[i][1]-1, operator[i][2]):
#                 magic += army[j][0]
#                 army[j][0] = 0
#
#         print magic
#     except EOFError:
#         break

while True:
    try:
        N = int(raw_input())
        army = []
        for _ in range(N):
            army.append([int(x) for x in raw_input().split()]+[0])
        M = int(raw_input())
        operator = []
        for _ in range(M):
            operator.append([int(x) for x in raw_input().split()])
        t = 0
        magic = 0
        for i in range(len(operator)):
            for j in range(operator[i][1]-1, operator[i][2]):
                magic += min(army[j][0] + (operator[i][0] - army[j][3]) * army[j][2], army[j][1])
                army[j][3] = operator[i][0]
                army[j][0] = 0
        print magic
    except EOFError:
        break