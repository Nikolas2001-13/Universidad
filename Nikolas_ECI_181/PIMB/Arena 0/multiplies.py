from sys import stdin

a=int(stdin.readline())
b=int(stdin.readline())

if a==0 and b==0:
    print("SI")
elif a>b:
    if b==0:
        print("NO")
    elif a%b ==0:
        print("SI")
    else:
        print("NO")
else:
    if a==0:
        print("NO")
    elif b%a==0:
        print("SI")
    else:
        print("NO")
    

        

