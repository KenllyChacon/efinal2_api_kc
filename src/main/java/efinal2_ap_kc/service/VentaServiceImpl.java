package efinal2_ap_kc.service;

import efinal2_ap_kc.repository.IVentaRepository;
import efinal2_ap_kc.repository.model.DetalleVenta;
import efinal2_ap_kc.repository.model.Producto;
import efinal2_ap_kc.repository.model.Venta;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaServiceImpl implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepository;


    @Transactional
    @Override
    public void insertarVenta(Venta venta) {
        List<Producto> productosParaVenta = new ArrayList<>();
        DetalleVenta detalleVenta = new DetalleVenta();
        for (Producto producto : venta.getProductos()) {
            Producto productoEnAlmacen = ventaRepository.buscarVenta(producto.getId());
            if (detalleVenta.getCantidad()) -detalleVenta.getCantidad() >= 0){
                detalleVenta.setCantidad(detalleVenta.getCantidad() - detalleVenta.getCantidad());
                productosParaVenta.add(productosParaVenta);
            }
            this.ventaRepository.insertarVenta(venta);
        }
    }

    List<Producto> productosParaVenta = new ArrayList<>();
        for (Producto producto : venta.getProductos()) {
            Producto productoEnAlmacen = productoRepository.findByCodBar(producto.getCodBar());
            if (productoEnAlmacen.getCantidad() - producto.getCantidad() >= 0) {
                productoEnAlmacen.setCantidad(productoEnAlmacen.getCantidad() - producto.getCantidad());
                productosParaVenta.add(productoEnAlmacen);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            @Override
            public Venta buscarVenta (Integer id){
                return this.ventaRepository.buscarVenta(id);
            }

            @Override
            public void actualizarVenta (Venta venta){
                this.ventaRepository.actualizarVenta(venta);
            }

            @Override
            public void borrarVenta (Integer id){
                this.ventaRepository.borrarVenta(id);
            }
        }
}