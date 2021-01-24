from sys import stdin

def vuel(x,c):
    a=0
    b=0
    for k in x:
        if a<=k:
            a+=k
            b+=1
    print(b)
            
        

def main():
    v,c=[int(i) for i in stdin.readline().strip().split()]
    while v!=0 and c!=0:
        x=[int(j) for j in stdin.readline().strip().split()]
        vuel(x,c)
        v,c=[int(i) for i in stdin.readline().strip().split()]

main()
