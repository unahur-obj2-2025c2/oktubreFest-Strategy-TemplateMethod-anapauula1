package ar.edu.unahur.obj2.marcas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.marcas.Marcas.Negra;
import ar.edu.unahur.obj2.marcas.Marcas.Roja;
import ar.edu.unahur.obj2.marcas.Marcas.Rubia;
import ar.edu.unahur.obj2.marcas.Personas.Alemanes;
import ar.edu.unahur.obj2.marcas.Personas.Belgas;

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
        Alemanes unAleman = new Alemanes(75.0, Boolean.TRUE, null, 12,"Alemania");
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
    /*
     ---------- Requerimientos segunda parte ----------------
     */
    @Test
    void saberSiQuiereEntrarAUnaCarpaUnaPersona() {
        Alemanes alemanDos = new Alemanes(72.0, Boolean.TRUE, null, 10,"Alemania");
        Rubia cervezaRubia = new Rubia(5.2, "Arg", 5.0);
        Carpas primerCarpa = new Carpas(20, Boolean.FALSE, cervezaRubia);
        // la carpa solo vende el tipo de cerveza rubia
        // saber si al la persona le gusta entrar a la carpa que dara falso
        assertFalse(alemanDos.quiereEntrarAUnaCarpa(primerCarpa));
        // si la carpa deja pasar al aleman 
        assertTrue(primerCarpa.dejaIngresarALaPersona(alemanDos));
        // si puede entrar la persona a la carpa debe tener los dos metodos
        assertFalse(alemanDos.puedeEntrarAlaCarpa(primerCarpa));
        // falso porque el no quiere entrar
        // el aleman no lo deja entrar entonces verificamos que se
        // cometio un error en este caso
        assertThrows(RuntimeException.class,()-> primerCarpa.entrarACarpa(alemanDos));
    }
    @Test
    void servirJarraAUnaPersonEliminandoLaMisma() {
        Belgas primerBelga = new Belgas(50.0, Boolean.TRUE, null, 5,"Belgica");
        Rubia cervezaRubia2 = new Rubia(5.2, "Arg", 5.0);
        Carpas segundaCarpa = new Carpas(30, Boolean.FALSE, cervezaRubia2);
        Jarras segundaJarra = new Jarras(0.5, cervezaRubia2);
        
        segundaCarpa.agregarJarra(segundaJarra);
        assertEquals(segundaCarpa.getJarrasAVender().size(), 1); // 1 elemento
        /*
         si probamos servir la jarra nos dara error entonces 
         nos fijamos si se largo el error porque la persona no esta en la carpa
         */
        assertThrows(RuntimeException.class,()-> segundaCarpa.servirJarra(primerBelga));
    }
    
}
