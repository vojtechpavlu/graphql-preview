import {MongoClient} from "mongodb";

import {publishers} from "./publishers.js";
import {authors} from "./authors.js";
import {books} from "./books.js";
import {tags} from "./tags.js";

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
        database.dropCollection("book"),
        database.dropCollection("tag")
    ])

    const publishersCollection = database.collection("publisher");
    const authorsCollection = database.collection("author");
    const booksCollection = database.collection("book");
    const tagsCollection = database.collection("tag");


    await Promise.all([
        publishersCollection.insertMany(publishers),
        authorsCollection.insertMany(authors),
        booksCollection.insertMany(books),
        tagsCollection.insertMany(tags)
    ]);

    await client.close()
}

run()