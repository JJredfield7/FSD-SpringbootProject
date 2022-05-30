package net.javaguides.springboot.model;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "restaurantInfo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantInfo {

    @Id
    @Column(name = "restaurantId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long restaurantId;

    @NotNull
    @Size(max = 65)
    @Column(name = "restaurantName")
    private String restaurantName;

    @NotNull
    @Size(max = 200)
    @Column(name = "address")
    private String address;

    @NotNull
    @Size(max = 50)
    @Column(name = "phoneNumber")
    private String phoneNumber;

}