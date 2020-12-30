/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.activities;

import java.util.*;
/**
 *
 * @author Roberto
 */
public class Lectures {
    
    private ArrayList<Lecture> list;
    
    public Lectures(){
        list = new ArrayList<Lecture>();
    }
    
    public void add(Lecture lect){
        list.add(lect);
    }
    
    public void remove(String lectS) {
        list.remove(search(lectS));
    }
    
    public int search(String lectS){
        
        int i = 0;
        while(i<list.size()){
            
            if(list.get(i).getName().equals(lectS))
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
