from sys import stdin

def cesar(y,m):
    abc=["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
    ABC=["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"]
    res=[]
    for i in y:
        if i in ABC:
            w=ABC.index(i)
            t=w+m
            while t>len(ABC)-1:
                t-=len(ABC)
            res.append(ABC[t])
        
        elif i in abc:
            q=abc.index(i)
            t=q+m
            while t>len(abc)-1:
                t-=len(abc)
            res.append(abc[t])
        else:
            res.append(i)
    return "".join(res)

def main():
    n=int(stdin.readline().strip())
    c=1
    while n!=0:
        y=stdin.readline().strip()
        m=int(stdin.readline().strip())
        print("Case"+str(c),"=",cesar(y,m))
        c+=1
        n-=1

main()
