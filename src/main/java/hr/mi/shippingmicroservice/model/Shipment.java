package hr.mi.shippingmicroservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Date;

/**
 * Entity representing a shipment. Tracks information about the id of the customer that ordered it, items within itself,
 * status, delivery and billing addresses and the dates of creation and estimated delivery.
 */
@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long shipmentId;

    @Column(nullable = false)
    private Long customerId;

    @OneToMany
    private Collection<Item> items;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private ShipmentStatus status;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Location deliveryAddress;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Location billingAddress;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date created;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date deliveryEstimate;
}
