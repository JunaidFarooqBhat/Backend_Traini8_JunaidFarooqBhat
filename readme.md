# Traini8: Buyogo (Backend_Traini8_JunaidFarooqBhat)

This project is developed using Java SpringBoot framework and utilizes a SQL database to store data. It consists of two APIs: one for creating new training centers and another for retrieving all training centers.

## APIs

1. **Create Training Center**
   - Endpoint: `/trainingcenter`
   - Method: POST
   - Description: This API accepts JSON data containing details/properties of a new training center. It performs validations on the input data and saves the new training center in the database.

2. **Get All Training Centers**
   - Endpoint: `/getcenters`
   - Method: GET
   - Description: This API retrieves all available training centers. Additionally, it provides optional filters for narrowing down the results:
     - Filter by state
     - Filter by pincode
     - Limit the number of results
   - Note: All three filters are optional.

## Testing

You can test these APIs using Swagger or Postman.

### Swagger
Swagger is integrated into the project for easy API testing. Access the Swagger UI by navigating to `http://localhost:8080/swagger-ui/index.html#/` after starting the application.
![Swagger UI](https://drive.google.com/uc?export=download&id=1eDuv3f_3leYeE0K6nPjSgWbWCm2QEBsz)

### Postman
You can also use Postman for testing the APIs. Use the provided endpoints and send requests with appropriate JSON data for creating training centers or retrieving training centers with optional filters.

## Dependencies
- SpringBoot Starter Web
- SpringBoot Starter Data JPA
- MySQL Driver
- Lombok
- Hibernate Validator (for validations)
- Swagger (for API documentation and testing)

