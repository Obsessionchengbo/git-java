package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowInformation {

    private Integer buid;

    private Integer uid;

    private Integer bid;

    private java.sql.Date borrowTime;

    private Integer status;

    private Date returnTime;

    private Float amercement;

}