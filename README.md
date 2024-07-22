# Emlakburada User Service

## Running User Service

The Gateway Service runs on `http://localhost:8080`.

## API Endpoints

### users

#### Save User
**POST** `/api/v1/users`

**Request:**
```json
{
    "name": "name",
    "surname": "surname",
    "email": "name@email.com",
    "password": "password"
}
```
#### Get User By Id
**GET** `/api/v1/users/{id}`

#### Get User By Email
**POST** `/api/v1/users/email`

**Request:**
```json
{
    "email": "name@email.com"
}
```

