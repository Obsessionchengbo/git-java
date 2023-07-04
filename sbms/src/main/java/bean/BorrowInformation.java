package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowInformation {

    private Integer buid;

    private Integer uid;

    private Integer bid;

    private Timestamp borrowTime;

    private Integer status;

    private Timestamp returnTime;

    private Float amercement;

}