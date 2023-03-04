package efinal2_ap_kc.controller;

import efinal2_ap_kc.repository.model.Producto;
import efinal2_ap_kc.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin()
@RequestMapping("/productos")
public class ProductoControllerRestFul {

    @Autowired
    private IProductoService iProductoService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void insertarProducto(@RequestBody Producto producto) {
        this.iProductoService.insertarProducto(producto);
    }

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Producto buscarProducto(@PathVariable("id")  Integer id) {
        return this.iProductoService.buscarProducto(id);
    }

    @PutMapping(path ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarProducto(@PathVariable("id") Integer id, @RequestBody Producto producto) {
        producto.setId(id);
        this.iProductoService.actualizarProducto(producto);
    }

    @DeleteMapping(path ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminarProducto(@PathVariable("id") Integer id) {
        this.iProductoService.borrarProducto(id);
    }

    @GetMapping(path = "/{codigoBarra}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Producto buscarProductoPorCodigoBarras(@PathVariable("codigoBarra")  String codigoBarras, Integer cantidad) {
        return this.iProductoService.buscarProductoPorCodigoBarraYCantidad(codigoBarras, cantidad);
    }

}
