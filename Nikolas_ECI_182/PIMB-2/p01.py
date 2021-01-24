from sys import stdin

def main():
    a=int(stdin.readline().strip())
    b=int(stdin.readline().strip())
    r=a+b
    if a<0 and b<0:
        print("("+str(a)+")+("+str(b)+")="+str(r))
    elif a<0:
        print("("+str(a)+")+"+str(b)+"="+str(r))
    elif b<0:
        print(str(a)+"+("+str(b)+")="+str(r))
    else:
        print(str(a)+"+"+str(b)+"="+str(r))
    
    
    

main()
