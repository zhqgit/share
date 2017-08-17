package com.share.portal.util;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.*;

/**
 * Created by  bin
 * Time： 2017/8/16.
 */
public class EmailUtil {

    private static Session session;
    private static MimeMessage msg;
    private static String user;

    private String text;
    private String html;
    private List<MimeBodyPart> attachments = new ArrayList<MimeBodyPart>();

    public EmailUtil() {
    }

    public static Properties defaultConfig(Boolean debug) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.debug", "false");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.debug", null != debug ? debug.toString() : "false");
        props.put("mail.smtp.timeout", "10000");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.host", "smtp.163.com");
        return props;
    }

    public static Properties SMTP_QQ(Boolean debug) {
        Properties props = defaultConfig(debug);

        return props;
    }

    public static Properties SMTP_163(Boolean debug) {
        Properties props = defaultConfig(debug);
        props.put("mail.smtp.host", "smtp.163.com");
        return props;
    }

    public static void config(Properties props, final String username, final String password) {
        session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        user = username;
        msg = new MimeMessage(session);
    }

    public static void config(Properties props) {
        final String username = props.getProperty("username");
        final String password = props.getProperty("password");
        user = username;
        session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        msg = new MimeMessage(session);
    }

    public static EmailUtil subject(String subject) throws MessagingException {
        EmailUtil emailUtil = new EmailUtil();
        msg.setSubject(subject, "UTF-8");
        return emailUtil;
    }

    public EmailUtil from(String nickName) throws MessagingException {
        try {
            nickName = MimeUtility.encodeText(nickName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        msg.setFrom(new InternetAddress(nickName + " <" + user + ">"));
        return this;
    }

    public EmailUtil from(String nickName, String from) throws MessagingException {
        try {
            nickName = MimeUtility.encodeText(nickName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        msg.setFrom(new InternetAddress(nickName + " <" + from + ">"));
        return this;
    }

    public EmailUtil replyTo(String... replyTo) throws MessagingException {
        String result = Arrays.asList(replyTo).toString().replaceAll("(^\\[|\\]$)", "").replace(", ", ",");
        msg.setReplyTo(InternetAddress.parse(result));
        return this;
    }

    public EmailUtil replyTo(String replyTo) throws MessagingException {
        msg.setReplyTo(InternetAddress.parse(replyTo.replaceAll(";", ",")));
        return this;
    }

    public EmailUtil to(String... to) throws Exception {
        String result = Arrays.asList(to).toString().replaceAll("(^\\[|\\]$)", "").replace(", ", ",");
        msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(result));
        return this;
    }

    public EmailUtil to(String to) throws MessagingException {
        msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to.replaceAll(";", ",")));
        return this;
    }

    public EmailUtil cc(String... cc) throws MessagingException {
        String result = Arrays.asList(cc).toString().replaceAll("(^\\[|\\]$)", "").replace(", ", ",");
        msg.addRecipients(Message.RecipientType.CC, InternetAddress.parse(result));
        return this;
    }

    public EmailUtil cc(String cc) throws MessagingException {
        msg.addRecipients(Message.RecipientType.CC, InternetAddress.parse(cc.replaceAll(";", ",")));
        return this;
    }

    public EmailUtil bcc(String... bcc) throws MessagingException {
        String result = Arrays.asList(bcc).toString().replaceAll("(^\\[|\\]$)", "").replace(", ", ",");
        msg.addRecipients(Message.RecipientType.BCC, InternetAddress.parse(result));
        return this;
    }

    public EmailUtil bcc(String bcc) throws MessagingException {
        msg.addRecipients(Message.RecipientType.BCC, InternetAddress.parse(bcc.replaceAll(";", ",")));
        return this;
    }

    public EmailUtil text(String text) {
        this.text = text;
        return this;
    }

    public EmailUtil html(String html) {
        this.html = html;
        return this;
    }

    public EmailUtil attach(File file) throws MessagingException {
        attachments.add(createAttachment(file, null));
        return this;
    }

    public EmailUtil attach(File file, String fileName) throws MessagingException {
        attachments.add(createAttachment(file, fileName));
        return this;
    }

    private MimeBodyPart createAttachment(File file, String fileName) throws MessagingException {
        MimeBodyPart attachmentPart = new MimeBodyPart();
        FileDataSource fds = new FileDataSource(file);
        attachmentPart.setDataHandler(new DataHandler(fds));
        try {
            attachmentPart.setFileName(null == fileName ? MimeUtility.encodeText(fds.getName()) : MimeUtility.encodeText(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attachmentPart;
    }

    public void send() throws MessagingException {
        if (text == null && html == null)
            throw new NullPointerException("At least one context has to be provided: Text or Html");

        MimeMultipart cover;
        boolean usingAlternative = false;
        boolean hasAttachments = attachments.size() > 0;

        if (text != null && html == null) {
            // TEXT ONLY
            cover = new MimeMultipart("mixed");
            cover.addBodyPart(textPart());
        } else if (text == null && html != null) {
            // HTML ONLY
            cover = new MimeMultipart("mixed");
            cover.addBodyPart(htmlPart());
        } else {
            // HTML + TEXT
            cover = new MimeMultipart("alternative");
            cover.addBodyPart(textPart());
            cover.addBodyPart(htmlPart());
            usingAlternative = true;
        }

        MimeMultipart content = cover;
        if (usingAlternative && hasAttachments) {
            content = new MimeMultipart("mixed");
            content.addBodyPart(toBodyPart(cover));
        }

        for (MimeBodyPart attachment : attachments) {
            content.addBodyPart(attachment);
        }

        msg.setContent(content);
        msg.setSentDate(new Date());
        Transport.send(msg);
    }

    private MimeBodyPart toBodyPart(MimeMultipart cover) throws MessagingException {
        MimeBodyPart wrap = new MimeBodyPart();
        wrap.setContent(cover);
        return wrap;
    }

    private MimeBodyPart textPart() throws MessagingException {
        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setText(text);
        return bodyPart;
    }

    private MimeBodyPart htmlPart() throws MessagingException {
        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(html, "text/html; charset=utf-8");
        return bodyPart;
    }

}
