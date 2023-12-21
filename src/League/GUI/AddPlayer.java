package League.GUI;

import League.Person.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddPlayer extends JPanel{
    JComboBox teamsComboBox;
    public AddPlayer(ArrayList<String> teamnames){
        this.setSize(new Dimension(980, 720));
        this.setLayout(new GridLayout(2, 1));
        JPanel titlepanel = new JPanel(new GridLayout(5, 1,0,30));
        JPanel contentPanel=new JPanel(new GridLayout(1, 1));
        JPanel panel2 = new JPanel(new GridLayout(4, 1,0,50));
        JLabel titleLabel = new JLabel("Add Player");
        titleLabel.setFont(new Font("Comic Sans",Font.BOLD,35));
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlepanel.add(titleLabel);
        this.add(titlepanel);
        this.add(contentPanel);
        contentPanel.add(panel2);
        JPanel namepanel = new JPanel(new GridLayout(1, 1));
        JLabel nameLabel = new JLabel("Name");
        namepanel.add(nameLabel);
        nameLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        JTextField nameFeild = new JTextField("");
        namepanel.add(nameFeild);
        titlepanel.add(namepanel);


        JPanel agepanel = new JPanel(new GridLayout(1, 1));
        JLabel ageLabel = new JLabel("Age");
        ageLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        agepanel.add(ageLabel);
        JTextField ageFeild = new JTextField("");
        agepanel.add(ageFeild);
        titlepanel.add(agepanel);

        JPanel salarypanel = new JPanel(new GridLayout(1, 1));
        JLabel salaryLabel = new JLabel("Salary");
        salaryLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        salarypanel.add(salaryLabel);
        JTextField salaryFeild = new JTextField("");
        salarypanel.add(salaryFeild);
        titlepanel.add(salarypanel);

        JPanel rankpanel = new JPanel(new GridLayout(1, 1));
        JLabel rankLabel = new JLabel("Rank");
        rankLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        rankpanel.add(rankLabel);
        JTextField rankFeild = new JTextField("");
        rankpanel.add(rankFeild);
        panel2.add(rankpanel);


        JPanel positionspanel = new JPanel(new GridLayout(1, 1));
        JLabel positionsLabel = new JLabel("Position");
        positionsLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        positionspanel.add(positionsLabel);
        String positions[]={"GoalKeeper","Defender","Midfielder","Forward"};
        JComboBox positionsComboBox =new JComboBox(positions);
        positionspanel.add(positionsComboBox);
        panel2.add(positionspanel);

        JButton saveButton=new JButton("Save");
        saveButton.setFocusable(false);
        saveButton.setFont(new Font("Comic Sans",Font.BOLD,20));

        panel2.add(saveButton);
        System.out.println(teamnames);
        teamsComboBox = new JComboBox(new DefaultComboBoxModel<>(teamnames.toArray()));

        JPanel comboboxpanel = new JPanel(new GridLayout(1, 1));
        JLabel comboBoxLabel = new JLabel("Team");
        comboBoxLabel.setFont(new Font("Comic Sans",Font.BOLD,20));

        comboboxpanel.add(comboBoxLabel);
        comboboxpanel.add(teamsComboBox);
        this.setVisible(true);
        titlepanel.add(comboboxpanel);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String name = nameFeild.getText();
                String Age = ageFeild.getText();
                String Salary = salaryFeild.getText();
                String rank =rankFeild.getText();
                String position = (String) positionsComboBox.getItemAt(positionsComboBox.getSelectedIndex());
                String team="Null";
                try{
                    team = (String) teamsComboBox.getItemAt(teamsComboBox.getSelectedIndex());
                }
                /**
                 *
                 * @throws NullPointerException  if no team exists
                 */
                catch(NullPointerException ignorable){
                    JOptionPane.showMessageDialog(null, "Add team first");
                }
                // validation
                if (!Validation(name,Age,Salary,rank,position)) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields");

                }

                else {
                    try{
                        Integer.parseInt(Age);
                        Integer.parseInt(Salary);
                        Integer.parseInt(rank);
                        Player p=new Player(name,Integer.parseInt(Age),Integer.parseInt(Salary),team);
                    }
                    /**
                     *
                     * @throws NumberFormatException if user enters non integers
                     */
                    catch(NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Enter a valid number in salary,age and rank");
                    }

                }
            }
        });
    }
    public boolean Validation(String name,String Age,String Salary,String rank,String position){
        if (name.isEmpty()||Age.isEmpty()||Salary.isEmpty()||rank.isEmpty()||position.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all fields");
            return false;
        }
        else{
            return true;
        }
    }

    public boolean Validation(String name,String team ){
        if(name.isEmpty()||team.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
}
