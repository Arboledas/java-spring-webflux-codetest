# Customer REST API with Spring WebFlux

The service will run on port 8090. Here some endpoints you can call:

**- Send Customer list with JSON format [(i.e attached customers.json)](/customers.json) and return it back sorted by `duetime`:**

`POST /customers/getByDueTimeAsc`

**- Get information about system health and the service itself:**

`GET /actuator/health`

`GET /actuator/info`

(Only those two endpoints are intentionally enabled using Spring Boot Actuator)

---------------

**- Testing with WebFluxTest and WebTestClient:**

Launch the test `testPostAndReadCustomersStatusOk` on the CustomerControllerTest 
to check that the code works sending a dummy single Customer JSON. 

**- Load Testing with JMeter:**

The API has been tested with some basic thread groups requests using JMeter.  The request body is the [attached customers.json](/customers.json)  
From lower to greater tests (There is also a folder JMeter with the results in the project)

a) The lowest test:  
- Number of Threads (users): 25  
- Ramp-up period (seconds): 1  
- Loop Count: 1  

|Label       |# Samples|Average|Min|Max|Std. Dev.|Error %|Throughput|Received KB/sec|Sent KB/sec|Avg. Bytes|
|------------|---------|-------|---|---|---------|-------|----------|---------------|-----------|----------|
|HTTP Request|25       |1      |1  |3  |0,39     |0,000% |26,12330  |272,51         |392,36     |10682,0   |
|TOTAL       |25       |1      |1  |3  |0,39     |0,000% |26,12330  |272,51         |392,36     |10682,0   |

b) Lower test:
- Number of Threads (users): 100
- Ramp-up period (seconds): 3
- Loop Count: 2

|Label       |# Samples|Average|Min|Max|Std. Dev.|Error %|Throughput|Received KB/sec|Sent KB/sec|Avg. Bytes|
|------------|---------|-------|---|---|---------|-------|----------|---------------|-----------|----------|
|HTTP Request|200      |1      |1  |4  |0,54     |0,000% |67,38544  |702,94         |1012,10    |10682,0   |
|TOTAL       |200      |1      |1  |4  |0,54     |0,000% |67,38544  |702,94         |1012,10    |10682,0   |

c) Greater test:
- Number of Threads (users): 250
- Ramp-up period (seconds): 3
- Loop Count: 4

|Label       |# Samples|Average|Min|Max|Std. Dev.|Error %|Throughput|Received KB/sec|Sent KB/sec|Avg. Bytes|
|------------|---------|-------|---|---|---------|-------|----------|---------------|-----------|----------|
|HTTP Request|1000     |1      |0  |6  |0,55     |0,000% |334,67202 |3491,18        |5026,62    |10682,0   |
|TOTAL       |1000     |1      |0  |6  |0,55     |0,000% |334,67202 |3491,18        |5026,62    |10682,0   |


d) The greatest test:   
- Number of Threads (users): 500  
- Ramp-up period (seconds): 5  
- Loop Count: 5

|Label       |# Samples|Average|Min|Max|Std. Dev.|Error %|Throughput|Received KB/sec|Sent KB/sec|Avg. Bytes|
|------------|---------|-------|---|---|---------|-------|----------|---------------|-----------|----------|
|HTTP Request|2500     |1      |0  |6  |0,53     |0,000% |501,00200 |5226,27        |7524,82    |10682,0   |
|TOTAL       |2500     |1      |0  |6  |0,53     |0,000% |501,00200 |5226,27        |7524,82    |10682,0   |


---------------
  
**Bonus point answer/conclusion**  
I don't think there is one better than the other, as far I know:
- Testing controller: Maybe I am wrong, but you test it as a Web Application, using a Spring Context. (Integration Test)
- Testing service directly: You need something like Mockito, and then you are not using a Spring Context. (Unit test)
