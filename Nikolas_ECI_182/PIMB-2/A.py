from sys import stdin

def chat(r):
    y=len(r)
    if y%2==0:
        print("CHAT WITH HER!")
    else:
        print("IGNORE HIM!")

def main():
    x=stdin.readline().strip()
    r=[]
    for i in x:
        if i not in r:
            r.append(i)
    chat(r)

main()

            
        
