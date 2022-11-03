# crea un diccionario llamado huespedes con 3 claves (keys)
huespedes={101:'Juan Valdes', 105:'Paquita la del Barrio', 202: 'Mariana Pajon'}

# imprime el diccionario llamado huespedes
print (huespedes)

# imprime cada par de clave-valor (key-value)
print (huespedes.items())

#imprime las 3 claves del diccionario
print (huespedes.keys())

# imprime solamente las claves (keys) de huespedes (diccionario)
for key in huespedes:
    print (key)
  
# imprime los valores (values) de huespedes
print (huespedes.values())

# imprime solamente los valores de huespedes
for key in huespedes:
    print (huespedes[key])
print()

# nombra las claves como "habitación" e immprime estas con su respectivo valor
for habitacion in huespedes:
    print (habitacion,':',huespedes[habitacion])
print()

# imprime las 3 claves pero todas con el ultimo valor (key) "Mariana Pajon"
for habitacion,huesped in huespedes.items():
    print (habitacion,':',huespedes[key])

# ennumera e imprime cada par de clave- valor
for indice, key in enumerate(huespedes):
    print (indice+1,key,huespedes[key])
print()

# imprime el valor de la clave nombrada "105"
print (huespedes[105])

# imrpime el valor de la clave nombrada "105" (el metodo get devuelve el valor de la clave, ya que este se encuentra en el diccionario de huespedes)
print (huespedes.get(105))

# imprime los signos dentro de las comillas creando un espacio
print ('====================================')

# añade un elemento al diccionario con indice (clave) "102"
huespedes[102]='Fanny Lu'

# añade un segundo elemento al diccionario con indice (clave) "107"
huespedes[107]='Don Omar'

# inserta la clave "109" con su respectivo valor "Luis Miguel"
huespedes.setdefault('109','Luis Miguel')

# imprime la clave 202 y entre parentesis imprime cada par clave-valor que se encontraba en el diciconario más los pares nuevos agregados
for huesped in huespedes.items():
    print (habitacion,':',huesped)
print()

# crea un nuevo diccionario llamado registroshoy con 2 claves e inserta estos nuevos elementos en el diccionario anterior de huespedes
registroshoy={201:'Vicente Fernandez',301:'Pepe Guardiola'}
huespedes.update(registroshoy)

# imprime cada par de valor-clave con sus nuevos elementos
for habitacion, huesped in huespedes.items():
    print (habitacion,':',huesped)
print()

# imprime los signos dentro de las comillas creando un espacio
print ('====================================')

# cambia el valor de la clave 107 
huespedes[107]='Ricky Martin'

# imprime el diccionario con el nuevo valor de la clave 107 y los demás pares de clave-valor agregados
print (huespedes)

# imprime los signos dentro de las comillas creando un espacio
print ('====================================')

# elimina la clave 102 
del huespedes[102]

# elimina y retorna la clave 202
huespedes.pop(202)

# imprime el diccionario
print(huespedes)

# imprime los signos dentro de las comillas creando un espacio
print ('====================================')

# crea e imprime una copia del ya existente diccionario
copia1=huespedes.copy()
print ('copia1: ',copia1)

# crea e imprime una segunda copia del ya existente diccionario
copia2={}
copia2.update(huespedes)
print ("copia2: ",copia2)

#imprime los signos dentro de las comillas creando un espacio
print ('====================================')

# crea una lista con 4 elementos
lista=[2,5,7,1]

# crea e imprime un nuevo diccionario donde los elementos de la lista son claves (keys) y las "xxx" sus correspondientes valores
diccio=dict.fromkeys(lista,"xxx")
print(diccio)

#imprime los signos dentro de las comillas creando un espacio
print ('====================================')

# crea un diccionario llamado inventario con 4 claves y sus respectivos valores "plata", "cartera", "mecato" y "días"
inventario={"plata": (500,2500), 'cartera' : ["Cedula","Moneda","Boletas"],'mecato':'Detodito','dias':1}

# imprime el diccionario "inventario"
print (inventario)

# accede a los datos del elemento "cartera" del diccionario y muta la lista con el metodo sort () e imprime el diccionario
inventario ['cartera'].sort()
print(inventario)

# elimina el valor moneda de la clave cartera e imprime el diciconario con la modificación 
inventario['cartera'].remove("Moneda")
print(inventario)

# imprime el indice 0 (500) de la clave pkata
print(inventario.get("plata")[0])
