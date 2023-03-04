package efinal2_ap_kc.repository.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_venta_id")
    @SequenceGenerator(name= "seq_venta_id", sequenceName = "seq_venta_id", allocationSize = 1)
    @Column(name ="vent_id")
    private Integer id;
    @Column(name ="vent_numero_venta")
    private String numeroVenta;
    @Column(name ="vent_cedula_cliente")
    private String cedulaCliente;
    @Column(name ="vent_detalle_venta")
    private String detalleVenta;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetalleVenta> detalleVentas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroVenta() {
        return numeroVenta;
    }

    public void setNumeroVenta(String numeroVenta) {
        this.numeroVenta = numeroVenta;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(String detalleVenta) {
        this.detalleVenta = detalleVenta;
    }
}
