from sys import stdin

def happy(r,a,n):
    h=["Happy","birthday","to","you","Happy","birthday","to","you","Happy","birthday","to","Rujia","Happy","birthday","to","you"]
    for k in r:
        for j in range(len(h)):
            for i in r:
                while n>len(h)-1:
                    n-=len(h)
                print(str(i)+":",h[a])
                a+=1




def main():
    n=int(stdin.readline().strip())
    a=0
    r=[]
    while n!=0:
        x=stdin.readline().strip()
        r.append(x)
        n-=1
    happy(r,a,n)

main()
        
