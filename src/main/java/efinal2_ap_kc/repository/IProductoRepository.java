package efinal2_ap_kc.repository;

import efinal2_ap_kc.repository.model.Producto;

public interface IProductoRepository {

    void insertarProducto(Producto producto);
    Producto buscarProducto(Integer id);
    void actualizarProducto(Producto producto);
    void borrarProducto(Integer id);

    Producto buscarProductoPorCodigoBarraYCantidad(String codigoBarras, Integer cantidad);
}
