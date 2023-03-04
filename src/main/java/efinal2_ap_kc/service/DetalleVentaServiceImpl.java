package efinal2_ap_kc.service;

import efinal2_ap_kc.repository.IDetalleVentaRepository;
import efinal2_ap_kc.repository.model.DetalleVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleVentaServiceImpl implements IDetalleVentaService{

    @Autowired
    private IDetalleVentaRepository detalleVentaRepository;


    @Override
    public void insertarDetalleVenta(DetalleVenta detalleVenta) {
        this.detalleVentaRepository.insertarDetalleVenta(detalleVenta);
    }

    @Override
    public DetalleVenta buscarDetalleVenta(Integer id) {
        return this.detalleVentaRepository.buscarDetalleVenta(id);
    }

    @Override
    public void actualizarDetalleVenta(DetalleVenta detalleVenta) {
        this.detalleVentaRepository.actualizarDetalleVenta(detalleVenta);
    }

    @Override
    public void borrarDetalleVenta(Integer id) {
        this.detalleVentaRepository.borrarDetalleVenta(id);
    }
}
