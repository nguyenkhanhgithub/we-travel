package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "type_of_cuisine_service")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TypeOfCuisineService implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_of_cuisine_service_id")
    private Long typeCuisineServiceId;

    @ManyToOne
    @JoinColumn(name = "restaurant_id" , referencedColumnName = "restaurant_id")
    private Restaurant restaurantId;

    @ManyToOne
    @JoinColumn(name = "type_of_cuisine_id")
    private TypeOfCuisine typeCuisineId;
}
