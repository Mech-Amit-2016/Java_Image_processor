package imageprocessingmain;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
// hello world
// this is our main class
//please execute the code to see demo
// programm execution starts from here after running this code we get a window onour screen which is our main window
// for editing the image.
// the utilities of this applicaton are given below
public class ImageProcessorFrame extends JFrame implements ActionListener {

    private JMenuBar mb;
    private JMenu file, utilities;

//    the application window contains three pannel
//    In first two pannel we take input image 
//    in third pannel we get edited result of both images
    private ImagePanel p1, p2, p3;
    private JFileChooser chooser;

    private JFrame frame;
//
    public ImageProcessorFrame() {
        
        try {
            setIconImage(ImageIO.read(new File("LOGO.jpg")));
        } catch (IOException ex) {
            Logger.getLogger(ImageProcessorFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
//   Registering windoListner to perform ativty on happening window event
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowIconified(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowActivated(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width, d.height);
        setTitle("DIGITAL IMAGE PROCESSOR ");
        chooser = new JFileChooser();
        mb = new JMenuBar();
        setJMenuBar(mb);
        file = new JMenu("File");
        file.setMnemonic('F');
        mb.add(file);
        JMenuItem quit = new JMenuItem("Quit");
        quit.setMnemonic('Q');
        quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.ALT_MASK));
        file.add(quit);
        utilities = new JMenu("Utilities");
        utilities.setMnemonic('U');
        mb.add(utilities);

        JMenuItem cropimage = new JMenuItem("Crop");
        cropimage.setMnemonic('P');
        cropimage.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
        utilities.add(cropimage);

        JMenuItem toptobottom = new JMenuItem("Top to Bottom");
        toptobottom.setMnemonic('B');
        toptobottom.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
        utilities.add(toptobottom);

        JMenuItem lefttoright = new JMenuItem("Left to Right");
        lefttoright.setMnemonic('L');
        lefttoright.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
        utilities.add(lefttoright);

        JMenuItem tograylevel = new JMenuItem("ToGrayLevel");
        tograylevel.setMnemonic('G');
        tograylevel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
        utilities.add(tograylevel);
        JMenuItem toblackwhite = new JMenuItem("ToB/W");
        toblackwhite.setMnemonic('B');
        toblackwhite.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
        utilities.add(toblackwhite);
        JMenuItem edgeextraction = new JMenuItem("EdgeExtraction");
        edgeextraction.setMnemonic('E');
        edgeextraction.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
        utilities.add(edgeextraction);
        JMenuItem artisticfilter = new JMenuItem("ArtisticFilter");
        artisticfilter.setMnemonic('A');
        artisticfilter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
        utilities.add(artisticfilter);
        JMenuItem combineimage = new JMenuItem("CombineImage");
        combineimage.setMnemonic('C');
        combineimage.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        utilities.add(combineimage);
        JMenuItem digitalnegative = new JMenuItem("Digital negative");
        digitalnegative.setMnemonic('N');
        digitalnegative.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        utilities.add(digitalnegative);
        JMenuItem compareedge = new JMenuItem("CompareEdge");
        compareedge.setMnemonic('P');
        compareedge.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.CTRL_MASK));
        //utilities.add(compareedge);
        JMenuItem imageimplanting = new JMenuItem("ImageImplanting");
        imageimplanting.setMnemonic('I');
        imageimplanting.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
        utilities.add(imageimplanting);
        JMenuItem desktopcapture = new JMenuItem("Desktopcapture");
        desktopcapture.setMnemonic('D');
        desktopcapture.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
        utilities.add(desktopcapture);
        JMenuItem thumbcompare = new JMenuItem("ThumbCompare");
        thumbcompare.setMnemonic('A');
        thumbcompare.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
        utilities.add(thumbcompare);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setLayout(new GridLayout(1, 3));
        p1 = new ImagePanel();
        p1.setBackground(Color.RED);
        add(p1);
        p2 = new ImagePanel();
        p2.setBackground(Color.GREEN);
        add(p2);
        p3 = new ImagePanel();
        p3.setOutputPanel(p3);
        p1.setOutputPanel(p3);
        p2.setOutputPanel(p3);
        p3.setBackground(Color.BLUE);
        add(p3);
        quit.addActionListener(this);
        cropimage.addActionListener(this);
        toptobottom.addActionListener(this);
        lefttoright.addActionListener(this);
        tograylevel.addActionListener(this);
        toblackwhite.addActionListener(this);
        edgeextraction.addActionListener(this);
        artisticfilter.addActionListener(this);
        combineimage.addActionListener(this);
        digitalnegative.addActionListener(this);
        compareedge.addActionListener(this);
        imageimplanting.addActionListener(this);
        desktopcapture.addActionListener(this);
        thumbcompare.addActionListener(this);
    }
