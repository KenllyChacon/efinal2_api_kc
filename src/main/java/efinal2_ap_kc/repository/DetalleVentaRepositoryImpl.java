package efinal2_ap_kc.repository;

import efinal2_ap_kc.repository.model.DetalleVenta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class DetalleVentaRepositoryImpl implements IDetalleVentaRepository{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void insertarDetalleVenta(DetalleVenta detalleVenta) {
        this.entityManager.persist(detalleVenta);
    }

    @Override
    public DetalleVenta buscarDetalleVenta(Integer id) {
        return this.entityManager.find(DetalleVenta.class,id);
    }

    @Override
    public void actualizarDetalleVenta(DetalleVenta detalleVenta) {
        this.entityManager.merge(detalleVenta);
    }

    @Override
    public void borrarDetalleVenta(Integer id) {
        DetalleVenta detalleVentaBorrar = this.buscarDetalleVenta(id);
        this.entityManager.remove(detalleVentaBorrar);
    }

}

