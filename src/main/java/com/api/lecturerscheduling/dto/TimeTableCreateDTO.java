package com.api.lecturerscheduling.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimeTableCreateDTO {
    private int classTimeTableId;
    private int slotId;
    private int weekId;
    private int roomId;
}
