package efinal2_ap_kc.service;

import efinal2_ap_kc.repository.model.DetalleVenta;

public interface IDetalleVentaService {

    void insertarDetalleVenta(DetalleVenta detalleVenta);
    DetalleVenta buscarDetalleVenta(Integer id);
    void actualizarDetalleVenta(DetalleVenta detalleVenta);
    void borrarDetalleVenta(Integer id);


}
