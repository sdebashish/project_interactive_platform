package Feature;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;public class Library extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextPane chatArea = new JTextPane();
    private JTextArea chatField = new JTextArea();
    private JButton sendButton = new JButton("SEND");
    private JButton helpButton = new JButton("Help");
    private boolean waitForOption = true;
    private int selectedOption = -1;    // Define email credentials securely (consider using environment variables)
    private static final String EMAIL_USERNAME = "your_email@gmail.com";
    private static final String EMAIL_PASSWORD = "your_password";
    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final String SMTP_PORT = "587";    // Declare helpTextArea and helpDialog as instance variables
    private JTextArea helpTextArea;
    private JDialog helpDialog;    public Library() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("ChatBot");        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(240, 240, 240));        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(new Color(65, 105, 225));        JLabel kindleLabel = new JLabel(" Kindle library");
        kindleLabel.setForeground(Color.WHITE);
        kindleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        kindleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topBar.add(kindleLabel, BorderLayout.CENTER);        helpButton.setBackground(new Color(255, 69, 0));
        helpButton.setForeground(Color.WHITE);
        helpButton.setFont(new Font("Arial", Font.BOLD, 16));
        helpButton.setFocusPainted(false);
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showHelpDialog();
            }
        });
        topBar.add(helpButton, BorderLayout.EAST);        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        chatArea.setBackground(Color.BLACK);
        chatArea.setForeground(Color.WHITE);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));
        chatArea.setEditable(false);        chatField.setBackground(Color.WHITE);
        chatField.setForeground(Color.BLACK);
        chatField.setFont(new Font("Arial", Font.PLAIN, 16));
        chatField.setBorder(new LineBorder(Color.BLACK, 1));
        chatField.setPreferredSize(new Dimension(chatField.getPreferredSize().width, 80));        sendButton.setBackground(new Color(65, 105, 225));
        sendButton.setForeground(Color.WHITE);
        sendButton.setFont(new Font("Arial", Font.BOLD, 16));
        sendButton.setFocusPainted(false);        JPanel chatInputPanel = new JPanel(new BorderLayout());
        chatInputPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        chatInputPanel.setBackground(new Color(240, 240, 240));
        chatInputPanel.add(chatField, BorderLayout.CENTER);
        chatInputPanel.add(sendButton, BorderLayout.EAST);        mainPanel.add(topBar, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(chatInputPanel, BorderLayout.SOUTH);        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });        chatField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });        add(mainPanel);        appendText("ChatBot: Hey, I am Your Library component bot! Which component would you like to know about?\n", Color.GREEN);
        appendText("1 - Filter\n", Color.YELLOW);
        appendText("2 - Sort\n", Color.YELLOW);
        appendText("3 - Collection\n", Color.YELLOW);
        appendText("4 - Remote License Release(RLR)\n", Color.YELLOW);
        appendText("5 - House Hold Sharing(HHS)\n", Color.YELLOW);
    }    public void appendText(String s, Color color) {
        StyledDocument doc = chatArea.getStyledDocument();
        Style style = chatArea.addStyle("ColorStyle", null);
        StyleConstants.setForeground(style, color);        try {
            if (s.startsWith("ChatBot:")) {
                doc.insertString(doc.getLength(), "\uD83E\uDD16 ", style);
                s = s.substring(8);
            }            if (!waitForOption || !s.startsWith("You selected")) {
                doc.insertString(doc.getLength(), "\n" + s, style);
            } else {
                doc.insertString(doc.getLength(), s, style);
            }            StyleConstants.setForeground(style, Color.GREEN);
    } catch (BadLocationException e) {
        e.printStackTrace();
    }
}    public void handleOptionChoice(String input) {
    try {
        int choice = Integer.parseInt(input);
        if (choice >= 1 && choice <= 5) {
            waitForOption = false;
            selectedOption = choice;
            switch (choice) {
                case 1:
                    appendText("\n\uD83E\uDD16 You selected Filter", Color.GREEN);
                    appendText("\n- Filters options refer to the various criteria and settings that you can apply to refine and narrow down your book selection.", Color.WHITE);
                    appendText("\n- By using these filter options, you can quickly find and organize your digital books to suit your reading preferences and needs.", Color.WHITE);
                    appendText("\n- This makes it easier to locate specific books or discover new ones in your Kindle library.", Color.WHITE);
                    appendText("\n\nDo you want to know more with all the details and videos on the component?\n", Color.GREEN);
                    appendText("1 - Yes\n2 - No\n", Color.GREEN);
                    break;
                case 2:
                    appendText("\n\uD83E\uDD16 You selected Sort", Color.GREEN);
                    appendText("\n- Sorting allows you to arrange your books in a specific order based on different criteria like title, author, publication date, etc.", Color.WHITE);
                    appendText("\n- It helps you quickly find the book you're looking for.", Color.WHITE);
                    appendText("\n\nDo you want to know more with all the details and videos on the component?\n", Color.GREEN);
                    appendText("1 - Yes\n2 - No\n", Color.GREEN);
                    break;
                case 3:
                    appendText("\n\uD83E\uDD16 You selected Collection", Color.GREEN);
                    appendText("\n- Collections help you group your books based on certain criteria, making it easier to organize and find them.", Color.WHITE);
                    appendText("\n- You can create collections based on genres, authors, or any other preferences you have.", Color.WHITE);
                    appendText("\n\nDo you want to know more with all the details", Color.GREEN);
                    appendText("1 - Yes\n2 - No\n", Color.GREEN);
                    break;
                case 4:
                    appendText("\n\uD83E\uDD16 You selected Remote License Release(RLR)", Color.GREEN);
                    appendText("\n- Remote License Release (RLR) allows you to manage the licenses for your eBooks remotely.", Color.WHITE);
                    appendText("\n- It helps you free up licenses for books you're not currently reading.", Color.WHITE);
                    appendText("\n\nDo you want to know more with all the details and videos on the component?\n", Color.GREEN);
                    appendText("1 - Yes\n2 - No\n", Color.GREEN);
                    break;
                case 5:
                    appendText("\n\uD83E\uDD16 You selected House Hold Sharing(HHS)", Color.GREEN);
                    appendText("\n- House Hold Sharing (HHS) allows you to share your Kindle content with other family members.", Color.WHITE);
                    appendText("\n- It lets you link Amazon accounts and access shared content.", Color.WHITE);
                    appendText("\n\nDo you want to know more with all the details and videos on the component?\n", Color.GREEN);
                    appendText("1 - Yes\n2 - No\n", Color.GREEN);
                    break;
            }
        } else {
            appendText("ChatBot: Invalid option. Choose an option between 1 and 5.\n", Color.RED);
        }
    } catch (NumberFormatException ex) {
        appendText("ChatBot: Invalid input. Please enter a number between 1 and 5.\n", Color.RED);
    }
}    private void sendMessage() {
    String text = chatField.getText().trim().toLowerCase();
    chatField.setText("");
    if (waitForOption) {
        handleOptionChoice(text);
    } else {
        if (selectedOption >= 1 && selectedOption <= 5) {
            if (text.equals("1")) {
                String url = "";
                if (selectedOption == 1) {
                    url = "https://w.amazon.com/bin/view/Wiki.labcollab.net/Kindle%2BEreader%2BTest%2BData%2BRepositary/Filters";
                } else if (selectedOption == 2) {
                    url = "https://w.amazon.com/bin/view/Wiki.labcollab.net/Kindle%2BEreader%2BTest%2BData%2BRepositary/Sort";
                } else if (selectedOption == 3) {
                    url = "https://w.amazon.com/bin/view/Wiki.labcollab.net/Kindle%2BEreader%2BTest%2BData%2BRepositary/Collections";
                } else if (selectedOption == 4) {
                    url = "https://w.amazon.com/bin/view/Wiki.labcollab.net/Kindle%2BEreader%2BTest%2BData%2BRepositary/RLR";
                } else if (selectedOption == 5) {
                    url = "https://wiki.labcollab.net/confluence/display/KCP/Amazon+Household+Sharing";
                }
                // Use relative path for ChromeDriver
                System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
                WebDriver driver = new ChromeDriver();
                driver.get(url);
                driver.manage().window().maximize();
            } else if (text.equals("2")) {
                waitForOption = true;
                selectedOption = -1;
                appendText("\n\uD83E\uDD16 ChatBot: You selected option - 2, Moving to the Main menu\n", Color.CYAN);
                appendText("1 - Filter\n", Color.YELLOW);
                appendText("2 - Sort\n", Color.YELLOW);
                appendText("3 - Collection\n", Color.YELLOW);
                appendText("4 - Remote License Release(RLR)\n", Color.YELLOW);
                appendText("5 - House Hold Sharing(HHS)\n", Color.YELLOW);
            } else {
                appendText("ChatBot: Invalid input. Please enter 1 for 'Yes' or 2 for 'No'.\n", Color.RED);
            }
        }
    }
}    private void showHelpDialog() {
    helpDialog = new JDialog(this, "Help", true);
    helpDialog.setSize(400, 300);
    helpDialog.setLocationRelativeTo(this);        helpTextArea = new JTextArea();
    helpTextArea.setFont(new Font("Arial", Font.PLAIN, 16));        JButton submitButton = new JButton("Submit");
    submitButton.setFont(new Font("Arial", Font.BOLD, 16));
    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String helpText = helpTextArea.getText();
            List<String> adminEmails = new ArrayList<String>();
            adminEmails.add("debashns@amazon.com");
            adminEmails.add("javsebas@amazon.com"); // Add your admin email addresses here
            notifyAdmin(adminEmails, helpText);
            JOptionPane.showMessageDialog(helpDialog, "Your request has been submitted");
            helpDialog.dispose();
        }
    });    
    JPanel dialogPanel = new JPanel(new BorderLayout());
    dialogPanel.add(new JScrollPane(helpTextArea), BorderLayout.CENTER);
    dialogPanel.add(submitButton, BorderLayout.SOUTH);        helpDialog.add(dialogPanel);
    helpDialog.setVisible(true);
}    private void notifyAdmin(List<String> adminEmails, String query) {
    Properties properties = new Properties();
    properties.put("mail.smtp.host", SMTP_HOST);
    properties.put("mail.smtp.port", SMTP_PORT);
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");        Session session = Session.getDefaultInstance(properties, new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(EMAIL_USERNAME, EMAIL_PASSWORD);
        }
    });        try {
        for (String adminEmail : adminEmails) {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_USERNAME));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(adminEmail));
            message.setSubject("Kindle Chatbot New User Query");
            message.setText("User query:\n\n" + query);                Transport.send(message);
            System.out.println("Admin Notification: Email notification sent successfully to " + adminEmail);
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.err.println("Admin Notification: Email notification failed to send.");
    }
}    public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            new Library().setVisible(true);
        }
    });
}
}


