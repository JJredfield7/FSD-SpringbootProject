package net.javaguides.springboot.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "orderDetails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetails {

    @Id
    @Column(name = "orderDetailsId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDetailsId;

    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "itemId", referencedColumnName = "itemId")
    private Item item;

}