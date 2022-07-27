package com.berat.bookstore.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "bookOrder")
@Table
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userName;

    @Column
    @ElementCollection(targetClass = Integer.class)
    private List<Integer> bookIdList;

    private Double totalPrice;
}
