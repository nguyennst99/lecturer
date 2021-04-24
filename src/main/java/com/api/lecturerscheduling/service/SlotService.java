package com.api.lecturerscheduling.service;

import com.api.lecturerscheduling.dto.SlotDTO;

public interface SlotService {
    SlotDTO getSlotInfo(String slotId);
    String getSlotId(String slot, String day);
}
