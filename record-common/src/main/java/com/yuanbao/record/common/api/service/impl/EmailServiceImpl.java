package com.yuanbao.record.common.api.service.impl;

import cn.hutool.extra.mail.Mail;
import cn.hutool.extra.mail.MailAccount;
import com.yuanbao.record.common.api.service.EmailService;
import com.yuanbao.record.mbp.dto.EmailDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.email}")
    private String email;
    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.port}")
    private String port;
    @Value("${spring.mail.username}")
    private String username;
    @Value("${spring.mail.password}")
    private String password;

    @Override
    public void send(EmailDto emailDto) {
        if (email == null || host == null || port == null || username == null || password == null) {
            throw new RuntimeException("配置异常");
        }

        MailAccount account = new MailAccount();
        account.setHost(host);
        account.setPort(Integer.parseInt(port));
        account.setFrom(username + "<" + email + ">");
        account.setUser(username);
        account.setPass(password);
        account.setAuth(true);
        account.setSslEnable(true);
        account.setStarttlsEnable(true);

        try {
            int size = emailDto.getTos().size();
            Mail.create(account)
                    .setTos(emailDto.getTos().toArray(new String[size]))
                    .setTitle(emailDto.getSubject())
                    .setContent(emailDto.getContent())
                    .setHtml(true)
                    .setUseGlobalSession(false)
                    .send();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
