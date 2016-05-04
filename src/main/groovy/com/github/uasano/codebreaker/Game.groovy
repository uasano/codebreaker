package com.github.uasano.codebreaker

class Game {

    private String answer

    Game(String answer) {
        if (answer.length() != 3) {
            throw new IllegalArgumentException('answer must be 3 characters.')
        }
        if (hasDuplicateChar(answer)) {
            throw new IllegalArgumentException('answer can\'t use same characters.')
        }
        if (hasNonNumericChar(answer)) {
            throw new IllegalArgumentException('answer can\'t use non numeric characters.')
        }
        this.answer = answer
    }

    private boolean hasNonNumericChar(String answer) {
        return !answer.matches('[0-9]{3}')
    }

    private boolean hasDuplicateChar(String answer) {
        Set<Character> set = new HashSet<>()

        answer.toCharArray().collect {c ->
            set.add(c)
        }.find{ it ->
            !it
        } != null
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
        answer.toCharArray().collect{ char c ->
            this.answer.contains(String.valueOf(c))
        }.findAll{it}.size()
    }

    Tuple guess(String answer) {
        if (answer == null) {
            throw new NullPointerException('answer can\'t allow null')
        }
        if (answer.length() != this.answer.length())  {
            throw new IllegalArgumentException("answer must be ${this.answer.length()} characters.")
        }
        Tuple result = new Tuple(
                correct(answer), countHit(answer), countBlow(answer))
        result
    }
}
