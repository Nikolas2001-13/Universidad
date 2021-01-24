from sys import stdin

a=(stdin.readline().strip())
b=(stdin.readline().strip())

def conversion():
    if a=="1":
        gr=float(b)*500
        print(gr,"gr")
    elif a=="-1":
        lb=float(b)/500
        print(lb,"lb")
    elif a=="2":
        cm=float(b)*100
        print(cm,"cm")
    elif a=="-2":
        mt=float(b)/100
        print(mt,"mt")
    elif a=="3":
        mi=float(b)*0.62
        print(mi,"mi")
    elif a=="-3":
        km=float(b)/0.62
        print(km,"km")
        
conversion()
