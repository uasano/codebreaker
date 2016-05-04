package com.github.uasano.codebreaker

import spock.lang.Specification


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

    def "答えが102の時に、456を入力するとHit0と判定されるべき"() {
        expect:
        answer102.countHit('456') == 0
    }

    def "答えが102の時に、123を入力するとHit1と判定されるべき"() {
        expect:
        answer102.countHit('123') == 1
    }
}