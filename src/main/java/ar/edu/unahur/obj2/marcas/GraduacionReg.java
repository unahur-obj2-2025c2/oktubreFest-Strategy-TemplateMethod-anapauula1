package ar.edu.unahur.obj2.marcas;

public class GraduacionReg {
    private static GraduacionReg instance = null;
    private Double nro;

    private GraduacionReg() {}

    public static GraduacionReg getInstance() {
        if (instance == null) {
            instance = new GraduacionReg();
        }
        return instance;
    }
    public Double getNro() {
        return nro;
    }

    public void setNro(Double nro) {
        this.nro = nro;
    }
}
