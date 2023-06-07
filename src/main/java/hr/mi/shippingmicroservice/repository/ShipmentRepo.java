package hr.mi.shippingmicroservice.repository;

import hr.mi.shippingmicroservice.model.Shipment;
import hr.mi.shippingmicroservice.model.ShipmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;


@Repository("H2ShipmentRepo")
public interface ShipmentRepo extends JpaRepository<Shipment, Long> {
    Collection<Shipment> findShipmentsByStatus(ShipmentStatus status);
    Collection<Shipment> findShipmentsByCreatedAfterAndCreatedBefore(Date after, Date before);
}
