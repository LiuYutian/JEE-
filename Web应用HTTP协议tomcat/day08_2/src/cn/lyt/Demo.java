package cn.lyt;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * ͼƬ
 */
public class Demo {
	public static void main(String[] args) {
		/*
		 * Image��ImageIO��BufferedImage��Icon��ImageIcon
		 */
		
		// �õ�ͼƬ������
		BufferedImage bi = new BufferedImage(150, 70, BufferedImage.TYPE_INT_BGR);
		
		// �õ����Ļ��ƻ���(����ͼƬ�ı�)
		Graphics2D g2 = (Graphics2D) bi.getGraphics();
		
		// ������ɫ
		g2.setColor(Color.WHITE);
		// ���λ�ã���С���������ͼƬ 
		g2.fillRect(0, 0, 150, 70);
		g2.setColor(Color.red);
		g2.drawRect(0, 0, 150-1, 70-1);
		
		// ��������
		g2.setFont(new Font("����", Font.BOLD, 18));
		g2.setColor(Color.BLACK);
		
		g2.drawString("HelloWorld", 3, 18);// ��ͼƬд�ַ���
		
		// ����ͼƬ
		try {
			ImageIO.write(bi, "JPEG", new FileOutputStream("H:/a.jpg"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
