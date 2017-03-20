/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataCleaner;

/**
 *
 * @author AAA
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.io.*;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.*;

public class table extends JPanel {
	//DeplacerPoint d=new DeplacerPoint();

	//Score s=new Score();
        String[] attribut;// = new ArrayList <String>();
        ArrayList <String>  Table = new ArrayList <String>();                      JButton bt,bt2 ;//pour eviter des problemes dheritage
        ArrayList <ArrayList<String>>  Table2 = new ArrayList <ArrayList<String>>();
        ArrayList <ArrayList<ArrayList<Integer>>>  Table3 = new ArrayList <ArrayList<ArrayList<Integer>>>();
        ArrayList <ArrayList<ArrayList<JRadioButton>>>  radiocontrols = new ArrayList <ArrayList<ArrayList<JRadioButton>>>();
        ArrayList <ArrayList<JTextField>>  textcontrols = new ArrayList <ArrayList<JTextField>>();
        ResultSet rs=null;
        Container c;JFrame f;
        ArrayList <ArrayList <String>> tableau=new ArrayList <ArrayList <String>>();
        FileWriter out ;String table="",cond="",attrib="";
        ArrayList <String> TABLE;
        ArrayList <String> Attributsource=new ArrayList <String>();
        ArrayList <String> Attributcible=new ArrayList <String>();
        Statement stmnt;int ind1 =1;int ind2 =1;String connectionString;
        Statement stmt = null;
        Connection conn = null;
        ArrayList attribu;
	
        //ArrayList <String> Attributcible;
	public table(){
                //this.stmnt=stmt;
                
		super.setBounds(100, 100, 560, 560);
		setVisible(true);
		f=new JFrame();
		f.setVisible(true);
		f.setBounds(100, 50, 800, 700);
                f.repaint();
		c = f.getContentPane();
		c.setLayout(null);
		c.add(this);
                attribut=new String[]
                {
                 "COD_GRAVITE","COD_SOCIO_PROF", "COD_SEXE","COD_ALCOOLEMIE","COD_TRAJET","COD_EXISTANCE","COD_UTILISATION","COD_PERMIS","DAT_PERMIS","DAT_NAIS",
                 "COD_ATMOSPHERE","COD_LUMIERE","NBR_TUES","NBR_BLLEG","NBR_BLGR","NBR_2roues",
                 "CAT_VEH","COD_ADMINISTRATIVE","NBR_PASSAGER","DAT_INTGR",
                 "LIBEL"
                };
                //Attributcible=new String[]
                ///{
                // "COD_GRAVITE", "COD_SOCIO_PROF", "COD_SEX","COD_ALCOOLEMIE","COD_TRAJET","COD_EXISTANCE","COD_UTILISATION","DAT_PERMIS","DAT_NAIS"
                //};
		JComboBox K=new JComboBox(attribut);
                Graphics g=K.getGraphics();
                bt = new JButton("scanner");
                bt.setEnabled(true);
                bt.setBounds(10,10,100,20);
                bt.setVisible(true);

		c.add(bt);
                bt.repaint();
                //g.dispose();
                bt2 = new JButton("ecrire une feille de donnees");
                bt2.setEnabled(true);
                bt2.setBounds(10,10,500,20);
                bt2.setVisible(false);

		c.add(bt2);
                bt2.repaint();

                K.setEnabled(true);
                K.setBounds(10,60,120,20);
                K.setVisible(true);
		c.add(K);
                K.addActionListener(new ActionListener() {

                  public void actionPerformed(ActionEvent evt) {
                     JComboBox cb = (JComboBox)evt.getSource();

                     // Get the new item
                String newItem = cb.getSelectedItem().toString();
                if (Attributsource.contains(newItem)==false)
                {Attributsource.add(newItem);

                 JLabel l = new JLabel(newItem);
                 l.setEnabled(true);
                 l.setBounds(30+120*ind1,60,120,20);
                 l.setVisible(true);ind1++;c.add(l);f.repaint();
                 l.repaint();
                 if (cb.getSelectedIndex()>=0 & cb.getSelectedIndex()<=9)
                 {
                     //Attributsource.add("");
                     if (Table.indexOf("SRP_USAGER")==-1)
                    // {
                         Table.add("SRP_USAGER");//Table2.add(new ArrayList<String>());}
                     //if (Table2.get(Table.indexOf("SRP_USAGER")).indexOf(newItem)==-1) Table2.get(Table.indexOf("SRP_USAGER")).add(newItem);
                     //if (Table3.size()<=Table.indexOf("SRP_USAGER"))  Table3.add(new ArrayList<ArrayList<Integer>>()) ;
                     //if (Table3.get(Table.indexOf("SRP_USAGER")).size()<=Table2.get(Table.indexOf("SRP_USAGER")).indexOf(newItem)) Table3.get(Table.indexOf("SRP_USAGER")).add(new ArrayList<Integer>());

                    }
                 if (cb.getSelectedIndex()>=10 & cb.getSelectedIndex()<=15)
                 {
                     //Attributsource.add("");
                     if (Table.indexOf("SRP_ACCIDENT")==-1)
                     //{
                         Table.add("SRP_ACCIDENT");//Table2.add(new ArrayList<String>());}
                     //if (Table2.get(Table.indexOf("SRP_ACCIDENT")).indexOf(newItem)==-1) Table2.get(Table.indexOf("SRP_ACCIDENT")).add(newItem);
                     //if (Table3.size()<=Table.indexOf("SRP_ACCIDENT"))  Table3.add(new ArrayList<ArrayList<Integer>>()) ;
                     //if (Table3.get(Table.indexOf("SRP_ACCIDENT")).size()<=Table2.get(Table.indexOf("SRP_ACCIDENT")).indexOf(newItem))  Table3.get(Table.indexOf("SRP_ACCIDENT")).add(new ArrayList<Integer>());

                    }
                  if (cb.getSelectedIndex()>=16 & cb.getSelectedIndex()<=19)
                 {
                     //Attributsource.add("");
                     if (Table.indexOf("SRP_VEHICULE")==-1)
                     //{
                         Table.add("SRP_VEHICULE");//Table2.add(new ArrayList<String>());}
                     //if (Table2.get(Table.indexOf("SRP_VEHICULE")).indexOf(newItem)==-1) Table2.get(Table.indexOf("SRP_VEHICULE")).add(newItem);
                     //if (Table3.size()<=Table.indexOf("SRP_VEHICULE"))  Table3.add(new ArrayList<ArrayList<Integer>>()) ;
                     //if (Table3.get(Table.indexOf("SRP_VEHICULE")).size()<=Table2.get(Table.indexOf("SRP_VEHICULE")).indexOf(newItem)) Table3.get(Table.indexOf("SRP_VEHICULE")).add(new ArrayList<Integer>());

                    }
                  if (cb.getSelectedIndex()==20)
                  {
                      if (Table.indexOf("Departements") != -1)
                  //{
                      Table.add("Departements");//Table2.add(new ArrayList<String>());}
                     //if (Table2.get(Table.indexOf("Departements")).indexOf(newItem)==-1) Table2.get(Table.indexOf("Departements")).add(newItem);
                     //if (Table3.size()<=Table.indexOf("Departements"))  Table3.add(new ArrayList<ArrayList<Integer>>()) ;
                     //if (Table3.get(Table.indexOf("Departements")).size()<=Table2.get(Table.indexOf("Departements")).indexOf(newItem)) Table3.get(Table.indexOf("Departements")).add(new ArrayList<Integer>());

                    }//attribut.add(Table.get(Table.indexOf(newItem)+1));
                 //cb.removeItem(newItem);


                }

                     //Determine if different from previously selected item
                     //boolean same = newItem.equals(oldItem);
                     //oldItem = newItem;
                     //JOptionPane optionPane = new JOptionPane(
                     //newItem,
                     //JOptionPane.QUESTION_MESSAGE,
                     //JOptionPane.YES_NO_OPTION);
                     //optionPane.setVisible(true);
                    
                     if ("comboBoxEdited".equals(evt.getActionCommand())) {
                      // User has typed in a string; only possible with an editable combobox
                      } else if ("comboBoxChanged".equals(evt.getActionCommand())) {

                      // User has selected an item; it may be the same item
                      }
                   }

                });


                JComboBox k2=new JComboBox(attribut);
                Graphics gg = k2.getGraphics();
                k2.setEnabled(true);
                k2.setBounds(10,90,120,20);
                k2.setVisible(true);
                //gg.dispose();
		c.add(k2);
                k2.addActionListener(new ActionListener() {

                  public void actionPerformed(ActionEvent evt) {
                     JComboBox cb = (JComboBox)evt.getSource();

                     // Get the new item
                String newItem = cb.getSelectedItem().toString();
                if (Attributcible.contains(newItem)==false)
                {Attributcible.add(newItem);
                 JLabel l = new JLabel(newItem);
                 l.setEnabled(true);
                 l.setBounds(30+120*ind2,90,120,20);
                 l.setVisible(true);ind2++;c.add(l);f.repaint();
                 l.repaint();
                 if (cb.getSelectedIndex()>=0 & cb.getSelectedIndex()<=9)
                 {
                     //Attributsource.add("");
                     if (Table.indexOf("SRP_USAGER")==-1)
                     //{
                         Table.add("SRP_USAGER");//Table2.add(new ArrayList<String>());}
                     //if (Table2.get(Table.indexOf("SRP_USAGER")).indexOf(newItem)==-1) Table2.get(Table.indexOf("SRP_USAGER")).add(newItem);
                     //if (Table3.size()<=Table.indexOf("SRP_USAGER"))  Table3.add(new ArrayList<ArrayList<Integer>>()) ;
                     //if (Table3.get(Table.indexOf("SRP_USAGER")).size()<=Table2.get(Table.indexOf("SRP_USAGER")).indexOf(newItem)) Table3.get(Table.indexOf("SRP_USAGER")).add(new ArrayList<Integer>());
                    }
                 if (cb.getSelectedIndex()>=10 & cb.getSelectedIndex()<=15)
                 {
                     //Attributsource.add("");
                     if (Table.indexOf("SRP_ACCIDENT")==-1)
                     //{
                         Table.add("SRP_ACCIDENT");//Table2.add(new ArrayList<String>());}
                     //if (Table2.get(Table.indexOf("SRP_ACCIDENT")).indexOf(newItem)==-1) Table2.get(Table.indexOf("SRP_ACCIDENT")).add(newItem);
                     //if (Table3.size()<=Table.indexOf("SRP_ACCIDENT"))  Table3.add(new ArrayList<ArrayList<Integer>>()) ;
                     //if (Table3.get(Table.indexOf("SRP_ACCIDENT")).size()<=Table2.get(Table.indexOf("SRP_ACCIDENT")).indexOf(newItem)) Table3.get(Table.indexOf("SRP_ACCIDENT")).add(new ArrayList<Integer>());

                    }
                  if (cb.getSelectedIndex()>=16 & cb.getSelectedIndex()<=19)
                 {
                     //Attributsource.add("");
                     if (Table.indexOf("SRP_VEHICULE")==-1)
                     //{
                         Table.add("SRP_VEHICULE");//Table2.add(new ArrayList<String>());}
                     //if (Table2.get(Table.indexOf("SRP_VEHICULE")).indexOf(newItem)==-1) Table2.get(Table.indexOf("SRP_VEHICULE")).add(newItem);
                     //if (Table3.size()<=Table.indexOf("SRP_VEHICULE"))  Table3.add(new ArrayList<ArrayList<Integer>>()) ;
                     //if (Table3.get(Table.indexOf("SRP_VEHICULE")).size()<=Table2.get(Table.indexOf("SRP_VEHICULE")).indexOf(newItem)) Table3.get(Table.indexOf("SRP_VEHICULE")).add(new ArrayList<Integer>());

                    }
                  if (cb.getSelectedIndex()==20) if (Table.indexOf("Departements")==-1)
                  {
                     // {
                      Table.add("Departements");//Table2.add(new ArrayList<String>());}
                    // if (Table2.get(Table.indexOf("Departements")).indexOf(newItem)==-1) Table2.get(Table.indexOf("Departements")).add(newItem);
                     //if (Table3.size()<=Table.indexOf("Departements"))  Table3.add(new ArrayList<ArrayList<Integer>>()) ;
                    // if (Table3.get(Table.indexOf("Departements")).size()<=Table2.get(Table.indexOf("Departements")).indexOf(newItem)) Table3.get(Table.indexOf("Departements")).add(new ArrayList<Integer>());
                      }
                 //attribut.add(Table.get(Table.indexOf(newItem)+1));
                 //cb.removeItem(newItem);


                }

                     //Determine if different from previously selected item
                     //boolean same = newItem.equals(oldItem);
                     //oldItem = newItem;
                     //JOptionPane optionPane = new JOptionPane(
                     //newItem,
                     //JOptionPane.QUESTION_MESSAGE,
                     //JOptionPane.YES_NO_OPTION);
                     //optionPane.setVisible(true);

                     if ("comboBoxEdited".equals(evt.getActionCommand())) {
                      // User has typed in a string; only possible with an editable combobox
                      } else if ("comboBoxChanged".equals(evt.getActionCommand())) {

                      // User has selected an item; it may be the same item
                      }
                   }

                });
                
                //ArrayList L=new ArrayList();
                //a.add(L);
                //a.add("prenom");
                
                //L.add(LL);

               





                  bt.addActionListener(new ActionListener() {

                  public void actionPerformed(ActionEvent evt) {
                  
                      executerequete();
                      bt.setVisible(false);
                      bt2.setVisible(true);

                      for (int j=0;j<Table2.size();j++)
                      {
                      ArrayList AR1 = new ArrayList();
                      ArrayList AR2 = new ArrayList();
                      for (int jj=0;jj<Table2.get(j).size();jj++)
                      {

                       
                       JRadioButton jr1 = new JRadioButton("valider",
                        true);
                       JRadioButton jr2 = new JRadioButton("remplacer par une donnee comprehensible", false);
                       jr2.setVisible(true);
                       jr2.setEnabled(true);
                       jr2.setBounds(10+j*50+50,10+jj*50,100,20);
                       JTextField jt  = new JTextField();
                       JRadioButton jr3 = new JRadioButton("supprimer", false);
                       jt.setVisible(true);
                       jt.setEnabled(true);
                       jt.setBounds(10+j*50+200,10+jj*50,20,20);
                       jr3.setVisible(true);
                       jr3.setEnabled(true);
                       jr3.setBounds(10+j*50+250,10+jj*50,100,20);
                       ArrayList ar = new ArrayList();
                       ar.add(jr1);ar.add(jr2);ar.add(jr3);
                       AR1.add(ar);
                       AR2.add(jt);
                      }
                      radiocontrols.add(AR1);
                      textcontrols.add(AR2);
                      }
                      afficher();
                      f.repaint();
                      }
                  });


                  bt2.addActionListener(new ActionListener() {

                  public void actionPerformed(ActionEvent evt) {
                      try {out = new FileWriter("c:\\out.fdd");}
                      catch(Exception e)
                      { System.out.println(e.getMessage());
                        JOptionPane.showMessageDialog(null, "Le programe a rencontré une erreur suite a l'ouverture du fichier.");
                        return;}
                      for (int i=0;i<attribu.size();i++)
                      {
                          for (int j=0;j<Table2.get(i).size();j++)
                      {
                          if (radiocontrols.get(i).get(j).get(1).isSelected())
                          
                              Table2.get(i).set(j, textcontrols.get(i).get(j).getText());
                          else if (radiocontrols.get(i).get(j).get(2).isSelected())
                           
                              Table2.get(i).set(j,"suprimé");

                      }
                      }


                      for (int i = 0 ;i<attribu.size();i++ )
                          for (int j = 0 ;j<Table2.get(i).size();j++ )
                      
                     if (Table2.get(i).get(j).equals("suprimé"))
                      for (int jj=0;jj<Table3.get(i).get(j).size()-1;jj++)
                      {
                         
                         if (tableau.get(Table3.get(i).get(j).get(jj)).size() != 0)
                             tableau.get(Table3.get(i).get(j).get(jj)).clear();
                          
                            

                      }
                      else
                          for (int jj=0;jj<Table3.get(i).get(j).size()-1;jj++)
                      {  try {
                          if (tableau.get(Table3.get(i).get(j).get(jj)).size()!=0)
                              tableau.get(Table3.get(i).get(j).get(jj)).set(i, Table2.get(i).get(j));
                           } catch (Exception e) {
                          System.out.println(e);
                      }

                        }
                          
                      
                      
                      try {out.write("fddacc" + "%" + attribu.size() + "%");} catch (Exception e) {};
                        for (int ii=0;ii<tableau.size();ii+=1){
                            String mot;
                                
                                if (tableau.get(ii).size()!=0)
                                {
                                    for (int i = 0; i < attribu.size(); i++)
                                    
                                        {
                                            try {
                                                out.write(Table2.get(i).indexOf(tableau.get(ii).get(i).toString())+1 + " ");
                                            } catch (Exception e) {};
                                    }

                                             try {out.write("@");} catch (Exception e) {};}

                                    //pbm
                      }
                        try {out.write("%");} catch (Exception e) {};
                        for (int ij=0;ij<attribu.size();ij++)
                        {
                            try {   int ind;String st="";
                                if ((ind=Attributcible.indexOf(attribu.get(ij)))!=-1)
                                    st = st + "ac";
                                    if ((ind=Attributsource.indexOf(attribu.get(ij)))!=-1)
                                    st = st + "as";
                                out.write(attribu.get(ij) + "%" + st + "%");
                            } catch (Exception e) {}
                            for (int iij=0;iij<Table2.get(ij).size();iij++)
                            {
                                if (Table2.get(ij).get(iij)!="suprimé")
                                try {
                                    
                                out.write(iij+1 + "@" + Table2.get(ij).get(iij) + "@");
                            } catch (Exception e) {}
                            }
                             try {
                                out.write("%");
                            } catch (Exception e) {};
                         }
                        //try {out.write("%");} catch (Exception e) {};
			try { out.write("#");out.close();} catch (Exception e) {};	//System.out.println(contact);
			

                  JOptionPane.showMessageDialog(null, "Les données sont ecrites parfaitement.");
                  }
                  });

		// pour les 2 car� couleur� au dessus
		//pj1=new JPanel();
		//pj1.setBounds(260,0,200,100);
		//pj1.setVisible(true);
		//pj1.setBackground(Color.red);
		//pj2=new JPanel();
		//pj2.setBounds(460,0,200,100);
		//pj2.setVisible(true);
		//pj2.setBackground(Color.green);
		//c.add(pj1);
		//c.add(pj2);

		
	    /*score1=new JLabel("Score1:");
	    score1.setBounds(500,20,100,30);
	    score1.setVisible(true);
	    score1.setForeground(Color.white);
	    score2=new JLabel("Score2:");
	    score2.setBounds(500,50,100,30);
	    score2.setVisible(true);
	    score2.setForeground(Color.white);
	    score3=new JLabel();
	    score3.setBounds(620,20,100,30);
	    score3.setVisible(true);
	    score3.setForeground(Color.white);
	    score4=new JLabel();
	    score4.setBounds(620,50,100,30);
		score4.setVisible(true);
		score4.setForeground(Color.white);
	    pj1.add(score1);
		pj2.add(score2);
		pj1.add(score3);
		pj2.add(score4);
	   c.add(message);
		c.add(action);*/

                c.repaint();
                c.revalidate();
                c.getGraphics().dispose();
		}

		 /******fin table*************/









	 private int x_sel=-1,y_sel=-1,ancienx,ancieny,prochainx,prochainy,clik=0,init=0,tour=0,couleur;
	 private boolean deplecer;
	 public JButton jouer1,jouer2;
	 public JLabel action,message,score1,score2,score3,score4,atour;
	 JPanel pj1,pj2;


