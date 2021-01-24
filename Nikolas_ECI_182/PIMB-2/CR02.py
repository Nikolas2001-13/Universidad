from sys import stdin

def cos(a,c):
    z=0
    x=0
    for i in a:
        if i+x<=c:
            x+=i
            z+=1
        else:
            break
    print(z)
        

def main():
    v,c=stdin.readline().split()
    v=int(v)
    c=int(c)
    while v!=0 and c!=0:
        a=[int(i) for i in stdin.readline().split()]
        cos(a,c)
        v,c=stdin.readline().split()
        v=int(v)
        c=int(c)

main()
