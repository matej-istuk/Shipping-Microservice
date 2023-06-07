package hr.mi.shippingmicroservice.model;

public enum ShipmentStatus {
    PENDING,
    PRE_TRANSIT,
    IN_TRANSIT,
    OUT_FOR_DELIVERY,
    FAILED_ATTEMPT,
    WAITING_FOR_DELIVERY,
    DELIVERED,
    PICKUP_READY,
    RETURNED,
    EXCEPTION,
    FAILURE,
    EXPIRED
}
