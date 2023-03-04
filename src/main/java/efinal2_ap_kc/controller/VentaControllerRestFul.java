package efinal2_ap_kc.controller;

import efinal2_ap_kc.repository.model.Venta;
import efinal2_ap_kc.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@CrossOrigin()
@RequestMapping("/ventas")
public class VentaControllerRestFul {

    @Autowired
    private IVentaService iVentaService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void insertarVenta(@RequestBody Venta venta) {
        this.iVentaService.insertarVenta(venta);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Venta buscarVenta(@PathVariable("id")  Integer id) {
        return this.iVentaService.buscarVenta(id);
    }

    @PutMapping(path ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarVenta(@PathVariable("id") Integer id, @RequestBody Venta venta) {
        venta.setId(id);
        this.iVentaService.actualizarVenta(venta);
    }

    @DeleteMapping(path ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminarVenta(@PathVariable("id") Integer id) {
        this.iVentaService.borrarVenta(id);
    }

}
