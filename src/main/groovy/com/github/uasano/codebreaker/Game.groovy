package com.github.uasano.codebreaker

class Game {

    private String answer

    Game(String answer) {
        this.answer = answer
    }

    boolean correct(String answer) {
        if (answer == null) {
            throw new NullPointerException('answer is null.')
        }
        this.answer == answer
    }
}
