package com.example.aventurasdemarcoyluis.model;
import com.example.aventurasdemarcoyluis.model.playablechar.Luis;
import com.example.aventurasdemarcoyluis.model.playablechar.Marco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {
    private AbstractPlayers marco1Test;
    private Marco marco2Test;
    private AbstractPlayers luis1Test;
    private Luis luis2Test;

    @BeforeEach
    void setUp() {
        marco1Test=new Marco(3,3,100,100,20,5);
        marco2Test=new Marco(3,3,100,100,20,5);
        luis1Test=new Luis(3,3,100,100,20,5);
        luis2Test=new Luis(3,3,100,100,20,5);
    }

    @Test
    void testConstructor(){
        assertTrue(marco1Test instanceof Marco);
        assertTrue(marco2Test instanceof Marco);
        assertTrue(marco1Test instanceof AbstractPlayers);
        assertTrue(marco2Test instanceof AbstractPlayers);
        assertTrue(luis1Test instanceof Luis);
        assertTrue(luis2Test instanceof Luis);
        assertTrue(luis1Test instanceof AbstractPlayers);
        assertTrue(luis2Test instanceof AbstractPlayers);

    }

    @Test
    void testEquals() {
        assertTrue(marco1Test.equals(marco2Test));
        assertTrue(luis1Test.equals(luis2Test));
        assertFalse(luis1Test.equals(marco1Test));
    }

    @Test
    void getHp() {
        assertEquals(100, marco1Test.getHp());
        assertEquals(100, marco2Test.getHp());
        assertEquals(100, luis1Test.getHp());
        assertEquals(100, luis2Test.getHp());
    }

    @Test
    void getAtk() {
        assertEquals(3, marco1Test.getAtk());
        assertEquals(3, marco2Test.getAtk());
        assertEquals(3, luis1Test.getAtk());
        assertEquals(3, luis2Test.getAtk());
    }

    @Test
    void getDef() {
        assertEquals(3, marco1Test.getDef());
        assertEquals(3, marco2Test.getDef());
        assertEquals(3, luis1Test.getDef());
        assertEquals(3, luis2Test.getDef());
    }

    @Test
    void getLvl() {
        assertEquals(5, marco1Test.getLvl());
        assertEquals(5, marco2Test.getLvl());
        assertEquals(5, luis1Test.getLvl());
        assertEquals(5, luis2Test.getLvl());
    }

    @Test
    void getFp() {
        assertEquals(20, marco1Test.getFp());
        assertEquals(20, marco2Test.getFp());
        assertEquals(20, luis1Test.getFp());
        assertEquals(20, luis2Test.getFp());
    }

    @Test
    void getType(){
        assertEquals(PlayerType.MARCO, marco1Test.getType());
        assertEquals(PlayerType.LUIS, luis1Test.getType());
        assertNotEquals(PlayerType.LUIS, marco1Test.getType());
    }

    @Test
    void isDeath() {
        assertTrue(!marco1Test.isDeath());
        Marco marcoDeath=new Marco(1,1,0,100,1,1);
        assertTrue(marcoDeath.isDeath());
        assertTrue(!luis1Test.isDeath());
        Luis luisDeath=new Luis(1,1,0,100,1,1);
        assertTrue(luisDeath.isDeath());

    }

    @Test
    //this is better tested in useStar
    void isInmortal() {
        assertTrue(!marco1Test.isInmortal());
    }


    @Test
    void hasEnoughFp() {
        assertTrue(!marco1Test.hasEnoughFp(21));
        assertTrue(!luis1Test.hasEnoughFp(21));
        assertTrue(marco1Test.hasEnoughFp(20));
        assertTrue(luis1Test.hasEnoughFp(20));
    }

    @Test
    void useHoneySyrup() {
        assertEquals(20, marco1Test.getFp());
        assertEquals(20, luis1Test.getFp());
        marco1Test.useHoneySyrup();
        luis1Test.useHoneySyrup();
        assertEquals(23, marco1Test.getFp());
        assertEquals(23, luis1Test.getFp());

    }

    @Test
    void useStar() {
        assertTrue(!marco1Test.isInmortal());
        assertTrue(!luis1Test.isInmortal());
        marco1Test.useStar();
        luis1Test.useStar();
        assertTrue(marco1Test.isInmortal());
        assertTrue(luis1Test.isInmortal());
    }

    @Test
    void useRedMushroom() {
        Marco marcoLowHP=new Marco(1,1,10,100,1,1);
        assertEquals(10,marcoLowHP.getHp());
        marcoLowHP.useRedMushroom();
        assertEquals(20,marcoLowHP.getHp());
    }

}