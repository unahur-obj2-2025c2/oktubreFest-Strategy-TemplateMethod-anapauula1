package ar.edu.unahur.obj2.marcas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.marcas.Marcas.Marca;
import ar.edu.unahur.obj2.marcas.Personas.Personas;

public class Carpas {
    private Integer limitePersonas;
    private Boolean tieneBanda;
    private List<Jarras> jarrasAVender = new ArrayList<>();
    private List<Personas> cantPersonas = new ArrayList<>();
    private Marca marcaDeCervezaVendida;
    
    public Carpas(Integer limitePersonas, Boolean tieneBanda, List<Jarras> jarrasAVender, List<Personas> cantPersonas,
            Marca marcaDeCervezaVendida) {
        this.limitePersonas = limitePersonas;
        this.tieneBanda = tieneBanda;
        this.jarrasAVender = jarrasAVender;
        this.cantPersonas = cantPersonas;
        this.marcaDeCervezaVendida = marcaDeCervezaVendida;
    }
    public Carpas(Integer limitePersonas, Boolean tieneBanda, Marca marcaDeCervezaVendida) {
        this.limitePersonas = limitePersonas;
        this.tieneBanda = tieneBanda;
        this.marcaDeCervezaVendida = marcaDeCervezaVendida;
    }
    public List<Personas> getCantPersonas() {
        return cantPersonas;
    }
    public void agregarPersona(Personas unaPersona){
        cantPersonas.add(unaPersona);
    }
    public Marca getMarcaDeCervezaVendida() {
        return marcaDeCervezaVendida;
    }
    public void setMarcaDeCervezaVendida(Marca marcaDeCervezaVendida) {
        this.marcaDeCervezaVendida = marcaDeCervezaVendida;
    }
    public Integer getLimitePersonas() {
        return limitePersonas;
    }
    public void setLimitePersonas(Integer limitePersonas) {
        this.limitePersonas = limitePersonas;
    }
    public Boolean getTieneBanda() {
        return tieneBanda;
    }
    public void setTieneBanda(Boolean tieneBanda) {
        this.tieneBanda = tieneBanda;
    }
    public List<Jarras> getJarrasAVender() {
        return jarrasAVender;
    }
    public void agregarJarra(Jarras unJarras){
        if(this.marcaDeCervezaVendida == unJarras.getMarca()){
            jarrasAVender.add(unJarras);
        }
        else{
            throw new RuntimeException("La marca de cerveza no es la aceptada");
        }
    }
    public Boolean dejaIngresarALaPersona(Personas unaPersona){
        return (cantPersonas.size() < this.limitePersonas) && !(unaPersona.estaEbria());
    }
    public void entrarACarpa(Personas unaPersona){
        if(unaPersona.puedeEntrarAlaCarpa(this)){
            cantPersonas.add(unaPersona);
        }
        else{
            throw new RuntimeException("No puede entrar");
        }
    }
    public void servirJarra(Personas unaPersona){
        Jarras jarra1 = new Jarras(2.5, marcaDeCervezaVendida);
        if(cantPersonas.contains(unaPersona)){
            unaPersona.agregarJarra(jarra1);
            jarrasAVender.remove(jarra1);
        }
        else{
            throw new RuntimeException("La persona no esta en la carpa");
        }
    }
}
