package ui;

import model.ItemMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;


public class Begin {
    ItemMap itemMap = new ItemMap();

    public void begin() {
        optionWindow();
    }

    public void optionWindow() {
        JFrame optionFrame = getjFrameOption("options");

        JPanel optionPanel = new JPanel();
        JLabel label1 = getjLabelOne("Welcome to put in your item!", 30000);
        JLabel label2 = getjLabelOne("Please tell me what do you wanna do by typing", 20000);

        JButton forAdd = getjButtonAdd();


        JButton forShow = getjButtonShow();

        JButton forRemove = getjButtonRemove();

        JButton forList = getjButtonList();


        JButton forLeave = getjButtonLeave(optionFrame, "Exit the program", 5000, 3000, 9500);

        optionPanel.add(label1);
        optionPanel.add(label2);
        optionPanel.add(forAdd);
        optionPanel.add(forShow);
        optionPanel.add(forRemove);
        optionPanel.add(forList);
        optionPanel.add(forLeave);

        optionFrame.add(optionPanel);
        optionFrame.setVisible(true);
    }

    private JButton getjButtonLeave(JFrame optionFrame, String s, int i, int i2, int i3) {
        JButton forLeave = new JButton();
        forLeave.setText(s);
        forLeave.setBounds(i, i2, i3, i2);
        forLeave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                optionFrame.dispose();
            }
        });
        return forLeave;
    }

    private JButton getjButtonList() {
        JButton forList = new JButton();
        forList.setText("List all items' information");
        forList.setBounds(5000,6000,9500,3000);
        forList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listWindow();
            }
        });
        return forList;
    }

    private JButton getjButtonRemove() {
        JButton forRemove = new JButton();
        forRemove.setText("Remove requested item");
        forRemove.setBounds(5000,9000,9500,3000);
        forRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeWindow();
            }
        });
        return forRemove;
    }

    private JButton getjButtonShow() {
        JButton forShow = new JButton();
        forShow.setText("Show requested item's information");
        forShow.setBounds(5000,12000,9500,3000);
        forShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showWindow();
            }
        });
        return forShow;
    }

    private JButton getjButtonAdd() {
        JButton forAdd = new JButton();
        forAdd.setText("Put in my item");
        forAdd.setBounds(5000,15000,9500,3000);
        forAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addWindow();
            }
        });
        return forAdd;
    }

    private JLabel getjLabelOne(String s, int i) {
        JLabel label1 = new JLabel(s);
        label1.setBounds(5000, i, 10000, 3000);
        label1.setBackground(Color.red);
        return label1;
    }

    private JFrame getjFrameOption(String options) {
        JFrame optionFrame = new JFrame(options);
        optionFrame.setLocation(500, 500);
        optionFrame.setSize(1500, 1500);
        optionFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return optionFrame;
    }

    public void addWindow() {
        JFrame addFrame = getjFrameOption("First choice: add");
        addFrame.setBounds(500, 500, 1250, 1000);
        JPanel addPanel = new JPanel();
        JLabel nameLabel = new JLabel("Name：");
        JTextField nameField = new JTextField();
        nameField.setColumns(100);
        addPanel.add(nameLabel);
        addPanel.add(nameField);
        JLabel locationLabel = new JLabel("Location：");
        JTextField locationField = new JTextField();
        locationField.setColumns(100);

        JButton forEnter = getjButtonEnter(addFrame, nameField, locationField);

        addPanel.add(locationLabel);
        addPanel.add(locationField);
        addPanel.add(forEnter);
        addFrame.add(addPanel);
        addFrame.setVisible(true);
    }

    private JButton getjButtonEnter(JFrame addFrame, JTextField nameField, JTextField locationField) {
        JButton forEnter = new JButton();
        forEnter.setText("Enter");
        forEnter.setBounds(500,1500,950,300);
        forEnter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String location = locationField.getText();
                conditionEnter(name, location, addFrame);
            }
        });
        return forEnter;
    }

    private void conditionEnter(String name, String location, JFrame addFrame) {
        if (itemMap.checkContainsKey(name)) {
            JFrame warning1 = new JFrame();
            JOptionPane.showMessageDialog(warning1,"The item with same name is on the list.");
            JOptionPane.showMessageDialog(warning1,"Unsuccessfully added new item.");
        } else {
            itemMap.addItem(name, location);
            String infoAdd = "Your item " + name + " is at " + itemMap.showValue(name) + " now";
            JFrame warning8 = new JFrame();
            JOptionPane.showMessageDialog(warning8,infoAdd);
            System.out.println("Your item " + name + " is at " + itemMap.showValue(name) + " now");
        }
        addFrame.dispose();
    }

    public void showWindow() {
        JFrame showFrame = getjFrameOption("Second choice: show");
        showFrame.setBounds(500, 500, 1250, 1000);
        JPanel showPanel = new JPanel();

        JLabel nameLabelSecond = new JLabel("Name：");
        JTextField nameFieldSecond = new JTextField();
        nameFieldSecond.setColumns(100);
        showPanel.add(nameLabelSecond);
        showPanel.add(nameFieldSecond);

        JButton forEnterSecond = getjButtonEnterSecond(showFrame, nameFieldSecond);

        showPanel.add(forEnterSecond);
        showFrame.add(showPanel);
        showFrame.setVisible(true);
    }

    private JButton getjButtonEnterSecond(JFrame showFrame, JTextField nameFieldSecond) {
        JButton forEnterSecond = new JButton();
        forEnterSecond.setText("Enter");
        forEnterSecond.setBounds(500,1500,950,300);
        forEnterSecond.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nameSecond = nameFieldSecond.getText();
                conditionEnterSecond(nameSecond, showFrame);
            }
        });
        return forEnterSecond;
    }

    private void conditionEnterSecond(String nameSecond, JFrame showFrame) {
        if (itemMap.checkEmpty()) {
            JFrame warning2 = new JFrame();
            System.out.println("Nothing on the list");
            JOptionPane.showMessageDialog(warning2,"The list is empty.");
            JOptionPane.showMessageDialog(warning2,"Unsuccessfully showed information");
        } else if (!itemMap.checkContainsKey(nameSecond)) {
            JFrame warning3 = new JFrame();
            System.out.println("The requested item is not on the list");
            JOptionPane.showMessageDialog(warning3,"The requested item is not on the list");
            JOptionPane.showMessageDialog(warning3,"Unsuccessfully showed information");
        } else {
            JFrame warning4 = new JFrame();
            System.out.println("Your item "  + nameSecond + " is at " + itemMap.showValue(nameSecond) + " now");
            String infoShow = "Your item " + nameSecond + " is at " + itemMap.showValue(nameSecond) + " now";
            JOptionPane.showMessageDialog(warning4,infoShow);
        }
        showFrame.dispose();
    }

    public void removeWindow() {
        JFrame removeFrame = getjFrameOption("Third choice: remove");
        removeFrame.setBounds(500, 500, 1250, 1000);
        JPanel removePanel = new JPanel();

        JLabel nameLabelThird = new JLabel("Name：");
        JTextField nameFieldThird = new JTextField();
        nameFieldThird.setColumns(100);
        removePanel.add(nameLabelThird);
        removePanel.add(nameFieldThird);

        JButton forEnterThird = getjButtonEnterThird(removeFrame, nameFieldThird);

        removePanel.add(forEnterThird);
        removeFrame.add(removePanel);
        removeFrame.setVisible(true);
    }

    private JButton getjButtonEnterThird(JFrame removeFrame, JTextField nameFieldThird) {
        JButton forEnterThird = new JButton();
        forEnterThird.setText("Enter");
        forEnterThird.setBounds(500,1500,950,300);
        forEnterThird.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nameThird = nameFieldThird.getText();
                conditionEnterThird(nameThird);
                removeFrame.dispose();
            }
        });
        return forEnterThird;
    }

    private void conditionEnterThird(String nameThird) {
        if (itemMap.checkEmpty()) {
            JFrame warning5 = new JFrame();
            System.out.println("Nothing on the list");
            JOptionPane.showMessageDialog(warning5,"The list is empty.");
            JOptionPane.showMessageDialog(warning5,"Unsuccessfully removed item");
        } else if (!itemMap.checkContainsKey(nameThird)) {
            JFrame warning6 = new JFrame();
            System.out.println("The requested item is not on the list");
            JOptionPane.showMessageDialog(warning6,"The requested item is not on the list");
            JOptionPane.showMessageDialog(warning6,"Unsuccessfully removed item");
        } else {
            itemMap.removeItem(nameThird);
            JFrame warning7 = new JFrame();
            System.out.println(nameThird + " is not on the list now");
            JOptionPane.showMessageDialog(warning7,"Your item " + nameThird + " is not on the list now");
        }
    }

    public void listWindow() {
        JFrame listFrame = getjFrameOption("Item List");
        listFrame.setBounds(500, 500, 1250, 1000);
        JPanel listPanel = new JPanel();
        JTable table = getjTable();

        JButton forExitTable = getjButtonLeave(listFrame, "Exit the Table", 500, 300, 950);

        listPanel.add(table);
        listPanel.add(forExitTable);
        listFrame.add(listPanel);
        listFrame.setSize(5000, 2000);
        listFrame.setVisible(true);
    }

    private JTable getjTable() {
        JTable table = new JTable(itemMap.getItemMap().size() + 1,2);
        table.setBounds(300, 400, 2000, 3000);
        table.setValueAt("Name", 0, 0);
        table.setValueAt("Location", 0, 1);

        int row = 1;
        for (Map.Entry<String,String> entry: itemMap.getItemMap().entrySet()) {
            table.setValueAt(entry.getKey(),row,0);
            table.setValueAt(entry.getValue(),row,1);
            row++;
        }
        return table;
    }


}
