package com.api.lecturerscheduling.service.impl;

import com.api.lecturerscheduling.dto.SlotDTO;
import com.api.lecturerscheduling.mapper.SlotMapper;
import com.api.lecturerscheduling.service.SlotService;
import org.springframework.stereotype.Service;

@Service
public class SlotServiceImpl implements SlotService {

    private final SlotMapper slotMapper;

    public SlotServiceImpl(SlotMapper slotMapper) {
        this.slotMapper = slotMapper;
    }

    @Override
    public SlotDTO getSlotInfo(String slotId) {
        return slotMapper.getSlotDTO(slotId);
    }

    @Override
    public String getSlotId(String slot, String day) {
        return slotMapper.getSlotId(slot, day);
    }
}
