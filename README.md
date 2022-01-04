# tqi_evolution_backend_2021

<p>Api created for TQI Evolution 2021 </p>

## Resources used
- Java
- Lombok
- JPA
- Maven
- Spring Validation
- Spring Security
- Docker
- Postgres

## Create database

```docker run --name tqi-db -d -p 5433:5432 -e POSTGRES_USER=postgres_user -e POSTGRES_PASSWORD=super123 -e POSTGRES_DB=tqi postgres```

## Client

#### Register

```http://localhost:8085/client```

#### Example
```
{
    "name": "string",
    "zipCode": "string",
    "cpf": "string",
    "email": "string",
    "number": "string",
    "password": "string",
    "remuneration": 0000.00,
    "rg": "string",
    "address": "string"
}
```
#### Loan listing 

``` http://localhost:8085/client/loans/00 ```

#### Example return 
```
[
    {
        "id": 0,
        "value": 00.0,
        "installment": 00
    },
    {
        "id": 0,
        "value": 00.0,
        "installment": 00
    }
]
```
#### Login

``` http://localhost:8085/client/login?email=example@email.com&password=xxxxxx ```

#### Return

``` true or false ```

## Loan

#### Register

``` http://localhost:8085/loan ``` 

#### Example
```
{
        "client": {
            "id": 0
        },
        "value": 000.00,
        "firstInstallmentDate": "yyyy-mm-dd",
        "installment": 00
}
```

#### Loan Detail

``` http://localhost:8085/loan/0 ```

#### Return
```
{
    "id": 0,
    "value": 000.00,
    "firstInstallmentDate": "yyyy-mm-dd",
    "installment": 00,
    "emailClient": "string",
    "remuneration": 0000.00
}
```
