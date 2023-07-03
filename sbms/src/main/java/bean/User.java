package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{

    private Integer uid;

    private String userName;

    private String password;

    private String name;

    private int sex;

    private int age;

    private int userType;

    private Float balance;

}