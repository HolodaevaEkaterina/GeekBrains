package Mini_library.project.services;

import Mini_library.project.entities.Author;
import Mini_library.project.entities.Book;
import Mini_library.project.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

  private BookRepository bookRepository;

  @Autowired
  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  public Author getId(String name) {
    return bookRepository.getId(name);
  };
}
