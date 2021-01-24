from sys import stdin

a=int(stdin.readline())
b=int(stdin.readline())
c=a+b

if a>=0 and b>=0:
    print(str(a)+"+"+str(b)+"="+str(c))
elif a<0 and b<0:
    print("("+str(a)+")""+""("+str(b)+")""="+str(c))
elif a<0 and b>=0:
    print("("+str(a)+")""+"+str(b)+"="+str(c))
elif a>=0 and b<0:
    print(str(a)+"+""("+str(b)+")""="+str(c))
