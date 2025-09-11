package ar.edu.unahur.obj2.marcas.Personas;

import java.util.List;

import ar.edu.unahur.obj2.marcas.Carpas;
import ar.edu.unahur.obj2.marcas.Jarras;
import ar.edu.unahur.obj2.marcas.Marcas.Marca;

public class Alemanes extends Personas {
    public Alemanes(Double peso, Boolean escuchaMusica, List<Jarras> cantCervezas, Integer nivAguante,String pais){
        super(peso, escuchaMusica, nivAguante,pais);
    }
    @Override
    public Boolean leGusta(Marca unaMarca) {
        return Boolean.TRUE;
    }
    @Override
    public Boolean adicional(Carpas unaCarpa) {
        return unaCarpa.getCantPersonas().size() > 0 ;
    }
}
