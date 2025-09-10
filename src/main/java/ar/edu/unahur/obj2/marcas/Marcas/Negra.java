package ar.edu.unahur.obj2.marcas.Marcas;

import ar.edu.unahur.obj2.marcas.GraduacionReg;

public class Negra extends Marca {
    public Negra(final Double contenidoLupulo,final String pais,final Double graduacion){
        super(contenidoLupulo, pais, graduacion);
    }
    @Override
    public Double getGraduacion() {
        if(GraduacionReg.getInstance().getNro() < this.getContenidoLupulo()*2){
            return GraduacionReg.getInstance().getNro();
        }
        else{
            return this.getContenidoLupulo();
        }
    }
   
}
