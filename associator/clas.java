/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package associator;

import java.io.*;
import java.lang.*;
import java.util.ArrayList;
/**
 *
 * @author AAA
 */
public class clas {

    	int num = 0 ; int data = 0;
        String filename = "C:\\out.fdd";
        FileInputStream file;
        DataInputStream dat;
        public int nbr;
        ArrayList <ArrayList<itemset>> items = new ArrayList <ArrayList<itemset>>();
        ArrayList <ArrayList> attribut=new ArrayList <ArrayList>();
        ArrayList<itemset> alternat = new ArrayList<itemset>();
        ArrayList Attributcible = new ArrayList();
        ArrayList Attributsource = new ArrayList();

    public ArrayList Read() throws IOException,FileNotFoundException
    {
        data=0;
        file  = new FileInputStream(filename) ;
        dat =  new DataInputStream(file);
        nbr=0;
        int n=1;
       
        String reconai = "";
         while((data= file.read()) != '%' ){

                        reconai = reconai + (char)data;
                        //nbr = dat.readChar();
		}
        if (!reconai.equals("fddacc")) return null;
	//Reset();
        while((data= file.read()) != '%' ){
			
                        nbr =nbr*n + data - '0' ;
                        n = n*10;
                        //nbr = dat.readChar();
		}
        init (items,nbr);

	while((data= file.read()) != '%' ){

                        int sm,i=0;
                        itemset itm;
                        int[] elt= new int[nbr];
                        
                        while (data != '@')
                        {
                        
                        sm = 0;
                        n=1;
                        while (data != ' ')
                        {
                            sm = sm*n + data-'0';
                            data = file.read();
                            n = n*10;

                        }

                        elt[i] = sm ;
                        i++;
                        data= file.read();

                        }
                        try{
			itm=new itemset(elt,1,null,longu(elt));
                        int feu=0;
                        if (items.get(nbr) == null)
                        {
                        ArrayList <itemset> ll=new ArrayList <itemset>();
                        //ll.add(itm);
                        items.add(nbr,ll);
                        }
                         else
                        {
                        //for (ArrayList l : items)
                        int niv=0;
                            for (itemset it : items.get(nbr) )
                            {
                                if (equals(it.getitem(),itm.getitem())==true)
                                {
                                feu=1;
                                it.setfrequence(it.getfrequence()+1);break;
                                }
                            else

                            {  int[] elt2= new int[nbr];int exist=0;
                               niv=0;
                               for (int j=0;j<nbr;j++)
                               {
                                   if (it.getitem()[j]==elt[j])
                                   {
                                       elt2[j]=elt[j];
                                       niv++;
                                   }
                                   else
                                   {
                                       elt2[j]=0;
                                   }
                               }
                               itemset eltt2=new itemset(elt2,0,null,longu(elt2));
                               int ind=nbr-1;int co=0;
                    if (niv!=0)
                    {
                               for (int j=ind;j>0;j--)
                               {
                               itemset X;int ret;int size;
                               if (it.getitems(j)!=null)
                               if ((size=it.getitems(j).size())!=0)
                               for (int jj=0;jj<size;jj++)
                               if ((X=it.getitems(j,jj))!=null)
                               {

                                ret=avancer(eltt2,X,it);
                                co++;
                                if (ret == 0)
                                {
                                    j = 0;exist=1;
                                    eltt2=rech(X,eltt2);
                                    break;
                                    }
                                if (ret == 2)
                                co--;
                                }

                               }
                               //else
                               //{
                               // ArrayList <itemset> ll=new ArrayList <itemset>();
                                //ll.add(eltt2);
                                //it.init();
                                //it.additem(longu(elt2),eltt2);
                               //}
                               if (exist==0)
                                if (co == 0)
                              {
                                 it.additem(longu(elt2), eltt2);
                              }





                               for (int j=ind;j>0;j--)
                               {
                               itemset X;int ret;int size;
                               if (itm.getitems(j)!=null)
                               if ((size=itm.getitems(j).size())!=0)
                               for (int jj=0;jj<size;jj++)
                               if ((X=itm.getitems(j,jj))!=null)
                               {
                                ret=avancer(eltt2,X,itm);
                                co++;

                                if (ret == 2)
                                {
                                co--;

                                   }
                                }

                               }
                               //else
                               //{
                               // ArrayList <itemset> ll=new ArrayList <itemset>();
                                //ll.add(eltt2);
                                //it.init();
                                //it.additem(longu(elt2),eltt2);
                               //}

                                if (co == 0)
                              {
                                 itm.additem(longu(elt2), eltt2);

                              }

                }
                             }
                               }
                              }
                            if (feu==0)
                            items.get(nbr).add(itm);
                        num ++;
                      } catch (Exception e) {
                          System.out.println(e);
            }
            
                            
                    }
             //FileReader rd = new FileReader("filename.txt" );
             //StreamTokenizer st = new StreamTokenizer(rd);
             String word="";
                int token;//= file.read();
                int indice=0;char to;
                
            while ((token= file.read()) != '#') {
                attribut.add(new ArrayList());
                word="";
                while (token != '%') {
                    to = (char) token;//to = new Character(token);
                    word = word + to;
                    token = file.read();
                    }
                attribut.get(indice).add(word);
                token = file.read();word="";
                while (token != '%') {
                    to = (char) token;//to = new Character(token);
                    word = word + to;
                    token = file.read();
                    }
                if (word.contains("ac")==true)  Attributcible.add(indice);
                if (word.contains("as")==true)  Attributsource.add(indice);
                while ((token = file.read()) != '%') {
                int nb=0;n=1;
                while (token != '@') {
                        nb =nb*n + token - '0' ;
                        n = n*10;
                        token = file.read();    }
                attribut.get(indice).add(nb);
                token = file.read();word="";
                while (token != '@') {
                    word = word + (char)token;
                    token = file.read();}
                attribut.get(indice).add(word);
                }
//

                //word = st.sval;
                
                indice++;
               
              }
                file.close();
            // Parse the file
           

            return items.get(nbr);
		}



    

          
    
