package com.coffeedelivery.utils;

import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VisualAssert {

    public static void assertScreenshotEquals(BufferedImage actualImage, String expectedPath) {
        File expectedFile = new File(expectedPath);

        try {
            if (!expectedFile.exists()) {
                expectedFile.getParentFile().mkdirs();
                ImageIO.write(actualImage, "png", expectedFile);
                System.out.println("The image doesn't exist. Creating image... - " + expectedPath);
                return;
            }

            BufferedImage expectedImage = ImageIO.read(expectedFile);
            
            Screenshot expectedScreenshot = new Screenshot(expectedImage);
            Screenshot actualScreenshot = new Screenshot(actualImage);
            
            ImageDiffer imgDiff = new ImageDiffer();
            ImageDiff diff = imgDiff.makeDiff(expectedScreenshot, actualScreenshot)
                                  .withDiffSizeTrigger(100);
            
            if (diff.hasDiff()) {
                File diffFile = new File(expectedFile.getParent(), "diff_" + expectedFile.getName());
                ImageIO.write(diff.getMarkedImage(), "png", diffFile);
                throw new AssertionError("There are differences between the images. The difference was saved in: " + diffFile.getAbsolutePath());
            }

        } catch (IOException e) {
            throw new RuntimeException("Error when comparing or saving image: " + e.getMessage(), e);
        }
    }
}