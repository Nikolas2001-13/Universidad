from sys import stdin

def rec(n,c):
    if c==0:
        return
    else:
        if n[c]>=n[c-1]:
            return n[c]
        else:
            return rec(n,c-1)

def main():
    n=[int(x) for x in stdin.readline().split(",")]
    c=len(n)-1
    print(rec(n,c))

main()
    
