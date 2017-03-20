/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package associator;

import java.io.*;
import java.lang.*;
import java.util.ArrayList;

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
/**
 *
 * @author AAA
 */
public class Main2 extends JPanel {

    	int num = 0 ; int data = 0;
        String filename ="C:\\1.txt";
        FileInputStream file;
        DataInputStream dat;
        public itemset prec;
        public itemset suiv;
        public float conf; public double sup=0;
        public ArrayList<itemset> al=new ArrayList<itemset>() ;
        public ArrayList af = new ArrayList<itemset>() ;
        private clas pr = new clas();
        public ArrayList<JLabel> jlabels =new ArrayList<JLabel>() ;
        JTextField t,t2;
        Container c;

        public  void mai(){
        super.setBounds(100, 100, 560, 560);
	setVisible(true);
	JFrame f=new JFrame();
	f.setVisible(true);
	f.setBounds(100, 50, 800, 700);
	c = f.getContentPane();
	c.setLayout(null);
	c.add(this);
        JLabel l = new JLabel("confiance minimale");
        l.setEnabled(true);
        l.setBounds(10,10,200,20);
        l.setVisible(true);
	c.add(l);
        t = new JTextField();
        t.setEnabled(true);
        t.setBounds(220,10,100,20);
        t.setVisible(true);
        c.add(t);
        JLabel l2 = new JLabel("nombre de regles");
        l2.setEnabled(true);
        l2.setBounds(10,50,200,20);
        l2.setVisible(true);
	c.add(l2);
        t2 = new JTextField();
        t2.setEnabled(true);
        t2.setBounds(220,50,100,20);
        t2.setVisible(true);
	c.add(t2);
        JButton bt = new JButton("Creer des regles");
        bt.setEnabled(true);
        bt.setBounds(10,100,200,20);
        bt.setVisible(true);
	c.add(bt);

        bt.addActionListener(new ActionListener() {

                  public void actionPerformed(ActionEvent evt) {



                      FileNotFoundException a = new FileNotFoundException();
        try
        {   int cc = 0;sup=0;al.clear();af.clear();
            if (! jlabels.isEmpty()){
            for (JLabel jl : jlabels)
               c.remove(jl);
            jlabels.clear();}
            ArrayList<itemset> ar = pr.Read();
            if (ar == null) return;
            System.out.println("-------------------------------------------------\nExtraction de regles\n-------------------------------------------------\n");
            
           for (itemset it : ar )
           {cc++;
           for (int j=pr.getlong()-1;j>0;j--)
            {
             itemset X;int size;
             if (it.getitems(j)!=null)
             if ((size=it.getitems(j).size())!=0)
             for (int jj=0;jj<size;jj++)
             if ((X=it.getitems(j,jj))!=null)
             {
             pr.remplir(X,it.getfrequence(),cc);

              }
               }
            }
           double n=1;int ii;
           for (ii=0;ii<t.getText().length();ii++)
               if (t.getText().charAt(ii)!='.') {sup = sup*n+(t.getText().charAt(ii)- '0');n=n*10;}
                else break;
           n=0.1;
           for (ii=ii+1;ii<t.getText().length();ii++)
                {sup = sup+(t.getText().charAt(ii)- '0')*n;n=n*0.1;}
            sup = sup * pr.getnbr();
            int nn=1;int nb=0;
           for (int iij=0;iij<t2.getText().length();iij++)
               {nb = nb*nn+(t2.getText().charAt(iij)- '0');nn=nn*10;}

            for (itemset it : ar )
           {

             pr.purifie(it,sup);


            }
            //ar.clear();
            ArrayList<itemset> ar2=pr.getalternat();
            for (int ik=0;ik<nb;ik++){
             int error=0;
             conf=0;prec=null;suiv=null;
            for (itemset it : ar )
            {
             rech (it);

            }
            al.add(prec);al.add(suiv);af.add(conf);
            
            ArrayList<Integer> sa=new ArrayList<Integer>();
            ArrayList<Integer> ca=new ArrayList<Integer>();
            ArrayList<Integer> sa2=new ArrayList<Integer>();
            ArrayList<Integer> ca2=new ArrayList<Integer>();
             for (int j=0;j<pr.getlong();j++)
            {
                 if (al.get(2*ik+1)==null)
                 {
                     error = 1;
                         break ;}
                 //int r;
            if (al.get(2*ik+1).getitem()[j]!=0)
            {
                sa.add(j);
                sa2.add(al.get(2 * ik + 1).getitem()[j]);}
            //if (pr.Attributcible.contains(j)) return true;
            }
            if (error==0){
            for (int j=0;j<pr.getlong();j++)
            {    
            //if (al.get(2*ik)==null) break ;
            if (al.get(2*ik).getitem()[j]!=0)
                if (!sa.contains(j))
                {
                    ca.add(j);
                    ca2.add(al.get(2 * ik).getitem()[j]);}

            //if (pr.Attributcible.contains(j)) return true;
            }String s="";
            for (int in=0;in<sa.size();in++)
            {
                s = s + pr.attribut.get(sa.get(in)).get(0).toString();
                s = s + "=" + pr.attribut.get(sa.get(in)).get(2*sa2.get(in)).toString() + ", ";
                }
            s = s+"-> ";

            for (int in=0;in<ca.size();in++)
            {
                s = s + pr.attribut.get(ca.get(in)).get(0).toString();
                s = s + "=" + pr.attribut.get(ca.get(in)).get(2*ca2.get(in)).toString() + ", ";
                }
                //if (al.get(2*ik+1)!=null)
            s = s+ "     suppoprt = " + (double)al.get(2*ik+1).getfrequence()/(double)pr.getnbr() ;
                //if (af.get(ik)!=null)
            s = s+  "  confiance = " + af.get(ik) + "\n";
             JLabel l = new JLabel(s);
            l.setEnabled(true);
            l.setBounds(10,200+30*ik,10000000,20);
            l.setVisible(true);
            c.add(l);c.repaint();
            //l.show();
            Graphics aa = l.getGraphics();
            aa.dispose();
            l.repaint();
            l.revalidate();
            c.revalidate();
            c.getGraphics().dispose();
            System.out.println(s.toString());
            c.paintAll(aa);
            c.paintComponents(aa);
            jlabels.add(l);
                }
            }


           }
        catch (Exception e)
        {
        System.out.println(e.getMessage());
        }







            }});
        


    }

