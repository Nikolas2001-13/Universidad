from sys import stdin

def GIF(a,b):
    g=a*b*8
    gif=g/5
    return gif
def JPEG(a,b):
    j=a*b*24
    jpeg=j/25
    return jpeg
def PNG(a,b):
    p=a*b*24
    png=p/8
    return png
def TIFF(a,b):
    tiff=a*b*48
    return tiff
def main():
    x=(stdin.readline().strip())
    a,b,n=x.split()
    a=int(a)
    b=int(b)
    n=float(n)*1000000000
    print (float("{0:.2f}".format(n/GIF(a,b))),"images in GIF format can be stored")
    print (float("{0:.2f}".format(n/JPEG(a,b))),"images in JPEG format can be stored")
    print (float("{0:.2f}".format(n/PNG(a,b))),"images in PNG format can be stored")
    print (float("{0:.2f}".format(n/TIFF(a,b))),"images in TIFF format can be stored")

main()
    
