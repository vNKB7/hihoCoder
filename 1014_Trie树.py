#!/usr/bin/env python2
#coding=utf8

class TrieTree(object):
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        if not len(word):
            return
        cur = self.root
        for c in word:
            if c not in cur.child:
                cur.child[c] = TrieNode(c, 0)
            cur = cur.child[c]
            cur.count += 1

    def search(self, prefix):
        cur = self.root
        for c in prefix:
            if c not in cur.child:
                return 0
            else:
                cur = cur.child[c]
        return cur.count


class TrieNode(object):
    def __init__(self, val = '.', count = 0):
        self.val = val
        self.count = count
        self.child = {}

while True:
    try:
        N = int(raw_input())
        words = []
        for i in range(N):
            words.append(raw_input())
        M = int(raw_input())
        prefix = []
        for i in range(M):
            prefix.append(raw_input())

        tt = TrieTree()
        for w in words:
            tt.insert(w)

        for p in prefix:
            print tt.search(p)

    except EOFError:
        break

