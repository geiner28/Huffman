# Resumen 


Este código es un ejemplo de compresión de datos sin pérdida usando el algoritmo de Huffman. El algoritmo de Huffman asigna códigos de longitud variable a los caracteres de entrada, basándose en la frecuencia de ocurrencia de cada símbolo en el archivo que se comprime. Los símbolos más frecuentes reciben los códigos más cortos y los menos frecuentes reciben los códigos más largos



`HuffmanNode`: Una clase que representa un nodo en el árbol de Huffman. Cada nodo tiene un valor (frecuencia o suma de frecuencias en el caso de los nodos internos) y puede tener un carácter asociado en el caso de los nodos hoja.

`ImplementComparator`: Una clase que implementa la interfaz Comparator para comparar los nodos de Huffman según sus valores. Esto se utiliza para construir la cola de prioridad en la que se basa el algoritmo de Huffman.

`Huffman`: La clase principal que contiene el método main y la lógica principal del algoritmo de Huffman.

`printCode`: Un método que imprime el código de Huffman para cada carácter en el árbol.

`encode`: Un método que recibe un texto y el nodo raíz del árbol de Huffman y devuelve el texto codificado utilizando el árbol de Huffman.

`getCharCode y getCharCodeHelper`: Métodos auxiliares utilizados para obtener el código de Huffman para un carácter dado.

`decode`: Un método que recibe un texto codificado y el nodo raíz del árbol de Huffman y devuelve el texto decodificado utilizando el árbol de Huffman.

El código en el método main crea el árbol de Huffman a partir de los caracteres y frecuencias dados. Luego, imprime el código de Huffman para cada carácter en el árbol. Posteriormente, solicita al usuario que ingrese un texto para codificarlo y muestra el texto codificado. Luego, solicita al usuario que ingrese el texto codificado para decodificarlo y muestra el texto decodificado.

`saveEncodedFile`: Un método adicional que se agrega para guardar el texto codificado en un archivo binario. Toma el nombre del archivo y el texto codificado como parámetros, y guarda el texto codificado en el archivo en forma de bytes.
Este proyecto se enfoca en la implementación básica del algoritmo de compresión Huffman y proporciona funciones para codificar y decodificar texto. También se ha agregado una función adicional saveEncodedFile para guardar el texto codificado en un archivo binario.




## Grafica 
![](https://www.ime.usp.br/~pf/estruturas-de-dados/aulas/figuressw/Chapter5/HuffTinyTiny.png)




## Instalacion 
1  Guarda el código en un archivo con extensión .java, por ejemplo, HuffmanCompression.java.

2  Asegúrate de tener un archivo de texto llamado input.txt en el mismo directorio que el archivo .java. Este archivo será el texto de entrada que se desea comprimir y luego decodificar.

3  Compila el código Java ejecutando el siguiente comando en la terminal:

`javac HuffmanCompression.java`

4  Después de compilar sin errores, ejecuta el programa con el siguiente comando:


`java HuffmanCompression`


