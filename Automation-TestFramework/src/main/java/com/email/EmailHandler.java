package com.email;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;
public class EmailHandler {
    public String path="C:\\Users\\Akshay Chavan\\Java\\Automation-TestFramework\\Automation-TestFramework\\src\\test\\resources\\EmailResource.html";
    private int totalTestCase=0;
    private int passedTestCase=0;
    private int faileTestCase=0;
    private int skippedTestCase=0;
    public void createFile() throws IOException {
        EmailTemplate emailTemplate = new EmailTemplate();
        emailTemplate.createEmailHtml(path);
    }
    public synchronized void updateStatus(String testCaseName, String startTime, String endTime,
                                          String status){
        EmailTemplate emailTemplate = new EmailTemplate();
        emailTemplate.addTableRow(path,testCaseName,startTime,endTime,10,status,"Chrome");
    }
    public void updateHeader(/*String newApplicationName, int newPassedTestCases,
                             int newFailedTestCases, int newSkippedTestCases*/){
        EmailTemplate emailTemplate = new EmailTemplate();
        emailTemplate.updateHtmlFile(path,"TestData","INTG",passedTestCase,faileTestCase,skippedTestCase,totalTestCase);

    }
    public  void sendEmail(String htmlContent) {
        // Sender's email and password
        final String fromEmail = "@gmail.com";
        final String password = "@ex";
        final String toAddress="@gmail.com";

        // Set up properties for the mail server
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        // Create a session with authentication
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            // Create a MIME message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
            message.setSubject("Automation Result");

            // Set the content as HTML
            message.setContent(htmlContent, "text/html");

            // Send the message
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
