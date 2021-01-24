from sys import stdin

a=(stdin.readline().strip())
b=float(stdin.readline().strip())
c=float(stdin.readline().strip())

m="MOD"
d="DIV"

if a=="+":
    print(b+c)
elif a=="-":
    print(b-c)
elif a=="*":
    print(b*c)
elif a=="/":
    if c!=0:
        print("{0:.2f}".format(b/c))
    elif c==0:
        print("Imposible Dividir Por Zero")
elif a==m:
    if c!=0:
        print(b%c)
    elif c==0:
        print("Imposible Dividir Por Zero")
elif a==d:
    if c!=0:
        print(b//c)
    elif c==0:
        print("Imposible Dividir Por Zero")
