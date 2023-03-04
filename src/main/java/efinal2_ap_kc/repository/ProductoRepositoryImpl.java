package efinal2_ap_kc.repository;

import efinal2_ap_kc.repository.model.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void insertarProducto(Producto producto) {
        this.entityManager.persist(producto);
    }

    @Override
    public Producto buscarProducto(Integer id) {
        return this.entityManager.find(Producto.class,id);
    }

    @Override
    public void actualizarProducto(Producto producto) {
        this.entityManager.merge(producto);
    }

    @Override
    public void borrarProducto(Integer id) {
        Producto productoBorrar = this.buscarProducto(id);
        this.entityManager.remove(productoBorrar);
    }

    @Override
    public Producto buscarProductoPorCodigoBarraYCantidad(String codigoBarras, Integer cantidad) {
        //Buscar uno en especifico
        TypedQuery<Producto> miTypeQuery = this.entityManager.createQuery("select g from Producto g where g.codigoBarras =:codigoBarras",Producto.class);
        miTypeQuery.setParameter("codigoBarras", codigoBarras);
        return miTypeQuery.getSingleResult();


    }

}
