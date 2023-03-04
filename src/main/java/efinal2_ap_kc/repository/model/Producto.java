package efinal2_ap_kc.repository.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_producto_id")
    @SequenceGenerator(name= "seq_producto_id", sequenceName = "seq_producto_id", allocationSize = 1)
    @Column(name = "produ_id")
    private Integer id;
    @Column(name = "produ_codigo_barras")
    private String codigoBarras;
    @Column(name = "produ_nombre")
    private String nombre;
    @Column(name = "produ_categoria")
    private String categoria;
    @Column(name = "produ_stock")
    private Integer stock;
    @Column(name = "produ_precio_unitario")
    private BigDecimal precioUnitario;

    @ManyToOne
    @JoinColumn(name = "produ_id_venta")
    private DetalleVenta detalleVenta;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public DetalleVenta getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(DetalleVenta detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
