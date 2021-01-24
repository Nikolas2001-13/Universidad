from sys import stdin

def idi(n):
    if n=="HELLO":
        return "ENGLISH"
    elif n=="HOLA":
        return "SPANISH"
    elif n=="HALLO":
        return "GERMAN"
    elif n=="BONJOUR":
        return "FRENCH"
    elif n=="CIAO":
        return "ITALIAN"
    elif n=="ZDRAVSTVUJTE":
        return "RUSSIAN"
    else:
        return "UNKNOWN"
    

def main():
    n=stdin.readline().strip()
    a=1
    while n!="#":
        print("Case "+str(a)+":",idi(n))
        a+=1
        n=stdin.readline().strip()

main()
        
