package efinal2_ap_kc.repository;

import efinal2_ap_kc.repository.model.Venta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class VentaRepositoryImpl implements IVentaRepository{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void insertarVenta(Venta venta) {
        this.entityManager.persist(venta);
    }

    @Override
    public Venta buscarVenta(Integer id) {
        return this.entityManager.find(Venta.class,id);
    }

    @Override
    public void actualizarVenta(Venta venta) {
        this.entityManager.merge(venta);
    }

    @Override
    public void borrarVenta(Integer id) {
        Venta ventaBorrar = this.buscarVenta(id);
        this.entityManager.remove(ventaBorrar);
    }

}

