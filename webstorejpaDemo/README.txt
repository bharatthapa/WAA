NOTE: Have to run the populateMySQL.sql file from the MySQL dashboard....


To demonstrate local CACHE run [ see the /cache code in ProductController]:
http://localhost:8091/webstore/products/cache?P1234=pp11223344&P1235=pp112233355

The P1234 does NOT use cache as there are multiple transactions.
The P1235 uses cache as there are the ProductService method does fetch & update in a single transaction..

To demonstrate cascading run - Based on Customer entity:

http://localhost:8091/webstore/products/cascade

To demonstrate a List fetch:

http://localhost:8091/webstore/products/fetch