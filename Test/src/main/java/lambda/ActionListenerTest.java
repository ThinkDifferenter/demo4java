package lambda;

import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerTest {

    @Test
    public void beforeJavaEight(){
        JButton show =  new JButton("Show");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Event handling without lambda expression is boring");
            }
        });
    }

    @Test
    public void afterJavaEight(){
        JButton show =  new JButton("Show");
        show.addActionListener((e) -> {
            System.out.println("Light, Camera, Action !! Lambda expressions Rocks");
        });
    }
}
