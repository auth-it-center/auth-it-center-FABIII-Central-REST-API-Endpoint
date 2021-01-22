package com.fab.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class TestResultLoggerExtension implements TestWatcher, AfterAllCallback {

    private static final int NUMBER_OF_TESTS = 2;

    private static int testsRun = 0;

    private final List<TestResultStatus> testResultsStatus = new ArrayList<>();

    private final ArrayList<String> testMessages = new ArrayList<>();

    private enum TestResultStatus {
        SUCCESSFUL, ABORTED, FAILED, DISABLED;
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        testMessages.add(
                "\tTest Disabled for test "
                + context.getDisplayName()
                + ": with reason :- "
                + reason.orElse("No reason")
        );

        testResultsStatus.add(TestResultStatus.DISABLED);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        testMessages.add("\tTest Successful for test " + context.getDisplayName());

        testResultsStatus.add(TestResultStatus.SUCCESSFUL);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        testMessages.add("\tTest Aborted for test " + context.getDisplayName());

        testResultsStatus.add(TestResultStatus.ABORTED);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        testMessages.add(
                "\tTest Failed for test "
                        + context.getDisplayName()
                        + ": with Execution Exception :- "
                        + context.getExecutionException()
        );

        EmailBody.testFailed();

        testResultsStatus.add(TestResultStatus.FAILED);
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        Map<TestResultStatus, Long> summary = testResultsStatus.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        testMessages.add("\tTest result summary for " + context.getDisplayName() + " " + summary.toString());

        if (testsRun == 0) {
            if (summary.containsKey(TestResultStatus.FAILED)) {
                EmailBody.reset();
                EmailBody.testFailed();
            } else {
                EmailBody.reset();
            }
        }

        EmailBody.addLine(context.getDisplayName());
        EmailBody.addLines(testMessages);

        testsRun++;

        if (testsRun == NUMBER_OF_TESTS && EmailBody.getTestFailed()) {
            System.out.println(EmailBody.getBody());
            testsRun = 0;

            //---------------------------------

            sendEmail();

            //---------------------------------

            return;
        }

        EmailBody.addLine("\n============================================================================\n");
    }

    private void sendEmail() {
        // Recipient's email ID needs to be mentioned.
        String to = "vasilisandritsouds@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "vasandven@gapps.auth.gr";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("vasandven@gapps.auth.gr", "zunlavodsngzokcb");

            }

        });

        // Used to debug SMTP issues
        //session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Fab3 Test Failure Report");

            // Now set the actual message
            message.setText(EmailBody.getBody());

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}