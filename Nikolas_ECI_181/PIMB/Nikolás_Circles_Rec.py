import turtle

def dib_circles(tortuga,longitud,width):
    if longitud > 0:
        tortuga.width(width)
        tortuga.circle(longitud,360)
        dib_circles(tortuga,longitud-20,width-5)
        

def main():
    tt = turtle.Turtle()
    dib_circles(tt,80,10)
    

main()
