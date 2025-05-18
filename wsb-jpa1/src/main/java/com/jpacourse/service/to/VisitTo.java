package com.jpacourse.service.to;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisitTo {
    private Long id;
    private String description;
    private LocalDateTime visitDate;
    private Long doctorId;
    private Long patientId;
    private Long treatmentId;
}
