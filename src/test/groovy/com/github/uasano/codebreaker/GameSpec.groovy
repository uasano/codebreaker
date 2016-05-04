package com.github.uasano.codebreaker

import spock.lang.Specification


class GameSpec extends Specification {

    Game sut

    void setup() {
        sut = new Game('102')
    }

    def "答えが102の時に、102を入力すると正解を返すべき"() {
        expect:
        sut.correct('102') == true
    }

    def "答えが102の時に、nullを入力するとNullPointerExceptionを返すべき"() {
        when:
        sut.correct(null)
        then:
        thrown(NullPointerException)
    }
}