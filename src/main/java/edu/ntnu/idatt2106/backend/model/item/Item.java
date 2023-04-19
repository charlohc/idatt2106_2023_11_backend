package edu.ntnu.idatt2106.backend.model.item;

import edu.ntnu.idatt2106.backend.model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Entity for when saving in database(?)
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "short_desc")
    private String shortDesc;

    @Column
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column
    private double price;

    @Column
    private double weight;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;
}