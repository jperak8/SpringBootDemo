package hr.java.spring.boot.example.hardware.model;

import lombok.*;

@Data
@NoArgsConstructor
public class Hardware {

    private Long id;
    private String name;
    private String code;
    private Double price;
    private HardwareType type;
    private Integer quantity;

    public Hardware(String name, String code, Double price, HardwareType type, Integer quantity) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }

}



