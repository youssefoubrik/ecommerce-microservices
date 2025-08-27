# E-commerce Microservices

A modern e-commerce platform built with Spring Boot microservices architecture.

## Project Overview

This project is a microservices-based e-commerce system that consists of several independent services working together to provide a complete e-commerce solution.

## Services

- **Config Server**: Centralized configuration management for all services
- **Discovery Service**: Service registry and discovery using Eureka
- **API Gateway**: Single entry point for all client requests
- **Customer Service**: Manages customer data and authentication
- **Product Service**: Handles product catalog and inventory
- **Order Service**: Processes and manages orders
- **Payment Service**: Handles payment processing
- **Notification Service**: Manages customer notifications

## Architecture

The system follows a microservices architecture pattern where each service is:

- Independently deployable
- Loosely coupled
- Highly maintainable and testable
- Organized around business capabilities

## Technologies

### Backend

- **Spring Boot**: Framework for creating stand-alone Spring applications
- **Spring Cloud**: Tools for common distributed system patterns
- **Eureka Server**: Service discovery and registration
- **Spring Cloud Config**: Centralized configuration management
- **Spring Cloud Gateway**: API Gateway for routing and filtering
- **Spring Cloud OpenFeign**: Declarative REST client
- **Spring Data JPA**: Data persistence and ORM
- **Spring Security**: Authentication and authorization
- **PostgreSQL**: Primary database for services
- **MongoDB**: Database for specific services requiring document storage
- **Apache Kafka**: Event streaming platform for asynchronous communication

### DevOps & Tools

- **Maven**: Dependency management and build automation
- **Docker**: Application containerization
- **Docker Compose**: Multi-container Docker applications

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Docker and Docker Compose

### Running the Application

1. Start the Config Server:

```bash
cd services/config-server
./mvnw spring-boot:run
```

2. Start the Discovery Service:

```bash
cd services/discovery
./mvnw spring-boot:run
```

3. Start other services:

```bash
cd services/<service-name>
./mvnw spring-boot:run
```

Alternatively, use Docker Compose to start all services:

```bash
docker-compose up
```

## Service Ports

- Config Server: 8888
- Discovery Service: 8761
- API Gateway: 8080
- Customer Service: 8081
- Product Service: 8082
- Order Service: 8083
- Payment Service: 8084
- Notification Service: 8085

## Project Structure

```
├── docker-compose.yml
├── services
│   ├── config-server/
│   ├── discovery/
│   ├── gateway/
│   ├── customer/
│   ├── product/
│   ├── order/
│   ├── payment/
│   └── notification/
└── diagrams/
    └── diagram.drawio
```
