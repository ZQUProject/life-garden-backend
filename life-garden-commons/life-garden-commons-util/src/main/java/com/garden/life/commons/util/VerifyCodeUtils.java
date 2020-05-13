package com.garden.life.commons.util;

import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class VerifyCodeUtils {
    private static String RANDOM_CODE = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";

    /**
     * 生成对应图片
     * @param output
     * @return
     */
    public static String drawCaptchaImage(ByteArrayOutputStream output, int width, int height) {

        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //画图画板
        Graphics2D graphics = bufferedImage.createGraphics();
        Font font = new Font("Times New Roman", Font.PLAIN, 24);
        graphics.setFont(font);
        //设置画板背景颜色
        graphics.setColor(new Color(160, 120, 80));
        graphics.setBackground(new Color(255, 255, 255));
        graphics.clearRect(0, 0, width, height);
        //画线干扰
        for (int i = 0; i < 50; i++) {
            int x = threadLocalRandom.nextInt(width);
            int y = threadLocalRandom.nextInt(height);
            int x1 = threadLocalRandom.nextInt(15);
            int y1 = threadLocalRandom.nextInt(15);
            graphics.drawLine(x, y, x + x1, y + y1);
        }

        graphics.setColor(new Color(80, 80, 180));
        String randomCaptcha = getRandomCaptcha();

        FontRenderContext context = graphics.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(randomCaptcha, context);
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = bounds.getY();
        double baseY = y - ascent;
        graphics.drawString(randomCaptcha, (int) x, (int) baseY);
        graphics.dispose();
        try {
            ImageIO.write(bufferedImage, "jpeg", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return randomCaptcha;
    }

    /**
     * 获得随机4位数
     * @return
     */
    private static String getRandomCaptcha() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        //取4位长度验证码
        StringBuilder randomCaptcha = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            randomCaptcha.append(RANDOM_CODE.charAt(threadLocalRandom.nextInt(RANDOM_CODE.length())));
        }
        return randomCaptcha.toString();
    }
}