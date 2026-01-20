package es.educastur.adriancr37.practicatienda;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
    private String idPedido;
    private Cliente clientePedido;
    private LocalDate fechaPedido;
    private ArrayList<LineaPedido> cestaCompra;

    public Pedido(ArrayList<LineaPedido> cestaCompra, Cliente clientePedido, LocalDate fechaPedido, String idPedido) {
        this.cestaCompra = cestaCompra;
        this.clientePedido = clientePedido;
        this.fechaPedido = fechaPedido;
        this.idPedido = idPedido;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getClientePedido() {
        return clientePedido;
    }

    public void setClientePedido(Cliente clientePedido) {
        this.clientePedido = clientePedido;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public ArrayList<LineaPedido> getCestaCompra() {
        return cestaCompra;
    }

    public void setCestaCompra(ArrayList<LineaPedido> cestaCompra) {
        this.cestaCompra = cestaCompra;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido{");
        sb.append("idPedido=").append(idPedido);
        sb.append(", clientePedido=").append(clientePedido);
        sb.append(", fechaPedido=").append(fechaPedido);
        sb.append(", cestaCompra=").append(cestaCompra);
        sb.append('}');
        return sb.toString();
    }
}
