package Mini_library.project.dto;

import Mini_library.project.entities.Author;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@ApiModel(description = "Author dto in the application.")
public class AuthorDto {

  @ApiModelProperty(notes = "Unique identifier of the author.", example = "1", required = true, position = 0)
  private Long id;

  @ApiModelProperty(notes = "Author's name.", example = "Rowling", required = true, position = 1)
  private String name;

  @ApiModelProperty(notes = "Number of books written.", example = "3", required = true, position = 2)
  private long booksCount;

  public AuthorDto(Author a) {
    this.id = a.getId();
    this.name = a.getName();
    this.booksCount = a.getBooks().stream().map(BookDto::new).count();
  }
}
