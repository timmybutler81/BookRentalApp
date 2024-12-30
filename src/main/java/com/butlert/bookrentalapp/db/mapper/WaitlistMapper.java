package com.butlert.bookrentalapp.db.mapper;

import com.butlert.bookrentalapp.db.entity.Waitlist;
import com.butlert.bookrentalapp.dto.WaitlistDTO;

public class WaitlistMapper {

    public static WaitlistDTO toDTO(Waitlist waitlist) {
        return new WaitlistDTO(waitlist.getId(), waitlist.getBookId(), waitlist.getUserId(), waitlist.getWaitlistStatus(), waitlist.getWaitlistAddDate(), waitlist.isProcessedFlag());
    }

    public static Waitlist toEntity(WaitlistDTO waitlistDTO) {
        Waitlist waitlist = new Waitlist();
        waitlist.setId(waitlistDTO.getId());
        waitlist.setBookId(waitlistDTO.getBookId());
        waitlist.setUserId(waitlistDTO.getUserId());
        waitlist.setWaitlistStatus(waitlistDTO.getWaitlistStatus());
        waitlist.setWaitlistAddDate(waitlistDTO.getWaitlistAddDate());
        waitlist.setProcessedFlag(waitlistDTO.isProcessedFlag());
        return waitlist;
    }
}
