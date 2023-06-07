package hr.mi.shippingmicroservice.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entity representing a location. Contains the country, city, address and postal code of a location that can be shipped
 * or billed to.
 */
@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long locationId;

    @Column(nullable = false)
    private String country;

    @Column
    private String city;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Integer postCode;
}
