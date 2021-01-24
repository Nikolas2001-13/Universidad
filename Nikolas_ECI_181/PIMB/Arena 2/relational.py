from sys import stdin

def relation():
    a=int(stdin.readline().strip())
    b=int(stdin.readline().strip())
    if a < b:
        print("<")
    elif a>b:
        print(">")
    elif a==b:
        print("=")

relation()