    public int avancer(  itemset b,itemset a ,itemset prec)
    {
    int x=0,pre=0,post=0;

                    for (int j=0;j<nbr;j++)
                               {
                                   if (a.getitem()[j]!=b.getitem()[j])
                                   {   x++;
                                       if ( (b.getitem()[j]==0) & (a.getitem()[j]!=0) )
                                       {
                                           post=1;
                                       }
                                        if ( (b.getitem()[j]!=0) & (a.getitem()[j]==0) )
                                       {
                                           pre=1;
                                       }

                                   }

                               }
                    if (x==0)

                    {
                        //exist(prec);
                        
                        return 0;
                     }
                    else
                    {
                        if (x==4)
                        {
                        //itemset itt;int existe=0;
                        //for (int ii=0;(itt=prec.getitems(longu(b,nbr),ii))!=null;ii++)
                        //{
                        //    if (itt.getitem()==b)
                        //    {
                                //existe=0;
                         //   }
                        //}
                         //if (existe == 0)
                         //prec.additem(longu(b,nbr), a);
                         return 2;
                        }

                        else
                        {

                            if (pre==0 & post == 1)
                            {
                              int ret;int co=0;
                              for (int j=longu(a.getitem())-1;j>0;j--)
                               {
                               itemset X;int size;
                               if (a.getitems(j)!=null)
                               if ((size=a.getitems(j).size())!=0)
                               for (int jj=0;jj<size;jj++)
                               if ((X=a.getitems(j,jj))!=null)
                               {
                                ret=avancer(b,X,a);
                                co++;
                                if (ret == 0)
                                return 0;
                                if (ret == 2)
                                co--;
                                }
                               }
                              if (co == 0)
                              {
                                 a.additem(longu(b.getitem()), b);
                              }
                              return 1;
                            }
                            else if(post==0 & pre==1)
                            {  itemset re;
                                for (int j=longu(prec.getitem())-1;j>0;j--)
                               {
                               itemset X;int size;
                               if (prec.getitems(j)!=null)
                               if ((size=prec.getitems(j).size())!=0)
                               for (int jj=0;jj<size;jj++)
                               if ((X=prec.getitems(j,jj))!=null)
                               {
                                if (prec.getitems(j,jj)==a)
                                {
                                prec.deleteitem(j,jj);
                                if ((re=rech(prec, b))==null)
                                prec.additem(longu(b.getitem()), b);
                                else
                                b=re;
                                b.additem(j,a);
                                return 1;}
                               }
                               }
                                if ((re=rech(prec, b))==null)
                                prec.additem(longu(b.getitem()),b);
                                else
                                b=re;
                                if ((re=rech(b, a))==null)
                                b.additem(longu(a.getitem()),a);
                               
                               return 1;
                           }
                            else if (post==1 & pre==1)
                            {
                                int ret,co=0;
                                
                               for (int j=longu(a.getitem())-1;j>0;j--)
                               {
                               itemset X;int size;
                               if (a.getitems(j)!=null)
                               if ((size=a.getitems(j).size())!=0)
                               for (int jj=0;jj<size;jj++)
                               if ((X=a.getitems(j,jj))!=null)
                               {
                               ret= avancer(b,X,prec);
                               co++;
                               if (ret==0) return 0;
                                if (ret == 2)
                                {

                                co--;
                                   }
                               }
                               }
                                itemset neww = join(a,b);
                                ret=avancer(neww,a,a);
                                if (ret==0) neww=rech(a,neww);
                                avancer(neww,b,b);
                                if (co==0)
                                {
                                return 2;
                                }
                                else
                                return 1;
                            }

                         }
                    }
    return 1;
    }


