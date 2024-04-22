# FarmCollector Spring Boot Application

## Overview

FarmCollector is a Spring Boot application that allows organizations to collect information from farmers for every field for every season, per farm. It provides APIs for adding planted and harvested data, as well as generating reports for each farm and crop type.

## Prerequisites

- Java 17
- Maven

## How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/aleem2013/farmcollector.git

2. Navigate to the project directory:
   cd <folder-name>

3. Build the project:
   mvn clean install
   
4. Run the application:
   mvn spring-boot:run
 
5. The application will start, and you can access the endpoints at http://localhost:8080/api/
   or
   you can access Swigger URL http://localhost:8080/swagger-ui/index.html#/

Endpoints:
POST /api/planted: Add planted data
POST /api/harvested: Add harvested data
GET /api/report/by-farm: Get report by farm
GET /api/report/by-crop-type: Get report by crop type

