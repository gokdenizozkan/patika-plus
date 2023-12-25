| TYPE   | URL                                  | DESC                                           |
|--------|--------------------------------------|------------------------------------------------|
| GET    | /api/books                           | Retrieves all books                            |
| GET    | /api/categories                      | Retrieves all categories                       |
| DELETE | /api/categories/delete-category/{id} | Deletes the category with the given id         |
| GET    | /api/loans                           | Retrieves all loans                            |
| GET    | /api/loans/{id}                      | Retrieves the loan with the given id           |
| POST   | /api/loans/lend-book                 | Inserts the given Loan object given in Body    |
| PUT    | /api/loans/update                    | Updates the Loan with the object given in Body |
| GET    | /api/publishers                      | Retrieves all publishers                       |
| GET    | /api/publishers/{id}                 | Retrieves the publisher with the given id      |

You may find the tables created by the application below:

Author

![Tables](img/author.png)

Book

![Tables](img/book.png)

Category

![Tables](img/category.png)

Book & Category

![Tables](img/book_category.png)

Loan

![Tables](img/loan.png)

Publisher

![Tables](img/publisher.png)