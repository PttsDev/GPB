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
public class Tutorships {
    
    private ArrayList<Tutorship> list;
    
    public Tutorships(){
        list = new ArrayList<Tutorship>();
    }
    
    public void add(Tutorship ts){
        list.add(ts);
    }
    
    public void remove(String tsS) {
        list.remove(search(tsS));
    }
    
    public int search(String tsS){
        
        int i = 0;
        while(i<list.size()){
            
            if(list.get(i).getName().equals(tsS))
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
    
    public Tutorship get(int pos){
        return this.list.get(pos);
    }
    
    @Override
    public String toString(){
        return ""; //TODO
    }
}
