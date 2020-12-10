package Mini_library.project.controllers;

import Mini_library.project.dto.BookDto;
import Mini_library.project.entities.Author;
import Mini_library.project.entities.Book;
import Mini_library.project.services.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api("Set of endpoints for books")
@RequestMapping("/api/v1/books")
public class BookController {

  private BookService bookService;

  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping
  @ApiOperation("Returns all books")
  public List<BookDto> getAllBooks() {
    List<Book> books = bookService.getAllBooks();
    return books.stream().map(BookDto::new).collect(Collectors.toList());
  }

  //"/?author_name=Rowling"
  @GetMapping("/author")
  @ApiOperation("Returns books by their author")
  public List<BookDto> getBooksByAuthor(String author_name) {
    List<Book> books = bookService.getId(author_name).getBooks();
    return books.stream().map(BookDto::new).collect(Collectors.toList());
  }
 }
