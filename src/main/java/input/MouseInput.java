package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by mnenmenth on 5/22/15.
 */
public class MouseInput implements MouseListener{

    public int mx, my;

    @Override
    public void mouseClicked(MouseEvent e){}

    @Override
    public void mousePressed(MouseEvent e){
        mx = e.getX();
        my = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e){

    }

    @Override
    public void mouseEntered(MouseEvent e){

    }

    @Override
    public void mouseExited(MouseEvent e){

    }

}
