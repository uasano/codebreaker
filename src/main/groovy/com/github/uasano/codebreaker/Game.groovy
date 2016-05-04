package com.github.uasano.codebreaker

class Game {

    private String answer

    Game(String answer) {
        if (answer.length() != 3) {
            throw new IllegalArgumentException('answer must be 3 characters.')
        }
        this.answer = answer
    }

    boolean correct(String answer) {
        if (answer == null) {
            throw new NullPointerException('answer is null.')
        }
        this.answer == answer
    }
}
