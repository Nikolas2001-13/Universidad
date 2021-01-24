from sys import stdin

def main():
    op=(stdin.readline().strip())
    a=float(stdin.readline())
    b=float(stdin.readline())
    d="/"
    m="*"
    s="+"
    r="-"
    if op == d :
        if b==0:
            print("Imposible Dividir Por Zero")
        else:
            print("{0:.2f}".format(a/b))
    elif op == m:
        print(a*b)
    elif op == s:
        print(a+b)
    elif op == r:
        print(a-b)
    elif op == "MOD":
        if b==0:
            print("Imposible Dividir Por Zero")
        else:
            print(a%b)
    elif op == "DIV":
        if b==0:
            print("Imposible Dividir Por Zero")
        else:
            print(a//b)



main()
