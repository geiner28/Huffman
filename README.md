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






# Grafica 
![](https://www.ime.usp.br/~pf/estruturas-de-dados/aulas/figuressw/Chapter5/HuffTinyTiny.png)









# Instalacion 
1  Guarda el código en un archivo con extensión .java, por ejemplo, HuffmanCompression.java.
( el archivo con el codigo fuente se encuentra en la carpete **SRC*)

2  Asegúrate de tener un archivo de texto llamado input.txt en el mismo directorio que el archivo .java. Este archivo será el texto de entrada que se desea comprimir y luego decodificar.

3  Compila el código Java ejecutando el siguiente comando en la terminal:

`javac HuffmanCompression.java`

4  Después de compilar sin errores, ejecuta el programa con el siguiente comando:


`java HuffmanCompression`








# como usarlo


## 1 Compilación:


- Abre una terminal o línea de comandos.
- Navega hasta el directorio donde tienes el archivo "HuffmanCompression.java".
- Ejecuta el siguiente comando para compilar el archivo Java:
  ( el archivo con el codigo fuente se encuentra en la carpete **SRC*)

`javac HuffmanCompression.java`

Si la compilación es exitosa, se generará un archivo "HuffmanCompression.class".


## 2 Ejecución:

- Asegúrate de tener un archivo de texto que deseas comprimir. Puedes crear un archivo de texto simple utilizando un editor de texto como Notepad o TextEdit.
-En la misma terminal o línea de comandos, ejecuta el siguiente comando para ejecutar el programa:

`java HuffmanCompression`

- Se mostrará el mensaje "Ingrese el nombre del archivo de texto: ".
- Ingresa el nombre del archivo de texto que deseas comprimir, incluyendo la extensión (por ejemplo, "texto.txt").
- Se mostrará el texto codificado, la tasa de compresión y el texto decodificado en la consola.
- El archivo comprimido se guardará con el nombre "compressed.bin" en el mismo directorio.
- 
## 3 Decodificación:

Si deseas decodificar el archivo comprimido, puedes utilizar el siguiente código como ejemplo:

####Java

```java
import java.io.IOException;

public class HuffmanDecompression {
    public static void main(String[] args) {
      
        String compressedFileName = "compressed.bin";
        String decompressedFileName = "decompressed.txt";

        HuffmanCompression huffman = new HuffmanCompression();
        try {
            String encodedText = HuffmanCompression.readEncodedFile(compressedFileName);
            String decodedText = huffman.decode(encodedText);
            HuffmanCompression.saveDecodedFile(decompressedFileName, decodedText);
            System.out.println("Archivo decodificado guardado como " + decompressedFileName);
          
        } catch (IOException e) {
            System.out.println("Error al decodificar el archivo: " + e.getMessage());
        }
    }
}
```

- Asegúrate de tener el archivo "compressed.bin" en el mismo directorio donde se encuentra este código.
- Ejecuta el código y se generará un archivo "decompressed.txt" que contiene el texto decodificado.







# Referencias 

`<link>` : <https://bing.com/search?q=tutoriales+de+compresi%c3%b3n+de+datos+con+Huffman>


`<link>` : <https://www.youtube.com/watch?v=85NFcU8yTSs>


`<link>` : <https://www.iiis.org/CDs2009/CD2009CSC/CISCI2009/PapersPdf/C177TX.pdf>







