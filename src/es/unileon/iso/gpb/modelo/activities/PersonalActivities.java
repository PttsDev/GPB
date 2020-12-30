/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.activities;

import java.util.ArrayList;

/**
 *
 * @author Roberto
 */
public class PersonalActivities {
        private ArrayList<PersonalActivity> list;
    
    public PersonalActivities(){
        list = new ArrayList<PersonalActivity>();
    }
    
    public void add(PersonalActivity pa){
        list.add(pa);
    }
    
    public void remove(String paS) {
        list.remove(search(paS));
    }
    
    public int search(String paS){
        
        int i = 0;
        while(i<list.size()){
            
            if(list.get(i).getName().equals(paS))
                return i;
            i++;
        }
        
        return -1;
    }
    
    public void remove(long ID) {
        list.remove(search(ID));
    }
    
    public int search(long ID){
        
        int i = 0;
        while(i<list.size()){
            
            if(list.get(i).getID()==ID)
                return i;
            i++;
        }
        
        return 0;
    }
    
    @Override
    public String toString(){
        return ""; //TODO
    }
}
