from sys import stdin

numero=int(stdin.readline())

x=numero//1000
y=numero%1000

d1=x
d2=y//100
d3=(y%100)//10
d4=((y%100)%10)//1

if d1>=d2 and d1>=d3 and d1>=d4:
    print (d1)
elif d2>=d1 and d2>=d3 and d2>=d4:
    print (d2)
elif d3>=d1 and d3>=d2 and d3>=d4:
    print (d3)
elif d4>=d1 and d4>=d2 and d4>=d3:
    print (d4)
elif d1==d2==d3==d4:
    print (d1)