// this is our actionPerformred metod in this we handel the event when we click on any utility of our application window
//    
// 
    public void actionPerformed(ActionEvent ev) {
        Object ob = ev.getActionCommand();
        if (ob.equals("Hello")) {
            int currentstate = this.getState();
            if (currentstate == NORMAL) {
                this.setState(ICONIFIED);
            } else {
                this.setState(NORMAL);
            }
            //System.exit(0);
        }

        if (ob.equals("Quit") || ob.equals("Exit")) {
            System.exit(0);
        }

        //***********************************************************************************
        if (ob.equals("Crop")) {
            BufferedImage img = p1.getIcon();
            BufferedImage newimage = ImageUtilities.cropImage(img, 100, 100, 150, 150);
            p3.setIcon(newimage);
        }
        //***********************************************************************************

        //***********************************************************************************
        if (ob.equals("Top to Bottom")) {
            BufferedImage img = p1.getIcon();
            BufferedImage newimage = ImageUtilities.reverseImageVertically(img);
            p3.setIcon(newimage);
        }
        //***********************************************************************************

        //***********************************************************************************
        if (ob.equals("Left to Right")) {
            BufferedImage img = p1.getIcon();
            BufferedImage newimage = ImageUtilities.reverseImageHorizontally(img);
            p3.setIcon(newimage);
        }
        //***********************************************************************************
        if (ob.equals("ToGrayLevel")) {
            BufferedImage img = p1.getIcon();
            BufferedImage newimage = ImageUtilities.toGrayLevel(img);
            p3.setIcon(newimage);
        }
        if (ob.equals("ToB/W")) {
            BufferedImage img = p1.getIcon();
            BufferedImage newimage = ImageUtilities.toBlackWhite(img);
            p3.setIcon(newimage);
        }
        if (ob.equals("EdgeExtraction")) {
            BufferedImage img = ImageUtilities.getEdges(p1.getIcon());
            p3.setIcon(img);
        }
        if (ob.equals("ArtisticFilter")) {
            BufferedImage img = p1.getIcon();
            BufferedImage newimage = ImageUtilities.toArtistFilter(img);
            p3.setIcon(newimage);
        }
        if (ob.equals("Digital negative")) {
            BufferedImage img = p1.getIcon();
            BufferedImage newimage = ImageUtilities.digitalNegative(img);
            p3.setIcon(newimage);

        }
        if (ob.equals("CombineImage")) {
            int w1 = p1.getIcon().getWidth();
            int w2 = p2.getIcon().getWidth();
            int maxw = Math.max(w1, w2);
            int h1 = p1.getIcon().getHeight();
            int h2 = p2.getIcon().getHeight();
            int maxh = Math.max(h1, h2);
            BufferedImage img1 = ImageUtilities.resizeImage(p1.getIcon(), maxw, maxh);
            BufferedImage img2 = ImageUtilities.resizeImage(p2.getIcon(), maxw, maxh);
            BufferedImage img = ImageUtilities.combineImage(img1, img2);
            p3.setIcon(img);
        }
        if (ob.equals("CompareEdge")) {
            int w1 = p1.getIcon().getWidth();
            int w2 = p2.getIcon().getWidth();
            int maxw = Math.max(w1, w2);
            int h1 = p1.getIcon().getHeight();
            int h2 = p2.getIcon().getHeight();
            int maxh = Math.max(h1, h2);
            BufferedImage img1 = ImageUtilities.resizeImage(p1.getIcon(), maxw, maxh);
            BufferedImage img2 = ImageUtilities.resizeImage(p2.getIcon(), maxw, maxh);
            float per = ImageUtilities.edgeComparator(img1, img2);
            System.out.println("Edges matched " + per + " %");
        }
        if (ob.equals("ImageImplanting")) {
            BufferedImage img = p1.getIcon();
            BufferedImage temp = ImageUtilities.getCopyImage(img);
            do {
                PixelData max = ImageImplanting.getZeroPixels(temp);
                ImageImplanting.setPixelValue(temp, max);
            } while (ImageImplanting.zeropixellist.size() > 0);
            p3.setIcon(temp);
        }
        if (ob.equals("Desktopcapture")) {
            BufferedImage img = ImageUtilities.getDesktopImage();
            p3.setIcon(img);
        }
        if (ob.equals("ThumbCompare")) {
            int w1 = p1.getIcon().getWidth();
            int w2 = p2.getIcon().getWidth();
            int maxw = Math.max(w1, w2);
            int h1 = p1.getIcon().getHeight();
            int h2 = p2.getIcon().getHeight();
            int maxh = Math.max(h1, h2);
            BufferedImage img1 = ImageUtilities.resizeImage(p1.getIcon(), maxw, maxh);
            BufferedImage img2 = ImageUtilities.resizeImage(p2.getIcon(), maxw, maxh);
            int r = ImageUtilities.compareThumb(img1, img2);
            if (r == 1) {
                JOptionPane.showMessageDialog(frame, "!!!! SAME THUMB IMPRESSION !!!!");
            } else {
                JOptionPane.showMessageDialog(frame, "!!!! DIFFER THUMB IMPRESSION !!!!");
            }

        }
    }

    public static void main(String args[]) {
        ImageProcessorFrame ipf = new ImageProcessorFrame();
        ipf.setVisible(true);
    }
}
