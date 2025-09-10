package ar.edu.unahur.obj2.marcas.Personas;

import java.util.List;

import ar.edu.unahur.obj2.marcas.Jarras;
import ar.edu.unahur.obj2.marcas.Marcas.Marca;

public class Checos extends Personas {
    public Checos(Double peso, Boolean escuchaMusica, List<Jarras> cantCervezas, Integer nivAguante){
        super(peso, escuchaMusica, nivAguante);
    }
    @Override
    public Boolean leGusta(Marca unaMarca) {
        return unaMarca.getGraduacion() > 8;
    }
    
}
