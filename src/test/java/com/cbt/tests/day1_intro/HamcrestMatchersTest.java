package com.cbt.tests.day1_intro;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {
    @Test
    public void test(){
        String one = "abc";
        String two = "abc";
        String three = "        abc";

        assertThat(one,equalTo(two));
        assertThat(one,equalToCompressingWhiteSpace(three));

        //equalTo == is
        assertThat(one, is(two));
        //one is not equal three same as assertNotEquals in testNG
        assertThat(one, is(not(three)));
        assertThat(one,not(three));

        //numbers
        assertThat(1,is(1));
        assertThat(1,lessThan(2));
        assertThat(1,lessThanOrEqualTo(2));
        assertThat(1,greaterThan(0));


        //LIST
        ArrayList<String> emptyList = new ArrayList<>();
        assertThat(emptyList,empty());

        List<String> words = Arrays.asList("Larry", "Moe", "Curly");
        assertThat(words,hasSize(3));
        assertThat(words, hasItem("Curly"));
        assertThat(words, contains("Larry", "Moe", "Curly"));
        //assertThat(words, contains("Moe", "Curly"));// this will fail. Contains here acts like equal
        assertThat(words, containsInAnyOrder("Moe", "Larry", "Curly"));


    }
}
