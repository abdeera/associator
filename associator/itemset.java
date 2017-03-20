/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package associator;

import javaapplication1.*;
import java.util.ArrayList;
/**
 *
 * @author AAA
 */
public class itemset {

	int frequence ;
        ArrayList <ArrayList<itemset>> itempt;
        int item[];
        int compt=0;
	
        public itemset(int[] itm,int fq,itemset itmpt,int longu){
		frequence = fq;
                item = itm;
                itempt= new ArrayList <ArrayList<itemset>>();
                //
                for (int i=0;i<longu;i++)
                {   ArrayList ll=new ArrayList<itemset>();//ll.add(0,null);
                    itempt.add(i, ll);
                }
                //itempt.get(lg).add(itmpt);

	}

	int getfrequence()
	{
		return frequence ;

	}

        int[] getitem()
	{
		return item;//.toCharArray() ;

	}
        itemset getitems(int lg,int nb)
	{
            if (itempt.size() <= lg) return null;
            if (itempt.get(lg).size() <= nb) return null;
            return itempt.get(lg).get(nb) ;
                
	}
        void  setfrequence(int fq)
	{
		this.frequence=fq ;

	}

        void  deleteitem(int lg,int nb)
	{
		this.itempt.get(lg).remove(nb)  ;

	}
        void  additem(int lg,itemset itm)
	{
		itempt.get(lg).add(itm) ;
                
	}
        boolean compareto (int[] itm)
        {
            return(itm==item);
        }

        ArrayList getitems(int lg)
	{
            if (itempt.size()<=lg) return null; ;
            return itempt.get(lg) ;

	}
        void setcompt(int c)
        {
            this.compt=c;
        }
        int getcompt()
        {
            return this.compt;
        }
}

