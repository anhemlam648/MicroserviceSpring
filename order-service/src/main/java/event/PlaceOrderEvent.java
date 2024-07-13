package event;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class PlaceOrderEvent implements Serializable {
    private String numberOrder;
}
