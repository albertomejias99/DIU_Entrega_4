package com.mycompany.diu_entrega_4;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Lienzo extends JPanel{
    private ArrayList<Integer> mouseX = new ArrayList<Integer>();
    private ArrayList<Integer> mouseY = new ArrayList<Integer>();

    public ArrayList<Integer> getMouseX() {
        return mouseX;
    }

    public void setMouseX(ArrayList<Integer> mouseX) {
        this.mouseX = mouseX;
    }

    public ArrayList<Integer> getMouseY() {
        return mouseY;
    }

    public void setMouseY(ArrayList<Integer> mouseY) {
        this.mouseY = mouseY;
    }
    
    public void manageArrayList(int x, int y){
        this.mouseX.add(0,x);
        this.mouseY.add(0,y);
        try{
            this.mouseX.remove(5);
            this.mouseY.remove(5);
        } catch (IndexOutOfBoundsException e){}
    }
    
    private static int[] toArrayOfInt(ArrayList<Integer> list){
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) list.get(i);
        }
        return arr;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);        
        int diametro = 15;
        int [] mouseXArray = toArrayOfInt(mouseX);
        int [] mouseYArray = toArrayOfInt(mouseY);
        for (int i = 0; i < mouseX.size(); i++) {
            g.fillOval(mouseXArray[i], mouseYArray[i], diametro, diametro);
        }
        
    }
}
