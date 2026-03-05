package es.educastur.adriancr37.practicatienda;

import java.io.Serializable;

public class LineaPedido implements Serializable {

    private Articulo articulo;
    private int unidades;

    public LineaPedido(Articulo articulo, int unidades) {
        this.articulo = articulo;
        this.unidades = unidades;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return String.format("%S x %d unidades", articulo, unidades);
    }

}
