package util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;
import java.io.File;

public class ImageUtil
{
    public static BufferedImage chageToJpg(File f)
    {
        try
        {
            java.awt.Image i= Toolkit.getDefaultToolkit().createImage(f.getAbsolutePath());
            PixelGrabber pg=new PixelGrabber(i,0,0,-1,-1,true);
            pg.grabPixels();
            int width=pg.getWidth();
            int height=pg.getHeight();
            final int[] RGB_MASKS={0xFF0000,0xFF00,0xFF};
            final ColorModel RGB_OPAQUE=new DirectColor
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
