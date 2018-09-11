package com.email;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class SendMail3 {
    private String from = "18756665811@163.com";
    private String to = "15761632038@163.com";
    private String host = "smtp.163.com";
    private String password = "yuanshuo312";

    public void sendMail() {

        //获取系统属性
        Properties properties = System.getProperties();
        //设置邮箱服务器
        properties.setProperty("mail.smtp.host", host);
        //获取默认session对象
        Session session = Session.getDefaultInstance(properties);

        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
            //设置发送者
            message.setFrom(new InternetAddress(from));
            //设置接收者
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //设置主题信息
            message.setSubject("我中彩票了");
            //设置消息体

            BodyPart mimeBodyPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();

            mimeBodyPart.setText("测试是否覆盖主题信息！");
            multipart.addBodyPart(mimeBodyPart);

            mimeBodyPart=new MimeBodyPart();
            String fileName = "D:\\pic\\3.jpg";
            DataSource dataSource = new FileDataSource(fileName);
            mimeBodyPart.setDataHandler(new DataHandler(dataSource));
            mimeBodyPart.setFileName(fileName);
            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);

            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {
        SendMail3 sendMail3 = new SendMail3();
        sendMail3.sendMail();
        System.out.println("发送成功");
    }
}
