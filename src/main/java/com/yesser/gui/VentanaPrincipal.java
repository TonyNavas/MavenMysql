package com.yesser.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.Collection;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class VentanaPrincipal extends JFrame {

    static JDesktopPane desktopPane;

    // Singleton
    static VentanaPrincipal miVentana;

    public VentanaPrincipal()
    {
        inicializar();
        miVentana = this;
    }

    private void inicializar() {
        setTitle("Mi Aplicación DAO _ Segunda Evaluación Parcial _ Implementación de software");
        setName("vPrincipal");
        setBounds(100, 100, 630, 375);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);

        JToolBar toolBar = new JToolBar();
        getContentPane().add(toolBar, BorderLayout.NORTH);

        JButton btnNewButton = new JButton("Nuevo");
        btnNewButton.addActionListener(ActionEvent -> mostrarVentanaClase());
        toolBar.add(btnNewButton);

        desktopPane = new JDesktopPane();
        getContentPane().add(desktopPane, BorderLayout.CENTER);
    }

    public void mostrar() {
        setVisible(true);
    }

    public static void agregarAlEscritorio(JInternalFrame ventanaInterna) {
        desktopPane.add(ventanaInterna);
        Dimension dskSize = desktopPane.getSize();
        Dimension frmSize = ventanaInterna.getSize();
        ventanaInterna.setLocation((dskSize.width - frmSize.width) / 2, (dskSize.height - frmSize.height) / 2);
        ventanaInterna.setVisible(true);
    }

    private static VentanaPrincipal getInstancia() {
        return (null == miVentana) ? new VentanaPrincipal() : miVentana;
    }

    public static void mostrarVentanaClase() {
        mostrarVentana(LibroClase.getInstancia());
    }

    private static void mostrarVentana(JInternalFrame frm) {
        try {
            //Agrenga  la Ventana al escritorio si la ventana no esta visible
            if (!frm.isVisible()) {
                agregarAlEscritorio(frm);
            } else {
                // si la ventana esta visible pero debajo de otras ventanas se mueve al frente y se selecciona
                frm.moveToFront();
                if (!frm.isSelected()) {
                    frm.setSelected(true);
                }
            }

        } catch (PropertyVetoException e) {
            System.out.println("Hola hay un error ventana principal");
        }

    }
}
