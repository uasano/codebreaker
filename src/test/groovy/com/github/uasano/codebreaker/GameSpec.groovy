package com.github.uasano.codebreaker

import spock.lang.Specification
import spock.lang.Unroll


class GameSpec extends Specification {

    Game answer102

    void setup() {
        answer102 = new Game('102')
    }

    def "答えに4桁の文字列を渡すとIllegalArgumentExceptionが発生するべき"() {
        when:
        new Game('1234')
        then:
        thrown(IllegalArgumentException)
    }

    def "答えが102の時に、102を入力すると正解を返すべき"() {
        expect:
        answer102.correct('102') == true
    }

    def "答えが102の時に、nullを入力するとNullPointerExceptionを返すべき"() {
        when:
        answer102.correct(null)
        then:
        thrown(NullPointerException)
    }

    @Unroll
    def "答えが102の時に、#inputを入力するとhit#hitCount, blow#blowCountと判定されるべき"() {
        expect:
        Tuple2<Integer, Integer> hint = answer102.guess(input)
        hint[0] == hitCount
        hint[1] == blowCount

        where:
        input | hitCount | blowCount
        '456' | 0 | 0
        '123' | 1 | 2
        '021' | 0 | 3
        '102' | 3 | 3
    }

    @Unroll
    def "答えが102の時に、#inputを入力するとIllegalArgumentExceptionが発生するべき"() {
        when:
        answer102.guess(input)
        then:
        thrown(IllegalArgumentException)
        where:
        input << [null, '12', '1234']
    }

}