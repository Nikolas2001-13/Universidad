import turtle

def dib_arbol(lon_rama,width,color,tortu):
  if lon_rama > 5:
    tortu.pencolor(color)
    tortu.width(width)
    tortu.forward(lon_rama)
    tortu.right(20)
    dib_arbol(lon_rama-20,width-2,color-1,tortu)
    tortu.left(40)
    dib_arbol(lon_rama-20,width-2,color-1,tortu)
    tortu.right(20)
    tortu.backward(lon_rama)

def main():
  t = turtle.Turtle()
  t.left(90)
  dib_arbol(70,10,(80,0),t)
  
main()
