from sys import stdin

def main():
    x=int(stdin.readline().strip())
    d1=x//1000
    d2=(x%1000)//100
    d3=((x%1000)%100)//10
    d4=(((x%1000)%100)%10)//1
    if d1>=d2 and d1>=d3 and d1>=d4:
        print(d1)
    elif d2>=d1 and d2>=d3 and d2>=d4:
        print(d2)
    elif d3>=d1 and d3>=d2 and d3>=d4:
        print(d3)
    elif d4>=d1 and d4>=d2 and d4>=d3:
        print(d4) 
    



main()
