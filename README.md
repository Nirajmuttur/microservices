
# Microservices

This is a simple microservices project .




## Services

- Factory Services
- Product Services
- Service Discovery
- API Gateway Service


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

```http
  GET /api/factory
```

#### Post factory

```http
  POST /api/factory/create
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `body`      | `JSON` | **Required** name of factory and location |

#### Update factory

```http
  PUT /api/factory/update
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `body`      | `JSON` | **Required** name of factory and location and factoryID |

## Product Related APIs

#### Post product

```http
  POST /api/product/create/{factoryID}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `product`      | `JSON` | **Required** name,description,price,quantity |
| `factoryID`      | `number` | **Required** factory id |

#### Get Product By Factory Id

```http
  GET /api/product/factory/{factoryID}
```

## Feedback

If you have any feedback, please reach out to me at nirajmuttur@gmail.com

