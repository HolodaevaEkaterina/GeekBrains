package Mini_library.project.controllers;

import Mini_library.project.dto.AuthorDto;
import Mini_library.project.exceptions.LibraryError;
import Mini_library.project.services.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("Set of endpoints for authors")
@RequestMapping("/api/v1/authors")
public class AuthorController {

  private AuthorService authorService;

  @Autowired
  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @GetMapping("/{id}")
  @ApiOperation("Returns a list of the author's books by name. 404 if does not exist.")
  public ResponseEntity<?> getAuthorById(@PathVariable Long id) {
    var author = authorService.findById(id);
    return author.isPresent() ? new ResponseEntity<>(new AuthorDto(author.get()), HttpStatus.OK) : new ResponseEntity<>(new LibraryError(HttpStatus.NOT_FOUND.value(), "there is no author with this id"), HttpStatus.NOT_FOUND);
  }
}
