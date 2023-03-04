package efinal2_ap_kc.service;

import efinal2_ap_kc.repository.IProductoRepository;
import efinal2_ap_kc.repository.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoRepository productoRepository;


    @Override
    public void insertarProducto(Producto producto) {
        if (producto != null) {
            producto.setStock(producto.getStock() + producto.getStock());
            this.sumarStock(producto.getStock(), producto.getStock());
            this.productoRepository.insertarProducto(producto);
        }
    }

    public void sumarStock(int nuevoStock, int stockExistente){
        int nuevoTotal = nuevoStock + stockExistente;
        stockExistente = nuevoTotal;
    }

    @Override
    public Producto buscarProducto(Integer id) {
        return this.productoRepository.buscarProducto(id);
    }

    @Override
    public void actualizarProducto(Producto producto) {
        this.productoRepository.actualizarProducto(producto);
    }

    @Override
    public void borrarProducto(Integer id) {
        this.productoRepository.borrarProducto(id);
    }

    @Override
    public Producto buscarProductoPorCodigoBarraYCantidad(String codigoBarras, Integer cantidad) {
        Producto producto = this.productoRepository.buscarProductoPorCodigoBarraYCantidad(codigoBarras, cantidad);
        if (cantidad <= producto.getStock()) {
            //Permite agregar producto a lista
            this.productoRepository.insertarProducto(producto);
        } else {
            System.out.println("Stock no disponible");
        }
        return producto;
    }



}
