from sys import stdin

a=int(stdin.readline().strip())
b=int(stdin.readline().strip())

def familia():
    a1=a//1000
    a2=(a%1000)//100
    a3=((a%1000)%100)//10
    a4=(((a%1000)%100)%10)//1

    b1=b//1000
    b2=(b%1000)//100
    b3=((b%1000)%100)//10
    b4=(((b%1000)%100)%10)//1

    if a1+a2+a3+a4==b1+b2+b3+b4:
        print(a,"y",b,"si son familia")
    else:
        print(a,"y",b,"no son familia")

familia()
