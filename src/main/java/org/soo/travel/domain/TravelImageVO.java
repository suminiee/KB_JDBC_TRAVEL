package org.soo.travel.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TravelImageVO {
    private Long no;
    private String filename;
    private Long travelNo;
}
