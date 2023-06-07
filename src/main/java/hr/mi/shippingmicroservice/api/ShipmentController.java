package hr.mi.shippingmicroservice.api;

import hr.mi.shippingmicroservice.model.Shipment;
import hr.mi.shippingmicroservice.model.ShipmentStatus;
import hr.mi.shippingmicroservice.service.ShipmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * Rest controller for shipment related requests. Handles /shipment/pending and /shipment/between get requests.
 */
@RestController
@RequestMapping(path = "shipment")
@AllArgsConstructor
public class ShipmentController {

    private ShipmentService shipmentService;

    /**
     * Returns all shipments which have the status PENDING.
     * @return <code>List</code> of shipments which have the status PENDING.
     */
    @GetMapping("pending")
    @ResponseBody
    public List<Shipment> getAllPending() {
        return shipmentService.getShipmentsByStatus(ShipmentStatus.PENDING);
    }

    /**
     * Returns all shipments which have been created between the received dates. Accepts strings in yyyy-MM-dd format.
     * @param after <code>String</code> representing date after which the shipment must've been created
     * @param before <code>String</code> representing date before which the shipment must've been created
     * @return <code>List</code> of shipments which have been created between the received dates
     * @throws IllegalArgumentException if the received arguments are in a wrong format
     */
    @GetMapping("between")
    @ResponseBody
    public List<Shipment> getAllBetween(@RequestParam(name = "after") String after, @RequestParam(name = "before") String before) throws IllegalArgumentException {
        return shipmentService.getShipmentsBetween(after, before);
    }

    /**
     * Handles the <code>IllegalArgumentException</code> for this controller.
     */
    @ResponseStatus(value= HttpStatus.BAD_REQUEST,
            reason="Bad date format.")  // 409
    @ExceptionHandler({ IllegalArgumentException.class })
    public void handleException() {

    }
}
