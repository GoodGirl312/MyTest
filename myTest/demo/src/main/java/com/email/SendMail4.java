package com.email;

import org.junit.Test;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class SendMail4 {
    private String form="18756665811@163.com";
    private String to="15101146021@163.com";
    private String host="smtp.163.com";
    private String authentic="yuanshuo312";

    @Test
    public void sendMail(){
        Properties properties=System.getProperties();
        properties.setProperty("mail.smtp.host",host);

        Session session=Session.getDefaultInstance(properties);


        try {
            MimeMessage message=new MimeMessage(session);
            //设置发送者
            message.setFrom(new InternetAddress(form));
            //接收者
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
            //设置消息
            message.setSubject("测试邮件");
            message.setText("我中大奖了");

            Multipart multipart=new MimeMultipart();
            BodyPart bodyPart=new MimeBodyPart();
            String fileName="D:\\pic\\3.jpg";
            bodyPart.setFileName(fileName);
            DataSource dataSource=new FileDataSource(fileName);
            bodyPart.setDataHandler(new DataHandler(dataSource));
            multipart.addBodyPart(bodyPart);
            message.setContent(multipart);

            Transport transport=session.getTransport("smtp");
            transport.connect(host,form,authentic);
            transport.sendMessage(message,message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
