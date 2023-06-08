# Shipping-Microservice

A simple demo microservice for tracking information about shipments. Implements only two get requests:

- /shipment/between - receives two parameters: after and before. After and before are strings in the yyyy-MM-dd format. Returns a json of all shipment entities that were created between the received dates.
- /shipment/pending - returns a json of all shipment entities whthatich have the status PENDING.


