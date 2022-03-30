import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.lang.reflect.Method;

public class DibujoCartesianas {

       private static Color devuelveColor(double x, double y) {
        if (y < 0.76 && y > 0.24) {
            return new Color(255, 255, 255);}
        return new Color(5, 11, 198);
    }


    //NO MODIFICAR A PARTIR DE AQUÍ

    public static int ANCHO = 400;
    public static int ALTO = 400;
    public static int diagonal = (int) Math.sqrt(ANCHO * ANCHO + ALTO * ALTO);

    public static void repinta(Canvas cnvs) {
        Graphics g = cnvs.getGraphics();
        Dimension dimension = cnvs.getSize();
        ANCHO = dimension.width;
        ALTO = dimension.height;
        for (int x = 0; x < ANCHO; x++) {
            for (int y = 0; y < ALTO; y++) {
                Color color = devuelveColor(x / (double) ANCHO, y / (double) ALTO);
                g.setColor(color);
                g.drawOval(x, y, 1, 1);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frmMain = new JFrame();
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMain.setSize(ANCHO, ALTO + 50);

        final Canvas cnvs = new Canvas();
        cnvs.setSize(ANCHO, ALTO);

        frmMain.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent componentEvent) {
                Component c = (Component) componentEvent.getSource();
                repinta(cnvs);
            }

            @Override
            public void componentMoved(ComponentEvent componentEvent) {
                Component c = (Component) componentEvent.getSource();
                repinta(cnvs);
            }

            @Override
            public void componentShown(ComponentEvent componentEvent) {
                repinta(cnvs);
            }

            @Override
            public void componentHidden(ComponentEvent componentEvent) {
            }
        });
        frmMain.add(cnvs);
        frmMain.setVisible(true);
        repinta(cnvs);
    }
}
