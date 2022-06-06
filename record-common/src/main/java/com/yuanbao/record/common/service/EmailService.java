package com.yuanbao.record.common.service;

import com.yuanbao.record.mbp.dto.EmailDto;

public interface EmailService {
    void send(EmailDto emailDto);
}
