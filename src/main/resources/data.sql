INSERT INTO LOCATION (POST_CODE, LOCATION_ID, ADDRESS, CITY, COUNTRY) VALUES
                    ( 10000, 1, 'Ulica 12', 'Zagreb', 'Croatia' );

INSERT INTO ITEM (ITEM_ID) VALUES ( 1 ), ( 2 ), ( 3 ), ( 4 );

INSERT INTO SHIPMENT (CREATED, DELIVERY_ESTIMATE, STATUS, BILLING_ADDRESS_LOCATION_ID, CUSTOMER_ID, DELIVERY_ADDRESS_LOCATION_ID, SHIPMENT_ID) VALUES
                    ( DATE '2022-12-31', DATE '2023-1-3', 7, 1, 1, 1, 1 ),
                    ( DATE '2023-1-4', DATE '2023-1-10', 0, 1, 2, 1, 2 ),
                    ( DATE '2023-1-5', DATE '2023-1-15', 0, 1, 3, 1, 3 );

INSERT INTO SHIPMENT_ITEMS (ITEMS_ITEM_ID, SHIPMENT_SHIPMENT_ID) VALUES
                   ( 1, 1 ),
                   ( 2, 2 ),
                   ( 3, 3 ),
                   ( 4, 3 );