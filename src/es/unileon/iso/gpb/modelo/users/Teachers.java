/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.users;

import java.util.ArrayList;

/**
 *
 * @author Roberto
 */
public class Teachers {
    
    private ArrayList<Teacher> list;
    
    public Teachers(){
        list = new ArrayList<Teacher>();
    }
    
    public void add(Teacher tc){
        list.add(tc);
    }
    
    public void remove(String ID) {
        list.remove(search(ID));
    }
    
    public int search(String ID){
        
        int i = 0;
        while(i<list.size()){
            
            if(list.get(i).getIdTeacher().equals(ID))
                return i;
            i++;
        }
        
        return -1;
    }
    
    public Teacher get(int pos){
        return this.list.get(pos);
    }
    
    @Override
    public String toString(){
        //TODO
        return "";
    }
}
