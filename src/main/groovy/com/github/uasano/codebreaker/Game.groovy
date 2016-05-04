package com.github.uasano.codebreaker

class Game {

    private String answer

    Game(String answer) {
        if (answer.length() != 3) {
            throw new IllegalArgumentException('answer must be 3 characters.')
        }
        this.answer = answer
    }

    private correct(String answer) {
        this.answer == answer
    }

    private int countHit(String answer) {
        int hit = 0
        answer.toCharArray().eachWithIndex { char c, int index ->
            if (this.answer.charAt(index) == c) {
                hit++
            }
        }
        return hit
    }

    private int countBlow(String answer) {
        int blow = 0

        answer.toCharArray().each { char c ->
            if (this.answer.contains(String.valueOf(c))) {
                blow++
            }
        }
        blow
    }

    Tuple guess(String answer) {
        if (answer == null || answer.length() != this.answer.length()) {
            throw new IllegalArgumentException("answer must be ${this.answer.length()} characters.")
        }
        Tuple result = new Tuple(
                correct(answer), countHit(answer), countBlow(answer))
        result
    }
}
