package ar.edu.unahur.obj2.marcas.Marcas;

public class Roja extends Negra{
    public Roja(Double contenidoLupulo,String pais,Double graduacion){
        super(contenidoLupulo, pais, graduacion);
    }
    @Override
    public Double getGraduacion() {
        // Super para que nos devuelva el resultado
        // del metodo en la cerveza negra
        return super.getGraduacion() * 1.25;
    }
    
}
