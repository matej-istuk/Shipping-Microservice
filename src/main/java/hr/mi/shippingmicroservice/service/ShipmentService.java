package hr.mi.shippingmicroservice.service;

import hr.mi.shippingmicroservice.model.Shipment;
import hr.mi.shippingmicroservice.model.ShipmentStatus;
import hr.mi.shippingmicroservice.repository.ShipmentRepo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Service class which executes the logic for shipment related requests.
 */
@Service
public class ShipmentService {
    private final ShipmentRepo shipmentRepo;

    public ShipmentService(@Qualifier("H2ShipmentRepo") ShipmentRepo shipmentRepo) {
        this.shipmentRepo = shipmentRepo;
    }

    /**
     * Returns a list of all shipments with the matching status.
     * @param status <code>ShipmentStatus</code>
     * @return <code>List</code> of shipments with the matching status
     */
    public List<Shipment> getShipmentsByStatus(ShipmentStatus status) {
        return new ArrayList<>(shipmentRepo.findShipmentsByStatus(status));
    }

    /**
     * Returns a list of shipments which have been created between the received dates.
     * Accepts strings in yyyy-MM-dd format
     * @param strAfter <code>String</code> in yyyy-MM-dd format. Represents the date after which the shipments have to
     *      *                  be created.
     * @param strBefore <code>String</code> in yyyy-MM-dd format. Represents the date before which the shipments have to
     *                  be created.
     * @return <code>List</code> of shipments between the received dates
     * @throws IllegalArgumentException if the received arguments are in a wrong format
     */
    public List<Shipment> getShipmentsBetween(String strAfter, String strBefore) throws IllegalArgumentException {
        Date after;
        Date before;
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            after = dateFormat.parse(strAfter);
            before = dateFormat.parse(strBefore);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
        return new ArrayList<>(shipmentRepo.findShipmentsByCreatedAfterAndCreatedBefore(after, before));
    }
}
