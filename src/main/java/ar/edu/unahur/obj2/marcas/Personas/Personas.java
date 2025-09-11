package ar.edu.unahur.obj2.marcas.Personas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.marcas.Carpas;
import ar.edu.unahur.obj2.marcas.Jarras;
import ar.edu.unahur.obj2.marcas.Marcas.Marca;

public abstract class Personas {
    private Double peso;
    private Boolean escuchaMusica;
    List<Jarras> cantCervezas = new ArrayList<>();
    private Integer nivAguante;
    private String pais;

    
    public Personas(Double peso, Boolean escuchaMusica, List<Jarras> cantCervezas, Integer nivAguante, String pais) {
        this.peso = peso;
        this.escuchaMusica = escuchaMusica;
        this.cantCervezas = cantCervezas;
        this.nivAguante = nivAguante;
        this.pais = pais;
    }
    public Personas(Double peso, Boolean escuchaMusica, Integer nivAguante, String pais) {
        this.peso = peso;
        this.escuchaMusica = escuchaMusica;
        this.nivAguante = nivAguante;
        this.pais = pais;
    }
    public Double getPeso() {
        return peso;
    }
    public Boolean getEscuchaMusica() {
        return escuchaMusica;
    }
    public Integer getNivAguante() {
        return nivAguante;
    }
    public List<Jarras> getCantCervezas() {
        return cantCervezas;
    }
    public void agregarJarra(Jarras unaJarra){
        cantCervezas.add(unaJarra);
    }
    public Boolean estaEbria(){
        return (cantAlcholIngerido() * this.peso) > this.nivAguante;
    }
    public Double cantAlcholIngerido(){
        return cantCervezas.stream().mapToDouble(j->j.getCapacidadLitros()).sum();
    }
    public abstract Boolean leGusta(Marca unaMarca);

    public Boolean quiereEntrarAUnaCarpa(Carpas unaCarpa){
        return this.leGusta(unaCarpa.getMarcaDeCervezaVendida()) && this.escuchaMusica && unaCarpa.getTieneBanda() && adicional(unaCarpa);
    }
    public abstract Boolean adicional(Carpas unaCarpa);

    public Boolean puedeEntrarAlaCarpa(Carpas unaCarpa){
        return quiereEntrarAUnaCarpa(unaCarpa) && unaCarpa.dejaIngresarALaPersona(this);
    }
    public Boolean esPatriota(Marca unMarca){
        return cantCervezas.stream().allMatch(j -> j.getMarca().getPais().equals(this.pais));
    }
}
