package Controllers.Models.SpriteFactory;

import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class Sprite {

    //********************************************************************************************************************//
    //************************************************ CLASS FIELDS ******************************************************//

    //Render System
    private String imgPath;
    private Image image;
    private double width;
    private double height;
    

    //Physics System
    private double[] position;
    private double[] speed;



    //********************************************************************************************************************//
    //************************************************ CLASS METHODS *****************************************************//

    //Constructor

    public Sprite(String imgPath){

        //Render System
        this.imgPath=imgPath;
        this.image=new Image(this.imgPath);
        this.width=this.image.getWidth();
        this.height=this.image.getHeight();

        //Physics System
        this.position=new double[2];
        this.speed=new double[2];
    }

    //Positioning System
    public void setPosition(double positionX, double positionY){
        this.position[0]=positionX;
        this.position[1]=positionY;
    }

    public void setPositionX(double positionX){
        this.position[0]=positionX;
    }

    public void setPositionY(double positionY){
        this.position[1]=positionY;
    }

    public double getPositionX(){
        return this.position[0];
    }

    public double getPositionY(){
        return this.position[1];
    }

    //Render System
    public void update(GraphicsContext drawer){

        drawer.drawImage(image,this.position[0],this.position[1]);
    }

    public void setImage(String imgPath){
        this.imgPath=imgPath;
        this.image=new Image(this.imgPath,this.width,this.height,false,false);
    }

    public Image getImage(){

        return this.image;
    }

    public void resizeImage(double width,double height){

        /*WritablePixelFormat<ByteBuffer> format = WritablePixelFormat.getByteBgraInstance();
        byte[] buffer = new byte[(int)(this.width * this.height)*4];

        PixelReader pixelReader= this.image.getPixelReader();

        pixelReader.getPixels(0, 0, (int)this.width, (int)this.height, format, buffer, 0, (int)this.width*4);

        this.image=new Image(new ByteArrayInputStream(buffer),width,height,false,false);*/
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {

            BufferedImage image = SwingFXUtils.fromFXImage(this.image, null);
            ImageIO.write((RenderedImage) image, "png", out);
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        this.image=new Image(in, width,height,false,false);
        this.width=width;
        this.height=height;

    }

    public void getImgSection(int positionX, int positionY, int width, int height){

        WritablePixelFormat<IntBuffer> format = WritablePixelFormat.getIntArgbInstance();
        int[] buffer = new int[(int)(this.width * this.height)];

        WritableImage newImage=new WritableImage((int)this.width,(int)this.height);

        PixelWriter pixelWriter =newImage.getPixelWriter();

        PixelReader pixelReader=this.image.getPixelReader();
        pixelReader.getPixels(positionX,positionY,width,height,format,buffer,0,(int)this.width);

        pixelWriter.setPixels(0,0, (int)this.width,(int)this.height,format,buffer,0,(int)this.width);

        this.image=newImage;


    }

    public String getImgPath(){
        return this.imgPath;
    }

    public double getWidth(){
        return this.width;

    }
    public double getHeight(){
        return this.height;
    }

    //Collide System
    public Rectangle2D getBoundary(){
        return new Rectangle2D(this.position[0],this.position[1],this.width,this.height);
    }
    public boolean collide(Sprite tempSprite){
        return tempSprite.getBoundary().intersects(this.getBoundary());
    }


}
