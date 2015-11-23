package cn.lyt.image;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

/**
 * ��̬����ͼƬ
 * @author lyt
 *
 */
public class Demo {
	@Test
	public void fun1() throws FileNotFoundException, IOException {
		// ͼƬ������
		BufferedImage bi = new BufferedImage(70, 35, BufferedImage.TYPE_INT_RGB);
		// ���ƻ���
		Graphics2D g = (Graphics2D) bi.getGraphics();
		// ������ɫ
		g.setColor(Color.WHITE);
		// ������
		g.fillRect(0, 0, 70, 35);
		g.setColor(Color.RED);
		// ��ͼƬд���ַ���2�� 2�� xy������
		g.drawString("Hello", 2, 35 - 2);
		
		ImageIO.write(bi, "JPEG", new FileOutputStream("F:/xxx.jpg"));
	}
	
	@Test
	public void fun2() throws FileNotFoundException, IOException{
		VerifyCode vc = new VerifyCode();
		BufferedImage bi = vc.getImage();
		VerifyCode.output(bi, new FileOutputStream("F:/XXX.jpg"));
		
		System.out.println(vc.getText());
	}
}
