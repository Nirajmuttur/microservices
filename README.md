
# Microservices

This is a simple microservices project .




## Services

- Factory Services
- Product Services
- Service Discovery
- API Gateway Service
- Config Server Service


## Run Locally

Clone the project

```bash
  git clone https://github.com/Nirajmuttur/microservices.git
```

Go to the each service directory and build docker image. 

```bash
  docker build -t <Image_name> .
```

Run docker compose

```bash
  docker-compose up -d
```



## Factory Related APIs
#### Get all factory

```bash
  GET /api/factory
```

#### Post factory

```bash
  POST /api/factory/create
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `body`      | `JSON` | **Required** name of factory and location |

#### Update factory

```bash
  PUT /api/factory/update
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `body`      | `JSON` | **Required** name of factory and location and factoryID |

## Product Related APIs

#### Post product

```bash
  POST /api/product/create/{factoryID}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `product`      | `JSON` | **Required** name,description,price,quantity |
| `factoryID`      | `number` | **Required** factory id |

#### Get Product By Factory Id

```bash
  GET /api/product/factory/{factoryID}
```

## Feedback

If you have any feedback, please reach out to me at nirajmuttur2@outlook.com

