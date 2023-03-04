package efinal2_ap_kc.controller;

import efinal2_ap_kc.repository.model.DetalleVenta;
import efinal2_ap_kc.service.IDetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin()
@RequestMapping("/detalles_ventas")
    public class DetalleVentaControllerRestFul {

    @Autowired
    private IDetalleVentaService iDetalleVentaService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void insertarDetalleVenta(@RequestBody DetalleVenta detalles_venta) {
        this.iDetalleVentaService.insertarDetalleVenta(detalles_venta);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DetalleVenta buscarDetalleVenta(@PathVariable("id")  Integer id) {
        return this.iDetalleVentaService.buscarDetalleVenta(id);
    }

    @PutMapping(path ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarDetalleVenta(@PathVariable("id") Integer id, @RequestBody DetalleVenta detalles_venta) {
        detalles_venta.setId(id);
        this.iDetalleVentaService.actualizarDetalleVenta(detalles_venta);
    }

    @DeleteMapping(path ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminarDetalleVenta(@PathVariable("id") Integer id) {
        this.iDetalleVentaService.borrarDetalleVenta(id);
    }

}
