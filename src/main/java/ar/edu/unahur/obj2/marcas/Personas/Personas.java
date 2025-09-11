package ar.edu.unahur.obj2.marcas.Personas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.marcas.Jarras;
import ar.edu.unahur.obj2.marcas.Marcas.Marca;

public abstract class Personas {

    public Double peso;
    public Boolean escuchaMusica;
    List<Jarras> cantCervezas = new ArrayList<>();
    public Integer nivAguante;

    public Personas(Double peso, Boolean escuchaMusica, List<Jarras> cantCervezas, Integer nivAguante) {
        this.peso = peso;
        this.escuchaMusica = escuchaMusica;
        this.cantCervezas = cantCervezas;
        this.nivAguante = nivAguante;
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
    public Personas(Double peso, Boolean escuchaMusica, Integer nivAguante) {
        this.peso = peso;
        this.escuchaMusica = escuchaMusica;
        this.nivAguante = nivAguante;
    }
    public Boolean estaEbria(){
        return (cantAlcholIngerido() * this.peso) > this.nivAguante;
    }
    public Double cantAlcholIngerido(){
        return cantCervezas.stream().mapToDouble(j->j.getCapacidadLitros()).sum();
    }
    public abstract Boolean leGusta(Marca unaMarca);
}
