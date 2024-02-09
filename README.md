# Clases Sealed JAVA 17


## ¿Que son las clases sealed?

En java la jerarquía de clases puede volverse compleja al existir numerosas clases que pueden extender  de super clases comunes llevando a situaciones complejas como modificaciones o nuevas features que podrían traer errores o situaciones inesperadas en la ejecución de nuestros procesos derivados de una mala jerarquía de clases.

Las clases sealed fueron propuestas en la versión 15 de java (*JEP360*) como preview, nuevamente propuestas con algunas mejoras en la versión 16 de java (*JEP397*) y siendo introducidas finalmente como parte de la versión 17 de java (*JEP 409*).

Las clases o interfaces que contienen la palabra reservada “*sealed*” limitan solo aquellas clases explícitamente expuestas a través del modificador “*permits*” para que estas puedan heredar/implementar de nuestra clase sealed, brindando de esta manera una forma de controlar, gestionar y limitar el comportamiento de nuestras sub clases.


## ¿Como se usan?

Para poder definir una clase o interface como “*sealed*” es necesario especificar 2 palabras reservadas “*sealed*” y “*permits*”.

***sealed*** nos permite definir que la clase o interfaz en cuestión sera utilizada como “*sealed*”.

***permits*** nos permite definir que clases podrán heredar de una clase y/o implementar una interface marcada como "*sealed*".

```
public abstract sealed class Felino permits Gato, Leon, Tigre, Puma { ... }
```

Para poder heredar o implementar una clase sealed es necesario agregar la palabra reservada final para no romper con las limitación de clases ya que el objetivo es limitar la herencia aumentando la accesibilidad de las clases y no su extensibilidad (en el apartado de reglas se verán los modificadores necesarios que deben ser utilizados por las sub clases).

```
public final class Gato extends Felino { ... }
public final class Tigre extends Felino { ... }
public final class Leon extends Felino { ... }
public final class Puma extends Felino { ... }
```

Para el caso de las interfaces quedarían definidas e implementadas de la siguiente manera.

```
public sealed interface Canino permits Perro, Lobo, Coyote, Zorro { ... }
public final class Perro implements Canino { ... }
public final class Lobo implements Canino { ... }
public final class Coyote implements Canino { ... }
public final class Zorro implements Canino { ... }
```

Las clases “*record*” agregadas en la versión 15 de java (*JEP384*) están marcadas implícitamente como “*final*” y pueden ser utilizados de la siguiente manera.

```
public sealed interface Ave permits Buitre, Aguila, Cuervo, Paloma { ... }
public record Buitre() implements Ave { ... }
public record Aguila() implements Ave { ... }
public record Cuervo() implements Ave { ... }
public record Paloma() implements Ave { ... }
```

## Reglas de las clases sealed

Las clases sealed imponen 3 reglas para poder definir las sub clases:
* Las clases sealed y sus sub clases deben pertenecer al mismo modulo y si están declarados en un modulo sin nombre, deben pertenecer el mismo paquete.
* Cada sub clase permitida debe heredar de la clase sealed.
* Cada sub clase permitida debe usar un modificador que describa como se propagara ese candado definido por su super clase.
  * Declarar la sub clase como final para impedir que esta pueda extender a otras clases.
  * Declarar la sub clase como clase sealed y especificar cuales serán sus sub clases.
  * Declarar la sub clase como non-sealed rompiendo como tal el candado impuesto por la super clase permitiendo que la sub clase se convierta en super clase sin control alguno.


## Conclusión

Las clases sealed no son una alternativa a utilizar “*final*” para bloquear la herencia de ciertas clases que nos interesan sin embargo es una gran agregado dentro del lenguaje programación java que nos permiten de una manera mas sensilla tomar el control y gestionar cuales clases pueden ser derivadas de otras limitando la herencia, ampliando la accesibilidad de dichas clases y mejorando la lectura y entendimiento del código al especificar cuales son las clases que tienen permitido heredar de nuestras clases sealed.

## Video explicativo

https://valtechcom-my.sharepoint.com/:v:/r/personal/luis_rubio_valtech_com/Documents/sealed%20classes.mp4?csf=1&web=1&e=YAWyLu

## Referencias

https://openjdk.org/jeps/409

https://rollbar.com/blog/what-are-sealed-classes-in-java/

https://blog.adamgamboa.dev/understanding-sealed-classes-in-java-17/


