from sys import stdin

def main():
    a=int(stdin.readline())
    b=int(stdin.readline())
    if a>b:
        if a%b==0:
            print("SI")
        else:
            print("NO")
    elif a<b:
        if b%a==0:
            print("SI")
        else:
            print("NO")
    else:
        print("SI")




main()
