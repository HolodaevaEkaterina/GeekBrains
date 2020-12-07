package Mini_library.project.services;

import Mini_library.project.entities.Author;
import Mini_library.project.repositories.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Service
public class AuthorService {
  private AuthorRepository authorRepository;

  @Autowired
  public AuthorService(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  public Optional<Author> findById(Long id) {
    return authorRepository.findById(id);
  }
}
