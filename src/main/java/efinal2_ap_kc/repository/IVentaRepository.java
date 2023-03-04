package efinal2_ap_kc.repository;

import efinal2_ap_kc.repository.model.Venta;

public interface IVentaRepository {
    void insertarVenta(Venta venta);
    Venta buscarVenta(Integer id);
    void actualizarVenta(Venta venta);
    void borrarVenta(Integer id);
}
