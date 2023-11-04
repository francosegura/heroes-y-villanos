
2. Ejercicio: H�roes y Villanos
2.1. Planteo
Se desea modelar un juego compuesto por h�roes y villanos. Cada personaje del juego posee un nombre real, un nombre de superh�roe o villano y un conjunto de caracter�sticas.
Las caracter�sticas son:  velocidad, fuerza,  resistencia y destreza.
Cada una de estas posee un nivel asociado, por ejemplo, velocidad: 500, fuerza: 700, etc. 

El mecanismo b�sico del juego se basa en enfrentar un personaje con otro y decidir cu�l de ellos es el ganador. Para decidir qui�n es el ganador se utiliza el valor de una de las caracter�sticas. En caso de empate, se decide por el valor de otra caracter�stica dada (en el orden establecido, y volviendo a comenzar si fuera necesario).
Por ejemplo: Si dos contendientes decidieran competir por Fuerza, y empatan, definen por Resistencia. Si hubiera otro empate, definen por Destreza. Ante otro empate, definen por Velocidad. Si resulta en empate, ser� empate finalmente.
El orden es:
Velocidad
Fuerza
Resistencia
Destreza

A su vez, el juego debe proveer un mecanismo de agrupamiento de los personajes en ligas para realizar desaf�os o enfrentamientos entre grupos de personajes. Para esto, el valor grupal de cada caracter�stica se determina como el promedio de los valores de esa caracter�stica entre todos los personajes.

Las ligas se almacenan en un archivo de texto, y se cargan en memoria antes de un enfrentamiento. 
Los archivos tienen el siguiente formato:
personajes.in
H�roe/Villano, NombreReal, NombrePersonaje, Velocidad, Fuerza, Resistencia, Destreza
H�roe, Edward Blake, The Comedian, 100, 200, 150, 50
Villano, Adrian Veidt, Ozymandias, 120, 180, 200, 200
...

Liga �ligas.in� (archivo que contiene los personajes que la conforman. Puede contener otra Liga y Personajes sueltos)
ligas.in
Watchmen, The Comedian, Rorschach
MinuteMen, Captain Metropoli, Dollar Bill, Hollis Mason
MightPower, Watchmen, Sally Silk
...

Las Ligas son homog�neas, s�lo de H�roes o s�lo Villanos. Cada personaje s�lamente puede pertenecer a una liga (o a ninguna).

Hacer un adecuado tratamiento de excepciones al construir Personajes y Ligas.

Es posible que tambi�n un solo personaje se enfrente a un grupo, o que una liga pertenezca a una liga m�s grande.
Se debe proveer servicios que permitan obtener: 
� Todos los personajes/ligas que existen en el juego que venzan a un personaje dado para una cierta caracter�stica. 
� Decidir qui�n es el vencedor de una disputa, acorde a una caracter�stica.
public boolean esGanador(Competidor competidor, Caracteristica c){}
� Poder armar ligas de s�per h�roes o s�per villanos. 
public Liga(){
public boolean agregarCompetidor(Competidor competidor){...}
}
� Obtener listados de personajes ordenados (ascendente o descendentemente) por m�ltiples caracter�sticas. En caso de igualdad de dos personajes para una caracter�stica dada se debe permitir ordenarlos por las siguientes caracter�sticas seleccionadas. 
Por ejemplo: 
Por fuerza y luego por velocidad o por velocidad y luego por destreza.
2.2 Uso del Sistema
Todo se realizar� por medio de la consola, no se esperan interfaces gr�ficas.

Solo se enfrentan H�roes contra Villanos (o ligas de H�roes contra Ligas de Villanos)
Las Ligas son homog�neas, s�lo de H�roes o s�lo Villanos.

El men� principal deber� permitir:
Administraci�n de Personajes
Carga desde archivo
Creaci�n
Listado
Guardar en archivo todos los personajes
Administraci�n de Ligas
Carga desde archivo
Creaci�n
Listado
Guardar en archivo todas las ligas
Realizaci�n de combates
Personaje contra Liga (definiendo caracter�stica)
Liga contra Liga (definiendo caracter�stica)
Reportes
Todos los personajes o ligas que venzan a un personaje dado para cierta caracter�stica
Listado ordenado de personajes por m�ltiples caracter�sticas

2.3 Temas a investigar
Entrada/salida (buffer y scanner)
System.in
Comparable/comparator
Patrones de Dise�o
3. Qu� entregar
Para la entrega, se deber� disponer de los siguientes entregables:
Diagrama de clases actualizado (.jpg)
Pruebas unitarias del c�digo. Dichas pruebas deber�n validar significativamente los aspectos cr�ticos del programa.
El c�digo:
debidamente comentado (lease: siempre y cuando se evidencie necesario y no sea redundante ni trivial),
debidamente formateado, y
sin errores de compilaci�n.
Un main que evidencie el funcionamiento del programa.
Los suficientes archivos de entrada de prueba significativamente distintos, para poder ejecutar distintas versiones del problema. Deber�n totalizar al menos treinta personajes.
Un breve informe (.pdf) que explique:
integrantes
decisiones de dise�o (cu�les aspectos del problema consideraron relevantes para el dise�o y cu�les no,  qu� opciones de implementaci�n evaluaron, cu�l fue la alternativa elegida en cada caso, y por qu�), sin entrar en detalles de implementaci�n
descripci�n de cada archivo .java comprendido en la soluci�n del problema
organizaci�n y distribuci�n del trabajo
conclusiones
Opcionalmente, tambi�n puede agregarse cualquier otro aspecto que consideren relevante (Ej: explicar el funcionamiento general de la soluci�n para un ejemplo concreto).
