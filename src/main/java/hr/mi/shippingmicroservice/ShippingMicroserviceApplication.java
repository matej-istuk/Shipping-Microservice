package hr.mi.shippingmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Simple demo microservice for tracking information about shipments. Implements only two get requests:
 * <ul>
 * 		<li>/shipment/between - receives two parameters: after and before.
 * 		After and before are strings in the yyyy-MM-dd format. Returns a json of all shipment entities which were
 * 		created between the received dates.	</li>
 * 		<li>/shipment/pending - Returns a json of all shipment entities which have the status PENDING.</li>
 * </ul>
 */
@SpringBootApplication
public class ShippingMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShippingMicroserviceApplication.class, args);
	}

}
