package event;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class PlaceOrderEvent {
    private String numberOrder;
}
