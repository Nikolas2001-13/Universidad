from sys import stdin

def prim(a):
    if a<2:
        return True
    for i in range(2,a):
        if a%i==0:
            return False
    else:
        return True
            

def main():
    n=stdin.readline().strip()
    p=1
    while n!="":
        n=n.replace("-","")
        a=0
        for i in n:
            a+=int(i)
        if prim(a):
            print("Number",str(p)+":","Alien")
        else:
            print("Number",str(p)+":","Not Alien")
        p+=1
        n=stdin.readline().strip()

main()
