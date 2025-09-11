package ar.edu.unahur.obj2.marcas.Marcas;

public abstract class Marca {
   private Double contenidoLupulo;
   private String pais;
   /*
    es una variable porque por ejemplo dice
    que cada graduacion de cerveza rubia es distinta
    */
   private Double graduacion;
   public Marca(Double contenidoLupulo, String pais, Double graduacion) {
      this.contenidoLupulo = contenidoLupulo;
      this.pais = pais;
      this.graduacion = graduacion;
   }
   public Double getContenidoLupulo() {
    return contenidoLupulo;
   }
   public void setContenidoLupulo(Double contenidoLupulo) {
    this.contenidoLupulo = contenidoLupulo;
   }
   public String getPais() {
    return pais;
   }
   public void setPais(String pais) {
    this.pais = pais;
   }
   public Double getGraduacion() {
    return graduacion;
   }
   public void setGraduacion(Double graduacion) {
    this.graduacion = graduacion;
   }
}
