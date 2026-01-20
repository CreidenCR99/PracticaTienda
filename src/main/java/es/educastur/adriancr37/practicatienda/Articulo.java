package es.educastur.adriancr37.practicatienda;

public class Articulo {

    private String idArticulo;
    private String description;
    private int existencias;
    private double pvp;

    public Articulo(String description, int existencias, String idArticulo, double pvp) {
        this.description = description;
        this.existencias = existencias;
        this.idArticulo = idArticulo;
        this.pvp = pvp;
    }

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public double getPvp() {
        return pvp;
    }

    public void setPvp(double pvp) {
        this.pvp = pvp;
    }

    @Override
    public String toString() {
        return "Articulo [idArticulo=" + idArticulo + ", description=" + description + ", existencias=" + existencias
                + ", pvp=" + pvp + "]";
    }
}
