
package mayintarlasi;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.Random;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.MouseInputListener;




public class mayinYerlestirme extends mayinTarlasi implements ActionListener{
    Date startDate = new Date();
    public int ABY_sec = 0;
 protected int ABY_Boyut;
 protected int ABY_Mayin_Sayiları; 
 JButton[][] ABY_butons;
 int[][] mayin;
 int ABY_Verilen_Hak;
 
    
  
  public void actionPerformed(ActionEvent e) {

    Date Date = new Date();
    ABY_sec= (int) ((Date.getTime()-startDate.getTime())/1000);
    JButton btn=(JButton)e.getSource();
     Point point=getArrayLocation(btn);
     if(mayin[point.x][point.y]<0){
        ABY_butons[point.x][point.y].setText(" "); 
        oyunBitti();
     }
     else if(mayin[point.x][point.y]>0){
         if(ABY_butons[point.x][point.y].getActionCommand()=="doldur"){                     
         if(mayin[point.x][point.y]==1){
         
           
           ABY_butons[point.x][point.y].setText(""+mayin[point.x][point.y]);
           ABY_butons[point.x][point.y].setOpaque(true);
           ABY_butons[point.x][point.y].setBackground(Color.YELLOW);
         }
         if(mayin[point.x][point.y]==2){
           ABY_butons[point.x][point.y].setText(""+mayin[point.x][point.y]);;
           ABY_butons[point.x][point.y].setOpaque(true);
           ABY_butons[point.x][point.y].setBackground(Color.GREEN);
         }
         if(mayin[point.x][point.y]==3){
           ABY_butons[point.x][point.y].setText(""+mayin[point.x][point.y]);
           ABY_butons[point.x][point.y].setOpaque(true);
           ABY_butons[point.x][point.y].setBackground(Color.PINK);
         }
         if(mayin[point.x][point.y]==4) {
           ABY_butons[point.x][point.y].setText(""+mayin[point.x][point.y]);
           ABY_butons[point.x][point.y].setOpaque(true);
           ABY_butons[point.x][point.y].setBackground(Color.magenta);
         }
         if(mayin[point.x][point.y]==5) {
           ABY_butons[point.x][point.y].setText(""+mayin[point.x][point.y]);
           ABY_butons[point.x][point.y].setOpaque(true);
           ABY_butons[point.x][point.y].setBackground(Color.BLUE);
         }
         if(mayin[point.x][point.y]>5) {
           ABY_butons[point.x][point.y].setText(""+mayin[point.x][point.y]);
           ABY_butons[point.x][point.y].setOpaque(true);
           ABY_butons[point.x][point.y].setBackground(Color.gray);
         }
          ABY_Verilen_Hak--;
       if(ABY_Verilen_Hak==0)
          JOptionPane.showMessageDialog(null,"Tebrikler! Tarlada mayın bırakmadın \n Geçen Süre: " +ABY_sec+ " sn" ,"Sonuc", JOptionPane.INFORMATION_MESSAGE);

       } 
     }
     else if(mayin[point.x][point.y]==0){
        ABY_Dikdörtgen_Aç(point.x,point.y); 
     }
     
  }
    @Override
  public void oyunBitti(){
     
      resim rs=new resim();
      for(int i=0;i<mayin.length;i++){
        for(int j=0;j<mayin.length;j++){
          if(mayin[i][j]<0){
            ABY_butons[i][j].setText("");
            ImageIcon mayin=rs.mayin();
            ABY_butons[i][j].setOpaque(true);
            ABY_butons[i][j].setBackground(Color.red);
            ABY_butons[i][j].setIcon(mayin);
          }
          else if(mayin[i][j]==0){
            ABY_butons[i][j].setText(" ");
            ABY_butons[i][j].setOpaque(true);
            ABY_butons[i][j].setBackground(Color.LIGHT_GRAY);
          }
          else{
            ABY_butons[i][j].setText(""+mayin[i][j]);
            if(mayin[i][j]==1){
              ABY_butons[i][j].setText(""+mayin[i][j]);
              ABY_butons[i][j].setOpaque(true);
              ABY_butons[i][j].setBackground(Color.yellow);
           }    
           if(mayin[i][j]==2){
              ABY_butons[i][j].setText(""+mayin[i][j]);
              ABY_butons[i][j].setOpaque(true);
              ABY_butons[i][j].setBackground(Color.GREEN);
           }  
           if(mayin[i][j]==3){
              ABY_butons[i][j].setText(""+mayin[i][j]);
              ABY_butons[i][j].setOpaque(true);
              ABY_butons[i][j].setBackground(Color.PINK);
           }
           if(mayin[i][j]==4){
              ABY_butons[i][j].setText(""+mayin[i][j]);
              ABY_butons[i][j].setOpaque(true);
              ABY_butons[i][j].setBackground(Color.MAGENTA);
           }
           if(mayin[i][j]==5){
              ABY_butons[i][j].setText(""+mayin[i][j]);
              ABY_butons[i][j].setOpaque(true);
              ABY_butons[i][j].setBackground(Color.BLUE);
           }
           if(mayin[i][j]>5){
              ABY_butons[i][j].setText(""+mayin[i][j]);
              ABY_butons[i][j].setOpaque(true);
              ABY_butons[i][j].setBackground(Color.gray);
           }
           
          }
        }  
      }
      JOptionPane.showMessageDialog(null,"Eyvah! Mayına bastın \n Geçen Süre: " +ABY_sec+ " sn","Sonuc",JOptionPane.INFORMATION_MESSAGE);

  }
  

