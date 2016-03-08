package gui.listeners;

import figures.Base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;


public interface IListenersManager {

    public MouseListener createMouseListener(JPanel paintPanel);

    public MouseMotionListener createMouseMotionListener(JPanel paintPanel);

    public Base provideDataForDrawing();
}
