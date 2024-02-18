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


## Testing

To test the application out in a simple manner, just start the application and 
either use `curl` or you can open the browser at http://localhost:8080/graphiql.


### Testing with `curl`

To use `curl`, keep in mind the requests are `POST` and the payload consists
of the query. See this example:

```shell
curl -i \
  -H 'Content-Type: application/json' \
  -X POST \
  -d '{"query": "query {allAuthors { fullName }}"}' \
  http://localhost:8080/graphql
```

To pick some other queries, just have a look into [Examples](#examples).


### Testing with Web-based client

As said above, you just need to open http://localhost:8080/graphiql in the browser
and you'll see the web-based client for testing purposes. You can always disable
this playground at `applicaion.properties` (by simply switching this to `false`: 
`spring.graphql.graphiql.enabled=false`).

Feel free to have a look into the docs (you'll find them in on the left side).


### Examples

Here are some examples to test it out.

1. Select all the authors' full names:
    ```graphql
    query {
      allAuthors {
        fullName
      }
    }
    ```

2. Select all the books per publisher:
    ```graphql
    query {
      allPublishers {
        name
        books {
          title
        }
      }
    }
    ```

3. Select a book by ID with populated authors, publisher and tags. Also mind the renamed 
fields at author and publisher entities:
    ```graphql
    query {
      bookById(id: "adf8a53g51ae1rg2a1r") {
        title
        year
        authors {
          name: fullName
        }
        publisher {
          publisherName: name
        }
        tags {        
          name
        }
      }
    }
    ```

4. Try to select non-existing book by ID:
    ```graphql
    {
      bookById(id: "non-existing") {
        title
      }
    }
    ```


## Note

This implementation does not include the data loader, so the server-database traffic 
is far from being optimized. Neither is the pagination taking place in here.
Also note there is no authentication method implemented either.

To have a notion on how does this work, follow these links:

- [Data Loader & Batching](https://www.graphql-java.com/documentation/batching/)
- [Pagination](https://www.howtographql.com/graphql-java/10-pagination/)
- [Authentication](https://www.howtographql.com/graphql-java/5-authentication/)