  public void ABY_Dikdörtgen_Aç(int x,int y){
      
    if(x<0 || y<0 || x>ABY_butons.length-1 ||y>ABY_butons.length-1)
       return;
     if(ABY_butons[x][y].getText()=="  "){
        
       if(mayin[x][y]>0){
         if(mayin[x][y]==1){
           ABY_butons[x][y].setText(""+mayin[x][y]);
           ABY_butons[x][y].setOpaque(true);
           ABY_butons[x][y].setBackground(Color.yellow);
         }
         if(mayin[x][y]==2){
           ABY_butons[x][y].setText(""+mayin[x][y]);
           ABY_butons[x][y].setOpaque(true);
           ABY_butons[x][y].setBackground(Color.GREEN);
         }
         if(mayin[x][y]==3){
           ABY_butons[x][y].setText(""+mayin[x][y]);
           ABY_butons[x][y].setOpaque(true);
           ABY_butons[x][y].setBackground(Color.PINK);
         }
         if(mayin[x][y]==4){
           ABY_butons[x][y].setText(""+mayin[x][y]);
           ABY_butons[x][y].setOpaque(true);
           ABY_butons[x][y].setBackground(Color.MAGENTA);
         }
         if(mayin[x][y]==5){
           ABY_butons[x][y].setText(""+mayin[x][y]);
           ABY_butons[x][y].setOpaque(true);
           ABY_butons[x][y].setBackground(Color.BLUE);
         }
         if(mayin[x][y]>5){
           ABY_butons[x][y].setText(""+mayin[x][y]);
           ABY_butons[x][y].setOpaque(true);
           ABY_butons[x][y].setBackground(Color.gray);
         }
         ABY_Verilen_Hak--;
         if(ABY_Verilen_Hak==0)
           JOptionPane.showMessageDialog(null,"Tebrikler! Tarlada mayın bırakmadın \n Geçen Süre: " +ABY_sec+ " sn", "Sonuc", JOptionPane.INFORMATION_MESSAGE);

       }
       
       if(mayin[x][y]==0){
           ABY_butons[x][y].setText(" ");
           ABY_butons[x][y].setOpaque(true);
           ABY_butons[x][y].setBackground(Color.LIGHT_GRAY);
           ABY_Verilen_Hak--;
         if(ABY_Verilen_Hak==0)
           JOptionPane.showMessageDialog(null,"Tebrikler! Tarlada mayın bırakmadın \n Geçen Süre: "+ABY_sec+ " sn", "Sonuc", JOptionPane.INFORMATION_MESSAGE);

        
         ABY_Dikdörtgen_Aç(x-1, y-1); ABY_Dikdörtgen_Aç(x-1, y+1); ABY_Dikdörtgen_Aç(x+1, y); ABY_Dikdörtgen_Aç(x+1, y-1);
         ABY_Dikdörtgen_Aç(x-1, y); ABY_Dikdörtgen_Aç(x, y+1); ABY_Dikdörtgen_Aç(x, y-1); ABY_Dikdörtgen_Aç(x+1, y+1);
       }
       
     }     
  }
 
  public Point getArrayLocation(JButton btn){
     Point pt=new Point(-1, -1);
     for(int j=0;j<ABY_butons.length;j++){
       for(int k=0;k<ABY_butons[j].length;k++){
         if(ABY_butons[j][k]==btn){
           pt.setLocation(j, k);
           return pt;
         }
       }
     }
     return pt; 
  }
   
  
  public JPanel getContent(){
        
        JPanel ABY_Panel  = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        ABY_Panel.setBackground(Color.LIGHT_GRAY);
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        for(int j = 0; j < ABY_butons.length; j++) {
        for(int k = 0; k < ABY_butons[j].length; k++) {
                int n = j*ABY_butons[j].length + k + 1;
                ABY_butons[j][k] = new JButton("  ");
                ABY_butons[j][k].addActionListener(this);
                ABY_butons[j][k].setActionCommand("doldur");
                gbc.gridwidth = (k < ABY_butons[j].length-1) ? 1 :GridBagConstraints.REMAINDER;
                ABY_Panel.add(ABY_butons[j][k], gbc);
                
            }
        }
        return ABY_Panel;
  }
  
  public mayinYerlestirme(int ABY_Boyut, int ABY_Mayin_Sayiları){
     this.ABY_Boyut=ABY_Boyut;
     this.ABY_Mayin_Sayiları=ABY_Mayin_Sayiları;
     ABY_butons=new JButton[ABY_Boyut][ABY_Boyut];  
     mayin=new int[ABY_Boyut][ABY_Boyut]; 
     ABY_Verilen_Hak=this.ABY_Boyut*this.ABY_Boyut-this.ABY_Mayin_Sayiları;
     Random rnd=new Random();
     int x,y;
     for(int i=0;i<mayin.length;i++){
       for(int j=0;j<mayin.length;j++){
          mayin[i][j]=0;
       }
     }
     
     for(int j=0;j<ABY_Mayin_Sayiları;j++){
       x=rnd.nextInt(ABY_Boyut);
       y=rnd.nextInt(ABY_Boyut);
       if(mayin[x][y]<0){
         j--;
         continue;
       }
       mayin[x][y]=-100;
       try{mayin[x-1][y]++;}catch(Exception e){}
       try{mayin[x+1][y]++;}catch(Exception e){}
       try{mayin[x][y-1]++;}catch(Exception e){}
       try{mayin[x][y+1]++;}catch(Exception e){}
       try{mayin[x-1][y-1]++;}catch(Exception e){}
       try{mayin[x-1][y+1]++;}catch(Exception e){}
       try{mayin[x+1][y-1]++;}catch(Exception e){}
       try{mayin[x+1][y+1]++;}catch(Exception e){}
     }  
  }



        
    
}
 