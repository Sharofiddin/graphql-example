use catalogDb
db.getCollection("Products").insertOne( { name: "pr1", category: "cat1", summary: "sum sum", description: "desc", imageFile: "img", price: 10.6 } )
