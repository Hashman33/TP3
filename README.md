[![Build Status](https://travis-ci.org/Hashman33/TP2.svg?branch=master)](https://travis-ci.org/Hashman33/TP2)
# TP2 - AlgoCraft

Grupo #13 - Turno Noche

ESTADO DEL TP:
	
	Implementado y testeado:
	- Herramientas se crean correctamente dependiendo de su tipo y material.
	- Los materiales se desgastan de manera correcta dependiendo de la herramienta (DOUBLE DISPACH).
	- Las herramientas se desgastan correctamente.
	- Jugador se crea correctamente con un Hacha de Madera equipada.
	- Se implementó un Mapa (singleton) que está compuesta por una Matriz compuesta por Celdas que admiten un Material o Jugador.
	- El Mapa se inicia con Materiales dentro del mismo insertados manualmente.
	- El Jugador puede insertarse en el Mapa en el Origen (0,0) o en una posición dada.
	- El Jugador puede moverese libremente en el mapa mientras la celda a ocupar este vacía.
	- El Jugador posee un inventario de materiales y herramientas, puede incorporar y remover elementos del mismo.
	- Clase MesaDeTrabajo para la creación de herramientas.
    - El jugador puede obtener materiales del mapa correctamente y sus herramientas se rompen con el uso.
    - El Jugador crea sus propias herramientas con sus materiales y la mesa de trabajo.
	- Clase MapaRandom, genera un mapa con materiles aleatoriamente distrbuidos.
	- Clase Juego con el inicio del juego.
    - Interfaz grafica: Menu Inicio.

    En implementación:
    - Interfaz gráfica Juego.
	
	
SUPUESTOS:

	- El pico fino puede desgastar cualquier material menos la madera (solo el diamante desgasta el pico fino).
	- El material se obtiene en el momento que se su durabilidad llega a 0.
	- La herramienta se rompe en el intento de uso posterior al llegar a durabilidad 0 y aparece la mano 
	  equipada(este "uso" no desgasta material).
	- Si el jugador quita de su inventario la herramienta que está equipando, se le equipa la mano.



PARA AGREGAR JAVAFX12:
	
	Con JDK12, ya no tenemos incluido JavaFx en su release. Por eso tenemos que descargarlo aparte, e incluirlo 
	como una librería cualquiera.
	
	- Descargar JavaFx 12.0.1 de https://gluonhq.com/products/javafx/ (ver que sea la 12.0.1 que está más abajo).
	- Haciendo update encontraremos un HolaMundo.java en el paquete algocraft.graficos. Es un 
	fragmento de código para probar que funcione correctamente la librería, aunque puede usar cualquiera
	para probarlo.
	- Para IntelliJ: es posible que lance una excepción al correrlo, para ello debemos ir a la 
	pestaña Run -> Edit Configurations y en la entrada que dice "VM Options" pegar lo siguiente:
	
	--module-path C:\Libs\javafx-sdk-12.0.1\lib --add-modules javafx.controls,javafx.fxml
	
	(Reemplazar C:\Libs\javafx-sdk-12.0.1\lib por tu ruta a JavaFx)
	
	Aplicar y aceptar, debería andar ok. Más info en https://openjfx.io/openjfx-docs/


	
