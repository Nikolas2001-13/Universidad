from sys import stdin

def main():
    n=int(stdin.readline().strip())
    for i in range(1,10):
        a=n*i
        print(str(n)+"X"+str(i)+"="+str(a))

main()
