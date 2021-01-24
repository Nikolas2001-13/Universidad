from sys import stdin

A= (stdin.readline().strip())
B= (stdin.readline().strip())
C= (stdin.readline().strip())
D= (stdin.readline().strip())
E= (stdin.readline().strip())

if A=="1" and B=="1" and C=="0" and D=="1" and E=="1":
      print("Recorrido Valido")
elif  A=="1" and B=="0" and C=="1" and D=="1" and E=="1":
      print("Recorrido Valido")
elif A!=1 or D!=1 or E!=1:
      print("Recorrido No Valido")
elif B==C:
      print("Recorrido No Valido")
else:
      print("Valor Leido No Valido")
