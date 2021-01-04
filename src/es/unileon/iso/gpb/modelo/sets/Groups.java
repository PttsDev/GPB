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
public class Groups {
    
    private ArrayList<Group> list;
    
    public Groups(){
        this.list = new ArrayList<Group>();
    }
    public void add(Group gp){
        list.add(gp);
    }
    
    public void remove(String type, int number) {
        list.remove(search(type, number));
    }
    
    public int search(String type, int number){
        
        int i = 0;
        while(i<list.size()){
            
            if(list.get(i).getType().equals(type) && list.get(i).getNumber() == number )
                return i;
            i++;
        }
        return -1;
    }
    
    public Group get(int pos){
        return this.list.get(pos);
    }

   @Override
    public String toString() {
        //TODO
        return "";
    } 
}
