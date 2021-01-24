from sys import stdin

def main():
    x=int(stdin.readline().strip())
    for i in range(x):
        a,b=(int(j) for j in stdin.readline().strip().split())
        if a>b:
            print(">")
        elif a<b:
            print("<")
        else:
            print("=")

main()
