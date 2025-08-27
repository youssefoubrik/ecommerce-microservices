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

- **Spring Boot**: Framework for creating stand-alone Spring applications
- **Spring Cloud**: Tools for common distributed system patterns
- **Eureka Server**: Service discovery
- **Spring Cloud Config**: Centralized configuration
- **Spring Cloud Gateway**: API Gateway
- **Maven**: Dependency management and build tool
- **Docker**: Containerization platform

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
