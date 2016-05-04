package com.github.uasano.codebreaker

import spock.lang.Specification
import spock.lang.Unroll


class GameSpec extends Specification {

    Game answer102

    void setup() {
        answer102 = new Game('102')
    }

    @Unroll
    def "答えに3桁以外の#answerを設定すると、IllegalArgumentExceptionが発生するべき"() {
        when:
        new Game(answer)
        then:
        thrown(IllegalArgumentException)
        where:
        answer << ['12', '1234']
    }

    def "答えにnullを設定するとIllegalArgumentExceptionが発生するべき"() {
        when:
        new Game(null)
        then:
        thrown(NullPointerException)
    }

    @Unroll
    def "答えが102の時に、#inputを入力するとcorrect#correct, hit#hitCount, blow#blowCountと判定されるべき"() {
        expect:
        Tuple result = answer102.guess(input)

        result[0] == correct
        result[1] == hitCount
        result[2] == blowCount

        where:
        input | correct | hitCount | blowCount
        '456' | false | 0 | 0
        '123' | false | 1 | 2
        '021' | false | 0 | 3
        '102' | true  | 3 | 3
    }

    @Unroll
    def "答えが102の時に、#inputを入力するとIllegalArgumentExceptionが発生するべき"() {
        when:
        answer102.guess(input)
        then:
        thrown(IllegalArgumentException)
        where:
        input << ['12', '1234']
    }

    def "答えが102の時に、nullを入力するとNullPointerExceptionが発生するべき"() {
        when:
        answer102.guess(null)
        then:
        thrown(NullPointerException)
    }

}