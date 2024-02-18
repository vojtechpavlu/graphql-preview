# GraphQL Preview

This repository is just a small example of how could the GraphQL be used with
Spring.

**⚠️ Mind this project is just for simple local development only!**


## Start up

To start the environment, you first need to start the database and fill it with data. 
For this purpose, there is already dockerized MongoDB prepared.

Then you can start testing.


### Prerequisites

To start the project up, you need to have preinstalled docker with docker compose (and of course Java).


### Database Start up

To minimize the hassle, I've prepared a docker compose declaration to start up the
MongoDB, it's management client and a mocker. To start it up, you only need to enter:

```shell
docker-compose up --build
```

in the `./mongodb` directory.

After successful start up, the database should be running and being filled with
mock data.

You can verify it at http://localhost:8081 while using `admin` and `pass` as
your credentials.