    int rech(itemset a)
    {   int feu = 0;
        for (int j=pr.longu(a.getitem())-1;j>0;j--)
            {
             itemset X;int size;
             if (a.getitems(j)!=null)
             if ((size=a.getitems(j).size())!=0)
             for (int jj=0;jj<size;jj++)
             if ((X=a.getitems(j,jj))!=null)
             {
             //for (int jj=0;(X=it.getitems(j,jj))!=null;jj++)
             feu=1;float nb;int feu2=0;
             for(int i=0;i<al.size();i+=2)
             
             //   if (X==al.get(i))
              //      if((nb=(((float)a.getfrequence()/(float)X.getfrequence())*((float)al.get(i).getfrequence()/(float)al.get(i+1).getfrequence())))>=conf)
               //     {
               //         conf = nb;
               //         prec=a;
               //         suiv=X;
               //     }
                if (X==al.get(i+1)&a==al.get(i)) {feu2=1;break;}

                if (feu2==0)
             if (((pr.longu(X.getitem())>=1)|(rech(X)==2))&(containsattribcible(a)) & (containsattribsource(X)) & ( (X.getfrequence()>=sup)))
                {
                   if  ((nb=((float)a.getfrequence()/(float)X.getfrequence()))>=conf)
                   {
                        conf = nb;
                        prec=a;
                        suiv=X;
                   }
                }


            }

            }
            if (feu==0) return 2;
        return 1;
    }

boolean containsattribsource(itemset it)
    {

    for (int j=0;j<pr.getlong();j++)
    {    //int r;
        if (it.getitem()[j]!=0)
            if (pr.Attributsource.contains(j)) return true;
    }
    return false;
}

boolean containsattribcible(itemset it)
    {

    for (int j=0;j<pr.getlong();j++)
    {    //int r;
        if (it.getitem()[j]!=0)
            if (pr.Attributcible.contains(j)) return true;
    }
    return false;
}

}


//