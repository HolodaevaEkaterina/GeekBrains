package Mini_library.project.dto;

import Mini_library.project.entities.Book;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@ApiModel(description = "Book dto in the application.")
public class BookDto {

  @ApiModelProperty(notes = "Unique identifier of the book.", example = "1", required = true, position = 0)
  private Long id;

  @ApiModelProperty(notes = "Name of the book.", example = "Harry Potter", required = true, position = 1)
  private String title;

  @ApiModelProperty(notes = "Author's name.", example = "3", required = true, position = 2)
  private String author;

  public BookDto(Book p) {
    this.id = p.getId();
    this.title = p.getTitle();
    this.author = p.getAuthor().getName();
  }

}
