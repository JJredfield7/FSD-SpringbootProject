package net.javaguides.springboot.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    @Id
    @Column(name = "itemId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @NotNull
    @Size(max = 50)
    @Column(name = "itemName")
    private String item_name;

    @NotNull
    @Min(0)
    @Max(1000000)
    @Column(name = "itemPrice")
    private Double item_price;

    @NotNull
    @Size(max = 200)
    @Column(name = "itemDescription")
    private String itemDescription;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "itemType")
    private ItemType itemType;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "itemSize")
    private FoodSize itemSize;
}