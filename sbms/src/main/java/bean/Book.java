package bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Integer bid;

    private String bookName;

    private String author;

    private String press;

    private String synopsis;

    private String bookType;

    private Float price;

    private Integer count;

}
