#Formula cuadratica
print("Asignar numeros correctos para resolver la formula")

a=float(input("Asignar primer numero a:"))
b=float(input("Asignar segundo numero b:"))
c=float(input("Asignar tercer numero c:"))

print("Respuesta con +:",(-b+((b**2)-4*a*c)**(1/2))/(2*a))

print("Respuesta con +:",(-b-((b**2)-4*a*c)**(1/2))/(2*a))
