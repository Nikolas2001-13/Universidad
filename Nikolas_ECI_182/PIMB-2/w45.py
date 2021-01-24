from sys import stdin

def main():
    a,b=stdin.readline().split()
    c,d=stdin.readline().split()
    a=int(a)
    b=int(b)
    c=int(c)
    d=int(d)
    x=a*d
    y=b*c
    r=x-y
    print("|A|="+str(r))

main()
