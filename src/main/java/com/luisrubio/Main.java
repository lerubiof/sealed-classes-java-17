package com.luisrubio;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

sealed class Felino permits Gato, Tigre {

    public String maullar() {
        return "miau";
    }
}

final class Gato extends Felino {

}

sealed class Tigre extends Felino permits Leon {

}

non-sealed class Leon extends Tigre {

}

class Puma extends Leon {

}

sealed interface Canino permits Perro, Lobo {

}

final class Perro implements Canino {

}

record Lobo() implements Canino {

}