void afficher()
{             
JTabbedPane tabbedPane = new JTabbedPane();
tabbedPane.setBounds(0,120,900,900);
tabbedPane.setVisible(true);
tabbedPane.setEnabled(true);
tabbedPane.requestFocus();
c.add(tabbedPane);
for (int i=0;i<attribu.size();i++){


JComponent[] ret = makeTextPanel(attribu.get(i).toString());


JComponent jl = ret[1];

jl.setEnabled(true);
jl.setBounds(10,120,500,500);
jl.setVisible(true);
//panel1.;
jl.validate();
    for (int j=0;j<radiocontrols.get(i).size();j++){

    JLabel jl2 = new JLabel(Table2.get(i).get(j));
    //jl.setText(jl.getText() + "\n" + Table2.get(i).get(j));
    //jl.repaint();
    jl2.setEnabled(true);
    jl2.setBounds(10+i*50,10+j*50,120,20);
    jl2.setVisible(true);
    //jl2.setBounds(10+j*50,10+i*50,50,50);
    jl.add(jl2);
    //jl.repaint();
    jl2.repaint();
    ButtonGroup gr = new ButtonGroup();
    JRadioButton jr1 =radiocontrols.get(i).get(j).get(0);
    jr1.setVisible(true);
    jr1.setEnabled(true);
    jr1.setBounds(10+i*50+120,10+j*50,65,20);
    gr.add(jr1);
    JRadioButton jr2 =radiocontrols.get(i).get(j).get(1);
    jr2.setVisible(true);
    jr2.setEnabled(true);
    jr2.setBounds(10+i*50+210,10+j*50,270,20);
    gr.add(jr2);
    JRadioButton jr3 =radiocontrols.get(i).get(j).get(2);
    JTextField jt =textcontrols.get(i).get(j);
    jt.setVisible(true);
    jt.setEnabled(true);
    jt.setBounds(10+i*50+480,10+j*50,220,20);
    jr3.setVisible(true);
    jr3.setEnabled(true);
    jr3.setBounds(10+i*50+700,10+j*50,100,20);
    gr.add(jr3);
    jl.add( jr1);

    jl.add(jr2);

    jl.add(jr3);
    
    jl.add(jt );

    }
tabbedPane.addTab(attribu.get(i).toString(), null, ret[0],
                  "Does nothing");
tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
jl.repaint();
tabbedPane.repaint();
//JFrame a = AL.get(1).get(2
        }



c.repaint();
c.revalidate();
c.getGraphics().dispose();
}


  protected JComponent[] makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        panel.repaint();
        filler.repaint();
        JComponent[] item = new JComponent[2];item[0]=panel;item[1]=filler;
        c.repaint();
        c.revalidate();
        c.getGraphics().dispose();
        return item;
    }


  void executerequete()
    { String cond1="",cond2="",exp="";
     
      if (Table.indexOf("SRP_USAGER")!=-1 & Table.indexOf("SRP_ACCIDENT")!=-1 )
          cond1 = " where SRP_VEHICULE.cle_30=SRP_USAGER.cle_30 and SRP_VEHICULE.cle_20=SPR_LIEU.cle_20 and SPR_LIEU.cle_10=SRP_ACCIDENT.cle_10";
      else if (Table.indexOf("SRP_USAGER")!=-1 &  Table.indexOf("SRP_VEHICULE")!=-1)
           cond1 = " where SRP_VEHICULE.cle_30=SRP_USAGER.cle_30";
      else if ( Table.indexOf("SRP_ACCIDENT")!=-1 & Table.indexOf("SRP_VEHICULE")!=-1)
           cond1 = " where SRP_VEHICULE.cle_20=SPR_LIEU.cle_20 and SPR_LIEU.cle_10=SRP_ACCIDENT.cle_10";
      //if (cond1!=null)
      exp = " and ";

      if (Table.indexOf("Departements")!=-1)
      {
          if (Table.indexOf("SRP_USAGER") != -1)
          cond2 = cond2 + exp + " SRP_USAGER.COD_DEP = Departements.DEP ";
          if (Table.indexOf("SRP_VEHICULE")!=-1 )
          cond2 = cond2 +  exp + " SPR_VEHICULE.COD_DEP = Departements.DEP ";
          if (Table.indexOf("SRP_ACCIDENT")!=-1 )
          cond2 = cond2 +  exp + " (SRP_VEHICULE.cle_20=SPR_LIEU.cle_20 and SPR_LIEU.cle_10=SRP_ACCIDENT.cle_10 and SPR_VEHICULE.COD_DEP=Departements.DEP) or (SRP_VEHICULE.cle_30=SRP_USAGER.cle_30 and SRP_VEHICULE.cle_20=SPR_LIEU.cle_20 and SPR_LIEU.cle_10=SRP_ACCIDENT.cle_10 and SPR_USAGER.COD_DEP=Departements.DEP)";
        }
      if (cond1!=null) cond = cond1+cond2; else if (cond2!=null) cond = "where 1=1 "+cond2;
      attribu= new ArrayList();
      for (int i=0;i<Attributsource.size();i++)
       attribu.add(Attributsource.get(i));

      for (int i=0;i<Attributcible.size();i++)
          if (attribu.indexOf(Attributcible.get(i))==-1) attribu.add(Attributcible.get(i));

      for (int i=0 ;i<attribu.size();i++)
      {attrib=attrib + attribu.get(i); if (i!=attribu.size()-1) attrib=attrib + " , ";}

      for (int i=0 ;i<Table.size();i++)
      {table=table + Table.get(i); if (i!=Table.size()-1) table=table + " , ";}
      int i=0;int in;String s;
       try {         
                        connectionString = "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb)}; DBQ=C:\\Base.mdb" ;

                        conn=DriverManager.getConnection(connectionString, "", "");
                        stmnt=conn.createStatement();
                        //stmnt.executeQuery("SELECT COD_PERMIS FROM  SRP_USAGER");
                        s="SELECT "+attrib+" FROM "+table+cond+";";
                        rs = stmnt.executeQuery(s);  //"SELECT "+attrib+" FROM "+table +cond + ";"
			while (rs.next())
                        {//tableau.add(rs);
                        tableau.add(new ArrayList<String>());
                        for (int ii=0;ii<attribu.size();ii+=1){

                                String g = attribu.get(ii).toString();
                                String occ = rs.getObject(g).toString();
                                tableau.get(i).add(occ);
                                if (Table2.size()<=ii) Table2.add(new ArrayList());
                                if (Table3.size()<=ii) Table3.add(new ArrayList<ArrayList<Integer>>());
				if ((in=Table2.get(ii).indexOf(occ))!=-1)
                                {
                                    Table3.get(ii).get(Table2.get(ii).indexOf(occ)).add(i);
                                }
                                else
                                {
                                    Table2.get(ii).add(occ);
                                    ArrayList Ar = new ArrayList();
                                    Ar.add(i);
                                    Table3.get(ii).add(Ar);

                                }


				//System.out.println(contact);
			}
                        i++;System.out.println(i);
                    }

          } catch (Exception e){
          System.out.println(e.getMessage());
          JOptionPane.showMessageDialog(null, "Le programe a rencontré une erreur suite a l'ouverture de la base des données");
          return;
          };
                
                c.repaint();
                c.revalidate();
                c.getGraphics().dispose();
            }
  }




