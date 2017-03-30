#!/usr/bin/env python2
#coding=utf8
import math
tasks = int(raw_input())
while True:
    try:
        (N, P, W, H) = (int(x) for x in raw_input().split())
        a = [int(x) for x in raw_input().split()]
        max_font = min(P * H * W / sum(a), H, W)
        min_font = 1
        final_font = 1
        while min_font <= max_font:
            S = (min_font + max_font) / 2
            word_pre_line = W / S
            lines = sum([math.ceil(float(x)/word_pre_line) for x in a])
            max_lines = H / S * P
            if lines <= max_lines:
                if S > final_font:
                    final_font = S
                min_font = S + 1
            else:
                max_font = S - 1
        print final_font
    except EOFError:
        break




