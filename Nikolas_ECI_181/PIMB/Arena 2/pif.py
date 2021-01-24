from sys import stdin

def pif():
    n=int(stdin.readline().strip())

    if n%2!=0:
        print("Weird")
    elif n%2==0:
        if 2<=n<=5:
            print("Not Weird")
        elif 6<=n<=20:
            print("Weird")
        elif 20<n:
            print("Not Weird")
    else:
        print("Not Weird")
        
pif()
