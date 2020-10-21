package com.bit.day24;

import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;

public class Ex13ItemStateChanged extends Frame implements ItemListener{
	Choice cho;
	List list;
	Checkbox ch1;
	Checkbox ch2;
	Checkbox ch3;
	Checkbox ch4;
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
//		int[] idxs = list.getSelectedIndexes();
//		String[] names = list.getSelectedItems();
//		System.out.println(ch1.getState());
//		System.out.println(Arrays.toString(idxs));
//		System.out.println(Arrays.toString(names));
//		System.out.println("");
		
		if(e.getSource() instanceof Checkbox) {
			System.out.println(((Checkbox)e.getSource()).getLabel() + " : " + ((Checkbox)e.getSource()).getState());			
		} else if(e.getSource() == cho) {
				System.out.println(cho.getSelectedItem());
		} else if(e.getSource() == list) {
			if(list.getSelectedItem() == (null)) {
				System.out.println("Not selected");
			} else {
			System.out.println(list.getSelectedItem());
			}
		}
	}
	
	public Ex13ItemStateChanged() {
		Panel p = new Panel();
		
		ch1 = new Checkbox("Checkbox item1");
		ch2 = new Checkbox("Checkbox item2");
		ch3 = new Checkbox("Checkbox item3");
		ch4 = new Checkbox("Checkbox item4");
		p.add(ch1);
		p.add(ch2);
		p.add(ch3);
		p.add(ch4);
		ch1.addItemListener(this);
		ch2.addItemListener(this);
		ch3.addItemListener(this);
		ch4.addItemListener(this);
		
		cho = new Choice();
		cho.add("Choice item1");
		cho.add("Choice item2");
		cho.add("Choice item3");
		cho.add("Choice item4");
		p.add(cho);
		
		list = new List(4, true);
		list.add("List item1");
		list.add("List item2");
		list.add("List item3");
		list.add("List item4");
		p.add(list);
//		
		cho.addItemListener(this);
		list.addItemListener(this);
		
		add(p);
		setSize(500, 500);
		setLocation(200, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex13ItemStateChanged();
	}


}
