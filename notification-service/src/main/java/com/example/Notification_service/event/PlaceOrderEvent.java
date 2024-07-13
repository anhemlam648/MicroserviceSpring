package com.example.Notification_service.event;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
public class PlaceOrderEvent implements Serializable {

    private String numberOrder;
}