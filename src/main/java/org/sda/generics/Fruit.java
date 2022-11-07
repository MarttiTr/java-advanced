package org.sda.generics;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Fruit class for Generic
 *
 * @author Martti Triksberg
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Fruit implements Serializable { // This class can be Serialized and Deserialized
    private String name;
    private String color;
    private BigDecimal price;
}
