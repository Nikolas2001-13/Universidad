from sys import stdin

def prime(n):
    if n<2:
        return "Primo"
    for i in range(2,n):
        if n%i==0:
            return "No Primo"
    else:
        return "Primo"
    
            
def main():
    x=int(stdin.readline().strip())
    while x!=0:
        n=int(stdin.readline().strip())
        print(prime(n))
        x-=1

main()
