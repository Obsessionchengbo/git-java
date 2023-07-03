package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowInformation {

    private Integer uid;

    private Integer bid;

    private LocalDate borrowTime;

    private int status;

    private LocalDate returnTime;

    private Float amercement;

}