# RBS Employee Portal System

## Getting Started Documentation
1. Build the application using:
    mvn clean install
    
2. Run the application using:
    mvn spring-boot:run
    
3. Execute the create Employee APIs using following curl commands:
    curl -X POST http://localhost:7000/v1/portal/employee -d '{"name" : "karan","salary" : 55555,"hiredate":""}'
    
4. Go to the application Portal UI at
    http://localhost:7000/
    
    
5. Click on Sort By Name or Sort By Salary to get the list of employees accordingly.
