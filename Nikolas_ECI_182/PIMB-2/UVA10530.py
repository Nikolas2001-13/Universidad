from sys import stdin

def main():
    x=int(stdin.readline().strip())
    y=(stdin.readline().strip())
    while x!=0:
        r=[]
        while y!="right on":
            r.append(x)
        print(r)
        x=int(stdin.readline().strip())
        y=(stdin.readline().strip())

main()

            
