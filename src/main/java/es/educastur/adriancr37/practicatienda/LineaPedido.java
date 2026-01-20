package es.educastur.adriancr37.practicatienda;

public class LineaPedido {

    private Articulo idArticulo;
    private int unidades;

    public LineaPedido(Articulo idArticulo, int unidades) {
        this.idArticulo = idArticulo;
        this.unidades = unidades;
    }
}
