package efinal2_ap_kc.service;

import efinal2_ap_kc.repository.model.Venta;

public interface IVentaService {

    void insertarVenta(Venta venta);
    Venta buscarVenta(Integer id);
    void actualizarVenta(Venta venta);
    void borrarVenta(Integer id);

}
