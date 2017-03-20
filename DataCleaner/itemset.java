/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DataCleaner;

import java.util.ArrayList;
/**
 *
 * @author AAA
 */
public class itemset {

	int frequence ;
        ArrayList <ArrayList<itemset>> itempt = new ArrayList <ArrayList<itemset>>();
        String item;

        public itemset(String itm,int fq,itemset itmpt){
		frequence = fq;
                item = itm;
                itempt=null;
                //itempt.get(lg).add(itmpt);

	}

	 int getfrequence()
	{
		return frequence ;

	}

         char[] getitem()
	{
		return item.toCharArray() ;

	}
         itemset getitems(int lg,int nb)
	{
		return itempt.get(lg).get(nb) ;

	}
        void  setfrequence(int fq)
	{
		this.frequence=fq ;

	}

        void  setitem(String itm)
	{
		this.item=itm ;

	}
        void  additem(int lg,itemset itm)
	{
		itempt.get(lg).add(itm) ;

	}
         boolean compareto (String itm)
        {
            return(itm==item);
        }
}

