/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import UserInterface.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author gauravpunjabi
 */
public class EventHandling implements ActionListener {
    private MainFrame ref;
    private HtmlHandler htmlHandler;
    public EventHandling(MainFrame ref) {
        this.ref = ref;
        this.htmlHandler = new HtmlHandler();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == ref.getSearchTextField()) {
            searchAction();
        }
    }
    private void searchAction() {
        String key = ref.getSearchTextField().getText();
        ArrayList<URL> images = htmlHandler.getImages(key);
        ref.setImages(images);
    }
}
