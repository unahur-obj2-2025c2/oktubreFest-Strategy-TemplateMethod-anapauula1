package ar.edu.unahur.obj2.marcas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.marcas.Marcas.Negra;
import ar.edu.unahur.obj2.marcas.Marcas.Roja;
import ar.edu.unahur.obj2.marcas.Personas.Alemanes;

public class MarcaTest {
    @Test
    void contenidoDelAlcholDeUnaJarra() {
        GraduacionReg.getInstance().setNro(14.0);
        Negra cervezaNegra = new Negra(3.2, "Arg", 7.20);
        Roja cervezaRoja = new Roja(3.2, "Arg", 0.08);
        Jarras jarraUno = new Jarras(0.5, cervezaRoja);
        // preguntamos sobre la graduacion que se saca con la condicion en el get
        assertEquals(cervezaNegra.getGraduacion(), 6.4);
        // la graduacion de la roja que seria la grad de negra * 1,25 que da 8.0
        assertEquals(cervezaRoja.getGraduacion(), 8.0);
        // sacamos el contenido de alchol que es 8.0 / 100 para el porcentaje * el contenido
        assertEquals(jarraUno.contenidoAlchol(cervezaRoja),0.04);
    }
    
    @Test
    void testSobreLaPersona() {
        Alemanes unAleman = new Alemanes(75.0, Boolean.TRUE, null, 12);
        Jarras primera = new Jarras(0.5, null);
        Jarras segunda = new Jarras(0.20, null);
        Negra negra1 = new Negra(5.0, "Arg", 8.0);
        unAleman.agregarJarra(primera); // agrego la primera jarra ahora agrego otra
        unAleman.agregarJarra(segunda);
        // utilizamos el metodo para suma del alchol que deberia de ser 0.7
        assertEquals(unAleman.cantAlcholIngerido(), 0.7);
        // saber si esta ebrio o no que en este caso es verdadero
        assertTrue(unAleman.estaEbria());
        // saber si le gusta una marca determinada de cerveza
        assertTrue(unAleman.leGusta(negra1));
        // a los alemanes le gustan todos los tipos
    }
}
