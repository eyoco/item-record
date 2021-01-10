package ui;

import model.ItemMap;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class Begin {
    ItemMap itemMap = new ItemMap();
    int fieldSize = 110;
    Font font = new Font("Dialog",1,30);
    Font fontMessage = new Font("Arial",Font.BOLD,30);
    Dimension dimensionButtom = new Dimension(800,150);
    Dimension dimensionButtomSecond = new Dimension(800,75);
    Dimension dimensionLabelHead = new Dimension(800,50);
    Dimension dimensionLabelSub = new Dimension(200,50);
    Rectangle rectangleWindowSub = new Rectangle(500,500,3500,300);
    Dimension dimensionField = new Dimension(100,150);

    public void begin() {
        optionWindow();
    }

    public void optionWindow() {
        JFrame optionFrame = getjFrameOption("options");

        JPanel optionPanel = getOptionPanel(Color.CYAN);
        JLabel label1 = getjLabelOne("Welcome to put in your item!", 30000);
        JLabel label2 = getjLabelOne("Please tell me what you wanna do by clicking buttons", 20000);

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

    private JPanel getOptionPanel(Color cyan) {
        JPanel optionPanel = new JPanel();
        optionPanel.setBackground(cyan);
        return optionPanel;
    }

    private JButton getjButtonLeave(JFrame optionFrame, String s, int i, int i2, int i3) {
        JButton forLeave = new JButton();
        forLeave.setText(s);
        forLeave.setBounds(i, i2, i3, i2);
        forLeave.setPreferredSize(dimensionButtom);
        forLeave.setFont(font);
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
        forList.setPreferredSize(dimensionButtom);
        forList.setFont(font);
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
        forRemove.setPreferredSize(dimensionButtom);
        forRemove.setFont(font);
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
        forShow.setPreferredSize(dimensionButtom);
        forShow.setFont(font);
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
        forAdd.setPreferredSize(dimensionButtom);
        forAdd.setFont(font);
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
        label1.setPreferredSize(dimensionLabelHead);
        label1.setFont(font);
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
        addFrame.setBounds(rectangleWindowSub);

        JPanel addPanel = getOptionPanel(Color.PINK);

        JLabel nameLabel = getNameLabel();

        JTextField nameField = getNameField();

        addPanel.add(nameLabel);
        addPanel.add(nameField);

        JLabel locationLabel = new JLabel("Location：");
        locationLabel.setPreferredSize(dimensionLabelSub);
        locationLabel.setFont(font);

        JTextField locationField = getNameField();

        JButton forEnter = getjButtonEnter(addFrame, nameField, locationField);

        addPanel.add(locationLabel);
        addPanel.add(locationField);
        addPanel.add(forEnter);
        addFrame.add(addPanel);
        addFrame.setVisible(true);
    }

    private JTextField getNameField() {
        JTextField nameField = new JTextField();
        nameField.setBounds(50,100,200,30);
        nameField.setColumns(fieldSize);
        nameField.setFont(font);
        return nameField;
    }

    private JLabel getNameLabel() {
        JLabel nameLabel = new JLabel("Name：");
        nameLabel.setFont(font);
        nameLabel.setPreferredSize(dimensionLabelSub);
        return nameLabel;
    }

    private JButton getjButtonEnter(JFrame addFrame, JTextField nameField, JTextField locationField) {
        JButton forEnter = new JButton();
        forEnter.setText("Enter");
        forEnter.setBounds(500,1500,950,300);
        forEnter.setPreferredSize(dimensionButtomSecond);
        forEnter.setFont(font);
        forEnter.setContentAreaFilled(false);
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
            JLabel labelEnterTrue = new JLabel("The item with same name is on the list.Unsuccessfully added");
            labelEnterTrue.setFont(fontMessage);
            JOptionPane.showMessageDialog(null,labelEnterTrue,"Message",JOptionPane.WARNING_MESSAGE);
        } else {
            itemMap.addItem(name, location);
            String infoAdd = "Your item " + name + " is at " + itemMap.showValue(name) + " now";
            JLabel labelEnterFalse = new JLabel(infoAdd);
            labelEnterFalse.setFont(fontMessage);
            JOptionPane.showMessageDialog(null,labelEnterFalse,"Message",JOptionPane.WARNING_MESSAGE);
            System.out.println("Your item " + name + " is at " + itemMap.showValue(name) + " now");
        }
        addFrame.dispose();
    }

    public void showWindow() {
        JFrame showFrame = getjFrameOption("Second choice: show");
        showFrame.setBounds(rectangleWindowSub);
        JPanel showPanel = getOptionPanel(Color.YELLOW);

        JLabel nameLabelSecond = getNameLabel();
        JTextField nameFieldSecond = new JTextField();
        nameFieldSecond.setColumns(fieldSize);
        nameFieldSecond.setFont(font);
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
        forEnterSecond.setFont(font);
        forEnterSecond.setPreferredSize(dimensionButtomSecond);
        forEnterSecond.setContentAreaFilled(false);
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
            System.out.println("Nothing on the list");
            getSecondEmptyLabel();
        } else if (!itemMap.checkContainsKey(nameSecond)) {
            System.out.println("The requested item is not on the list");
            String secondFalse = "The requested item is not on the list.\nUnsuccessfully showed information.";
            JLabel labelEnterSecondFalse = new JLabel(secondFalse);
            labelEnterSecondFalse.setFont(fontMessage);
            JOptionPane.showMessageDialog(null, labelEnterSecondFalse, "Message", JOptionPane.WARNING_MESSAGE);
        } else {
            System.out.println("Your item "  + nameSecond + " is at " + itemMap.showValue(nameSecond) + " now");
            String infoShow = "Your item " + nameSecond + " is at " + itemMap.showValue(nameSecond) + " now";
            JLabel labelEnterSecondTrue = new JLabel(infoShow);
            labelEnterSecondTrue.setFont(fontMessage);
            JOptionPane.showMessageDialog(null,labelEnterSecondTrue,"Message",JOptionPane.WARNING_MESSAGE);
        }
        showFrame.dispose();
    }

    private void getSecondEmptyLabel() {
        JLabel labelEnterSecondEmpty = new JLabel("The list is empty.\nUnsuccessfully showed information.");
        labelEnterSecondEmpty.setFont(fontMessage);
        JOptionPane.showMessageDialog(null,labelEnterSecondEmpty,"Message",JOptionPane.WARNING_MESSAGE);
    }

    public void removeWindow() {
        JFrame removeFrame = getjFrameOption("Third choice: remove");
        removeFrame.setBounds(rectangleWindowSub);
        JPanel removePanel = getOptionPanel(Color.LIGHT_GRAY);

        JLabel nameLabelThird = new JLabel("Name：");
        nameLabelThird.setPreferredSize(dimensionLabelSub);
        nameLabelThird.setFont(font);
        JTextField nameFieldThird = new JTextField();
        nameFieldThird.setColumns(fieldSize);
        nameFieldThird.setFont(font);
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
        forEnterThird.setPreferredSize(dimensionButtomSecond);
        forEnterThird.setFont(font);
        forEnterThird.setContentAreaFilled(false);
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
            System.out.println("Nothing on the list");
            getSecondEmptyLabel();
        } else if (!itemMap.checkContainsKey(nameThird)) {
            System.out.println("The requested item is not on the list");
            String thirdFalse = "The requested item is not on the list.\nUnsuccessfully showed information.";
            JLabel labelEnterThirdFalse = new JLabel(thirdFalse);
            labelEnterThirdFalse.setFont(fontMessage);
            JOptionPane.showMessageDialog(null,labelEnterThirdFalse,"Message",JOptionPane.WARNING_MESSAGE);
        } else {
            itemMap.removeItem(nameThird);
            System.out.println(nameThird + " is not on the list now");
            String infoRemove = "Your item " + nameThird + " is not on the list now";
            JLabel labelEnterThirdTrue = new JLabel(infoRemove);
            labelEnterThirdTrue.setFont(fontMessage);
            JOptionPane.showMessageDialog(null,labelEnterThirdTrue,"Message",JOptionPane.WARNING_MESSAGE);
        }
    }

    public void listWindow() {
        JFrame listFrame = getjFrameOption("Item List");
        listFrame.setBounds(rectangleWindowSub);
        JPanel listPanel = new JPanel();
        JTable table = getjTable();

        JButton forExitTable = getjButtonLeave(listFrame, "Exit the Table", 500, 300, 950);
        JScrollPane itemMapSp = new JScrollPane(table);
        itemMapSp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        itemMapSp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        itemMapSp.add(forExitTable);
        listFrame.add(itemMapSp);
        listFrame.setSize(500, 200);
        listFrame.setVisible(true);
    }

    private JTable getjTable() {
        Object[][] arrItemMap = new Object[itemMap.getItemMap().size()][2];
        Set mapEntries = itemMap.getItemMap().entrySet();
        Iterator mapIterator = mapEntries.iterator();

        int rowIndex = 0;

        while (mapIterator.hasNext()) {
            Map.Entry itemMapping = (Map.Entry) mapIterator.next();
            arrItemMap[rowIndex][0] = itemMapping.getKey();
            arrItemMap[rowIndex][1] = itemMapping.getValue();
            rowIndex++;
        }

        String[] columnNames = {"Name", "Location"};
        JTable table = new JTable(arrItemMap,columnNames);

        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(font);

        table.setFont(font);
        table.setRowHeight(40);

        return table;
    }

}
