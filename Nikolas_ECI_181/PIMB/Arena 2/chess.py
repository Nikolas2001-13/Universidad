from sys import stdin

def rook(m,n):
    if m==n:
        return m
    elif m>n:
        return n
    else:
        return m
def queen(m,n):
    if m==n:
        return m
    elif m>n:
        return n
    else:
        return m
def knight(m,n):
    if m%2==0 and n%2==0:
        return int(m*n/2)
    elif m%2!=0 and n%2!=0:
        return int(((m*n)-1)/2)
    elif m%2!=0 and n%2==0:
        return int(m*n/2)
    elif m%2==0 and n%2!=0:
        return int(m*n/2)
def king(m,n):
    if m%2==0 and n%2==0:
        return int(m*n/4)
    elif m%2!=0 and n%2!=0:
        return int(((m*n)-1)/4)
    else:
        return int(((m+1)//2)*((n+1)//2))
    
def main():
    x=(stdin.readline().strip())
    m=int(stdin.readline().strip())
    n=int(stdin.readline().strip())
    if x=="r":
        print (rook(m,n))
    elif x=="Q":
        print (queen(m,n))
    elif x=="k":
        print (knight(m,n))
    elif x=="K":
        print (king(m,n))

main()
