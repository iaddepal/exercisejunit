package com.company;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main obj = new Main();

    @BeforeEach
    public void initeach(){
        ByteArrayInputStream in = new ByteArrayInputStream("John\n35".getBytes());
        System.setIn(in);
    }

    @Test
    void Exception(){
        ByteArrayInputStream in = new ByteArrayInputStream("John\n35".getBytes());
        System.setIn(in);

        PrintStream standardOut = System.out;

        ByteArrayOutputStream captor = new ByteArrayOutputStream();

        System.setOut(new PrintStream(captor));

        obj.AcceptData();

        assertTrue(new String(captor.toByteArray()).contains("You didn't enter a valid number."));

        System.setOut(standardOut);
    }

    @org.junit.jupiter.api.Test
    void acceptData(){
        obj.AcceptData();
        assertEquals("John",obj.getName());
        assertEquals(35,obj.getHours());
    }


    @org.junit.jupiter.api.Test
    void computeWage()
    {
        obj.AcceptData();
        obj.ComputeWage();

        assertEquals(525,obj.getGtotal());

    }

    @org.junit.jupiter.api.Test
    void display(){
        obj.AcceptData();
        obj.ComputeWage();

        PrintStream standardOut = System.out;

        ByteArrayOutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        obj.Display();

        assertEquals("The total wage of john is 525.0",captor.toString().trim());

        System.setOut(standardOut);


    }


}