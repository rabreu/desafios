## Formatter.java e WriteToFile.java

### Métodos

#### Construtores

##### Formatter.java

``Formatter()``\
``Formatter(String inputText, Integer limit)``

##### WriteToFile.java

``WriteToFile()``

#### Não-construtores

##### Formatter.java

``String lineLimit(String inputText, Integer limit)``\
``String lineLimit()``\
``String lineLimitBlock(String inputText, Integer limit)``\
``String lineLimitBlock()``\

##### WriteToFile.java

``void write(String text, String filename)``


### Uso
```
String unFormatedtext = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\n"
  + "\n"
  + "And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.";

Formatter format = new Formatter(unFormatedtext, 40);
WriteToFile writeToFile = new WriteToFile();

String formatedText = format.lineLimit();
writeToFile.write(formatedText, "output_parte1.txt");

formatedText = format.lineLimitBlock();
writeToFile.write(formatedText, "output_parte2.txt");
```
#### output_parte1.txt
```
In the beginning God created the heavens
and the earth. Now the earth was
formless and empty, darkness was over
the surface of the deep, and the Spirit
of God was hovering over the waters.

And God said, "Let there be light," and
there was light. God saw that the light
was good, and he separated the light
from the darkness. God called the light
"day," and the darkness he called
"night." And there was evening, and
there was morning - the first day.
```
#### output_parte2.txt
```
In the beginning God created the heavens
and  the   ear th.  Now  the  earth  was
formless  and  empty,  darkness was over
the  surface of the deep, and the Spirit
of  God  was  hovering over the waters.

And  God said, "Let there be light," and
there  was light. God saw that the light
was  good,  and  he  separated the light
from  the darkness. God called the light
"day,"  and   th e  darkness  he  called
"night."  And  there  was  evening,  and
there was morning - the first day.
```
Você também pode reutilizar uma instância do __Formatter__ que já foi utilizada:

```format.lineLimit(unFormatedtext, 40);```

ou 

```format.lineLimitBlock(unFormatedtext, 40);```

Ou também iniciar uma instância sem argumentos:

```Formatter format = new Formatter();```
