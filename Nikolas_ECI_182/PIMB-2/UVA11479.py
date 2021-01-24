from sys import stdin

def tri(a,b,c):
    if a+b>c and a+c>b and b+c>a:
        if a==b==c:
            return "Equilateral"
        elif a==b!=c or a==c!=b or b==c!=a:
            return "Isosceles"
        else:
            return "Scalene"
    else:
        return  "Invalid"


        
def main():
    n=int(stdin.readline().strip())
    for i in range(n):
        a,b,c=stdin.readline().strip().split()
        a=int(a)
        b=int(b)
        c=int(c)
        print("Case "+str(i+1)+":",tri(a,b,c))

main()
