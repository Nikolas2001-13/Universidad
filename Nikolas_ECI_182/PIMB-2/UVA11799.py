from sys import stdin

def vel(p,a):
    v=max(p)
    print("Case "+str(a)+":",v)

def main():
    n=int(stdin.readline().strip())
    a=1
    while n!=0:
        x=[int(i) for i in stdin.readline().strip().split()]
        p=x[1:]
        vel(p,a)
        a+=1
        n-=1

main()
