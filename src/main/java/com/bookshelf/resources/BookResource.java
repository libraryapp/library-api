package com.bookshelf.resources;

        import com.bookshelf.db.BookDAO;
        import com.bookshelf.models.Book;
        import com.google.common.base.Optional;
        import com.wordnik.swagger.annotations.ApiParam;
        import io.dropwizard.hibernate.UnitOfWork;
        import io.dropwizard.jersey.params.LongParam;

        import javax.ws.rs.*;

        import javax.ws.rs.core.MediaType;
        import javax.ws.rs.core.Response;


        import java.util.List;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    private final BookDAO booksDAO;

    public BookResource(BookDAO booksDAO) {
        this.booksDAO = booksDAO;
    }

    @Path("/{bookId}")
    @GET
    @UnitOfWork
    public Book getBook(@PathParam("bookId") LongParam bookId) {
        return findSafely(bookId.get());
    }

    private Book findSafely(long bookId) {
        final Optional<Book> book = booksDAO.findById(bookId);
        if (!book.isPresent()) {
            throw new NotFoundException("No such book.");
        }
        return book.get();
    }

    @GET
    @UnitOfWork
    public List<Book> findAll() {
        return booksDAO.findAll();
    }

    @POST
    @UnitOfWork
    public Optional<Book> create(@ApiParam Book book) {

        if (book == null) {
            throw new WebApplicationException("Invalid Payload", Response.Status.BAD_REQUEST);
        }
        long id = booksDAO.create(book);
        return booksDAO.findById(id);
    }
}
