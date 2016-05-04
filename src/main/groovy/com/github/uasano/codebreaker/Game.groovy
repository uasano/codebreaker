package com.github.uasano.codebreaker

class Game {

    private String answer

    Game(String answer) {
        this.answer = answer
    }

    boolean correct(String answer) {
        this.answer == answer
    }
}
