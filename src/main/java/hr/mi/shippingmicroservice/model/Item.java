package hr.mi.shippingmicroservice.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Placeholder entity for ordered item contained in shipments.
 */
@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long itemId;

}
