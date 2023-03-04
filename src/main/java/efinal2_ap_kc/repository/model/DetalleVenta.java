package efinal2_ap_kc.repository.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_deve_id")
    @SequenceGenerator(name= "seq_deve_id", sequenceName = "seq_deve_id", allocationSize = 1)
    @Column(name="deve_id")
    private Integer id;
    @Column(name="deve_cantidad")
    private Integer cantidad;
    @Column(name="deve_precio_unitario")
    private BigDecimal precioUnitario;
    @Column(name="deve_subtotal")
    private BigDecimal subtotal;

    @OneToMany(mappedBy = "detalleVenta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Producto> productos;

    @ManyToOne
    @JoinColumn(name = "deve_id_venta")
    private Venta venta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
