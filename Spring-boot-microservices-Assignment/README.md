Assignment Overview: Create three microservices:

1. Create Eureka Server using spring boot running on port number 87612. 
2. User Service: Manages user data stored in MySQL running on port number 91913.
3. Product Service: Manages product data stored in MongoDB running on port number 92924. 
4. Order Service: Manages order data stored in H2 running on port number 9393.
5. API gate way : Responsible to provide route all 3 micro service running on port number 8080.

The microservices will communicate with each other using RESTful APIs. For instance, the Order 
Service will need to fetch user and product details from the User and Product Services respectively.

User Service (MySQL):
• Database: MySQL
• Entity: User with fields id, username, email, createdAt.
• API Endpoints:
o GET /users/{id}: Get user details by ID.
o POST /users: Create a new user.
o GET /users: List all users.
• Database Interaction: Spring Data JPA

Product Service (MongoDB):
• Database: MongoDB
• Entity: Product with fields id, name, description, price, createdAt.
• API Endpoints:
o GET /products/{id}: Get product details by ID.
o POST /products: Create a new product.
o GET /products: List all products.
• Database Interaction: Spring Data MongoDB

Order Service (H2):
• Database: H2 (in-memory)
• Entity: Order with fields id, userId, productId, quantity, orderDate.
• API Endpoints:
o GET /orders/{id}: Get order details by ID.
o POST /orders: Create a new order. Oid auto increment or you can pass 
manually, username, product name, orderdate(system date).
o GET /orders: List all orders.
• Database Interaction: Spring Data JPA

Microservice Communication:
1. Order Service → User Service:
o When creating or placing an order, the Order Service will call the User Service to 
validate the user by fetching user details. Passing user id get the user name. You 
need to use RestTemplate with load balance features to get user name. if we pass 
wrong user id then don’t place the order return the message as user not exits. 
2. Order Service → Product Service:
o Similarly, the Order Service will call the Product Service to fetch product details 
before placing an order. Passing product id to get product details. This service need 
to use Feign Client concept to call Product Service . if product not present don’t 
place the order.


Implement Service and Controller Layers:
• Implement CRUD operations in each service.
• Expose REST endpoints through controllers.
Set Up Inter-Service Communication:
• Use RestTemplate and Feign client in the Order Service to call User and Product services.
