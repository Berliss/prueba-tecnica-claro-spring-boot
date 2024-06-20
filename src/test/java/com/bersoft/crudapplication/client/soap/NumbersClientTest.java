package com.bersoft.crudapplication.client.soap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbersClientTest {

    @Test
    void numberToDollars_successfulResponse() {
        //given
        NumbersClient numbersClient = new NumbersClient();
        //when
        String value = numbersClient.numberToDollars(10.5D);
        //then
        System.out.println(value);
        assertNotNull(value);
        assertEquals(value, "ten dollars and fifty cents");
    }

    @Test
    void numberToDollars_unSuccessfulResponse() {
        //given
        NumbersClient numbersClient = new NumbersClient();
        //when
        String value = numbersClient.numberToDollars(-1D);
        //then
        System.out.println(value);
        assertNotNull(value);
        assertEquals(value, "number too large dollars and number too large cents");
    }

    @Test
    void numberToDollars_unSuccessfulResponse_throwsNullPointerException() {
        //given
        NumbersClient numbersClient = new NumbersClient();
        //when
        //then
        assertThrows(NullPointerException.class, () -> numbersClient.numberToDollars(null));
    }

}