package edu.school.ui.frm;

import javax.swing.*;
import java.awt.event.WindowEvent;

abstract class AFrame  extends JFrame {
    abstract void initUI();

    abstract void bindEvent();

    abstract void customer();

    abstract void window_closing(WindowEvent event);


}
