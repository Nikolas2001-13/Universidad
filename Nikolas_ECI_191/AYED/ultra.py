from sys import stdin

def insertionSort(alist):
    p=0
    for index in range(1,len(alist)):
        currentvalue = alist[index]
        position = index

        while position>0 and alist[position-1]>currentvalue:
            alist[position]=alist[position-1]
            position = position-1
            p+=1

        alist[position]=currentvalue

    return p


def main():
    n=int(stdin.readline().strip())
    r=[]
    while n!=0:
        p=0
        for i in range(n):
            a=int(stdin.readline().strip())
            r.append(a)
        print(insertionSort(r))
        n=int(stdin.readline().strip())
        r=[]

main()
