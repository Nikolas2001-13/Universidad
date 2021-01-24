from sys import stdin

def secuencia(n):
    if n==1:
        return 1
    elif n>0:
        print(n)
        return secuencia(n//2)
        
    

def main():
    n=int(stdin.readline().strip())
    print(secuencia(n))

main()
