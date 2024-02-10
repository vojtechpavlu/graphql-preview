import {MongoClient} from "mongodb";

import {publishers} from "./publishers.js";
import {authors} from "./authors.js";
import {books} from "./books.js";

const url = `mongodb://localhost:27017/`

const client = new MongoClient(url, {
    auth: {
        username: "rootuser",
        password: "rootpass"
    }
});

const run = async () => {
    const database = client.db("graphql-preview");

    await Promise.all([
        database.dropCollection("publisher"),
        database.dropCollection("author"),
        database.dropCollection("book")
    ])

    const publishersCollection = database.collection("publisher");
    const authorsCollection = database.collection("author");
    const booksCollection = database.collection("book");

    await Promise.all([
        publishersCollection.insertMany(publishers),
        authorsCollection.insertMany(authors),
        booksCollection.insertMany(books)
    ]);

    await client.close()
}

run()