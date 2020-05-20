package mayintarlasi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import sun.awt.RepaintArea;


public class Ekran extends mayinTarlasi{
    protected int ABY_dikdörtgenSayisi=10;
    protected int mayin=12;
    Date startDate = new Date();
    public int sec = 0;
    
    JFrame frm=new JFrame("ABY_Mayını Tarlası");
    public static void main(String [] args){
       
        Ekran al=new Ekran();
        al.ilkFrame();        
        
   }
   public void ilkFrame(){
    
      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frm.getContentPane().add(new mayinYerlestirme(10,12).getContent());
      frm.setSize(550,400);
      frm.setLocationRelativeTo(null);
      frm.setVisible(true);
      frm.setResizable(false);
      JMenuBar menuBar=new JMenuBar();
      menuBar.setBackground(Color.white);
      menuBar.setSize(550,100);
      oyunMenubar(menuBar);
      frm.setJMenuBar(menuBar);
                JLabel label=new JLabel("");
                label.setSize(500,20);
                label.setVisible(true);
                label.setFont(new Font("Tahoma", Font.PLAIN,70));
      
      
   }
   

  public void oyunMenubar(JMenuBar menuBar){        
        JMenu ABY_Dosya=new JMenu("Ayarlar");
        menuBar.add(ABY_Dosya);
        JMenuItem yeniOyun=new JMenuItem("Yeni oyun");
        ABY_Dosya.add(yeniOyun);
        yeniOyun.setBackground(Color.orange);
        JMenuItem Kolay_Seviye=new JMenuItem("Kolay_Seviye");
        ABY_Dosya.add(Kolay_Seviye);
        Kolay_Seviye.setBackground(Color.yellow);
        JMenuItem Orta_Seviye=new JMenuItem("Orta_Seviye");
        ABY_Dosya.add(Orta_Seviye);
        Orta_Seviye.setBackground(Color.green);
        JMenuItem Zor_Seviye=new JMenuItem("Zor_Seviye");
        Zor_Seviye.setBackground(Color.red);
        ABY_Dosya.add(Zor_Seviye);
        JMenuItem ozel=new JMenuItem("Özel_Seviye");
        ozel.setBackground(Color.magenta);
        ABY_Dosya.add(ozel);
        JMenuItem cikis=new JMenuItem("Çıkıs");
        ABY_Dosya.add(cikis);
        cikis.setBackground(Color.gray);
        
        cikis.addActionListener(new ActionListener() {
          
            @Override
             public void actionPerformed(ActionEvent e) {
               System.exit(0);                      
                  }
            }); 
        
        yeniOyun.addActionListener(new ActionListener() {
            
            @Override
             public void actionPerformed(ActionEvent e) {
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frm.setVisible(false);
                 
                Ekran al=new Ekran();
                JFrame frm=new JFrame("Oyun");
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frm.getContentPane().add(new mayinYerlestirme(10,12).getContent());
                frm.setSize(550,400);
                frm.setLocationRelativeTo(null); 
                frm.setVisible(true);
                frm.setResizable(false);
                JMenuBar menuBar=new JMenuBar();
                frm.setJMenuBar(menuBar);

                al.oyunMenubar(menuBar);
                al.frm=frm;

                  }
            }); 
            
        
        Kolay_Seviye.addActionListener(new ActionListener() {
           
            @Override
             public void actionPerformed(ActionEvent e) {
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frm.setVisible(false);
                Ekran al=new Ekran();
                JFrame frm=new JFrame("Kolay_Seviye ABY_Mayını Tarlası");
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frm.getContentPane().add(new mayinYerlestirme(9,7).getContent());
                frm.setSize(450,350);
                frm.setLocationRelativeTo(null);
                frm.setVisible(true);
                frm.setResizable(false);
                JMenuBar menuBar=new JMenuBar();
                frm.setJMenuBar(menuBar);
                al.oyunMenubar(menuBar); 
                al.frm=frm;
                  }
            }); 
        
        Orta_Seviye.addActionListener(new ActionListener() {
           
            @Override
             public void actionPerformed(ActionEvent e) {
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frm.setVisible(false);
                Ekran al=new Ekran();
                JFrame frm=new JFrame("Orta_Seviye ABY_Mayını Tarlası");
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frm.getContentPane().add(new mayinYerlestirme(13,23).getContent());
                frm.setSize(700,450);
                frm.setLocationRelativeTo(null);
                frm.setVisible(true);  
                frm.setResizable(false);
                JMenuBar menuBar=new JMenuBar();
                frm.setJMenuBar(menuBar);
                al.oyunMenubar(menuBar);  
                al.frm=frm;
                  }
            }); 
        
        Zor_Seviye.addActionListener(new ActionListener() {
           
            @Override
             public void actionPerformed(ActionEvent e) {
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frm.setVisible(false);
                Ekran al=new Ekran();
                JFrame frm=new JFrame("Zor_Seviye ABY_Mayını Tarlası");
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frm.getContentPane().add(new mayinYerlestirme(19,62).getContent());
                frm.setSize(1050,600);
                frm.setLocationRelativeTo(null);
                frm.setVisible(true);  
                frm.setResizable(false);
                JMenuBar menuBar=new JMenuBar();
                frm.setJMenuBar(menuBar);
                al.oyunMenubar(menuBar);   
                al.frm=frm;
             }
            }); 
        ozel.addActionListener(new ActionListener() {
           
            @Override
             public void actionPerformed(ActionEvent e) {
                Scanner klavye=new Scanner(System.in);
                 
                int ABY_dikdörtgen = Integer.parseInt(JOptionPane.showInputDialog("ABY_dikdörtgen Sayısını Giriniz:"));
                int ABY_Mayını = Integer.parseInt(JOptionPane.showInputDialog("ABY_Mayını Sayısını Giriniz:"));
                 
                
                 
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frm.setVisible(false);
                Ekran al=new Ekran();
                JFrame frm=new JFrame("Özel_Seviye ABY_Mayını Tarlası");
                frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frm.getContentPane().add(new mayinYerlestirme(ABY_dikdörtgen,ABY_Mayını).getContent());
                frm.setSize(ABY_dikdörtgen*55,ABY_dikdörtgen*45);
                frm.setLocationRelativeTo(null);
                frm.setVisible(true); 
                frm.setResizable(false);
                JMenuBar menuBar=new JMenuBar();
                frm.setJMenuBar(menuBar);
                al.oyunMenubar(menuBar);
                al.frm=frm;
                  }
            }); 
  }
  
  
}


