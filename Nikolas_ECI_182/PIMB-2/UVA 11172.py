from sys import stdin

def main():
    a=int(stdin.readline())
    b=int(stdin.readline())
    if a>b:
        print(">")
    elif a<b:
        print("<")
    else:
        print("=")

main()
