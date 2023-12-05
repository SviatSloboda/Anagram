package com.foxminded.anagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class AnagramTest {
    @Test
    void getAnagram_when_null_then_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () ->
            Anagram.getAnagram(null)
        );
    }

    @Test
    void reverseLetters_when_null_then_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () ->
            Anagram.reverseLetters(null)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n","   ", "\t\t\t", "\n\n\n"})
    void getAnagram_whenEmptyOrWhiteSpaceInput_thenSameAsInput(String input) {
        // when
        String actual = Anagram.getAnagram(input);
        // then
        assertEquals(input, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n","   ", "\t\t\t", "\n\n\n"})
    void reverseLetters_whenOrEmptyOrWhiteSpaceInput_thenSameAsInput(String input) {
        // when
        String actual = Anagram.reverseLetters(input);
        // then
        assertEquals(input, actual);
    }

    @ParameterizedTest
    @CsvSource({
        "a,a",
        "aaa,aaa",
        "AaaAaaA,AaaAaaA",
        "ab,ba"
    })
    void reverseLetters_when_letterParameters_then_letterParameters(String expected, String actual) {
        //when
        actual = Anagram.reverseLetters(actual);
        //then
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
        "a,a",
        "aaa,aaa",
        "AaaAaaA,AaaAaaA",
        "ab,ba",
        "a a a,a a a",
        "a  a  a,a  a  a"
    })
    void getAnagram_when_letterParameters_then_letterParameters(String expected, String actual) {
        //when
        actual = Anagram.getAnagram(actual);
        //then
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"000b00a, 000a00b",
        "dcba, abcd",
        "efgh, hgfe",
        "q!w!e!r!t!y,y!t!r!e!w!q"
    })
    void reverseLetters_when_oneComplexWord_then_oneComplexWord(String expectedString, String actual) {
        //when
        actual = Anagram.reverseLetters(actual);
        //then
        assertEquals(expectedString, actual);
    }

    @ParameterizedTest
    @CsvSource({"dcba hgfe, abcd efgh",
        "d1cba hgf!e, a1bcd efg!h",
        " olleh  olleh , hello  hello "
    })
    void getAnagram_when_twoWords_then_twoWords(String expectedString, String actual) {
        //when
        actual = Anagram.getAnagram(actual);
        //then
        assertEquals(expectedString, actual);
    }
}
