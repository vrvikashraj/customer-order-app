# customer-order-app Spring Boot App (Products, Customers, Orders)
	CRUD for products & customers  
	Create order with stock check  
	Cache products for 10 minutes  
	H2 database for local testing

# How to run
	Righ click on project and then Run As>> Spring Boot App

# Login to H2 Console
	URL: http://localhost:8080/h2-console
	Database Name: invenco
	Username: sa
	Password: (blank)

# APIs
	POST /products – create product
	POST /customers – create customer
	POST /orders – create order
	GET /orders/{customerId} 

# Validations:
	Product name cannot be blank
	Customer email must be unique
	Order can't be placed if product isout of stock.
