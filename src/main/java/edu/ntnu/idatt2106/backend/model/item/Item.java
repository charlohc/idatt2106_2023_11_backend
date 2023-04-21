package edu.ntnu.idatt2106.backend.model.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.ntnu.idatt2106.backend.model.recipe.RecipeItem;
import edu.ntnu.idatt2106.backend.model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


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
    private String shortDesc;

    @Enumerated(EnumType.STRING)
    private Category category;
    private double price;

    private double weight;

   @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;

   @JsonIgnore
    @OneToMany(mappedBy = "item")
    private List<RecipeItem> recipeItems;

}
