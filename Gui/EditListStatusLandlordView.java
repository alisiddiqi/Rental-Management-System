package Gui;

import Model.Listing;

import java.util.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EditListStatusLandlordView implements Component{
    private ArrayList<Listing> listings = new ArrayList<Listing>();
    List<String[]> values = new ArrayList<String[]>();
    private JTable table = new JTable();
    private JScrollPane scrollPane = new JScrollPane();
    private JButton RegisterBtn= new JButton("Register a Property");
    private JButton ListingsBtn= new JButton("Listings");
    private JButton MessagesBtn= new JButton("Messages");
    private JLabel idOfProp = new JLabel("Enter the the ID of the property you wish to edit the status for:");
    private JButton submitChange = new JButton("Submit");
    private JLabel changedStatus = new JLabel("Enter the new status for the property:");


    private JButton payBtn = new JButton("Pay");
    private JLabel idForPayLabel = new JLabel("Enter the property ID for which you will pay the fee:");
    private JTextField idInputForPay = new JTextField();
    private JComboBox IDList = new JComboBox();
    private JComboBox IDListTwo = new JComboBox();
    private String[] statuses = {"Active", "Canceled", "Suspended", "Rented"};
    private JComboBox StatusList = new JComboBox(statuses);

    private Color back = new Color(25, 25, 112);
    private Color button = new Color(0,0,0);
    private Color tableBack = new Color(31,97,141);
    private Color headBack = new Color(21,67,96);

    
    public EditListStatusLandlordView() {
    	
    }
    
    public EditListStatusLandlordView(ArrayList<Listing> input)
    {
        setTable(input);
        // draw();
    }

    public void setTable(ArrayList<Listing> input)
    {
        Object columnNames[] = { "Property ID", "Type", "Bedrooms", "Bathrooms", "Furnished", "Quadrant", "Status", "Balance"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        IDList.removeAllItems();
        IDListTwo.removeAllItems();
        for(int i=0; i< input.size(); i++) {
            Object rowData[] = {input.get(i).getListingID(), input.get(i).getPropertyType(),
                    input.get(i).getNumbedRooms(), input.get(i).getNumbathRooms(),
                    input.get(i).getIsFurnished(), input.get(i).getQuadrant(), input.get(i).getStatus(),
            input.get(i).getBalance()};
            model.addRow(rowData);

            IDList.addItem(input.get(i).getListingID());
            IDListTwo.addItem(input.get(i).getListingID());
        }
        table.setModel(model);
        System.out.println("here");
        System.out.println("here");
    }

    @Override
    public void draw()
    {	
        frame.getContentPane().removeAll();
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
        frame.setTitle("Edit Status Landlord");  //Giving frame the size set and title
        frame.setResizable(true);
        frame.setSize(900,900);

        JPanel navBarpanel = new JPanel(); //Setting navbar sizes and adding buttons to it
        navBarpanel.add(RegisterBtn);
        navBarpanel.add(ListingsBtn);
        navBarpanel.add(MessagesBtn);
        navBarpanel.setSize(frame.getWidth(),50);
        navBarpanel.setLayout(new GridLayout());

        RegisterBtn.setBackground(button);
        ListingsBtn.setBackground(button);
        MessagesBtn.setBackground(button);
        RegisterBtn.setForeground(Color.WHITE);
        ListingsBtn.setForeground(Color.WHITE);
        MessagesBtn.setForeground(Color.WHITE);

        submitChange.setForeground(Color.white);
        submitChange.setBackground(button);
        payBtn.setBackground(button);
        payBtn.setForeground(Color.white);

        idOfProp.setBounds(50,460,400,20);
        IDListTwo.setBounds(50,480,400,30);
        changedStatus.setBounds(50,530,400,20);
        StatusList.setBounds(50,550,400,30);
        submitChange.setBounds(50, 600,400,30);

        idOfProp.setForeground(Color.white);
        idForPayLabel.setForeground(Color.white);
        changedStatus.setForeground(Color.white);

        idForPayLabel.setBounds(540,460,300,20);
        IDList.setBounds(540,490,300,30);
        payBtn.setBounds(540,530,300,30);

        table.setBackground(tableBack);
        table.setForeground(Color.white);
        table.getTableHeader().setBackground(headBack);
        table.getTableHeader().setForeground(Color.white);

        table.setBounds(30,100,500,300);
        table.setRowHeight(20);
        scrollPane.setViewportView(table);
        scrollPane.setBounds(30, 100, 800, 300);
        frame.getContentPane().setBackground(back);
        frame.getContentPane().add(scrollPane);
        frame.add(navBarpanel);
        frame.add(payBtn);
        frame.add(IDList);
        frame.add(idForPayLabel);
        frame.add(idOfProp);
        frame.add(StatusList);
        frame.add(IDListTwo);
        frame.add(changedStatus);
        frame.add(submitChange);
        frame.setLayout(null);
        frame.setVisible(true);
        System.out.println("in draw");
    }
    
    public void visible() {
    	draw();
    }

    // public static void main(String []args)
    // {
    //     ArrayList <Listing> in = new ArrayList<Listing>();
    //     in.add(new Listing(1, "Apartment", 4, 5, true, "NE", "10:10", "106 5th Ave", "johndoe@gmail.com", "Active", true));
    //     in.add(new Listing(2, "Apartment", 2, 2, true, "SW", "10:10", "202 3rd Ave", "johndoe@gmail.com", "Active", true));
    //     EditListStatusLandlordView x = new EditListStatusLandlordView(in);
    //     Listing obj = new Listing(2, "Apartment", 2, 2, true, "SW", "10:10", "90 6th Ave", "johndoe@gmail.com", "Active", true);
    //     System.out.println(obj.getID());
    // }

    public void RegisterPerformed(ActionListener a) //For register property navbar redirect
    {
        this.RegisterBtn.addActionListener(a);
    }

    public void ListingsPerformed(ActionListener a) // For Listings navbar redirect
    {
        this.ListingsBtn.addActionListener(a);
    }

    public void MessagesPerformed(ActionListener a) //For messages navbar redirect
    {
        this.MessagesBtn.addActionListener(a);
    }

    public void updateStatus(ActionListener a) //For update status of form button
    {
        this.submitChange.addActionListener(a);
    }

    public void paySubmission(ActionListener a) //For submitting your fee payment
    {
        this.payBtn.addActionListener(a);
    }

    public String getpayInput()
    {
        return Integer.toString((int)IDList.getSelectedItem());
    }

    public String getIDForStatusUpdateInput()
    {
        return Integer.toString((int)IDListTwo.getSelectedItem());
    }

    public String getStatus()
    {
        return (String)StatusList.getSelectedItem();
    }
}
