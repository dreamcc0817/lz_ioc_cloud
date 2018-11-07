package com.bonc.ioc.core.mail;/**
 * Created by wo on 2018-09-26.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * MailServiceImple模块
 *
 * @version 1.0
 * @Author chenxiaoyang
 * @Date 2018-09-26 13:58
 */
@Component
public class MailServiceImple implements MailInterface {
    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 发送文本消息
     *
     * @param to      接收者
     * @param form    发送者
     * @param subject 标题
     * @param content 正文
     */
    @Override
    public void sendSimpleMail(String to, String form, String subject, String content) throws Exception {
        SimpleMailMessage simpleMailMEssage = new SimpleMailMessage();
        simpleMailMEssage.setFrom(form);
        simpleMailMEssage.setTo(to);
        simpleMailMEssage.setText(content);
        simpleMailMEssage.setSubject(subject);
        javaMailSender.send(simpleMailMEssage);
    }

    /**
     * 发送html页面
     *
     * @param to      接收者
     * @param form    发送者
     * @param subject 标题
     * @param html    html页面
     */
    @Override
    public void sendJHtmlMail(String to, String form, String subject, String html) throws Exception {
        MimeMessage message = javaMailSender.createMimeMessage();
        //true表示需要创建一个multipart message
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(form);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(html, true);
        javaMailSender.send(message);
    }

    /**
     * 发送附件邮件
     *
     * @param to       接收者
     * @param from     发送者
     * @param subject  标题
     * @param content  正文
     * @param filePath 文件路径
     * @throws Exception
     */
    @Override
    public void sendAttachmentsMail(String to, String from, String subject, String content, String filePath) throws Exception {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
        helper.addAttachment(fileName, file);
        javaMailSender.send(message);
    }
}
