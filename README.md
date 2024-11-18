# Online Grocery Order Management System

## Overview
This is a RESTful API service built with Spring Boot for managing an online grocery ordering system. The system supports CRUD operations for customers, grocery items, and orders, focusing on maintaining records and providing essential functionality.

## Features
- **Customer Management**: Create, read, update, and delete customer information.
- **Grocery Item Management**: Manage grocery items, including categories, prices, and stock quantities.
- **Order Management**: Handle orders, including assigning customers, managing multiple grocery items per order, calculating total prices, and tracking order dates.

## Entities
1. **Customer**  
   - Fields: `Name`, `Email`, `Address`, `Phone`
   - One customer can place multiple orders.

2. **Grocery Item**  
   - Fields: `Name`, `Category`, `Price`, `Quantity`
   - A grocery item can be included in multiple orders.

3. **Order**  
   - Fields: `Customer`, `Grocery Item(s)`, `Order Date`, `Total Price`
   - An order can contain multiple grocery items.

## Requirements
1. **CRUD Operations**  
   - Implemented for all entities: Customer, Grocery Item, and Order.

2. **Error Handling**  
   - Appropriate HTTP response codes (e.g., `404` for "Not Found").

3. **Testing (Optional)**  
   - Unit tests for critical functionalities using JUnit and Mockito.

## Endpoints
### Customer Management
- `POST /api/customers` - Create a new customer.  
- `GET /api/customers/{id}` - Retrieve a customer by ID.  
- `GET /api/customers` - Retrieve all customers.  
- `PUT /api/customers/{id}` - Update customer details.  
- `DELETE /api/customers/{id}` - Delete a customer.  

### Grocery Item Management
- `POST /api/grocery-items` - Add a new grocery item.  
- `GET /api/grocery-items/{id}` - Retrieve a grocery item by ID.  
- `GET /api/grocery-items` - Retrieve all grocery items.  
- `PUT /api/grocery-items/{id}` - Update grocery item details.  
- `DELETE /api/grocery-items/{id}` - Delete a grocery item.  

### Order Management
- `POST /api/orders` - Create a new order.  
- `GET /api/orders/{id}` - Retrieve an order by ID.  
- `GET /api/orders` - Retrieve all orders.  
- `PUT /api/orders/{id}` - Update an order.  
- `DELETE /api/orders/{id}` - Delete an order.  

## Technologies Used
- **Backend**: Spring Boot  
- **Database**: MySQL (or other relational database systems)  
- **ORM**: Spring Data JPA  
- **Testing**: JUnit, Mockito  

## Setup Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/online-grocery-order-management.git
   cd online-grocery-order-management
   ```
2. Build and run the application:
   ```bash
   ./gradlew bootRun
   ```
3. Test the API using [Postman](https://www.postman.com/) or other tools.

## Future Improvements
- Add authentication and authorization.
- Implement pagination for large datasets.
- Enhance order functionality with payment processing and delivery tracking.
- Introduce complex business rules (e.g., discounts, promotions).

## Resources
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)  
- [Postman Documentation](https://learning.postman.com/docs/getting-started/introduction/)  
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)

---

> **Note**: This is a simplified project designed to demonstrate the implementation of RESTful APIs with Spring Boot. Complex business logic and advanced features are beyond the scope of this assignment.

