package ar.edu.unahur.obj2.marcas.Personas;

import java.util.List;

import ar.edu.unahur.obj2.marcas.Carpas;
import ar.edu.unahur.obj2.marcas.Jarras;
import ar.edu.unahur.obj2.marcas.Marcas.Marca;

public class Belgas extends Personas {
    public Belgas(Double peso, Boolean escuchaMusica, List<Jarras> cantCervezas, Integer nivAguante) {
       super(peso, escuchaMusica, cantCervezas, nivAguante);
    }
    @Override
    public Boolean leGusta(Marca unaMarca) {
        return unaMarca.getContenidoLupulo() > 4;
    }
    @Override
    public Boolean adicional(Carpas unaCarpa) {
        return Boolean.TRUE;
    }    
}
