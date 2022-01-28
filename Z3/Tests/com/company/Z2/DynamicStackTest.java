package com.company.Z2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicStackTest {
    DynamicStack<Integer> stosDynamiczny;

    @BeforeEach
    public void SetUp() {
        stosDynamiczny = new DynamicStack<>(4);
    }

    @Test
    public void IsGrowing() {
        assertEquals(0, stosDynamiczny.size());

        stosDynamiczny.push(1);
        stosDynamiczny.push(2);
        assertEquals(2, stosDynamiczny.size());
        assertEquals(4, stosDynamiczny.MaxSize());

        stosDynamiczny.push(3);
        assertEquals(3, stosDynamiczny.size());
        assertEquals(8, stosDynamiczny.MaxSize());

        stosDynamiczny.push(4);
        assertEquals(4, stosDynamiczny.size());

        stosDynamiczny.push(5);
        assertEquals(5, stosDynamiczny.size());
    }

    @Test
    public void IsDecreasing() {
        stosDynamiczny.push(1);
        stosDynamiczny.push(2);
        stosDynamiczny.push(3);
        stosDynamiczny.push(4);
        stosDynamiczny.push(5);
        stosDynamiczny.push(6);
        stosDynamiczny.push(7);
        stosDynamiczny.push(8);
        stosDynamiczny.push(9);
        stosDynamiczny.push(10);
        stosDynamiczny.push(11);
        stosDynamiczny.push(12);

        assertEquals(32, stosDynamiczny.MaxSize());

        try {
            stosDynamiczny.pop();
            stosDynamiczny.pop();
            stosDynamiczny.pop();
            stosDynamiczny.pop();

            assertEquals(16, stosDynamiczny.MaxSize());

            stosDynamiczny.pop();
            stosDynamiczny.pop();
            stosDynamiczny.pop();
            stosDynamiczny.pop();

            assertEquals(8, stosDynamiczny.MaxSize());

            stosDynamiczny.pop();
            assertEquals(8, stosDynamiczny.MaxSize());


        } catch (EmptyStackException emptyStackError) {
            emptyStackError.printStackTrace();
        }

    }

}