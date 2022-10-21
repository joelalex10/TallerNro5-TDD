package edu.ucb.prueba;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class AscensorTest {
    private Ascensor ascensor;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void before(){
        //Preparacion de la prueba
        ascensor = new Ascensor();
    }

    @Test
    public void moverAscensor() throws Exception{
        assertEquals(2,ascensor.moverAscensor());
        assertEquals(3,ascensor.moverAscensor());
        assertEquals(2,ascensor.moverAscensor());
        assertEquals(1,ascensor.moverAscensor());
    }
    @Test
    public void crearPersona(){
        ascensor.crearPersona();
        ascensor.crearPersona();
        ascensor.crearPersona();
    }

    @Test
    public void controlAscensor(){
        assertEquals("Piso 1",ascensor.seleccionarPiso(1));
        assertEquals("Piso 3",ascensor.seleccionarPiso(3));
        assertEquals("Piso 2",ascensor.seleccionarPiso(2));


    }

}