    int longu(int[] n)
    {
    int compt =0;
    for (int j=0;j<nbr;j++)
    {
        if (n[j]!=0)
            compt++;
    }
    return compt;
}

    void exist(itemset itm)
    {
        for (itemset it : items.get(nbr) )
        {
          if (it.getitem()==itm.getitem())
          {
            it.setfrequence(it.getfrequence()+1);
            return;
          }
        }
    }

    void init (ArrayList l,int n)
                {
            for (int i=0;i<=n;i++)
                l.add(i, null);
        }
    itemset join (itemset a ,itemset b)
    {   itemset it;
        int[] vect = new int[nbr];
        for (int i=0;i<nbr;i++)
        {
            if (a.getitem()[i]==b.getitem()[i]) vect[i]=a.getitem()[i]; else vect[i]=0;
        }
        it = new itemset(vect,0,null,nbr);
        return it;
    }

    itemset rech (itemset a, itemset b)
    {
        if (equals(a.getitem(),b.getitem())==true) return a;
        for (int j=longu(a.getitem())-1;j>0;j--)
            {
             itemset X;itemset ret;int size;
             if (a.getitems(j)!=null)
             if ((size=a.getitems(j).size())!=0)
             for (int jj=0;jj<size;jj++)
             if ((X=a.getitems(j,jj))!=null)
             {
             ret= rech(X,b);

             if (ret!=null) return ret;

             }
             }

        return null;

    }
    boolean equals (int[] a,int[] b)
    {
        for (int i=0;i<a.length;i++)
        {
            if (a[i]!=b[i]) return false;
        }
        return true;
    }
    ArrayList getens()
    {
       return items.get(nbr);
    }

    int getnbr()
    {
        return num;
    }


    void purifie(itemset it,double n)
    {  try{
        if (it!=null )
            if (longu(it.getitem())>0 & containsattribsource(it))
        //for (itemset it : a )
        { if (it.getfrequence()>=n) {if (it.getcompt()!=-1) {
              alternat.add(it);it.setcompt(-1);remplir2(it);} return;}

             //if (equals(a.getitem(),b.getitem())==true) return a;
            if (longu(it.getitem())!=1)
            for (int j=longu(it.getitem())-1;j>0;j--)
            {
             itemset X;
             if (it.getitems(j)!=null)
             if (it.getitems(j).size()!=0)
             for (int jj=0;jj<(it.getitems(j).size());jj++)
             if ((X=it.getitems(j,jj))!=null)
             if (it.getfrequence()>=n) {if (X.getcompt()!=-1) {
                 alternat.add(X);it.setcompt(-1);remplir2(it);} return;}
             else purifie(X,n);
            }
            

        }
        } catch (Exception e) {
            System.out.println(e);
        }
        ;
    }


    void remplir(itemset it,int fq,int cc)
    {
          if (it!=null)
             //if (equals(a.getitem(),b.getitem())==true) return a;

            for (int j=longu(it.getitem())-1;j>0;j--)
            {
             itemset X;int size;
             if (it.getitems(j)!=null)
             if ((size=it.getitems(j).size())!=0)
             for (int jj=0;jj<size;jj++)
             if ((X=it.getitems(j,jj))!=null)
             {
             //for (int jj=0;(X=it.getitems(j,jj))!=null;jj++)

             remplir(X,fq,cc);

            }
            }
    if (it.getcompt()!=cc)
    {
        it.setfrequence(it.getfrequence() + fq);
        it.setcompt(cc);
        }
    }

  int getlong()
    {
      return nbr;
  }

boolean containsattribsource(itemset it)
    {

    for (int j=0;j<nbr;j++)
    {    //int r;
        if (it.getitem()[j]!=0)
            if (Attributsource.contains(j)) return true;
    }
    return false;
}

void remplir2(itemset it)
    {

        //for (itemset it : a )
    if (longu(it.getitem())!=1)
       for (int j=longu(it.getitem())-1;j>0;j--)
            {
             itemset X;
             if (it.getitems(j)!=null)
             if (it.getitems(j).size()!=0)
             for (int jj=0;jj<(it.getitems(j).size());jj++)
             if ((X=it.getitems(j,jj))!=null)
             if (X==null)
                 it.deleteitem(j, jj);
             else if(longu(X.getitem())<=0 | containsattribsource(X)==false)
                 it.deleteitem(j, jj);
             else {X.setcompt(-1);remplir2(X);}
            }
    

}

ArrayList<itemset> getalternat ()
    {
    return this.alternat;
}

}
