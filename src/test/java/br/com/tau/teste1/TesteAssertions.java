package br.com.tau.teste1;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class TesteAssertions {

    @Test
    void firstAssertEquals(){
        assertEquals("String 1", "String 1", "Os valores não são iguais. Verifique se" +
                " os parâmetros de entrada estão corretos");
    }

    @Test
    void secondAssertEquals(){
        List<String> expectedValues = Arrays.asList("StringUm","StringDois", "StringTres");
        List<String> actualValues = Arrays.asList("StringUm", "StringDois", "StringTres");

        assertEquals(expectedValues,actualValues);
    }

    @Test
    void thirdAssertEquals(){
        int[] expectedInt = {1,2,3};
        int[] actualInt = {1,2,3};
        assertArrayEquals(expectedInt,actualInt);
    }

    @Test
    void fourthAssertEquals(){
        assertTrue(true, "Asserção resultou em falso");
    }

    @Test
    void fifthAssertEquals(){
        assertThrows(NullPointerException.class, null);
    }

    @Test
    void sixthAssertEquals(){
        int[] expectedInt = {1,2,3};
        int[] actualInt = {1,2,3};
        Assertions.assertAll(
                () -> assertEquals("String 1", "String 1", "Os valores não são iguais. Verifique se" +
                        " os parâmetros de entrada estão corretos"),
                () ->  assertTrue(true, "Asserção resultou em falso"),
                () -> assertArrayEquals(expectedInt,actualInt, "Os elementos dos arrays não são iguais")
        );
    }

    @Test
    void seventhAssertEquals(){
        Map<String, Integer> keyValues = new HashMap<>();
        keyValues.put("StringUm", 1);
        keyValues.put("StringDois", 2);
        keyValues.put("StringTres", 3);

        assertThat(keyValues, Matchers.hasKey("StringUm"));
        assertThat(keyValues, Matchers.hasValue(2));
    }

    @Test
    void eighthAssertEquals(){
        List<Integer> myList = Arrays.asList(1,2,3,4,5);
        assertThat(myList,Matchers.hasItem(1));
    }

    @Test
    void ninthAssertEquals(){
        List<String> myList = Arrays.asList("String um", "Strign dois", "String tres");
        assertThat(myList,Matchers.anyOf(Matchers.hasItem("String um"),Matchers.hasItem("String dois"),
                Matchers.hasItem("String tres")));
    }

    @Test
    void tenthAssertEquals(){
        List<String> myList = Arrays.asList("Um", "Dois", "Tres");
        assertThat(myList, Matchers.containsInAnyOrder("Um", "Tres", "Dois"));
    }
}
