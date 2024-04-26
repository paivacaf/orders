# API de Pedidos

## Iniciar banco 
```
cd order-command-service
cd docker
docker-compose -f mysql.yml up -d
```

## Microservico de criação de pedidos (order-command-service)


### Requisicao para criar pedidos
```
curl --location 'http://localhost:8080/orders/v1' \
--header 'Content-Type: application/json' \
--data '[
    {
      "controlNumber": "12345",
      "productName": "Product A",
      "unitPrice": 10.0,
      "quantity": 2,
      "clientCode": 1
    },
    {
      "controlNumber": "67890",
      "productName": "Product B",
      "unitPrice": 15.0,
      "quantity": 1,
      "clientCode": 2
    },
    {
      "controlNumber": "67891",
      "productName": "Product B",
      "unitPrice": 15.0,
      "quantity": 1,
      "clientCode": 2
    },
    {
      "controlNumber": "67892",
      "productName": "Product B",
      "unitPrice": 15.0,
      "quantity": 1,
      "clientCode": 2
    },
    {
      "controlNumber": "67893",
      "productName": "Product B",
      "unitPrice": 15.0, 
      "registrationDate": "2024-04-27", 
      "clientCode": 2
    }
  ]'
```

## Microservico de consulta de pedidos (order-query-service)


### Requisição para listar todos os pedidos:
```
curl --location 'curl "http://localhost:8081/orders'
```