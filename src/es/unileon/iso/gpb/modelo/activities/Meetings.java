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
public class Meetings {
    private ArrayList<Meeting> list;
    
    public Meetings(){
        list = new ArrayList<Meeting>();
    }
    
    public void add(Meeting met){
        list.add(met);
    }
    
    public void remove(String metS) {
        list.remove(search(metS));
    }
    
    public int search(String metS){
        
        int i = 0;
        while(i<list.size()){
            
            if(list.get(i).getName().equals(metS))
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
        
        return -1;
    }
    
    
    public Meeting get(int pos){
        return this.list.get(pos);
    }
    
    @Override
    public String toString(){
        return ""; //TODO
    }
}
