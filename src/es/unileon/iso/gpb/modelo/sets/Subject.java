/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.iso.gpb.modelo.sets;

/**
 *
 * @author Roberto
 */
public class Subject {
    
    private String name;
    private long ID;
    private Groups groups;
    
    public Subject(String name, long ID) {
        this.name = name;
        this.ID = ID;
        this.groups = new Groups();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getID() {
        return this.ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void addGroup(Group gp){
        this.groups.add(gp);
    }
    
    public void removeGroup(String type, int number) {
        this.groups.remove(type, number);
    }
    
        
    public Group searchGroup(String type, int number){
        return this.groups.get(this.groups.search(type, number));
    }
    
    
    @Override
    public String toString() {
        //TODO
        return "";
    }
    
    
    
}
