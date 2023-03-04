package efinal2_ap_kc.repository;

import efinal2_ap_kc.repository.model.DetalleVenta;

public interface IDetalleVentaRepository {

    void insertarDetalleVenta(DetalleVenta detalleVenta);
    DetalleVenta buscarDetalleVenta(Integer id);
    void actualizarDetalleVenta(DetalleVenta detalleVenta);
    void borrarDetalleVenta(Integer id);

}
