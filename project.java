import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import javax.swing.ImageIcon;
import java.time.format.DateTimeFormatter;

class project extends JFrame implements ActionListener {

    JButton rules, back;
    JTextField tfname;

    project() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Specify the file path of the image
        String imagePath = "C:/Users/91951/OneDrive/Desktop/JAVA/login.jpg";

        // Check if the image path is not null
        if (imagePath != null) {
            try {
                // Create ImageIcon using the image path
                ImageIcon imageIcon = new ImageIcon(imagePath);

                // Create JLabel with the ImageIcon
                JLabel imageLabel = new JLabel(imageIcon);

                // Set the bounds of the image label
                imageLabel.setBounds(0, 0, 600, 500);

                // Add the image label to the frame
                add(imageLabel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        JLabel heading = new JLabel("Quiz Tech");
        heading.setBounds(750, 60, 300, 45);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel name = new JLabel("Enter your name");
        name.setBounds(810, 150, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(Color.MAGENTA);
        add(name);

        tfname = new JTextField();
        tfname.setBounds(735, 200, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);

        back = new JButton("Back");
        back.setBounds(915, 270, 120, 25);
        back.setBackground(Color.RED);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        rules = new JButton("Next");
        rules.setBounds(735, 270, 120, 25);
        rules.setBackground(Color.GREEN);
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);

        setSize(1200, 500);
        setLocation(200, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rules) {
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new project();
    }
}

class Rules extends JFrame implements ActionListener {

    String name;
    JButton start, back;

    Rules(String name) {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Welcome " + name + " to QUIZ TECH");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
                "<html>" +
                        "1. You are trained to be a programmer and not a story teller, answer point to point"
                        + "<br><br>" +
                        "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer"
                        + "<br><br>" +
                        "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>"
                        +
                        "4. Crying is allowed but please do so quietly." + "<br><br>" +
                        "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
                        "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di"
                        + "<br><br>" +
                        "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
                        "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
                        "<html>");
        add(rules);

        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30);
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);

        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name);
        } else {
            setVisible(false);
            new project();
        }
    }
}

class Quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score;

    String name;

    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        // Specify the file path of the image
        String imagePath = "C:/Users/91951/OneDrive/Desktop/JAVA/quiz.jpg";

        // Check if the image path is not null
        if (imagePath != null) {
            try {
                // Create ImageIcon using the image path
                ImageIcon imageIcon = new ImageIcon(imagePath);

                // Create JLabel with the ImageIcon
                JLabel imageLabel = new JLabel(imageIcon);

                // Set the bounds of the image label
                imageLabel.setBounds(0, 0, 1440, 392);

                // Add the image label to the frame
                add(imageLabel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 630, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1100, 710, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }

    public int calculateScore() {
        score = 0;
        for (int i = 0; i < 10; i++) {
            if (useranswers[i][0].equals(answers[i][1])) {
                score += 10;
            }
        }
        return score;
    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));

        if (timer > 0) {
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }

        timer--; // 14

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                setVisible(false);
                new Score(name, calculateScore());
            } else { // next button
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }

    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
    }
}

class Score extends JFrame implements ActionListener {
    private String name; // Declare an instance variable
    public int score;
    public int marks;
    JButton save, top;

    Score(String name, int score) {
        this.name = name; // Assign the constructor parameter to the instance variable
        this.score = score;
        marks = score;
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        String imagePath = "C:/Users/91951/OneDrive/Desktop/JAVA/score.png";

        // Check if the image path is not null
        if (imagePath != null) {
            try {
                // Create ImageIcon using the image path
                ImageIcon imageIcon = new ImageIcon(imagePath);
                Image i2 = imageIcon.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
                ImageIcon i3 = new ImageIcon(i2);
                JLabel image = new JLabel(i3);
                image.setBounds(0, 200, 300, 250);
                add(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        JLabel heading = new JLabel("Thank you " + name + " for playing Quiz Tech");
        heading.setBounds(45, 30, 700, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(heading);

        JLabel lblscore = new JLabel("Your score is " + score);
        lblscore.setBounds(450, 200, 300, 30);
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(lblscore);

        save = new JButton("SAVE");
        save.setBounds(365, 270, 120, 30);
        save.setBackground(new Color(30, 144, 255));
        save.setForeground(Color.WHITE);
        save.addActionListener(this);
        add(save);

        top = new JButton("TOP SCORERS");
        top.setBounds(600, 270, 120, 30);
        top.setBackground(new Color(30, 144, 255));
        top.setForeground(Color.WHITE);
        top.addActionListener(this);
        add(top);

        setVisible(true);
    }

    public String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return currentDate.format(formatter);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == save) {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/project";
                String username = "root";
                String password = "sailaja";
                Connection con = DriverManager.getConnection(url, username, password);
                System.out.println("Anna nene");
                String q = "INSERT INTO student(StudentName,Score,Datee) VALUES (?, ?, ?)";
                PreparedStatement st = con.prepareStatement(q);
                st.setString(1, name);
                st.setInt(2, marks);
                st.setString(3, getCurrentDate());
                st.executeUpdate();
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        if (ae.getSource() == top) {
            new scorers();
            // setVisible(false);
        }
    }
}

class scorers extends JFrame implements ActionListener {
    JButton play;

    scorers() {
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        String imagePath = "C:/Users/91951/OneDrive/Desktop/JAVA/highscore.jpg";

        // Check if the image path is not null
        if (imagePath != null) {
            try {
                // Create ImageIcon using the image path
                ImageIcon imageIcon = new ImageIcon(imagePath);

                // Create JLabel with the ImageIcon
                JLabel imageLabel = new JLabel(imageIcon);

                // Set the bounds of the image label
                imageLabel.setBounds(0, 0, 600, 500);

                // Add the image label to the frame
                imageLabel.setBounds(0, 200, 300, 250);
                add(imageLabel);

                setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/project";
            String username = "root";
            String password = "sailaja";
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Anna nene");
            String q = "SELECT StudentName, Score FROM student ORDER BY Score DESC LIMIT 5";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(q);
            JLabel jl = new JLabel("TOP SCORES");
            // System.out.println("Anna nene");
            jl.setBounds(380, 100, 200, 40);
            jl.setFont(new Font("Tahoma", Font.PLAIN, 22));
            jl.setBackground(Color.GREEN);
            // jl.setForeground(Color.WHITE);
            add(jl);
            int i = 40;
            while (resultSet.next()) {
                String playerName = resultSet.getString("StudentName");
                int score = resultSet.getInt("Score");
                JLabel jl2 = new JLabel(playerName + "       " + score);
                jl2.setBounds(380, 100 + i, 200, 40);
                jl2.setFont(new Font("Tahoma", Font.PLAIN, 18));
                jl2.setBackground(new Color(30, 144, 255));
                System.out.println("Anna nene");
                add(jl2);
                i = i + 30;
            }
            resultSet.close();
            statement.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        play = new JButton("PLAY AGAIN");
        play.setBounds(380, 400, 120, 30);
        play.setBackground(new Color(30, 144, 255));
        play.setForeground(Color.WHITE);
        play.addActionListener(this);
        add(play);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == play) {
            new project();
            setVisible(false);
        }
    }
}
