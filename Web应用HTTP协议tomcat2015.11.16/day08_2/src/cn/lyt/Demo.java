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
 * 图片
 */
public class Demo {
	public static void main(String[] args) {
		/*
		 * Image、ImageIO、BufferedImage、Icon、ImageIcon
		 */
		
		// 得到图片缓冲区
		BufferedImage bi = new BufferedImage(150, 70, BufferedImage.TYPE_INT_BGR);
		
		// 得到它的绘制环境(这张图片的笔)
		Graphics2D g2 = (Graphics2D) bi.getGraphics();
		
		// 设置颜色
		g2.setColor(Color.WHITE);
		// 填充位置，大小，填充整张图片 
		g2.fillRect(0, 0, 150, 70);
		g2.setColor(Color.red);
		g2.drawRect(0, 0, 150-1, 70-1);
		
		// 设置字体
		g2.setFont(new Font("宋体", Font.BOLD, 18));
		g2.setColor(Color.BLACK);
		
		g2.drawString("HelloWorld", 3, 18);// 向图片写字符串
		
		// 保存图片
		try {
			ImageIO.write(bi, "JPEG", new FileOutputStream("H:/a.jpg"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
