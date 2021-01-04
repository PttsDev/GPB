/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.sets;

import java.util.ArrayList;



/**
 *
 * @author Roberto
 */
public class Subjects {
    
    private ArrayList<Subject> list;
    
    public Subjects(){
        this.list = new ArrayList<Subject>();
    }
    public void add(Subject sb){
        list.add(sb);
    }
    
    public void remove(String sbS) {
        list.remove(search(sbS));
    }
    
    public int search(String sbS){
        
        int i = 0;
        while(i<list.size()){
            
            if(list.get(i).getName().equals(sbS))
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
    
    public Subject get(int pos){
        return this.list.get(pos);
    }
    
    @Override
    public String toString() {
        //TODO
        return "";
    }
}
