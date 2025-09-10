package ar.edu.unahur.obj2.marcas;

import ar.edu.unahur.obj2.marcas.Marcas.Marca;

public class Jarras {
    private Double capacidadLitros;
    private Marca marca;

    public Double getCapacidadLitros() {
        return capacidadLitros;
    }
    public void setCapacidadLitros(Double capacidadLitros) {
        this.capacidadLitros = capacidadLitros;
    }
    public Marca getMarca() {
        return marca;
    }
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    public Jarras(Double capacidadLitros, Marca marca) {
        this.capacidadLitros = capacidadLitros;
        this.marca = marca;
    }
}
