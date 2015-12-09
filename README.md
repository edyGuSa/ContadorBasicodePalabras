# ContadorBasicodePalabras

Este programa analiza un archivo de texto plano (.txt) y crea un reporte que consiste en un conteo de palabras en el
archivo (.txt)

Tecnologias
  * Sistema operativo :     Ubuntu 15.04
  * Entorno de desarrollo:  Eclipse Java Mars

Modo de uso
  * Descargar el contenido del repositorio
  * Descomprimir el archivo
  * Una vez el archivo este descomprimido podemos compilarlo desde consola de la siguinte forma:
  
   *~/Descargas/ContadorBasicodePalabras-master$ javac Counter.java

Ejemplo de una corrida

Una vez el el programa principal (Counter.java) ha sido compilado se crea un archivo (.class)
ahora ya podemos hacer uso del programa en consola de la siguinte forma:


~/Descargas/ContadorBasicodePalabras-master$ java Counter data.txt stopwords.txt

El primer parametro data.txt es de prueba y aquí usted le podra proporcionar el archivo que usted quiera

como resultado se podran ver estadísticas como 
 * 10 palabras mas comunes
 * total de palabras con auxiliares y 
 * total de palabras sin auxiliraes
 * además de una notificacion de que se ha generado un reporte

Notas
 * En  el archivo que se ha descomprimido se adjuntan el archivo data.txt y stopwords.txt
 * Para que el programa funcione es necesario proporcionar como segundo parametro el stopwords.txt
 * El reporte generado se encuentra en lacarpeta donde se alojen los .class
 * Solo funciona con archivos .txt
